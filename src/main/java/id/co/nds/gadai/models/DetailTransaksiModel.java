package id.co.nds.gadai.models;

import javax.validation.constraints.NotEmpty;

public class DetailTransaksiModel extends RecordModel {
    // main
    @NotEmpty(message = "Tidak boleh kosong")
    private String idTransaksi;

    @NotEmpty(message = "Tidak boleh kosong")
    private Integer noUrut;

    @NotEmpty(message = "Tidak boleh kosong")
    private String namaBarang;

    @NotEmpty(message = "Tidak boleh kosong")
    private Double nilaiPencairanPelanggan;

    @NotEmpty(message = "Tidak boleh kosong")
    private Double diskonAdmBuka;

    @NotEmpty(message = "Tidak boleh kosong")
    private Double hargaPerSatuan;

    
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Double getNilaiPencairanPelanggan() {
        return nilaiPencairanPelanggan;
    }

    public void setNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) {
        this.nilaiPencairanPelanggan = nilaiPencairanPelanggan;
    }

    public Double getDiskonAdmBuka() {
        return diskonAdmBuka;
    }

    public void setDiskonAdmBuka(Double diskonAdmBuka) {
        this.diskonAdmBuka = diskonAdmBuka;
    }

    public Double getHargaPerSatuan() {
        return hargaPerSatuan;
    }

    public void setHargaPerSatuan(Double hargaPerSatuan) {
        this.hargaPerSatuan = hargaPerSatuan;
    }
}
