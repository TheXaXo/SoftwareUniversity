package OnlineRadioDatabase;

import java.time.LocalTime;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<Song> songs;
    private LocalTime totalLength;

    public Playlist() {
        this.songs = new ArrayList<>();
        totalLength = LocalTime.of(0, 0, 0);
    }

    public void addSong(Song song) {
        this.songs.add(song);
        this.totalLength = this.totalLength.plusMinutes(song.getMinutes());
        this.totalLength = this.totalLength.plusSeconds(song.getSeconds());
    }

    public int getNumberOfSongs() {
        return this.songs.size();
    }

    public LocalTime getTotalLength() {
        return this.totalLength;
    }
}