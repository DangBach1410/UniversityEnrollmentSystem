package FacadePattern.bt1;

public class Main {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);

        homeTheater.watchMovie("Avengers: Endgame");
        System.out.println("--- After Movie ---");
        homeTheater.endMovie();
    }
}

