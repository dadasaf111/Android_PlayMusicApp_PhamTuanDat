package song;

import java.io.Serializable;

public class Song implements Serializable {
    private int resourceId;
    private int mp3;
    private String nameSong;
    private String nameArtist;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public int getMp3() {
        return mp3;
    }

    public void setMp3(int mp3) {
        this.mp3 = mp3;
    }

    public Song(int resourceId, String nameSong, String nameArtist) {
        this.resourceId = resourceId;
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
    }

    public Song ( String nameSong, String nameArtist,int resourceId, int mp3 ) {
        this.resourceId = resourceId;
        this.mp3 = mp3;
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
    }
}
