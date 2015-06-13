package tp1.enonce.multimedia.state;

import tp1.enonce.multimedia.MultimediaManager;

public class CreatedState implements MediaState {
	@Override
	public void start(final MultimediaManager manager) {
		manager.initPlayer();
		manager.getPlayer().play(manager.getTitle(), manager.getAuthor(), manager.getCategory(), manager.getSize(), manager.getContenu());
		manager.setState(new PlayingState());
	}

	@Override
	public void pause(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Pause while not Playing.");
	}

	@Override
	public void resume(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Resume while not Paused.");
	}

	@Override
	public void stop(final MultimediaManager manager) {
		throw new RuntimeException("Cannot do Stop while not Playing.");
	}

	@Override
	public int getState() {
		return MultimediaManager.CREATED;
	}
}
