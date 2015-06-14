package tp1.enonce.multimedia.state;

import tp1.enonce.multimedia.MultimediaManager;

public class PlayingState implements MediaState {
	@Override
	public void start(final MultimediaManager manager) {		
		//do nothing
	}

	@Override
	public void pause(final MultimediaManager manager) {
		manager.initPlayer();
		manager.getPlayer().pause(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.incrementUsage();
		manager.setState(new PausedState());
	}

	@Override
	public void resume(final MultimediaManager manager) {
		//do nothing
	}

	@Override
	public void stop(final MultimediaManager manager) {
		manager.initPlayer();
		manager.getPlayer().close(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.incrementUsage();
		manager.setState(new StoppedState());
	}

	@Override
	public MediaState getState() {
		return MultimediaManager.PLAYING;
	}
}
