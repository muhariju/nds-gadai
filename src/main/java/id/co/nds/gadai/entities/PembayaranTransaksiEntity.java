package id.co.nds.gadai.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tx_pembayaran")
public class PembayaranTransaksiEntity implements Serializable{
    @Id
    @GenericGenerator(name = "ms_id_seq",
        strategy = "id.co.nds.gadai.generators.TransaksiIdGenerator")
    @GeneratedValue(generator = "ms_id_seq")
    @Column(name = "id")
    private String id;
    
    @Column(name = "id_transaksi")
    private String idTransaksi;

    @Column(name = "total_tagihan_cicilan")
    private Double totalTagihanCicilan;

    @Column(name = "total_tagihan_denda")
    private Double totalTagihanDenda;

    @Column(name = "biaya_adm_tutup")
    private Double biayaAdmTutup;

    @Column(name = "total_tagihan")
    private Double totalTagihan;

    @Column(name = "pembulatan")
    private Double pembulatan;

    @Column(name = "jumlah_pembayaran")
    private Double jumlahPembayaran;

    @Column(name = "metode_bayar")
    private String metodeBayar;

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
}
