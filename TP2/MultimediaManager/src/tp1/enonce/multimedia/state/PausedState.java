package tp1.enonce.multimedia.state;

import tp1.enonce.multimedia.MultimediaManager;

public class PausedState implements MediaState {
	@Override
	public void start(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Start while paused.");
	}

	@Override
	public void pause(final MultimediaManager manager) {
		//do nothing
	}

	@Override
	public void resume(final MultimediaManager manager) {
		manager.getPlayer().play(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.decrementUsage();
		manager.setState(new PlayingState());
	}

	@Override
	public void stop(final MultimediaManager manager) {
		manager.getPlayer().close(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.incrementUsage();
		manager.setState(new StoppedState());
	}

	@Override
	public int getState() {
		return MultimediaManager.PAUSED;
	}
}
