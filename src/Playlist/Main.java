package Playlist;

/**
 * This program provides playlist for radio stations.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 */

public final class Main {

    private Main() {

    }

    /**
     * Main entry point to the application.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        PlaylistUI playlistUI = new PlaylistUI(playlist);
        playlistUI.interactive();

    }

}