package id.co.nds.gadai.services;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.nds.gadai.controllers.composites.IdCicilan;
import id.co.nds.gadai.controllers.composites.IdTransaksi;
import id.co.nds.gadai.entities.DetailTransaksiEntity;
import id.co.nds.gadai.entities.JadwalCicilanEntity;
import id.co.nds.gadai.entities.PembayaranTransaksiEntity;
import id.co.nds.gadai.entities.ProdukEntity;
import id.co.nds.gadai.entities.TransaksiEntity;
import id.co.nds.gadai.entities.ViewPembayaranDetailEntity;
import id.co.nds.gadai.entities.ViewPembayaranTransaksiEntity;
import id.co.nds.gadai.entities.ViewTransaksiEntity;
import id.co.nds.gadai.globals.GlobalConstant;
import id.co.nds.gadai.models.DataBarangGadaiModel;
import id.co.nds.gadai.models.PembayaranModel;
import id.co.nds.gadai.models.TransaksiModel;
import id.co.nds.gadai.repos.DetailTransaksiRepo;
import id.co.nds.gadai.repos.JadwalCicilanRepo;
import id.co.nds.gadai.repos.PembayaranRepo;
import id.co.nds.gadai.repos.ProdukRepo;
import id.co.nds.gadai.repos.TransaksiRepo;
import id.co.nds.gadai.repos.ViewPembayaranDetailRepo;
import id.co.nds.gadai.repos.ViewPembayaranTransaksiRepo;
import id.co.nds.gadai.repos.ViewTransaksiRepo;

@Service
public class TransaksiService implements Serializable {
    @Autowired
    private ViewTransaksiRepo viewTransaksiRepo;
    @Autowired
    private ViewPembayaranTransaksiRepo viewPembayaranTransaksiRepo;
    @Autowired
    private ViewPembayaranDetailRepo viewPembayaranDetailRepo;
    @Autowired
    private TransaksiRepo transaksiRepo;
    @Autowired
    private DetailTransaksiRepo detailTransaksiRepo;
    @Autowired
    private JadwalCicilanRepo jadwalCicilanRepo;
    @Autowired
    private ProdukRepo produkRepo;
    @Autowired
    private PembayaranRepo pembayaranRepo;

    public List<ViewTransaksiEntity> doGetAllTransaksi() {
        List<ViewTransaksiEntity> transaksi = new ArrayList<>();
        viewTransaksiRepo.findAlls().forEach(transaksi::add);
        return transaksi;
    }

    public List<ViewPembayaranTransaksiEntity> doGetAllPembayaranTransaksi() {
        List<ViewPembayaranTransaksiEntity> transaksi = new ArrayList<>();
        viewPembayaranTransaksiRepo.findAll().forEach(transaksi::add);
        return transaksi;
    }

    public List<ViewTransaksiEntity> doSearchTransaksi(String ProductId, String ProdukName, String Status,
            LocalDate TrxDateBegin, LocalDate TrxDateEnd,
            String Id, String NomorKtp, String CustId, String NamaPelanggan) {
        List<ViewTransaksiEntity> transaksi = new ArrayList<>();
        viewTransaksiRepo.findWhere(ProductId, ProdukName, Status, TrxDateBegin, TrxDateEnd,
                Id, NomorKtp, CustId, NamaPelanggan).forEach(transaksi::add);
        return transaksi;
    }

    public List<ViewPembayaranTransaksiEntity> doSearchPembayaran(String idTransaksi, String CustId,
            String NamaPelanggan,
            LocalDate TrxDateBegin, LocalDate TrxDateEnd) {

        System.out.println(TrxDateBegin + "oooooooo" + TrxDateEnd);
        List<ViewPembayaranTransaksiEntity> transaksi = new ArrayList<>();
        viewPembayaranTransaksiRepo.findWhere(idTransaksi, CustId, NamaPelanggan, TrxDateBegin, TrxDateEnd)
                .forEach(transaksi::add);
        return transaksi;
    }

    public ViewTransaksiEntity findById(String id) {
        // process
        ViewTransaksiEntity view = viewTransaksiRepo.findById(id).orElse(null);
        return view;
    }

    public ViewPembayaranDetailEntity findPembayaranById(String id) {
        // process
        ViewPembayaranDetailEntity view = viewPembayaranDetailRepo.findById(id).orElse(null);
        return view;
    }

    public List<ViewPembayaranTransaksiEntity> findAllPembayaranById(String id) {
        // process
        List<ViewPembayaranTransaksiEntity> transaksi = new ArrayList<>();
        viewPembayaranTransaksiRepo.findAllById(id).forEach(transaksi::add);
        return transaksi;
    }

    public ViewPembayaranTransaksiEntity findAllPembayaranByCicilan(String id, String cicilan) {
        // process
        ViewPembayaranTransaksiEntity transaksi = viewPembayaranTransaksiRepo.findAllByCicilan(id, cicilan);
        return transaksi;
    }

    public List<DetailTransaksiEntity> findBarangById(String id) {
        // process
        List<DetailTransaksiEntity> barang = new ArrayList<>();
        detailTransaksiRepo.findByIdTranskaksi(id).forEach(barang::add);
        return barang;
    }

    public List<JadwalCicilanEntity> findCicilanById(String id) {
        // process
        List<JadwalCicilanEntity> barang = new ArrayList<>();
        jadwalCicilanRepo.findCicilanById(id).forEach(barang::add);
        return barang;
    }

    public Integer doUpdateCicilan() {
        int update = jadwalCicilanRepo.updateCicilanAktif();
        update = jadwalCicilanRepo.updateCicilanTerlambat();
        update = jadwalCicilanRepo.updateCicilanDibayar();
        update = jadwalCicilanRepo.updateDenda();
        return update;
    }

    public TransaksiEntity doInsert(TransaksiModel transaksiModel) {
        // process
        TransaksiEntity transaksi = new TransaksiEntity();
        ProdukEntity produk = produkRepo.findById(transaksiModel.getProductId()).orElse(null);

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMM");
        String date = dateObj.format(formatter);

        List<String> countTransaksi = new ArrayList<>();
        transaksiRepo.countId().forEach(countTransaksi::add);
        String count = countTransaksi.stream().map(n -> String.valueOf(n)).collect(Collectors.joining("-", "", ""));
        String idTransaksi = String.format(date + "01" + "%05d", Integer.valueOf(count) + 1);

        transaksi.setId(idTransaksi);
        transaksi.setCustId(transaksiModel.getCustId());
        transaksi.setDiskonAdmBuka(transaksiModel.getDiskonAdmBuka());
        transaksi.setNilaiPencairanPelanggan(transaksiModel.getNilaiPencairanPelanggan());
        transaksi.setTotalNilaiTaksiran(transaksiModel.getTotalNilaiTaksiran());
        transaksi.setProductId(transaksiModel.getProductId());
        transaksi.setTanggalTransaksi(dateObj);
        transaksi.setTanggalJatuhTempo(dateObj.plusMonths(produk.getJangkaWaktu()));
        transaksi.setStatus("AKTIF");
        transaksi.setRecStatus(GlobalConstant.REC_STATUS_ACTIVE);
        transaksi.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        transaksi.setCreatorId(
                transaksiModel.getActorId() == null ? 0 : transaksiModel.getActorId());
        transaksiRepo.save(transaksi);
        DataBarangGadaiModel[] barang = transaksiModel.getDataBarangGadai();
        for (int i = 0; i < barang.length; ++i) {
            DetailTransaksiEntity detail = new DetailTransaksiEntity(
                    new IdTransaksi(idTransaksi, barang[i].getNo()),
                    barang[i].getNamaBarang(), barang[i].getKondisi(),
                    barang[i].getJlh(), (double) (Math.round(barang[i].getHargaPerSatuan() * 100) / 100));
            detailTransaksiRepo.save(detail);
        }

        Double adminBukaAkhir = produk.getAdminBuka() - transaksiModel.getDiskonAdmBuka() / 100;
        adminBukaAkhir = (double) (Math.round(adminBukaAkhir * 100) / 100);
        Double totalNilaiPinjaman = (transaksiModel.getNilaiPencairanPelanggan() + adminBukaAkhir);
        totalNilaiPinjaman = (double) (Math.round(totalNilaiPinjaman * 100) / 100);
        Double pokok = (totalNilaiPinjaman / (produk.getJangkaWaktu() / produk.getJasaPenyimpananPeriode()));
        Double bunga = pokok * produk.getJasaPenyimpanan() / 100;
        Integer cicilan = produk.getJangkaWaktu() / produk.getJasaPenyimpananPeriode();

        for (int i = 0; i < cicilan; ++i) {
            String status = "BELUM AKTIF";
            if (i == 0) {
                status = "AKTIF";
            }
            pokok = (double) (Math.round(pokok * 100) / 100);
            bunga = (double) (Math.round(bunga * 100) / 100);
            String cicilanKe = String.valueOf(i + 1);
            JadwalCicilanEntity jadwal = new JadwalCicilanEntity(
                    new IdCicilan(idTransaksi, cicilanKe),
                    pokok, bunga, status, dateObj.plusMonths(i + 1),
                    dateObj.plusMonths(i + 1).minusDays(1));
            jadwalCicilanRepo.save(jadwal);
        }

        return transaksi;
    }

    public PembayaranTransaksiEntity doInsertPembayaran(PembayaranModel transaksiModel) {
        // process
        PembayaranTransaksiEntity transaksi = new PembayaranTransaksiEntity();

        transaksi.setIdTransaksi(transaksiModel.getIdTransaksi());
        transaksi.setTotalTagihanCicilan(transaksiModel.getTotalTagihanCicilan());
        transaksi.setTotalTagihanDenda(transaksiModel.getTotalTagihanDenda());
        transaksi.setBiayaAdmTutup(transaksiModel.getBiayaAdmTutup());
        transaksi.setTotalTagihan(transaksiModel.getTotalTagihan());
        transaksi.setPembulatan(transaksiModel.getPembulatan());
        transaksi.setJumlahPembayaran(transaksiModel.getJumlahPembayaran());
        transaksi.setMetodeBayar(transaksiModel.getMetodeBayar());

        // pembayaranRepo.save(transaksi);

        for (int i = 0; i < transaksiModel.getCheckBayar().length; i++) {
            pembayaranRepo.updateStatus(transaksiModel.getIdTransaksi(), transaksiModel.getCheckBayar()[i].toString());
        }
        return transaksi;
    }

}
