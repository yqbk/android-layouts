package mw.gridviewexample;

import java.io.Serializable;

public class Song implements Serializable {

    private int number;
    private String artist;
    private String title;

    public Song(int number, String artist, String title) {
        this.number = number;
        this.artist = artist;
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
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
}
