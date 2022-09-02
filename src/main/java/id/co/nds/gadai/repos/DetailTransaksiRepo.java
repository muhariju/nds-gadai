package id.co.nds.gadai.repos;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.DetailTransaksiEntity;

@Repository
@Transactional
public interface DetailTransaksiRepo
        extends JpaRepository<DetailTransaksiEntity, String>, JpaSpecificationExecutor<DetailTransaksiEntity> {
    @Modifying
    @Query(value = "SELECT * "
            + "from tx_detailtransaksi "
            + "WHERE LOWER(id_transaksi) = LOWER(:id)", nativeQuery = true)
    List<DetailTransaksiEntity> findByIdTranskaksi(@Param("id") String id);
}
