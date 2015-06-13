/**
 * 
 */
package tp1.enonce.multimedia;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Isaac
 *
 */
public class TestMultimediaManager {
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
	
	public static class Tests{
		//Two test for each method (start, pause, resume, stop)
		private MultimediaManager managerMusicWithLocation;
		private MultimediaManager managerMusicNoLocation;
		private MultimediaManager managerVideoWithLocation;
		private MultimediaManager managerVideoNoLocation;
		
		@BeforeClass
	    public void setUpBeforeClass() {
			
		}
		
		//Test 1
		@Test
		public void testStartFromCREATED(){
			//Music start from CREATED state
			managerMusicNoLocation.setState(MultimediaManager.CREATED);
			managerMusicNoLocation.start();
			assertTrue("Cannot do Start from CREATED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
			//Video start from CREATED state
			managerVideoNoLocation.setState(MultimediaManager.CREATED);
			managerVideoNoLocation.start();
			assertTrue("Cannot do Start from CREATED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
			
		}
		
		//Test 2
		@Test
		public void testStartFromSTOP(){
			//Music start from STOPPED state
			managerMusicNoLocation.setState(MultimediaManager.STOPPED);
			managerMusicNoLocation.start();
			assertTrue("Cannot do Start from STOPPED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
			//Video start from STOPPED state
			managerVideoNoLocation.setState(MultimediaManager.STOPPED);
			managerVideoNoLocation.start();
			assertTrue("Cannot do Start from STOPPED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
		}
		
		//Test 3
		@Test
		public void testSyopFromPLAYING(){
			//Music start from STOP state
			managerMusicNoLocation.setState(MultimediaManager.CREATED);
			managerMusicNoLocation.start();
			assertTrue("Cannot do Start from CREATED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
		}
		
		//Test 2
		@Test
		public void testPause(){
			
		}
		
		//Test 3
		@Test
		public void testResume(){
			
		}
		
		//Test 4
		@Test
		public void testStop(){
			
		}
		
	
		/**
		 * @throws java.lang.Exception
		 */
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}
	
		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			managerMusicWithLocation    = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerMusicNoLocation = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerVideoWithLocation      = new MultimediaManager(true,  2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
			managerVideoNoLocation   = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.VIDEO,   0, dummyObject);
		}
	
		/**
		 * @throws java.lang.Exception
		 */
		@After
		public void tearDown() throws Exception {
		}
	
		@Test
		public void test() {
			fail("Not yet implemented");
		}
	}
}
