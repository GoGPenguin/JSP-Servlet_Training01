package Model.BEAN;

public class Vacxin {
    private String idVacxin;
    private String nameVacxin;
    private int soMui;
    private String moTa;
    private int giaVacxin;
    private String tenHangSX;
    public Vacxin() {
        super();
    }

    public Vacxin(String id) {
        this.idVacxin = "-1";
    }

    public String getIdVacxin() {
        return idVacxin;
    }

    public void setIdVacxin(String idVacxin) {
        this.idVacxin = idVacxin;
    }

    public String getNameVacxin() {
        return nameVacxin;
    }

    public void setNameVacxin(String nameVacxin) {
        this.nameVacxin = nameVacxin;
    }

    public int getSoMui() {
        return soMui;
    }

    public void setSoMui(int soMui) {
        this.soMui = soMui;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getGiaVacxin() {
        return giaVacxin;
    }

    public void setGiaVacxin(int giaVacxin) {
        this.giaVacxin = giaVacxin;
    }

    public String getTenHangSX() {
        return tenHangSX;
    }

    public void setTenHangSX(String tenHangSX) {
        this.tenHangSX = tenHangSX;
    }
}
