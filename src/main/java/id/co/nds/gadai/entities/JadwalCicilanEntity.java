package id.co.nds.gadai.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import id.co.nds.gadai.controllers.composites.IdCicilan;

@Entity
@Table(name = "tx_jadwalcicilan")
public class JadwalCicilanEntity implements Serializable{
    
    @EmbeddedId
    private IdCicilan idTransaksi;

    @Column(name = "pokok")
    private Double pokok;

    @Column(name = "bunga")
    private Double bunga;

    @Column(name = "denda")
    private Double denda;

    @Column(name = "status")
    private String status;

    @Column(name = "tanggal_aktif")
    private LocalDate tanggalAktif;

    @Column(name = "tanggal_jatuh_tempo")
    private LocalDate tanggalJatuhTempo;

    @Column(name = "tanggal_bayar")
    private LocalDate tanggalBayar;
    public JadwalCicilanEntity(){}
    public JadwalCicilanEntity(IdCicilan idTransaksi, Double pokok, Double bunga, String status, LocalDate tanggalAktif, LocalDate tanggalJatuhTempo){
        this.idTransaksi = idTransaksi;
        this.pokok = pokok;
        this.bunga = bunga;
        this.status = status;
        this.tanggalAktif = tanggalAktif;
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }
    public JadwalCicilanEntity(IdCicilan idTransaksi, String status){
        this.idTransaksi = idTransaksi;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getTanggalAktif() {
        return tanggalAktif;
    }

    public void setTanggalAktif(LocalDate tanggalAktif) {
        this.tanggalAktif = tanggalAktif;
    }

    public LocalDate getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(LocalDate tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public LocalDate getTanggalBayar() {
        return tanggalBayar;
    }

    public void setTanggalBayar(LocalDate tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    public Double getDenda() {
        return denda;
    }

    public void setDenda(Double denda) {
        this.denda = denda;
    }
}
