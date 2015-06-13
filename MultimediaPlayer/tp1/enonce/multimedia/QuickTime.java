package tp1.enonce.multimedia;

public interface QuickTime extends MediaPlayer {
	final static QuickTime PLAYER = new QuickTime() {

		@Override
		public void pause(String titre, String author, String category,
				int length, Object contents) {
			// TODO Auto-generated method stub
		}

		@Override
		public void close(String titre, String author, String category,
				int length, Object contents) {
			// TODO Auto-generated method stub
		}

		@Override
		public void play(String titre, String author, String category,
				int length, Object contents) {
			// TODO Auto-generated method stub
		}

	};

}
