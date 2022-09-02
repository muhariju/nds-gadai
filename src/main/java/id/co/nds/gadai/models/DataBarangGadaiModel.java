package id.co.nds.gadai.models;

public class DataBarangGadaiModel {
    
    private String no;
    private String namaBarang;
    private String Kondisi;
    private Double jlh;
    private Double hargaPerSatuan;
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getNamaBarang() {
        return namaBarang;
    }
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }
    public String getKondisi() {
        return Kondisi;
    }
    public void setKondisi(String kondisi) {
        Kondisi = kondisi;
    }
    public Double getJlh() {
        return jlh;
    }
    public void setJlh(Double jlh) {
        this.jlh = jlh;
    }
    public Double getHargaPerSatuan() {
        return hargaPerSatuan;
    }
    public void setHargaPerSatuan(Double hargaPerSatuan) {
        this.hargaPerSatuan = hargaPerSatuan;
    }    
}
