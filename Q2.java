import java.util.Arrays;

class Playlist {
    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Q2 {
    public static void main(String[] args) {

        System.out.println("Name: Pritham M");

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("Songs in playlist:");

        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("Modified copy:");

        for (String song : copy) {
            System.out.println(song);
        }

        System.out.println("Actual playlist:");

        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Song count: " + p.getSongCount());
    }
}