package id.co.nds.gadai.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.ViewTransaksiEntity;

@Repository
@Transactional
public interface ViewTransaksiRepo
                extends JpaRepository<ViewTransaksiEntity, String>, JpaSpecificationExecutor<ViewTransaksiEntity> {
        @Query(value = "SELECT COUNT(*) FROM tx_transaksi WHERE LOWER(id) = LOWER(:id)", nativeQuery = true)
        long countById(@Param("id") String id);

        @Modifying
        @Query(value = "SELECT tx_transaksi.*, "
                        + "ms_produk.nama_produk,  "
                        + "ms_produk.keterangan,  "
                        + "ms_produk.ltv,  "
                        + "ms_produk.jangka_waktu,  "
                        + "ms_produk.jasa_penyimpanan,  "
                        + "ms_produk.jasa_penyimpanan_periode,  "
                        + "ms_produk.admin_buka,  "
                        + "ms_produk.admin_buka_type,  "
                        + "ms_produk.admin_tutup,  "
                        + "ms_produk.admin_tutup_type,  "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN ms_produk ON ms_produk.id=tx_transaksi.product_id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id ", nativeQuery = true)
        List<ViewTransaksiEntity> findAlls();

        @Query(value = "SELECT tx_transaksi.*, "
                        + "ms_produk.nama_produk,  "
                        + "ms_produk.keterangan,  "
                        + "ms_produk.ltv,  "
                        + "ms_produk.jangka_waktu,  "
                        + "ms_produk.jasa_penyimpanan,  "
                        + "ms_produk.jasa_penyimpanan_periode,  "
                        + "ms_produk.admin_buka,  "
                        + "ms_produk.admin_buka_type,  "
                        + "ms_produk.admin_tutup,  "
                        + "ms_produk.admin_tutup_type,  "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN ms_produk ON ms_produk.id=tx_transaksi.product_id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE ms_produk.id like %?1% "
                        + "AND ms_produk.nama_produk like %?2% "
                        + "AND tx_transaksi.status like %?3% "
                        + "AND tx_transaksi.tanggal_transaksi >= ?4 "
                        + "AND tx_transaksi.tanggal_transaksi <= ?5 "
                        + "AND tx_transaksi.id like %?6% "
                        + "AND ms_pelanggan.nomor_ktp like %?7% "
                        + "AND ms_pelanggan.id like %?8% "
                        + "AND ms_pelanggan.nama_pelanggan like %?9% "
                        ,nativeQuery = true)
        List<ViewTransaksiEntity> findWhere(String ProductId, String ProdukName, String Status, LocalDate TrxDateBegin, LocalDate TrxDateEnd, 
        String Id, String NomorKtp, String CustId, String NamaPelanggan);

        @Query(value = "SELECT tx_transaksi.*, "
                        + "ms_produk.nama_produk,  "
                        + "ms_produk.keterangan,  "
                        + "ms_produk.ltv,  "
                        + "ms_produk.jangka_waktu,  "
                        + "ms_produk.jasa_penyimpanan,  "
                        + "ms_produk.jasa_penyimpanan_periode,  "
                        + "ms_produk.admin_buka,  "
                        + "ms_produk.admin_buka_type,  "
                        + "ms_produk.admin_tutup,  "
                        + "ms_produk.admin_tutup_type,  "
                        + "ms_pelanggan.nama_pelanggan, "
                        + "ms_pelanggan.nomor_ktp "
                        + "from tx_transaksi "
                        + "JOIN ms_produk ON ms_produk.id=tx_transaksi.product_id "
                        + "JOIN ms_pelanggan ON ms_pelanggan.id=tx_transaksi.cust_id "
                        + "WHERE LOWER(tx_transaksi.id) = LOWER(:id)", nativeQuery = true)
        Optional<ViewTransaksiEntity> findById(@Param("id") String id);

}
