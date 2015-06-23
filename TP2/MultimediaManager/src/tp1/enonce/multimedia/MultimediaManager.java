/*
 * Modifier par
 * Isaac Ouellet Therrien (14056950)
 * Frédéric Carrier (14068395)
 * 
 */

package tp1.enonce.multimedia;

import tp1.enonce.multimedia.state.*;

public class MultimediaManager {

	final static String VIDEO = ".mov";
	final static String MUSIQUE = ".mp3";
	
	public final static MediaState CREATED = new CreatedState();
	public final static MediaState PAUSED = new PausedState();
	public final static MediaState PLAYING = new PlayingState();
	public final static MediaState STOPPED = new StoppedState();

	private MediaState state;
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
	 * s'il s'agit d'une location, la variable utilisation_ ne doit jamais ètre
	 * supérieure à maximum_
	 * 
	 * s'il s'agit d'une location, la variable d'instance maximum_ doit ètre
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
		setState(new CreatedState());
	}

	public void start() {

		// cette méthode ne peut être invoquée
		// que pour démarrer la lecture du document multimédia

		if (getUsage() == getMax()) {
			return;
		}

		state.start(this);
		// l'état de l'instance est PLAYING
	}

	public void pause() {

		// l'instance doit être dans l'état PLAYING
		// pour que cette opération soit valide

		state.pause(this);
		
		// l'état de l'instance est PAUSED
		// le nombre d'utilisation est incrémentée de 1
	}

	public void resume() {

		// cette opération n'est valide qu'après une pause
		state.resume(this);
		
		// l'état de l'instance est PLAYING
		// le nombre d'utilisation est décrémentée de 1
	}

	public void stop() {

		// le contenu doit jouer pour que cette opération soit valide
		state.stop(this);

		// l'état de l'instance est STOPPED
		// le nombre d'utilisation est incrémentée de 1
	}
	
	public void initPlayer(){
		if (categorie == MUSIQUE)
			setPlayer(iTunes.PLAYER);
		else
			setPlayer(QuickTime.PLAYER);
	}
	
	MediaState getState() {
		return state.getState();
	}

	public void setState(MediaState etat) {
		this.state = etat;
	}

	public int getMax() {
		return maximum;
	}

	void setMax(int max) {
		this.maximum = max;
	}

	public int getUsage() {
		return utilisation;
	}

	void setUsage(int utilisation) {
		this.utilisation = utilisation;
	}

	public void incrementUsage(){
		if(isLocation())
			setUsage(getUsage() + 1);
	}
	
	public void decrementUsage(){
		if(isLocation())
			setUsage(getUsage() - 1);
	}
	
	public boolean isLocation() {
		return location;
	}

	void setLocation(boolean location) {
		this.location = location;
	}

	public String getAuthor() {
		return auteur;
	}

	void setAuthor(String auteur) {
		this.auteur = auteur;
	}

	public String getTitle() {
		return titre;
	}

	void setTitle(String titre) {
		this.titre = titre;
	}

	public String getCategory() {
		return categorie;
	}

	void setCategory(String categorie) {
		this.categorie = categorie;
	}

	public int getSize() {
		return taille;
	}

	void setTaille(int taille) {
		this.taille = taille;
	}

	public Object getContenu() {
		return contenu;
	}

	void setContenu(Object contenu) {
		this.contenu = contenu;
	}

	public MediaPlayer getPlayer() {
		return player;
	}

	void setPlayer(MediaPlayer player) {
		this.player = player;
	}
}
