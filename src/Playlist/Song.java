package Playlist;

/**
 * Modelizes a song.
 * 
 * @author Emir Yuksel
 * @version 1.0
 */

public class Song {
    private int id;
    private String artist;
    private String title;
    private int length;
    private int priority;
    private int remainingTime;
    private String formattedID;

    /**
     * Creates a song according to the given parameters.
     * 
     * @param id
     * @param artist
     * @param title
     * @param length
     * @param priority
     */

    public Song(int id, String artist, String title, int length, int priority) {
        this.setId(id);
        this.setArtist(artist);
        this.setTitle(title);
        this.setLength(length);
        this.setPriority(priority);
        this.setRemainingTime(length);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtist() {

        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    @Override
    public String toString() {
        setFormattedID(String.format("%05d", id));
        return getFormattedID() + ":" + getArtist() + ":" + getTitle() + ":" + getLength();
    }

    /**
     * Checks if the song is already being played.
     * 
     * @return
     */
    public boolean isPlaying() {
        if (this.remainingTime == this.length) {
            return false;
        }
        return true;
    }

    public String getFormattedID() {
        return formattedID;
    }

    public void setFormattedID(String formattedID) {
        this.formattedID = formattedID;
    }

}
