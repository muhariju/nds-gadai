package id.co.nds.gadai.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tx_transaksi")
public class ViewPembayaranDetailEntity {
    
    @Id
    @Column(name = "id")
    private String id;
    
    @Column(name = "nama_pelanggan")
    private String namaPelanggan;
    
    @Column(name = "product_id")
    private String productId;
    
    @Column(name = "nama_produk")
    private String namaProduk;
    
    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "tanggal_transaksi")
    private LocalDate tanggalTransaksi;
    
    @Column(name = "cust_id")
    private String custId;
    
    @Column(name = "total_pinjaman")
    private Double totalPinjaman;
    
    @Column(name = "tanggal_jatuh_tempo")
    private LocalDate tanggalJatuhTempo;
    
    @Column(name = "total_kewajiban")
    private Double totalKewajiban;
    
    @Column(name = "total_denda")
    private Double totalDenda;
    
    @Column(name = "total_pembayaran")
    private Double totalPembayaran;

    @Column(name = "jangka_waktu")
    private Integer jangkaWaktu;

    public Integer getJangkaWaktu() {
        return jangkaWaktu;
    }

    public void setJangkaWaktu(Integer jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public LocalDate getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(LocalDate tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Double getTotalPinjaman() {
        return totalPinjaman;
    }

    public void setTotalPinjaman(Double totalPinjaman) {
        this.totalPinjaman = totalPinjaman;
    }

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(LocalDate tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public Double getTotalKewajiban() {
        return totalKewajiban;
    }

    public void setTotalKewajiban(Double totalKewajiban) {
        this.totalKewajiban = totalKewajiban;
    }

    public Double getTotalDenda() {
        return totalDenda;
    }

    public void setTotalDenda(Double totalDenda) {
        this.totalDenda = totalDenda;
    }

    public Double getTotalPembayaran() {
        return totalPembayaran;
    }

    public void setTotalPembayaran(Double totalPembayaran) {
        this.totalPembayaran = totalPembayaran;
    }
    
}
