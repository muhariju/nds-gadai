package id.co.nds.gadai.repos;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.ViewPembayaranTransaksiEntity;

@Repository
@Transactional
public interface ViewPembayaranTransaksiRepo
                extends JpaRepository<ViewPembayaranTransaksiEntity, String>,
                JpaSpecificationExecutor<ViewPembayaranTransaksiEntity> {

        @Query(value = "SELECT tx_transaksi.id, tx_transaksi.id as id_transaksi, "
                        + "tx_transaksi.tanggal_transaksi, "
                        + "tx_transaksi.cust_id, "
                        + "tx_jadwalcicilan.cicilan_ke, tx_jadwalcicilan.cicilan_ke as cicilanke, "
                        + "(tx_jadwalcicilan.pokok+tx_jadwalcicilan.bunga+tx_jadwalcicilan.denda) as total_tagihan, "
                        + "tx_jadwalcicilan.status, "
                        + "tx_jadwalcicilan.tanggal_aktif, "
                        + "tx_jadwalcicilan.tanggal_jatuh_tempo, "
                        + "tx_jadwalcicilan.tanggal_bayar, "
                        + "tx_jadwalcicilan.pokok, "
                        + "tx_jadwalcicilan.bunga, "
                        + "tx_jadwalcicilan.denda, "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN tx_jadwalcicilan ON tx_jadwalcicilan.id_transaksi=tx_transaksi.id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE LOWER(tx_transaksi.id) = LOWER(:id) ORDER BY cicilan_ke ASC", nativeQuery = true)
        List<ViewPembayaranTransaksiEntity> findAllById(@Param("id") String id);

        @Query(value = "SELECT tx_transaksi.id, tx_transaksi.id as id_transaksi, "
                        + "tx_transaksi.tanggal_transaksi, "
                        + "tx_transaksi.cust_id, "
                        + "tx_jadwalcicilan.cicilan_ke, tx_jadwalcicilan.cicilan_ke as cicilanke, "
                        + "(tx_jadwalcicilan.pokok+tx_jadwalcicilan.bunga+tx_jadwalcicilan.denda) as total_tagihan, "
                        + "tx_jadwalcicilan.status, "
                        + "tx_jadwalcicilan.tanggal_aktif, "
                        + "tx_jadwalcicilan.tanggal_jatuh_tempo, "
                        + "tx_jadwalcicilan.tanggal_bayar, "
                        + "tx_jadwalcicilan.pokok, "
                        + "tx_jadwalcicilan.bunga, "
                        + "tx_jadwalcicilan.denda, "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN tx_jadwalcicilan ON tx_jadwalcicilan.id_transaksi=tx_transaksi.id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE LOWER(tx_transaksi.id) = LOWER(:id) AND cicilan_ke = :cicilan", nativeQuery = true)
        ViewPembayaranTransaksiEntity findAllByCicilan(@Param("id") String id, @Param("cicilan") String cicilan);

        @Query(value = "SELECT tx_transaksi.id, tx_transaksi.id as id_transaksi, "
                        + "tx_transaksi.tanggal_transaksi, "
                        + "tx_transaksi.cust_id, "
                        + "tx_jadwalcicilan.cicilan_ke, tx_jadwalcicilan.cicilan_ke as cicilanke, "
                        + "(tx_jadwalcicilan.pokok+tx_jadwalcicilan.bunga+tx_jadwalcicilan.denda) as total_tagihan, "
                        + "tx_jadwalcicilan.status, "
                        + "tx_jadwalcicilan.tanggal_aktif, "
                        + "tx_jadwalcicilan.tanggal_jatuh_tempo, "
                        + "tx_jadwalcicilan.tanggal_bayar, "
                        + "tx_jadwalcicilan.pokok, "
                        + "tx_jadwalcicilan.bunga, "
                        + "tx_jadwalcicilan.denda, "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN tx_jadwalcicilan ON tx_jadwalcicilan.id_transaksi=tx_transaksi.id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE tx_jadwalcicilan.status = 'AKTIF' OR tx_jadwalcicilan.status = 'TERLAMBAT' ORDER BY tx_transaksi.id, cicilan_ke ASC", nativeQuery = true)
        List<ViewPembayaranTransaksiEntity> findAll();

        @Query(value = "SELECT tx_transaksi.id, tx_transaksi.id as id_transaksi, "
                        + "tx_transaksi.tanggal_transaksi, "
                        + "tx_transaksi.cust_id, "
                        + "tx_jadwalcicilan.cicilan_ke, tx_jadwalcicilan.cicilan_ke as cicilanke, "
                        + "(tx_jadwalcicilan.pokok+tx_jadwalcicilan.bunga+tx_jadwalcicilan.denda) as total_tagihan, "
                        + "tx_jadwalcicilan.status, "
                        + "tx_jadwalcicilan.tanggal_aktif, "
                        + "tx_jadwalcicilan.tanggal_jatuh_tempo, "
                        + "tx_jadwalcicilan.tanggal_bayar, "
                        + "tx_jadwalcicilan.pokok, "
                        + "tx_jadwalcicilan.bunga, "
                        + "tx_jadwalcicilan.denda, "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN tx_jadwalcicilan ON tx_jadwalcicilan.id_transaksi=tx_transaksi.id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE (tx_jadwalcicilan.status = 'AKTIF' OR tx_jadwalcicilan.status = 'TERLAMBAT') "
                        + "AND tx_transaksi.id like %?1% "
                        + "AND tx_transaksi.cust_id like %?2% "
                        + "AND ms_pelanggan.nama_pelanggan like %?3% "
                        + "AND tx_jadwalcicilan.tanggal_jatuh_tempo >= ?4 "
                        + "AND tx_jadwalcicilan.tanggal_jatuh_tempo <= ?5 "
                        + "ORDER BY tx_transaksi.id, cicilan_ke ASC", nativeQuery = true)
        List<ViewPembayaranTransaksiEntity> findWhere(String Id, String CustId, String NamaPelanggan,
                        LocalDate TrxDateBegin, LocalDate TrxDateEnd);

}
