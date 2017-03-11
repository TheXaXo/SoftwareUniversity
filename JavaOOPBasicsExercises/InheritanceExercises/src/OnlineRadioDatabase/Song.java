package OnlineRadioDatabase;

import java.time.LocalTime;

public class Song {
    private String artist;
    private String name;
    private int minutes;
    private int seconds;
    private LocalTime length;

    public Song(String artist, String name, int minutes, int seconds) {
        this.setArtist(artist);
        this.setName(name);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
        this.setLength();
    }

    public void setLength() {
        this.length = LocalTime.of(0, this.getMinutes(), this.getSeconds());
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        if (artist.length() < 3 || artist.length() > 20) {
            throw new IllegalArgumentException("Artist name should be between 3 and 20 symbols.");
        }

        this.artist = artist;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 30) {
            throw new IllegalArgumentException("Song name should be between 3 and 30 symbols.");
        }

        this.name = name;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new IllegalArgumentException("Song minutes should be between 0 and 14.");
        }

        this.minutes = minutes;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new IllegalArgumentException("Song seconds should be between 0 and 59.");
        }

        this.seconds = seconds;
    }
}