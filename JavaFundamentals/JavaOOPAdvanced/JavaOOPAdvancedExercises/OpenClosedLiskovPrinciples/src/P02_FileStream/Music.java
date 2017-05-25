package P02_FileStream;

public class Music extends BaseStreamable {

    private String artist;
    private String album;

    public Music(int length, int bytesSent, String artist, String album) {
        super(length, bytesSent);
        this.setArtist(artist);
        this.setAlbum(album);
    }

    public String getArtist() {
        return this.artist;
    }

    private void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return this.album;
    }

    private void setAlbum(String album) {
        this.album = album;
    }
}