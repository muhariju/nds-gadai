package id.co.nds.gadai.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.ProdukEntity;
import id.co.nds.gadai.globals.GlobalConstant;

@Repository
@Transactional
public interface ProdukRepo extends JpaRepository<ProdukEntity, String>, JpaSpecificationExecutor<ProdukEntity> {
        @Query(value = "SELECT COUNT(*) FROM ms_produk WHERE LOWER(id) = LOWER(:id)", nativeQuery = true)
        long countById(@Param("id") String id);

        @Modifying
        @Query(value = "UPDATE ms_produk SET rec_status = '"
                        + GlobalConstant.REC_STATUS_NON_ACTIVE
                        + "', deleter_id = ?2 , deleted_date = NOW() "
                        + "WHERE id = ?1", nativeQuery = true)
        Integer doDelete(String id, Integer deleterId);

        @Modifying
        @Query(value = "SELECT * FROM ms_produk WHERE "
        + "tipe_produk = 'Konsinyasi Cicilan Tetap' AND "
        + "rec_status = '"
        + GlobalConstant.REC_STATUS_ACTIVE
        + "'", nativeQuery = true)
        List<ProdukEntity>getProdukCicilanTetap();
}
