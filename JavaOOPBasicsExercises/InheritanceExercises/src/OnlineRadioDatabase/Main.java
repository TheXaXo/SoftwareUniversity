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

            if (tokens.length != 3) {
                System.out.println("Invalid song.");
                continue;
            }

            String artist = tokens[0];
            String name = tokens[1];

            String[] lengthArgs = tokens[2].split(":");

            if (lengthArgs.length != 2) {
                System.out.println("Invalid song length.");
                continue;
            }

            int minutes = Integer.parseInt(lengthArgs[0]);
            int seconds = Integer.parseInt(lengthArgs[1]);

            try {
                Song song = new Song(artist, name, minutes, seconds);
                playlist.addSong(song);

                System.out.println("Song added.");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Songs added: %d%n", playlist.getNumberOfSongs());
        System.out.printf("Playlist length: %dh %dm %ds%n",
                playlist.getTotalLength().getHour(), playlist.getTotalLength().getMinute(), playlist.getTotalLength().getSecond());
    }
}