package id.co.nds.gadai.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.PembayaranTransaksiEntity;

@Repository
@Transactional
public interface PembayaranRepo
        extends JpaRepository<PembayaranTransaksiEntity, String>, JpaSpecificationExecutor<PembayaranTransaksiEntity> {
    @Modifying
    @Query(value = "UPDATE tx_jadwalcicilan SET status = 'LUNAS', tanggal_bayar = CURRENT_DATE WHERE id_transaksi = ?1 and cicilan_ke =?2", nativeQuery = true)
    Integer updateStatus(String id, String cicilan);
}
