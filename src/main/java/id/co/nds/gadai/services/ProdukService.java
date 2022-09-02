package id.co.nds.gadai.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai.entities.ProdukEntity;
import id.co.nds.gadai.globals.GlobalConstant;
import id.co.nds.gadai.models.ProdukModel;
import id.co.nds.gadai.repos.ProdukRepo;
import id.co.nds.gadai.repos.specs.ProdukSpec;

@Service
public class ProdukService implements Serializable {
    @Autowired
    private ProdukRepo produkRepo;
    
    public List<ProdukEntity> doGetAllProduk() {
        List<ProdukEntity> produk = new ArrayList<>();
        produkRepo.findAll().forEach(produk::add);
        return produk;
    }

    public List<ProdukEntity> doGetProdukCicilanTetap() {
        List<ProdukEntity> produk = new ArrayList<>();
        produkRepo.getProdukCicilanTetap().forEach(produk::add);
        return produk;
    }

    public List<ProdukEntity> doSearchProduk(ProdukModel produkModel) {
        List<ProdukEntity> produk = new ArrayList<>();
        ProdukSpec specs = new ProdukSpec(produkModel);
        produkRepo.findAll(specs).forEach(produk::add);
        return produk;
    }

    public ProdukEntity doInsert(ProdukModel produkModel){

        // process
        ProdukEntity produk = new ProdukEntity();
        produk.setId(produkModel.getId());
        produk.setTipeProduk(produkModel.getTipeProduk());
        produk.setNamaProduk(produkModel.getNamaProduk());
        produk.setKeterangan(produkModel.getKeterangan());
        produk.setLtv(produkModel.getLtv());
        produk.setJangkaWaktu(produkModel.getJangkaWaktu());
        produk.setAdminBuka(produkModel.getAdminBuka());
        produk.setAdminBukaType(produkModel.getAdminBukaType());
        produk.setAdminTutup(produkModel.getAdminTutup());
        produk.setAdminTutupType(produkModel.getAdminTutupType());
        produk.setJasaPenyimpanan(produkModel.getJasaPenyimpanan());
        produk.setJasaPenyimpananPeriode(produkModel.getJasaPenyimpananPeriode());
        produk.setDendaKeterlambatan(produkModel.getDendaKeterlambatan());
        produk.setDendaKeterlambatanPeriode(produkModel.getDendaKeterlambatanPeriode());
        produk.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        produk.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        produk.setCreatorId(
                produkModel.getActorId() == null ? 0 : produkModel.getActorId());
        return produkRepo.save(produk);
    }
    
    public ProdukEntity findById(String id) {
        // process
        ProdukEntity produk = produkRepo.findById(id).orElse(null);
        return produk;
    }

    public ProdukEntity doUpdate(ProdukModel produkModel) {
        // validation
        
        // process
        ProdukEntity produk = new ProdukEntity();
        produk = findById(produkModel.getId());
        produk.setNamaProduk(produkModel.getNamaProduk());
        produk.setKeterangan(produkModel.getKeterangan());
        produk.setLtv(produkModel.getLtv());
        produk.setJangkaWaktu(produkModel.getJangkaWaktu());
        produk.setAdminBuka(produkModel.getAdminBuka());
        produk.setAdminBukaType(produkModel.getAdminBukaType());
        produk.setAdminTutup(produkModel.getAdminTutup());
        produk.setAdminTutupType(produkModel.getAdminTutupType());
        produk.setJasaPenyimpanan(produkModel.getJasaPenyimpanan());
        produk.setJasaPenyimpananPeriode(produkModel.getJasaPenyimpananPeriode());
        produk.setDendaKeterlambatan(produkModel.getDendaKeterlambatan());
        produk.setDendaKeterlambatanPeriode(produkModel.getDendaKeterlambatanPeriode());
        produk.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        produk.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        produk.setUpdaterId(
                produkModel.getActorId() == null ? 0 : produkModel.getActorId());

        return produkRepo.save(produk);
    }

    public ProdukEntity doDelete(ProdukModel produkModel) {
        // validation

        // process
        ProdukEntity produk = new ProdukEntity();
        produk = findById(produkModel.getId());

        produk.setRecStatus(GlobalConstant.REC_STATUS_NON_ACTIVE);
        produk.setDeletedDate(new Timestamp(System.currentTimeMillis()));
        produk.setDeleterId(
                produkModel.getActorId() == null ? 0 : produkModel.getActorId());

        produkRepo.doDelete(produk.getId(), produk.getDeleterId());
        return produk;
    }
}
