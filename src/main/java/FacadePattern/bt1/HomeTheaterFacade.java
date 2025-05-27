package FacadePattern.bt1;

public class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private SoundSystem soundSystem;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem soundSystem) {
        this.dvdPlayer = dvd;
        this.projector = projector;
        this.soundSystem = soundSystem;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing to watch a movie...");
        projector.on();
        projector.setInput("DVD");
        soundSystem.on();
        soundSystem.setVolume(8);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down home theater...");
        dvdPlayer.off();
        projector.off();
        soundSystem.off();
    }
}

