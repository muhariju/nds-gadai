package id.co.nds.gadai.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.TransaksiEntity;

@Repository
@Transactional
public interface TransaksiRepo extends JpaRepository<TransaksiEntity, String>, JpaSpecificationExecutor<TransaksiEntity> {
    @Query(value = "SELECT count(*) as id FROM tx_transaksi ", nativeQuery = true)
    List<String> countId(); 
}
