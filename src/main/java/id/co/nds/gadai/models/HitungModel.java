package id.co.nds.gadai.models;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class HitungModel {
    // main
    @NotNull(message = "Tidak boleh kosong")
    private String idprodukTransaksi;
    @NotNull(message = "Tidak boleh kosong")
    @Min(value = 1000000, message = "Tidak boleh kurang dari 1.000.000.00")
    private Double nilaiPencairanPelanggan;
    @NotNull(message = "Tidak boleh kosong")
    private Double diskonAdmBuka;

    private Double totalNilaiTaksiran;
    private Double ltv;
    private Double maksimalNilaiPinjaman;
    private Double adminBuka;
    private Double adminBukaAkhir;
    private Double totalNilaiPinjaman;
    
    private LocalDate tglTransaksi;
    private LocalDate tanggalJatuhTempo;
    private Double jasaPenyimpanan;
    private Integer jasaPenyimpananPeriode;
    private Double BiayaJasaPenyimpananPerPeriode;
    private Double totalBiayaJasaPenyimpanan;
    private Double adminTutup;
    private Double totalPengembalian;

    public String getIdprodukTransaksi() {
        return idprodukTransaksi;
    }
    public void setIdprodukTransaksi(String idprodukTransaksi) {
        this.idprodukTransaksi = idprodukTransaksi;
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
    public Double getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }
    public void setTotalNilaiTaksiran(Double totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
    }
    public Double getLtv() {
        return ltv;
    }
    public void setLtv(Double ltv) {
        this.ltv = ltv;
    }
    public Double getMaksimalNilaiPinjaman() {
        return maksimalNilaiPinjaman;
    }
    public void setMaksimalNilaiPinjaman(Double maksimalNilaiPinjaman) {
        this.maksimalNilaiPinjaman = maksimalNilaiPinjaman;
    }
    public Double getAdminBuka() {
        return adminBuka;
    }
    public void setAdminBuka(Double adminBuka) {
        this.adminBuka = adminBuka;
    }
    public Double getAdminBukaAkhir() {
        return adminBukaAkhir;
    }
    public void setAdminBukaAkhir(Double adminBukaAkhir) {
        this.adminBukaAkhir = adminBukaAkhir;
    }
    public Double getTotalNilaiPinjaman() {
        return totalNilaiPinjaman;
    }
    public void setTotalNilaiPinjaman(Double totalNilaiPinjaman) {
        this.totalNilaiPinjaman = totalNilaiPinjaman;
    }
    public LocalDate getTglTransaksi() {
        return tglTransaksi;
    }
    public void setTglTransaksi(LocalDate tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }
    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }
    public void setTanggalJatuhTempo(LocalDate tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }
    public Double getJasaPenyimpanan() {
        return jasaPenyimpanan;
    }
    public void setJasaPenyimpanan(Double jasaPenyimpanan) {
        this.jasaPenyimpanan = jasaPenyimpanan;
    }
    public Integer getJasaPenyimpananPeriode() {
        return jasaPenyimpananPeriode;
    }
    public void setJasaPenyimpananPeriode(Integer jasaPenyimpananPeriode) {
        this.jasaPenyimpananPeriode = jasaPenyimpananPeriode;
    }
    public Double getBiayaJasaPenyimpananPerPeriode() {
        return BiayaJasaPenyimpananPerPeriode;
    }
    public void setBiayaJasaPenyimpananPerPeriode(Double biayaJasaPenyimpananPerPeriode) {
        BiayaJasaPenyimpananPerPeriode = biayaJasaPenyimpananPerPeriode;
    }
    public Double getTotalBiayaJasaPenyimpanan() {
        return totalBiayaJasaPenyimpanan;
    }
    public void setTotalBiayaJasaPenyimpanan(Double totalBiayaJasaPenyimpanan) {
        this.totalBiayaJasaPenyimpanan = totalBiayaJasaPenyimpanan;
    }
    public Double getAdminTutup() {
        return adminTutup;
    }
    public void setAdminTutup(Double adminTutup) {
        this.adminTutup = adminTutup;
    }
    public Double getTotalPengembalian() {
        return totalPengembalian;
    }
    public void setTotalPengembalian(Double totalPengembalian) {
        this.totalPengembalian = totalPengembalian;
    }

}
