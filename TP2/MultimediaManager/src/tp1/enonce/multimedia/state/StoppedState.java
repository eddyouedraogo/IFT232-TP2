package tp1.enonce.multimedia.state;

import tp1.enonce.multimedia.MultimediaManager;

public class StoppedState implements MediaState {
	@Override
	public void start(MultimediaManager manager) {
		manager.getPlayer().play(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.setState(new PlayingState());
	}
	
	@Override
	public void pause(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Pause while stopped.");
	}

	@Override
	public void resume(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Resume while stopped.");
	}

	@Override
	public void stop(final MultimediaManager manager) {
		//do nothing
	}

	@Override
	public int getState() {
		return MultimediaManager.STOPPED;
	}
}
