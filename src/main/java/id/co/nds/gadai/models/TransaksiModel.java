package id.co.nds.gadai.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransaksiModel extends RecordModel {
    // main
    private String id;

    @NotEmpty(message = "Tidak boleh kosong")
    private String productId;

    @NotNull(message = "Tidak boleh kosong")
    private BigDecimal totalNilaiTaksiran;

    @NotNull(message = "Tidak boleh kosong")
    @Min(value = 1000000, message = "Tidak boleh kurang dari 1.000.000.00")
    private Double nilaiPencairanPelanggan;

    @NotNull(message = "Tidak boleh kosong")
    @Max(value = 100, message = "Tidak boleh lebih dari 100%")
    @Min(value = 0, message = "Tidak boleh kurang dari 0")
    private Double diskonAdmBuka;

    @NotEmpty(message = "Tidak boleh kosong")
    private String custId;

    private String produkName;
    private LocalDate trxDateBegin;
    private LocalDate trxDateEnd;
    private String namaPelanggan;
    private String nomorKtp;
    private Date tanggalJatuhTempo;
    private String status;
    private DataBarangGadaiModel[] dataBarangGadai;

    public void setDataBarangGadai(DataBarangGadaiModel[] dataBarangGadai) {
        this.dataBarangGadai = dataBarangGadai;
    }

    public DataBarangGadaiModel[] getDataBarangGadai() {
        return dataBarangGadai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }

    public void setTotalNilaiTaksiran(BigDecimal totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getProdukName() {
        return produkName;
    }

    public void setProdukName(String produkName) {
        this.produkName = produkName;
    }

    public LocalDate getTrxDateBegin() {
        return trxDateBegin;
    }

    public void setTrxDateBegin(LocalDate trxDateBegin) {
        this.trxDateBegin = trxDateBegin;
    }

    public LocalDate getTrxDateEnd() {
        return trxDateEnd;
    }

    public void setTrxDateEnd(LocalDate trxDateEnd) {
        this.trxDateEnd = trxDateEnd;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNamapelanggan() {
        return namaPelanggan;
    }

    public void setNamapelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
