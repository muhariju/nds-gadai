package id.co.nds.gadai.repos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.JadwalCicilanEntity;

@Repository
@Transactional
public interface JadwalCicilanRepo
        extends JpaRepository<JadwalCicilanEntity, String>, JpaSpecificationExecutor<JadwalCicilanEntity> {

    @Query(value = "SELECT * "
            + "from tx_jadwalcicilan "
            + "WHERE LOWER(id_transaksi) = LOWER(:id)", nativeQuery = true)
    List<JadwalCicilanEntity> findCicilanById(@Param("id") String id);

    @Modifying
    @Query(value = "UPDATE tx_jadwalcicilan SET status = 'AKTIF' WHERE NOW() >= tanggal_aktif AND NOW() <= tanggal_jatuh_tempo", nativeQuery = true)
    int updateCicilanAktif();

    @Modifying
    @Query(value = "UPDATE tx_jadwalcicilan SET status = 'TERLAMBAT' WHERE NOW() > tanggal_jatuh_tempo", nativeQuery = true)
    int updateCicilanTerlambat();

    @Modifying
    @Query(value = "UPDATE tx_jadwalcicilan SET status = 'DIBAYAR' WHERE tanggal_bayar != NULL", nativeQuery = true)
    int updateCicilanDibayar();

    @Modifying
    @Query(value = "UPDATE tx_jadwalcicilan "
            + "SET     denda = D.denda_keterlambatan/100*(pokok+bunga)* DATE_PART('day', NOW() - tx_jadwalcicilan.tanggal_jatuh_tempo) "
            + "FROM    tx_transaksi AS B "
            + "JOIN 	ms_produk AS D ON D.id = B.product_id "
            + "WHERE   tx_jadwalcicilan.id_transaksi = B.id "
            + "AND	tx_jadwalcicilan.status = 'TERLAMBAT'", nativeQuery = true)
    int updateDenda();
}
