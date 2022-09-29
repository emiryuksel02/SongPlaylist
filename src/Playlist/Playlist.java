package Playlist;

import util.list.Iterator;
import util.list.LinkedList;
import util.list.ListManipulation;

/**
 * Provides needed methods for the playlist.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 */

public class Playlist extends ListManipulation {

    private LinkedList<Song> playlist = new LinkedList<Song>();
    private LinkedList<Song> history = new LinkedList<Song>();

    /**
     * Adds a song to the playlist.
     * 
     * @param song
     */
    public void add(Song song) {
        protectPlayingSong(this.playlist);
        Iterator<Song> iterator = this.playlist.iterator();

        /**
         * Checks if the song can be added in case of the given conditions:
         * 
         * Page 5, Lines 5-11 : "Ein Lied kann der Wiedergabeliste mehrfach hinzugefügt
         * werden, d. h. die Wiedergabeliste kann Lieder mit identischen Kennungen und
         * Attributen enthalten. Die Wiedergabeliste kann jedoch keine Lieder mit
         * identischen Kennungen und unterschiedlichen Attributen enthalten. Die Kennung
         * für ein Lied kann nach dem Entfernen neu vergeben werden, ebenso kann die
         * Wiedergabeliste auch Lieder mit identischen Attributen, aber
         * unterschiedlichen Kennungen enthalten."
         * 
         */

        while (iterator.hasNext()) {
            Song currentSong = iterator.next();

            if (currentSong.getId() == song.getId()) {
                if (!currentSong.getArtist().equals(song.getArtist()) || currentSong.getLength() != song.getLength()
                        || currentSong.getPriority() != song.getPriority()
                        || !currentSong.getTitle().equals(song.getTitle())) {

                    return;
                }
            }
        }

        playlist.add(song);

        setPlaylist(sortList(this.playlist));

    }

    /**
     * Removes a song by id.
     * 
     * @param id
     */

    public void remove(int id) {
        if (!songExists(id, this.playlist) || playlist.isEmpty()) {
            return;
        }
        Iterator<Song> iterator = this.playlist.iterator();
        LinkedList<Song> newPlaylist = new LinkedList<Song>();

        while (iterator.hasNext()) {
            Song currentSong = iterator.next();
            if (currentSong.getId() != id) {
                newPlaylist.add(currentSong);

            }
        }

        int removedAmount = playlist.size() - newPlaylist.size();
        if (removedAmount > 0) {
            System.out.println("Removed " + removedAmount + " songs.");
        }
        playlist = newPlaylist;

    }

    /**
     * Simulates playback of the playlist for the period of time specified seconds.
     * 
     * @param length
     */

    public void play(int length) {
        Iterator<Song> iterator = this.playlist.iterator();
        int sumLength = 0;
        int currentSongLength;
        while (sumLength < length) {
            if (playlist.isEmpty()) {
                return;
            }
            Song currentSong = iterator.next();
            sumLength = currentSong.getRemainingTime() + sumLength;
            if (sumLength <= length) {
                history.add(currentSong);
                this.playlist.remove(currentSong);

            }
            if (sumLength > length) {
                currentSongLength = sumLength - length;
                currentSong.setRemainingTime(currentSongLength);
                break;
            }

        }

    }

    /**
     * Skips the next song to be played and removes it from the playlist.
     */

    public void skip() {

        if (playlist.isEmpty()) {
            return;
        }

        Song skippedSong = firstSong(this.playlist);
        this.playlist.remove(skippedSong);

    }

    /**
     * Displays the next song to be played by priority. If there is no song, it
     * gives nothing.
     */

    public void peek() {
        if (this.playlist.isEmpty()) {
            System.out.println("");
            return;
        }
        Song peekSong = firstSong(this.playlist);
        System.out.println(peekSong.toString() + ":" + peekSong.getRemainingTime());
    }

    /**
     * Displays the full playlist sorted by priority.
     */

    public void list() {

        printAll(this.playlist);

    }

    /**
     * Displays the list of all previously fully simulated songs.
     * 
     * @return
     */

    public LinkedList<Song> history() {
        printAll(this.history);
        return this.history;
    }

    /**
     * Returns the playlist.
     * 
     * @return
     */
    public LinkedList<Song> getPlaylist() {
        return playlist;
    }

    /**
     * Setter for playlist.
     * 
     * @param playlist
     */
    public void setPlaylist(LinkedList<Song> playlist) {
        this.playlist = playlist;
    }

}
