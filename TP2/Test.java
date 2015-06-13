package tp1.enonce.multimedia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class TestMultimediaManager {

	//Allow init of managers
	private static Multimedia dummyObject = new Multimedia(){
		@Override
		public String getTitle() {
			return "Title";
		}

		@Override
		public String getAuthor() {
			return "Author";
		}

		@Override
		public boolean isFree() {
			return false;
		}

		@Override
		public boolean isRented() {
			return false;
		}

		@Override
		public boolean isBought() {
			return false;
		}

		@Override
		public String getOwner() {
			return "Owner";
		}		
	};
	
	public static class TestContructor{		
		@Test
		public void testConstructor(){
			MultimediaManager test;
			
			/* Création d'une instance Musique avec Location */
			test = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			assertTrue("Constructeur - Musique avec Location \"Location\" - Failed", test.isLocation());
			assertTrue("Constructeur - Musique avec Location \"Maximum\" - Failed", test.getMax() == 2);
			assertTrue("Constructeur - Musique avec Location \"Auteur\" - Failed", test.getAuthor() == "Auteur");
			assertTrue("Constructeur - Musique avec Location \"Titre\" - Failed", test.getTitle() == "Titre");
			assertTrue("Constructeur - Musique avec Location \"Categorie\" - Failed", test.getCategory() == MultimediaManager.MUSIQUE);
			assertTrue("Constructeur - Musique avec Location \"Taille\" - Failed", test.getSize() == 0);

			/* Création d'une instance Musique sans Location */
			test = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			assertTrue("Constructeur - Musique sans Location \"Categorie\" - Failed", test.getCategory() == MultimediaManager.MUSIQUE);
			assertFalse("Constructeur - Musique sans Location \"Location\" - Failed", test.isLocation());

			/* Création d'une instance Video avec Location */
			test = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
			assertTrue("Constructeur - Vidéo avec Location \"Categorie\" - Failed", test.getCategory() == MultimediaManager.VIDEO);
			assertTrue("Constructeur - Vidéo avec Location \"Location\" - Failed", test.isLocation());
			
			/* Création d'une instance Video sans Location */
			test = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
			assertTrue("Constructeur - Vidéo sans Location \"Categorie\" - Failed", test.getCategory() == MultimediaManager.VIDEO);
			assertFalse("Constructeur - Vidéo sans Location \"Location\" - Failed", test.isLocation());
		}		
	}
	
	/**
	 * Classe de test pour les différentes méthodes
	 * On défini un manager de musique et de vidéo avec et sans location pour les tests dans le Before
	 * @author Samuel Dussault
	 */
	public static class TestMethodes{
		private MultimediaManager managerMusiqueLocation;
		private MultimediaManager managerMusiquePasLocation;
		private MultimediaManager managerVideoLocation;
		private MultimediaManager managerVideoPasLocation;
		
		@Before
	    public void initObjects() {
			managerMusiqueLocation    = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerMusiquePasLocation = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerVideoLocation      = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
			managerVideoPasLocation   = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
		}
		
		@Test
		public void testStart() {
			/* Musique État CREATED */
			managerMusiquePasLocation.setState(MultimediaManager.CREATED);
			managerMusiquePasLocation.start();
			assertTrue("Start - Musique État Start when CREATED - Failed", managerMusiquePasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Musique État STOPPED */
			managerMusiquePasLocation.setState(MultimediaManager.STOPPED);
			managerMusiquePasLocation.start();
			assertTrue("Start - Musique État Start when STOPPED - Failed", managerMusiquePasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Vidéo État CREATED */		
			managerVideoPasLocation.setState(MultimediaManager.CREATED);
			managerVideoPasLocation.start();
			assertTrue("Start - Vidéo État Start when CREATED - Failed", managerVideoPasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Vidéo État STOPPED */
			managerVideoPasLocation.setState(MultimediaManager.STOPPED);
			managerVideoPasLocation.start();
			assertTrue("Start - Vidéo État Start when STOPPED - Failed", managerVideoPasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Location avec utilisation maximale */
			managerVideoLocation.setState(MultimediaManager.STOPPED);
			managerVideoLocation.setUsage(2);
			managerVideoLocation.start();
			assertFalse("Start - Vidéo État Start when STOPPED avec Utilisation Maximale - Failed", managerVideoLocation.getState() == MultimediaManager.PLAYING);
		}

		@Test
		public void testPause() {
			/* Musique pas en location */
			managerMusiquePasLocation.start();
			managerMusiquePasLocation.pause();
			assertTrue("Pause - Musique sans location PAUSED - Failed", managerMusiquePasLocation.getState() == MultimediaManager.PAUSED);
			
			/* Musique en location */
			managerMusiqueLocation.start();
			managerMusiqueLocation.pause();
			assertTrue("Pause - Musique en location PAUSED - Failed", managerMusiqueLocation.getState() == MultimediaManager.PAUSED);
			assertTrue("Pause - Musique en location PAUSED - Utilisation == 1 - Failed", managerMusiqueLocation.getUsage() == 1);
			
			/* Vidéo pas en location */
			managerVideoPasLocation.start();
			managerVideoPasLocation.pause();
			assertTrue("Pause - Vidéo sans location PAUSED - Failed", managerVideoPasLocation.getState() == MultimediaManager.PAUSED);
			
			/* Vidéo en location */
			managerVideoLocation.start();
			managerVideoLocation.pause();
			assertTrue("Pause - Vidéo en location PAUSED - Utilisation == 1 - Failed", managerVideoLocation.getState() == MultimediaManager.PAUSED);
			assertTrue("Pause - Musique en location PAUSED - Utilisation == 1 - Failed", managerVideoLocation.getUsage() == 1);
		}

		@Test
		public void testResume() {
			/* Musique pas en location */
			managerMusiquePasLocation.start();
			managerMusiquePasLocation.pause();
			managerMusiquePasLocation.resume();
			assertTrue("Pause - Musique sans location RESUME - Failed", managerMusiquePasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Musique en location */
			managerMusiqueLocation.start();
			managerMusiqueLocation.pause();
			managerMusiqueLocation.resume();
			assertTrue("Pause - Musique en location RESUME - Failed", managerMusiqueLocation.getState() == MultimediaManager.PLAYING);
			assertTrue("Pause - Musique en location RESUME - Utilisation == 0 - Failed", managerMusiqueLocation.getUsage() == 0);
			
			/* Vidéo pas en location */
			managerVideoPasLocation.start();
			managerVideoPasLocation.pause();
			managerVideoPasLocation.resume();
			assertTrue("Pause - Vidéo sans location RESUME - Failed", managerVideoPasLocation.getState() == MultimediaManager.PLAYING);
			
			/* Vidéo en location */
			managerVideoLocation.start();
			managerVideoLocation.pause();
			managerVideoLocation.resume();
			assertTrue("Pause - Vidéo en location RESUME - Failed", managerVideoLocation.getState() == MultimediaManager.PLAYING);
			assertTrue("Pause - Musique en location RESUME - Utilisation == 0 - Failed", managerVideoLocation.getUsage() == 0);
		}

		@Test
		public void testStop() {
			/* Musique pas en location */
			managerMusiquePasLocation.start();
			managerMusiquePasLocation.stop();
			assertTrue("Pause - Musique sans location STOPPED - Failed", managerMusiquePasLocation.getState() == MultimediaManager.STOPPED);
			
			/* Musique en location */
			managerMusiqueLocation.start();
			managerMusiqueLocation.stop();
			assertTrue("Pause - Musique en location STOPPED - Failed", managerMusiqueLocation.getState() == MultimediaManager.STOPPED);
			assertTrue("Pause - Musique en location STOPPED - Failed", managerMusiqueLocation.getUsage() == 1);
			
			/* Vidéo pas en location */
			managerVideoPasLocation.start();
			managerVideoPasLocation.stop();
			assertTrue("Pause - Vidéo sans location STOPPED - Failed", managerVideoPasLocation.getState() == MultimediaManager.STOPPED);
			
			/* Vidéo en location */
			managerVideoLocation.start();
			managerVideoLocation.stop();
			assertTrue("Pause - Vidéo en location STOPPED - Failed", managerVideoLocation.getState() == MultimediaManager.STOPPED);
		}
	}
}
