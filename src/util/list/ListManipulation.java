package util.list;

import Playlist.Song;

/**
 * Provides useful methods for the playlist.
 * 
 * @author Emir Yuksel
 * @version 1.0
 *
 */

public class ListManipulation {
    private static final int PLAYING_SONG_PRIORITY = -2147483648;

    private LinkedList<Song> unsortedSongSet = new LinkedList<Song>();

    /**
     * Prints all elements from playlist.
     * 
     * @param playlist
     */

    public void printAll(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        while (iterator.hasNext()) {
            Song currentSong = iterator.next();
            System.out.println(currentSong.toString());
        }
    }

    /**
     * Checks if a song with the given id exists in the playlist.
     * 
     * @param id
     * @param playlist
     * @return
     */

    public boolean songExists(int id, LinkedList<Song> playlist) {
        int i = 0;
        Iterator<Song> iterator = playlist.iterator();
        while (iterator.hasNext()) {
            Song currentSong = iterator.next();
            if (currentSong.getId() == id) {
                i++;
                break;
            }
        }

        if (i > 0) {
            return true;
        }

        return false;
    }

    /**
     * Finds the first song of the playlist.
     * 
     * @param playlist
     * @return
     */
    public Song firstSong(LinkedList<Song> playlist) {

        Song firstSong = playlist.first();
        return firstSong;
    }

    /**
     * According to the task, if a song is already being played; priority of the
     * next added song does not matter. It protects the playing song by setting its
     * priority to minimum number that can be an integer.
     * 
     * @param playlist
     */
    public void protectPlayingSong(LinkedList<Song> playlist) {
        if (playlist.isEmpty()) {
            return;
        }

        Song playingSong = playlist.first();
        if (playingSong.getRemainingTime() < playingSong.getLength()) {
            playingSong.setPriority(PLAYING_SONG_PRIORITY);
        }

    }

    /**
     * Converts playlist to a song array.
     * 
     * @param playlist
     * @return
     */

    public Song[] toArray(LinkedList<Song> playlist) {
        Song[] songSet = new Song[playlist.size()];
        Iterator<Song> iterator = playlist.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Song currentSong = iterator.next();
            songSet[i] = currentSong;
            i++;
        }
        return songSet;
    }

    /**
     * Returns the song with minimum priority.
     */
    public Song getSongWithMinPriority(LinkedList<Song> playlist) {

        Song[] songSet = toArray(playlist);
        Song minPrioritySong = songSet[0];
        for (int k = 1; k < songSet.length; k++) {
            if (minPrioritySong.getPriority() > songSet[k].getPriority()) {
                minPrioritySong = songSet[k];
            }
        }

        return minPrioritySong;

    }

    /**
     * Sorts the playlist depending on priority.
     * 
     * @param playlist
     * @return
     */

    public LinkedList<Song> sortList(LinkedList<Song> playlist) {
        LinkedList<Song> sortedList = new LinkedList<Song>();
        int i = playlist.size();
        for (int k = 0; k < i; k++) {
            sortedList.add(getSongWithMinPriority(playlist));
            playlist.remove(getSongWithMinPriority(playlist));
        }
        return sortedList;

    }

    public LinkedList<Song> getUnsortedSongSet() {
        return unsortedSongSet;
    }

    public void setUnsortedSongSet(LinkedList<Song> unsortedSongSet) {
        this.unsortedSongSet = unsortedSongSet;
    }

}
