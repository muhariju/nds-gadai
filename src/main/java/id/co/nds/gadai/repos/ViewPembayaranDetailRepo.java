package id.co.nds.gadai.repos;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.nds.gadai.entities.ViewPembayaranDetailEntity;

@Repository
@Transactional
public interface ViewPembayaranDetailRepo
                extends JpaRepository<ViewPembayaranDetailEntity, String>,
                JpaSpecificationExecutor<ViewPembayaranDetailEntity> {       

        @Query(value = "select tx_transaksi.cust_id, ms_pelanggan.nama_pelanggan, tx_transaksi.product_id,"
        + "  ms_produk.jangka_waktu, ms_produk.nama_produk, ms_produk.keterangan, tx_transaksi.tanggal_transaksi, tx_transaksi.id,"
        + " (tx_transaksi.nilai_pencairan_pelanggan+(ms_produk.admin_buka-(tx_transaksi.diskon_adm_buka/100*ms_produk.admin_buka))) as total_pinjaman,"
        + " tx_transaksi.tanggal_jatuh_tempo, sum(tx_jadwalcicilan.pokok+tx_jadwalcicilan.bunga) as total_kewajiban,"
        + " sum(tx_jadwalcicilan.denda) as total_denda, sum(tx_pembayaran.jumlah_pembayaran) as total_pembayaran"
        + " from tx_transaksi join ms_pelanggan on tx_transaksi.cust_id = ms_pelanggan.id"
        + " join ms_produk on tx_transaksi.product_id = ms_produk.id"
        + " join tx_jadwalcicilan on tx_transaksi.id = tx_jadwalcicilan.id_transaksi"
        + " left join tx_pembayaran on tx_transaksi.id = tx_pembayaran.id_transaksi"
        + " WHERE LOWER(tx_transaksi.id)=LOWER(:id) Group by ms_pelanggan.id, ms_produk.id, tx_transaksi.id", nativeQuery = true)
        Optional<ViewPembayaranDetailEntity> findById(@Param("id") String id);
}
