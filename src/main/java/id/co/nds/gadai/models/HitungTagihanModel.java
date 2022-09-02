package id.co.nds.gadai.models;

import javax.persistence.Id;

public class HitungTagihanModel {
    // main
    @Id
    private String id;

    private Integer[] checkBayar;
    private Double diskon;
    private Double totalPembayaranCicilan;
    private Double totalPembayaranDenda;
    private Double biayaAdminTutup;
    private Double totalTagihan;
    private Double pembulatan;
    private Double totalTagihanSetelahPembulatan;
    private Double metodePembayaran;

    public Double getTotalPembayaranCicilan() {
        return totalPembayaranCicilan;
    }
    public void setTotalPembayaranCicilan(Double totalPembayaranCicilan) {
        this.totalPembayaranCicilan = totalPembayaranCicilan;
    }
    public Double getTotalPembayaranDenda() {
        return totalPembayaranDenda;
    }
    public void setTotalPembayaranDenda(Double totalPembayaranDenda) {
        this.totalPembayaranDenda = totalPembayaranDenda;
    }
    public Double getBiayaAdminTutup() {
        return biayaAdminTutup;
    }
    public void setBiayaAdminTutup(Double biayaAdminTutup) {
        this.biayaAdminTutup = biayaAdminTutup;
    }
    public Double getTotalTagihan() {
        return totalTagihan;
    }
    public void setTotalTagihan(Double totalTagihan) {
        this.totalTagihan = totalTagihan;
    }
    public Double getPembulatan() {
        return pembulatan;
    }
    public void setPembulatan(Double pembulatan) {
        this.pembulatan = pembulatan;
    }
    public Double getTotalTagihanSetelahPembulatan() {
        return totalTagihanSetelahPembulatan;
    }
    public void setTotalTagihanSetelahPembulatan(Double totalTagihanSetelahPembulatan) {
        this.totalTagihanSetelahPembulatan = totalTagihanSetelahPembulatan;
    }
    public Double getMetodePembayaran() {
        return metodePembayaran;
    }
    public void setMetodePembayaran(Double metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer[] getCheckBayar() {
        return checkBayar;
    }
    public void setCheckBayar(Integer[] checkBayar) {
        this.checkBayar = checkBayar;
    }
    public Double getDiskon() {
        return diskon;
    }
    public void setDiskon(Double diskon) {
        this.diskon = diskon;
    }

}
