package tp1.enonce.multimedia.state;

import tp1.enonce.multimedia.MultimediaManager;

public interface MediaState{		
		public void start(final MultimediaManager manager);		
		public void pause(final MultimediaManager manager);
		public void resume(final MultimediaManager manager);
		public void stop(final MultimediaManager manager);
		
		public MediaState getState();
}