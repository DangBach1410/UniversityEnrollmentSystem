package AdapterPattern.bt1;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new NewAudioPlayer();

        player.play("mp3", "song1.mp3");
        player.play("mp4", "video1.mp4");
        player.play("vlc", "clip1.vlc");
        player.play("avi", "movie.avi");
    }
}
