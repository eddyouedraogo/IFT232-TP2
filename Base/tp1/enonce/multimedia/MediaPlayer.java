package tp1.enonce.multimedia;

public interface MediaPlayer {
	void pause(String titre, String author, String category, int length,
			Object contents);

	void close(String titre, String author, String category, int length,
			Object contents);

	void play(String titre, String author, String category, int length,
			Object contents);
}
