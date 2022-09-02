package id.co.nds.gadai.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tx_transaksi")
public class ViewTransaksiEntity {
    
    @Id
    @GenericGenerator(name = "tx_id_seq", strategy = "id.co.nds.gadai.generators.TransaksiIdGenerator")
    @GeneratedValue(generator = "tx_id_seq")
    @Column(name = "id")
    private String id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "total_nilai_taksiran")
    private String totalNilaiTaksiran;

    @Column(name = "nilai_pencairan_pelanggan")
    private Double nilaiPencairanPelanggan;

    @Column(name = "diskon_adm_buka")
    private Double diskonAdmBuka;

    @Column(name = "cust_id")
    private String custId;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @Column(name = "deleted_date")
    private Timestamp deletedDate;

    @Column(name = "creator_id")
    private Integer creatorId;

    @Column(name = "updater_id")
    private Integer updaterId;

    @Column(name = "deleter_id")
    private Integer deleterId;

    @Column(name = "rec_status")
    private String recStatus;

    @Column(name = "nama_produk")
    private String produkName;

    @Column(name = "nama_pelanggan")
    private String custName;

    @Column(name = "nomor_ktp")
    private String nomorKtp;

    @Column(name = "keterangan")
    private String keterangan;
    
    @Column(name = "tanggal_transaksi")
    private Date tanggalTransaksi;

    @Column(name = "tanggal_jatuh_tempo")
    private Date tanggalJatuhTempo;

    @Column(name = "status")
    private String status;

    @Column(name = "ltv")
    private Double ltv;

    @Column(name = "jangka_waktu")
    private Integer jangkaWaktu;

    @Column(name = "jasa_penyimpanan")
    private Double jasaPenyimpanan;
    
    @Column(name = "jasa_penyimpanan_periode")
    private Integer jasaPenyimpananPeriode;

    @Column(name = "admin_buka")
    private Double adminBuka;
    
    @Column(name = "admin_tutup")
    private Double adminTutup;

    @Column(name = "admin_buka_type")
    private String adminBukaType;
    
    @Column(name = "admin_tutup_type")
    private String adminTutupType;
        
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTotalNilaiTaksiran() {
        return totalNilaiTaksiran;
    }

    public void setTotalNilaiTaksiran(String totalNilaiTaksiran) {
        this.totalNilaiTaksiran = totalNilaiTaksiran;
    }

    public Double getNilaiPencairanPelanggan() {
        return nilaiPencairanPelanggan;
    }

    public void setNilaiPencairanPelanggan(Double nilaiPencairanPelanggan) {
        this.nilaiPencairanPelanggan = nilaiPencairanPelanggan;
    }

    public Double getDiskonAdmBuka() {
        return diskonAdmBuka;
    }

    public void setDiskonAdmBuka(Double diskonAdmBuka) {
        this.diskonAdmBuka = diskonAdmBuka;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Timestamp getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Timestamp deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Integer updaterId) {
        this.updaterId = updaterId;
    }

    public Integer getDeleterId() {
        return deleterId;
    }

    public void setDeleterId(Integer deleterId) {
        this.deleterId = deleterId;
    }

    public String getRecStatus() {
        return recStatus;
    }

    public void setRecStatus(String recStatus) {
        this.recStatus = recStatus;
    }

    public String getProdukName() {
        return produkName;
    }

    public void setProdukName(String produkName) {
        this.produkName = produkName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public Date getTanggalJatuhTempo() {
        return tanggalJatuhTempo;
    }

    public void setTanggalJatuhTempo(Date tanggalJatuhTempo) {
        this.tanggalJatuhTempo = tanggalJatuhTempo;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(Date tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Double getLtv() {
        return ltv;
    }

    public void setLtv(Double ltv) {
        this.ltv = ltv;
    }

    public Integer getJangkaWaktu() {
        return jangkaWaktu;
    }

    public void setJangkaWaktu(Integer jangkaWaktu) {
        this.jangkaWaktu = jangkaWaktu;
    }

    public Double getJasaPenyimpanan() {
        return jasaPenyimpanan;
    }

    public void setJasaPenyimpanan(Double jasaPenyimpanan) {
        this.jasaPenyimpanan = jasaPenyimpanan;
    }

    public Integer getJasaPenyimpananPeriode() {
        return jasaPenyimpananPeriode;
    }

    public void setJasaPenyimpananPeriode(Integer jasaPenyimpananPeriode) {
        this.jasaPenyimpananPeriode = jasaPenyimpananPeriode;
    }

    public Double getAdminBuka() {
        return adminBuka;
    }

    public void setAdminBuka(Double adminBuka) {
        this.adminBuka = adminBuka;
    }

    public Double getAdminTutup() {
        return adminTutup;
    }

    public void setAdminTutup(Double adminTutup) {
        this.adminTutup = adminTutup;
    }

    public String getAdminBukaType() {
        return adminBukaType;
    }

    public void setAdminBukaType(String adminBukaType) {
        this.adminBukaType = adminBukaType;
    }

    public String getAdminTutupType() {
        return adminTutupType;
    }

    public void setAdminTutupType(String adminTutupType) {
        this.adminTutupType = adminTutupType;
    }

}
