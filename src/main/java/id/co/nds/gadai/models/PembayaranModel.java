package id.co.nds.gadai.models;

import javax.validation.constraints.NotNull;

public class PembayaranModel extends RecordModel {
    // main
    private String id;
    
    @NotNull(message = "Tidak boleh kosong")
    private String idTransaksi;

    @NotNull(message = "Tidak boleh kosong")
    private Double totalTagihanCicilan;

    @NotNull(message = "Tidak boleh kosong")
    private Double totalTagihanDenda;

    @NotNull(message = "Tidak boleh kosong")
    private Double biayaAdmTutup;

    @NotNull(message = "Tidak boleh kosong")
    private Double totalTagihan;

    @NotNull(message = "Tidak boleh kosong")
    private Double pembulatan;

    @NotNull(message = "Tidak boleh kosong")
    private Double jumlahPembayaran;

    @NotNull(message = "Tidak boleh kosong")
    private String metodeBayar;

    private Integer[] checkBayar;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Double getTotalTagihanCicilan() {
        return totalTagihanCicilan;
    }

    public void setTotalTagihanCicilan(Double totalTagihanCicilan) {
        this.totalTagihanCicilan = totalTagihanCicilan;
    }

    public Double getTotalTagihanDenda() {
        return totalTagihanDenda;
    }

    public void setTotalTagihanDenda(Double totalTagihanDenda) {
        this.totalTagihanDenda = totalTagihanDenda;
    }

    public Double getBiayaAdmTutup() {
        return biayaAdmTutup;
    }

    public void setBiayaAdmTutup(Double biayaAdmTutup) {
        this.biayaAdmTutup = biayaAdmTutup;
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

    public Double getJumlahPembayaran() {
        return jumlahPembayaran;
    }

    public void setJumlahPembayaran(Double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }

    public String getMetodeBayar() {
        return metodeBayar;
    }

    public void setMetodeBayar(String metodeBayar) {
        this.metodeBayar = metodeBayar;
    }

    public Integer[] getCheckBayar() {
        return checkBayar;
    }

    public void setCheckBayar(Integer[] checkBayar) {
        this.checkBayar = checkBayar;
    }
}
