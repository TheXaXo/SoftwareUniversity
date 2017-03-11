package OnlineRadioDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Playlist playlist = new Playlist();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(";");

            String artist;
            String name;
            String[] lengthArgs;

            try {
                artist = tokens[0];
                name = tokens[1];
                lengthArgs = tokens[2].split(":");
            } catch (Exception ex) {
                System.out.println("Invalid song.");
                continue;
            }

            int minutes;
            int seconds;

            try {
                minutes = Integer.parseInt(lengthArgs[0]);
                seconds = Integer.parseInt(lengthArgs[1]);
            } catch (Exception ex) {
                System.out.println("Invalid song length.");
                continue;
            }

            try {
                Song song = new Song(artist, name, minutes, seconds);
                playlist.addSong(song);

                System.out.println("Song added.");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", playlist.getNumberOfSongs());
        System.out.printf("Playlist length: %dh %dm %ds%n",
                playlist.getTotalLength().getHour(), playlist.getTotalLength().getMinute(), playlist.getTotalLength().getSecond());
    }
}