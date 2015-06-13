package tp1.enonce.multimedia;

public class MultimediaManager {

	final static String VIDEO = ".mov";
	final static String MUSIQUE = ".mp3";

	final static private int CREATED = 1;
	final static private int PAUSED = 2;
	final static private int PLAYING = 3;
	final static private int STOPPED = 4;

	private int etat;
	private int maximum;
	private int utilisation;
	private boolean location;

	private String auteur;
	private String titre;
	private String categorie; // MUSIQUE ou VIDEO
	private int taille;
	private Object contenu;

	private MediaPlayer player;

	/**
	 * s'il s'agit d'une location, la variable utilisation_ ne doit jamais être
	 * supérieure à maximum_
	 * 
	 * s'il s'agit d'une location, la variable d'instance maximum_ doit être
	 * supérieure à 0
	 * 
	 * s'il s'agit d'une location, la valeur de la variable d'instance
	 * utilisation_ correspond à la différence entre le nombre d'invocations des
	 * méthodes pause() et stop() et le nombre d'invocations de la méthode
	 * resume()
	 */

	public MultimediaManager(boolean location, int maximum, String auteur,
			String titre, String categorie, int taille, Object contenu) {
		this.location = location;
		this.maximum = maximum;

		this.auteur = auteur;
		this.titre = titre;
		this.categorie = categorie;
		this.taille = taille;
		this.contenu = contenu;

		utilisation = 0;
		etat = (new createdState);
	}

	public void start() {

		// cette méthode ne peut être invoquée
		// que pour démarrer la lecture du document multimédia

		if (getUsage() == getMax()) {
			return;
		}

		if (etat == CREATED) {
			if (categorie == MUSIQUE) {
				player = iTunes.PLAYER;
				player.play(titre, auteur, categorie, taille, contenu);
				etat = PLAYING;
			}
			if (categorie == VIDEO) {
				player = QuickTime.PLAYER;
				player.play(titre, auteur, categorie, taille, contenu);
				etat = PLAYING;
			}
		}
		if (etat == STOPPED) {
			if (categorie == MUSIQUE) {
				player.play(titre, auteur, categorie, taille, contenu);
				etat = PLAYING;
			}
			if (categorie == VIDEO) {
				player.play(titre, auteur, categorie, taille, contenu);
				etat = PLAYING;
			}
		}
		// l'état de l'instance est PLAYING
	}

	public void pause() {

		// l'instance doit être dans l'état PLAYING
		// pour que cette opération soit valide

		if (categorie == MUSIQUE) {
			player.pause(titre, auteur, categorie, taille, contenu);
			if (location) {
				utilisation = utilisation + 1;
			}
			etat = PAUSED;
		}

		if (categorie == VIDEO) {
			player.pause(titre, auteur, categorie, taille, contenu);
			if (location) {
				utilisation = utilisation + 1;
			}
			etat = PAUSED;
		}
		// l'état de l'instance est PAUSED
		// le nombre d'utilisation est incrémentée de 1
	}

	public void resume() {

		// cette opération n’est valide qu’après une pause

		if (location) {
			utilisation = utilisation - 1;
		}
		if (categorie == MUSIQUE) {
			player.play(titre, auteur, categorie, taille, contenu);
			etat = PLAYING;
		}
		if (categorie == VIDEO) {
			player.play(titre, auteur, categorie, taille, contenu);
			etat = PLAYING;
		}
		// l'état de l'instance est PLAYING
		// le nombre d'utilisation est décrémentée de 1
	}

	public void stop() {

		// le contenu doit jouer pour que cette opération soit valide

		if (categorie == MUSIQUE) {
			player.close(titre, auteur, categorie, taille, contenu);
			if (location) {
				utilisation = utilisation + 1;
			}
			etat = STOPPED;
		}

		if (categorie == VIDEO) {
			player.close(titre, auteur, categorie, taille, contenu);
			if (location) {
				utilisation = utilisation + 1;
			}
			etat = STOPPED;
		}

		// l'état de l'instance est STOPPED
		// le nombre d'utilisation est incrémentée de 1
	}

}
