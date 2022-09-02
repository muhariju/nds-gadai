package id.co.nds.gadai.models;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import id.co.nds.gadai.validators.IdUserExistsConstraint;
import id.co.nds.gadai.validators.NomorHpUserExistsConstraint;

public class UserModel extends RecordModel {
    // main
    @NotEmpty(message = "Tidak boleh kosong")
    @IdUserExistsConstraint
    private String id;

    @NotEmpty(message = "Tidak boleh kosong")
    private String namaUser;

    @Pattern(regexp = "^0\\d{8,11}", message = "Harus di awali 0 dengan jumlah karakter minimal 9 dan maksimal 12")
    @NotEmpty(message = "Tidak boleh kosong")
    @NomorHpUserExistsConstraint
    private String nomorHp;

    private String keterangan;

    @NotNull(message = "Tidak boleh kosong")
    @Min(value = 500000, message = "Minimal limit 500.000,00")
    @Max(value = 1000000000, message = "Maksimal Limit 1.000.000.000")
    private Double limitTransaksi;

    @NotNull(message = "Tidak boleh kosong")
    private Date tanggalMasuk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Double getLimitTransaksi() {
        return limitTransaksi;
    }

    public void setLimitTransaksi(Double limitTransaksi) {
        this.limitTransaksi = limitTransaksi;
    }

    public Date getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(Date tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

}
