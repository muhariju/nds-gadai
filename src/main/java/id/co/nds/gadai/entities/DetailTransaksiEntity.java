package id.co.nds.gadai.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import id.co.nds.gadai.controllers.composites.IdTransaksi;

@Entity
@Table(name = "tx_detailtransaksi")
public class DetailTransaksiEntity implements Serializable{

    @EmbeddedId
    private IdTransaksi idTransaksi;
    
    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "kondisi")
    private String kondisi;

    @Column(name = "jlh")
    private Double jlh;

    @Column(name = "harga_per_satuan")
    private Double hargaPerSatuan;

    public DetailTransaksiEntity(){}

    public DetailTransaksiEntity(IdTransaksi idTransaksi, String namaBarang, String kondisi, Double jlh, Double hargaPerSatuan) {
        this.idTransaksi = idTransaksi;
        this.namaBarang = namaBarang;
        this.kondisi = kondisi;
        this.jlh = jlh;
        this.hargaPerSatuan = hargaPerSatuan;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
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
