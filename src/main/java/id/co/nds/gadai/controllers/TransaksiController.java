package id.co.nds.gadai.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai.models.ResponseModel;
import id.co.nds.gadai.models.TransaksiModel;
import id.co.nds.gadai.models.HitungModel;
import id.co.nds.gadai.models.HitungTagihanModel;
import id.co.nds.gadai.models.PelangganModel;
import id.co.nds.gadai.models.PembayaranModel;
import id.co.nds.gadai.services.PelangganService;
import id.co.nds.gadai.services.ProdukService;
import id.co.nds.gadai.services.TransaksiService;
import id.co.nds.gadai.entities.DetailTransaksiEntity;
import id.co.nds.gadai.entities.JadwalCicilanEntity;
import id.co.nds.gadai.entities.PelangganEntity;
import id.co.nds.gadai.entities.PembayaranTransaksiEntity;
import id.co.nds.gadai.entities.ProdukEntity;
import id.co.nds.gadai.entities.TransaksiEntity;
import id.co.nds.gadai.entities.ViewPembayaranDetailEntity;
import id.co.nds.gadai.entities.ViewPembayaranTransaksiEntity;
import id.co.nds.gadai.entities.ViewTransaksiEntity;

@RestController
@RequestMapping(value = "/transaksi")
public class TransaksiController {
    @Autowired
    private PelangganService pelangganService;
    @Autowired
    private ProdukService produkService;
    @Autowired
    private TransaksiService transaksiService;

    @GetMapping(value = "/doSearchPelanggan")
    public ResponseEntity<ResponseModel> doSearchPelangganController(@RequestParam(required = false) String id,
            String namaPelanggan, String nomorKtp, String nomorHp) {
        // request
        PelangganModel pelanggan = new PelangganModel();
        pelanggan.setNomorKtp(nomorKtp);
        pelanggan.setNamaPelanggan(namaPelanggan);
        pelanggan.setId(id);
        pelanggan.setNomorHp(nomorHp);
        List<PelangganEntity> pelanggans = pelangganService.doSearchPelanggan(pelanggan);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(pelanggans);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetAllTransaksi")
    public ResponseEntity<ResponseModel> doGetAllTransaksiController() {
        // request
        List<ViewTransaksiEntity> transaksi = transaksiService.doGetAllTransaksi();
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetAllPembayaranTransaksi")
    public ResponseEntity<ResponseModel> doGetAllPembayaranTransaksiController() {
        // request
        List<ViewPembayaranTransaksiEntity> transaksi = transaksiService.doGetAllPembayaranTransaksi();
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetDetailTransaksi/{id}")
    public ResponseEntity<ResponseModel> doGetDetailTransaksiController(@PathVariable String id) {
        // request
        ViewTransaksiEntity transaksi = transaksiService.findById(id);
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetPembayaranDetail/{id}")
    public ResponseEntity<ResponseModel> doGetPembayaranDetailController(@PathVariable String id) {
        // request
        ViewPembayaranDetailEntity transaksi = transaksiService.findPembayaranById(id);
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetAllPembayaran/{id}")
    public ResponseEntity<ResponseModel> doGetAllPembayaranController(@PathVariable String id) {
        // request
        List<ViewPembayaranTransaksiEntity> transaksi = transaksiService.findAllPembayaranById(id);
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetBarangTransaksi/{id}")
    public ResponseEntity<ResponseModel> doGetBarangTransaksiController(@PathVariable String id) {
        // request
        List<DetailTransaksiEntity> transaksi = transaksiService.findBarangById(id);
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetCicilanTransaksi/{id}")
    public ResponseEntity<ResponseModel> doGetCicilanTransaksiController(@PathVariable String id) {
        // request
        List<JadwalCicilanEntity> transaksi = transaksiService.findCicilanById(id);
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/doHitungTagihan")
    public ResponseEntity<ResponseModel> doHitungTagihanController(
            @RequestBody HitungTagihanModel hitung) {
        // process

        Double denda = 0.0;
        Double pokok = 0.0;
        for (int i = 0; i < hitung.getCheckBayar().length; i++) {
            ViewPembayaranTransaksiEntity transaksi = transaksiService.findAllPembayaranByCicilan(hitung.getId(),
                    hitung.getCheckBayar()[i].toString());
            denda += transaksi.getDenda();
            pokok += transaksi.getPokok();
        }
        ViewTransaksiEntity trans = transaksiService.findById(hitung.getId());
        hitung.setTotalPembayaranDenda(denda);
        hitung.setTotalPembayaranCicilan(pokok);
        hitung.setBiayaAdminTutup(trans.getAdminTutup());
        if (hitung.getDiskon() == null) {
            hitung.setDiskon(0.0);
        }
        Double totalTagihan = denda + pokok + trans.getAdminTutup() - hitung.getDiskon();
        hitung.setTotalTagihan(totalTagihan);
        Double pembulatan = Double.valueOf(String.valueOf(totalTagihan.intValue()).substring(0,
                String.valueOf(totalTagihan.intValue()).length() - 4) + "0000");
        hitung.setPembulatan(totalTagihan - pembulatan);
        hitung.setTotalTagihanSetelahPembulatan(pembulatan);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(hitung);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doSearchTransaksi")
    public ResponseEntity<ResponseModel> doSearchTransaksiController(@RequestParam(required = false) String ProductId,
            String ProdukName, String Status, String TrxDateBegin, String TrxDateEnd,
            String Id, String NomorKtp, String CustId, String NamaPelanggan) {
        // process
        LocalDate TrxDateBegins = LocalDate.parse(TrxDateBegin);
        LocalDate TrxDateEnds = LocalDate.parse((TrxDateEnd));
        List<ViewTransaksiEntity> trans = transaksiService.doSearchTransaksi(ProductId, ProdukName, Status,
                TrxDateBegins, TrxDateEnds,
                Id, NomorKtp, CustId, NamaPelanggan);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(trans);
        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/doSearchPembayaran")
    public ResponseEntity<ResponseModel> doSearchPembayaranController(@RequestParam(required = false) String idTransaksi,
           String CustId, String NamaPelanggan, String TrxDateBegin, String TrxDateEnd) {
        // process
        LocalDate TrxDateBegins = LocalDate.parse(TrxDateBegin);
        LocalDate TrxDateEnds = LocalDate.parse((TrxDateEnd));
         List<ViewPembayaranTransaksiEntity> trans = transaksiService.doSearchPembayaran(idTransaksi, CustId, NamaPelanggan, TrxDateBegins, TrxDateEnds);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(trans);
        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/doHitung")
    public ResponseEntity<ResponseModel> doSearchUserController(
            @Valid @RequestParam(required = false) String idprodukTransaksi, Double nilaiPencairanPelanggan,
            Double diskonAdmBuka, Double totalNilaiTaksiran) {
        // request

        HitungModel hitung = new HitungModel();

        hitung.setIdprodukTransaksi(idprodukTransaksi);
        hitung.setNilaiPencairanPelanggan(nilaiPencairanPelanggan);
        hitung.setDiskonAdmBuka(diskonAdmBuka);
        hitung.setTotalNilaiTaksiran(totalNilaiTaksiran);

        ProdukEntity produk = produkService.findById(idprodukTransaksi);

        hitung.setLtv(produk.getLtv());
        hitung.setAdminBuka(produk.getAdminBuka());
        hitung.setAdminTutup(produk.getAdminTutup());
        hitung.setJasaPenyimpanan(produk.getJasaPenyimpanan());
        hitung.setJasaPenyimpananPeriode(produk.getJasaPenyimpananPeriode());

        if (produk.getAdminBukaType() == "PERSEN") {
            hitung.setAdminBuka(nilaiPencairanPelanggan * produk.getAdminBuka() / 100);
        }
        hitung.setAdminBukaAkhir(produk.getAdminBuka() - (produk.getAdminBuka() * diskonAdmBuka / 100));

        if (produk.getAdminTutupType() == "PERSEN") {
            hitung.setAdminTutup(nilaiPencairanPelanggan * produk.getAdminTutup() / 100);
        }

        LocalDate date = LocalDate.now();
        LocalDate tanggalJatuhTempo = date.plusMonths(produk.getJangkaWaktu());
        hitung.setTglTransaksi(date);
        hitung.setTanggalJatuhTempo(tanggalJatuhTempo);

        hitung.setMaksimalNilaiPinjaman(produk.getLtv() * totalNilaiTaksiran / 100);
        hitung.setTotalNilaiPinjaman(nilaiPencairanPelanggan + hitung.getAdminBukaAkhir());
        hitung.setBiayaJasaPenyimpananPerPeriode((produk.getJasaPenyimpanan() / 100 * hitung.getTotalNilaiPinjaman())
                / (produk.getJangkaWaktu() / produk.getJasaPenyimpananPeriode()));
        hitung.setTotalBiayaJasaPenyimpanan((produk.getJangkaWaktu() / hitung.getJasaPenyimpananPeriode())
                * hitung.getBiayaJasaPenyimpananPerPeriode());
        hitung.setTotalPengembalian(
                hitung.getTotalNilaiPinjaman() + hitung.getTotalBiayaJasaPenyimpanan() + produk.getAdminTutup());

        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(hitung);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/doInsert")
    public ResponseEntity<ResponseModel> doInsertTransaksiController(
            @Valid @RequestBody TransaksiModel transaksiModel) {

        TransaksiEntity transaksi = transaksiService.doInsert(transaksiModel);
        // response
        ResponseModel response = new ResponseModel();

        response.setMsg("Sukses Simpan dengan nomor transaksi {" + transaksi.getId() + "}");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/doInsertPembayaran")
    public ResponseEntity<ResponseModel> doInsertTransaksiPembayaranController(
            @Valid @RequestBody PembayaranModel transaksiModel) {

        PembayaranTransaksiEntity transaksi = transaksiService.doInsertPembayaran(transaksiModel);
        // response
        ResponseModel response = new ResponseModel();

        response.setMsg("Sukses Simpan dengan nomor pembayaran {" + transaksi.getId() + "}");
        response.setData(transaksi);
        return ResponseEntity.ok(response);
    }
}
