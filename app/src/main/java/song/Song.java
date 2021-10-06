package song;

public class Song {
    private int resourceId;
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

    public Song(int resourceId, String nameSong, String nameArtist) {
        this.resourceId = resourceId;
        this.nameSong = nameSong;
        this.nameArtist = nameArtist;
    }
}
