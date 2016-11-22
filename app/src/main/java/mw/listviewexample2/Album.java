package mw.listviewexample2;

public class Album {

    private String artist;
    private String title;
    private int cover;

    public Album(String artist, String title, int cover) {
        this.artist = artist;
        this.title = title;
        this.cover = cover;
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
}
