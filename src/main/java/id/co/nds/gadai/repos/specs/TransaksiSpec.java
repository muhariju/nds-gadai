package id.co.nds.gadai.repos.specs;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import id.co.nds.gadai.entities.ViewTransaksiEntity;
import id.co.nds.gadai.models.TransaksiModel;

public class TransaksiSpec implements Specification<ViewTransaksiEntity>{
    private TransaksiModel transaksiModel;

    public TransaksiSpec(TransaksiModel transaksiModel){
        super();
        this.transaksiModel = transaksiModel;
    }

    @Override
    public Predicate toPredicate(Root<ViewTransaksiEntity> root, CriteriaQuery<?> cq,
        CriteriaBuilder cb){
            Predicate p = cb.and();
            //Predicate p = cb.disjunction();

            // id produk criteria
            if(transaksiModel.getProductId() != null && transaksiModel.getProductId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("productId")),
                "%" + transaksiModel.getProductId().toLowerCase()+ "%"));
            }

            // nama produk criteria
            if(transaksiModel.getProdukName() != null && transaksiModel.getProdukName().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("produkName")),
                "%" + transaksiModel.getProdukName().toLowerCase()+ "%"));
            }

            // status criteria
            if(transaksiModel.getStatus() != null && transaksiModel.getStatus().length() > 0){
                p.getExpressions().add(cb.equal(root.get("status"), transaksiModel.getStatus()));
            }

            // tanggal transaksi criteria 
            // if(transaksiModel.getTrxDateBegin() != null && transaksiModel.getTrxDateEnd() != null){
            //     p.getExpressions().add(cb.between(root.get("tanggalTransaksi"),transaksiModel.getTrxDateBegin(),transaksiModel.getTrxDateEnd())
            //     );
            // }

            // nomor transaksi criteria
            if(transaksiModel.getId() != null && transaksiModel.getId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("id")),
                "%" + transaksiModel.getId().toLowerCase()+ "%"));
            }

            // id produk criteria
            if(transaksiModel.getCustId() != null && transaksiModel.getCustId().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("custId")),
                "%" + transaksiModel.getCustId().toLowerCase()+ "%"));
            }

            // nomor ktp criteria
            if(transaksiModel.getNomorKtp() != null && transaksiModel.getNomorKtp().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("nomorKtp")),
                "%" + transaksiModel.getNomorKtp().toLowerCase()+ "%"));
            }

            // nomor transaksi criteria
            if(transaksiModel.getNamapelanggan() != null && transaksiModel.getNamapelanggan().length() > 0){
                p.getExpressions().add(cb.like(cb.lower(root.get("namaPelanggan")),
                "%" + transaksiModel.getNamapelanggan().toLowerCase()+ "%"));
            }

            cq.orderBy(cb.asc(root.get("id")));
            
            return p;
        }
}
