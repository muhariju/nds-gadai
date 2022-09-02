package id.co.nds.gadai.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai.entities.PelangganEntity;
import id.co.nds.gadai.globals.GlobalConstant;
import id.co.nds.gadai.models.PelangganModel;
import id.co.nds.gadai.repos.PelangganRepo;
import id.co.nds.gadai.repos.specs.PelangganSpec;

@Service
public class PelangganService implements Serializable {
    @Autowired
    private PelangganRepo pelangganRepo;

    public List<String> doGetJenisUsaha() {
        List<String> jenisUsaha = new ArrayList<>();
        jenisUsaha.add("Pertanian, Kehutanan dan Perikanan");
        jenisUsaha.add("Pertambangan dan Penggalian");
        jenisUsaha.add("Industri Pengolahan");
        jenisUsaha.add("Pengadaan Listrik, Gas, Uap/Air Panas Dan Udara Dingin");
        jenisUsaha.add("Treatment dan Pemulihan Material Sampah, dan Aktivitas Remediasi");
        jenisUsaha.add("Konstruksi");
        jenisUsaha.add("Perdagangan Besar Dan Eceran");
        jenisUsaha.add("Pengangkutan dan Pergudangan");
        jenisUsaha.add("Penyediaan Akomodasi Dan Penyediaan Makan Minum");
        jenisUsaha.add("Informasi Dan Komunikasi");
        jenisUsaha.add("Aktivitas Keuangan dan Asuransi");
        jenisUsaha.add("Real Estat");
        jenisUsaha.add("Aktivitas Profesional, Ilmiah Dan Teknis");
        jenisUsaha.add("Aktivitas Penyewaan dan Penunjang Usaha Lainnya");
        jenisUsaha.add("Administrasi Pemerintahan, Pertahanan Dan Jaminan Sosial Wajib");
        jenisUsaha.add("Pendidikan");
        jenisUsaha.add("Aktivitas Kesehatan Manusia Dan Aktivitas Sosial");
        jenisUsaha.add("Kesenian, Hiburan Dan Rekreasi");
        jenisUsaha.add("Aktivitas Jasa Lainnya");
        jenisUsaha.add("Aktivitas Rumah Tangga");
        jenisUsaha.add("Aktivitas Badan Internasional Dan Badan Ekstra Internasional Lainnya");
        return jenisUsaha;
    }

    public List<PelangganEntity> doGetAllPelanggan() {
        List<PelangganEntity> pelanggan = new ArrayList<>();
        pelangganRepo.findAll().forEach(pelanggan::add);
        return pelanggan;
    }

    public List<PelangganEntity> doSearchPelanggan(PelangganModel pelangganModel) {
        List<PelangganEntity> pelanggan = new ArrayList<>();
        PelangganSpec specs = new PelangganSpec(pelangganModel);
        pelangganRepo.findAll(specs).forEach(pelanggan::add);
        return pelanggan;
    }

    public PelangganEntity doInsert(PelangganModel pelangganModel) {

        // process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan.setNamaPelanggan(pelangganModel.getNamaPelanggan());
        pelanggan.setNomorHp(pelangganModel.getNomorHp());
        pelanggan.setNomorKtp(pelangganModel.getNomorKtp());
        pelanggan.setJenisKelamin(pelangganModel.getJenisKelamin());
        pelanggan.setJenisUsaha(pelangganModel.getJenisUsaha());
        pelanggan.setLimitPinjaman(pelangganModel.getLimitPinjaman());
        pelanggan.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        pelanggan.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        pelanggan.setCreatorId(
                pelangganModel.getActorId() == null ? 0 : pelangganModel.getActorId());
        return pelangganRepo.save(pelanggan);
    }

    public PelangganEntity findById(String id) {
        // process
        PelangganEntity pelanggan = pelangganRepo.findById(id).orElse(null);
        return pelanggan;
    }

    public PelangganEntity doUpdate(PelangganModel pelangganModel) {
        // validation

        // process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan = findById(pelangganModel.getId());
        pelanggan.setNamaPelanggan(pelangganModel.getNamaPelanggan());
        pelanggan.setNomorHp(pelangganModel.getNomorHp());
        pelanggan.setNomorKtp(pelangganModel.getNomorKtp());
        pelanggan.setJenisKelamin(pelangganModel.getJenisKelamin());
        pelanggan.setJenisUsaha(pelangganModel.getJenisUsaha());
        pelanggan.setLimitPinjaman(pelangganModel.getLimitPinjaman());

        pelanggan.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        pelanggan.setUpdaterId(
                pelangganModel.getActorId() == null ? 0 : pelangganModel.getActorId());

        return pelangganRepo.save(pelanggan);
    }

    public PelangganEntity doDelete(PelangganModel pelangganModel) {
        // validation

        // process
        PelangganEntity pelanggan = new PelangganEntity();
        pelanggan = findById(pelangganModel.getId());

        pelanggan.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        pelanggan.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        pelanggan.setDeleterId(
                pelangganModel.getActorId() == null ? 0 : pelangganModel.getActorId());

        pelangganRepo.doDelete(pelanggan.getId(), pelanggan.getDeleterId());
        return pelanggan;
    }
}
