package id.co.nds.gadai.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import id.co.nds.gadai.controllers.composites.IdCicilan;

@Entity
@Table(name = "tx_transaksi")
public class ViewPembayaranTransaksiEntity {
    
    @EmbeddedId
    private IdCicilan idTransaksi;

    @Column(name = "id")
    private String id;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "nama_pelanggan")
    private String custName;

    @Column(name = "nomor_ktp")
    private String nomorKtp;

    @Column(name = "tanggal_transaksi")
    private Date tanggalTransaksi;

    @Column(name = "tanggal_aktif")
    private Date tanggalAktif;

    @Column(name = "tanggal_jatuh_tempo")
    private Date tanggalJatuhTempo;

    @Column(name = "tanggal_bayar")
    private Date tanggalBayar;

    @Column(name = "pokok")
    private Double pokok;

    @Column(name = "bunga")
    private Double bunga;

    @Column(name = "denda")
    private Double denda;

    @Column(name = "status")
    private String status;
    
    @Column(name = "cicilanke")
    private String cicilanKe;

    @Column(name = "total_tagihan")
    private String totalTagihan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
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

    public String getCicilanKe() {
        return cicilanKe;
    }

    public void setCicilanKe(String cicilanKe) {
        this.cicilanKe = cicilanKe;
    }

    public String getTotalTagihan() {
        return totalTagihan;
    }

    public void setTotalTagihan(String totalTagihan) {
        this.totalTagihan = totalTagihan;
    }

    public Date getTanggalAktif() {
        return tanggalAktif;
    }

    public void setTanggalAktif(Date tanggalAktif) {
        this.tanggalAktif = tanggalAktif;
    }
    
    public Date getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(Date tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public IdCicilan getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(IdCicilan idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public Double getPokok() {
        return pokok;
    }

    public void setPokok(Double pokok) {
        this.pokok = pokok;
    }

    public Double getBunga() {
        return bunga;
    }

    public void setBunga(Double bunga) {
        this.bunga = bunga;
    }

    public Double getDenda() {
        return denda;
    }

    public void setDenda(Double denda) {
        this.denda = denda;
    }
    
}
