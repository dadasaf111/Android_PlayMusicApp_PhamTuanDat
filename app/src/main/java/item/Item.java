package item;

public class Item {
    private int resourceId;
    private String tieuDe;
    private String moTa;

    public Item(int resourceId, String tieuDe, String moTa) {
        this.resourceId = resourceId;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
