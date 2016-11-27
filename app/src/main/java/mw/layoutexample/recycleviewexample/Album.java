package mw.layoutexample.recycleviewexample;

import java.io.Serializable;
import java.util.List;

public class Album implements Serializable {

    private String artist;
    private String title;
    private int cover;
    private List<Song> songs;

    public Album(String artist, String title, int cover, List<Song> songs) {
        this.artist = artist;
        this.title = title;
        this.cover = cover;
        this.songs = songs;
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

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
