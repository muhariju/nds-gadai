package id.co.nds.gadai.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import id.co.nds.gadai.validators.NomorHpPelangganExistsConstraint;
import id.co.nds.gadai.validators.NomorKtpPelangganExistsConstraint;

public class PelangganModel extends RecordModel {
    // main
    private String id;

    @NotEmpty(message = "Tidak boleh kosong")
    private String namaPelanggan;

    @NomorKtpPelangganExistsConstraint
    @NotEmpty(message = "Tidak boleh kosong")
    @Pattern(regexp = "^\\d{16}", message = "Harus 16 digit")
    private String nomorKtp;

    @NomorHpPelangganExistsConstraint
    @Pattern(regexp = "^0\\d{8,11}", message = "Harus di awali 0 dengan jumlah karakter minimal 9 dan maksimal 12")
    private String nomorHp;

    @NotEmpty(message = "Tidak boleh kosong")
    private String jenisKelamin;

    @NotEmpty(message = "Tidak boleh kosong")
    private String jenisUsaha;

    @NotNull(message = "Tidak boleh kosong")
    @Min(value = 1000000, message = "Minimal limit 1.000.000,00")
    //@Pattern(regexp = "^(([1-9]\\d{6,8}|[1-2]\\d{9})(|\\.\\d{1,2}))|3000000000", message = "Maksimal Limit 3.000.000.000")
    @Max(value = 3000000000L, message = "Maksimal Limit 3.000.000.000") 
    private Double limitPinjaman;

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

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisUsaha() {
        return jenisUsaha;
    }

    public void setJenisUsaha(String jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
    }

    public Double getLimitPinjaman() {
        return limitPinjaman;
    }

    public void setLimitPinjaman(Double limitPinjaman) {
        this.limitPinjaman = limitPinjaman;
    }

}
