/**
 * 
 */
package tp1.enonce.multimedia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Isaac
 *
 */
public class TestMultimediaManager {
	private static Multimedia dummyObject = new Multimedia() {
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

	public static class Tests {
		// Tests for each method (start, pause, resume, stop)
		private MultimediaManager managerMusicWithLocation;
		private MultimediaManager managerMusicNoLocation;
		private MultimediaManager managerVideoWithLocation;
		private MultimediaManager managerVideoNoLocation;

		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			managerMusicWithLocation = new MultimediaManager(true, 2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerMusicNoLocation = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.MUSIQUE, 0, dummyObject);
			managerVideoWithLocation = new MultimediaManager(true, 2, "Auteur", "Titre", MultimediaManager.VIDEO, 0, dummyObject);
			managerVideoNoLocation = new MultimediaManager(false, 2, "Auteur", "Titre", MultimediaManager.VIDEO, 0, dummyObject);
		}

		// Test 1
		@Test
		public void testStartFromCREATEDMusic() {
			// Music start from CREATED state
			managerMusicNoLocation.setState(MultimediaManager.CREATED);
			managerMusicNoLocation.start();
			assertTrue("Music - Cannot do Start from CREATED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 2
		@Test
		public void testStartFromCREATEDVideo() {
			// Video start from CREATED state
			managerVideoNoLocation.setState(MultimediaManager.CREATED);
			managerVideoNoLocation.start();
			assertTrue("Video - Cannot do Start from CREATED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 3
		@Test
		public void testStartFromSTOPPEDMusic() {
			// Music start from STOPPED state
			managerMusicNoLocation.setState(MultimediaManager.STOPPED);
			managerMusicNoLocation.start();
			assertTrue("Music - Cannot do Start from STOPPED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 4
		@Test
		public void testStartFromSTOPPEDVideo() {
			// Video start from STOPPED state
			managerVideoNoLocation.setState(MultimediaManager.STOPPED);
			managerVideoNoLocation.start();
			assertTrue("Video - Cannot do Start from STOPPED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 5
		@Test
		public void testStopFromPLAYINGMusic() {
			// Music stop from PLAYING state
			managerMusicNoLocation.setState(MultimediaManager.PLAYING);
			managerMusicNoLocation.stop();
			assertTrue("Music - Cannot do Stop from PLAYING state", managerMusicNoLocation.getState() == MultimediaManager.STOPPED);
		}

		// Test 6
		@Test
		public void testStopFromPLAYINGVideo() {
			// Video stop from PLAYING state
			managerVideoNoLocation.setState(MultimediaManager.PLAYING);
			managerVideoNoLocation.stop();
			assertTrue("Video - Cannot do Stop from PLAYING state", managerVideoNoLocation.getState() == MultimediaManager.STOPPED);
		}

		// Test 7
		@Test
		public void testPauseFromPLAYINGMusic() {
			// Music pause from PLAYING state
			managerMusicNoLocation.setState(MultimediaManager.PLAYING);
			managerMusicNoLocation.pause();
			assertTrue("Music - Cannot do Pause from PLAYING state", managerMusicNoLocation.getState() == MultimediaManager.PAUSED);
		}

		// Test 8
		@Test
		public void testPauseFromPLAYINGVideo() {
			// Video pause from PLAYING state
			managerVideoNoLocation.setState(MultimediaManager.PLAYING);
			managerVideoNoLocation.pause();
			assertTrue("Video - Cannot do Pause from PLAYING state", managerVideoNoLocation.getState() == MultimediaManager.PAUSED);
		}

		// Test 9
		@Test
		public void testResumeFromPAUSEDMusic() {
			// Music resume from PAUSED state
			managerMusicNoLocation.setState(MultimediaManager.PAUSED);
			managerMusicNoLocation.resume();
			assertTrue("Music - Cannot do Resume from PAUSED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 10
		@Test
		public void testResumeFromPAUSEDVideo() {
			// Video resume from PAUSED state
			managerVideoNoLocation.setState(MultimediaManager.PAUSED);
			managerVideoNoLocation.resume();
			assertTrue("Video - Cannot do Pause from PAUSED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
		}

		// Test 11
		@Test
		public void testNormalUsageMusic() {
			// Music normal usage
			managerMusicNoLocation.setState(MultimediaManager.CREATED);
			managerMusicNoLocation.start();
			assertTrue("Music - Cannot do Start from CREATED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
			managerMusicNoLocation.pause();
			assertTrue("Music - Cannot do Pause from PLAYING state", managerMusicNoLocation.getState() == MultimediaManager.PAUSED);
			managerMusicNoLocation.resume();
			assertTrue("Music - Cannot do Resume from PAUSED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
			managerMusicNoLocation.pause();
			assertTrue("Music - Cannot do Pause from PLAYING state", managerMusicNoLocation.getState() == MultimediaManager.PAUSED);
			managerMusicNoLocation.resume();
			assertTrue("Music - Cannot do Resume from PAUSED state", managerMusicNoLocation.getState() == MultimediaManager.PLAYING);
			managerMusicNoLocation.stop();
			assertTrue("Music - Cannot do Stop from PLAYING state", managerMusicNoLocation.getState() == MultimediaManager.STOPPED);
		}

		// Test 12
		@Test
		public void testNormalUsageVideo() {
			// Video normal usage
			managerVideoNoLocation.setState(MultimediaManager.CREATED);
			managerVideoNoLocation.start();
			assertTrue("Video - Cannot do Start from CREATED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
			managerVideoNoLocation.pause();
			assertTrue("Video - Cannot do Pause from PLAYING state", managerVideoNoLocation.getState() == MultimediaManager.PAUSED);
			managerVideoNoLocation.resume();
			assertTrue( "Video - Cannot do Resume from PAUSED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
			managerVideoNoLocation.pause();
			assertTrue("Video - Cannot do Pause from PLAYING state", managerVideoNoLocation.getState() == MultimediaManager.PAUSED);
			managerVideoNoLocation.resume();
			assertTrue( "Video - Cannot do Resume from PAUSED state", managerVideoNoLocation.getState() == MultimediaManager.PLAYING);
			managerVideoNoLocation.stop();
			assertTrue("Video - Cannot do Stop from PLAYING state", managerVideoNoLocation.getState() == MultimediaManager.STOPPED);
		}

		// Test 13
		@Test
		public void testPauseLocationMusic() {
			// Music location
			managerMusicWithLocation.start();
			managerMusicWithLocation.pause();
			assertTrue("Music - location PAUSED - Utilisation", managerMusicWithLocation.getUsage() == 1);
		}

		// Test 14
		@Test
		public void testPauseLocationVideo() {
			// Video location
			managerVideoWithLocation.start();
			managerVideoWithLocation.pause();
			assertTrue("Video - location PAUSED - Utilisation", managerVideoWithLocation.getUsage() == 1);
		}
	}
}
