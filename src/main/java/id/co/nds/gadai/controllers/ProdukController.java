package id.co.nds.gadai.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.nds.gadai.models.ResponseModel;
import id.co.nds.gadai.models.ProdukModel;
import id.co.nds.gadai.services.ProdukService;
import id.co.nds.gadai.entities.ProdukEntity;

@RestController
@RequestMapping(value = "/produk")
public class ProdukController {
    @Autowired
    private ProdukService produkService;

    @GetMapping(value = "/doGetAllProduk")
    public ResponseEntity<ResponseModel> doGetAllproduk() {
        // request
        List<ProdukEntity> produk = produkService.doGetAllProduk();
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(produk);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doSearchProduk")
    public ResponseEntity<ResponseModel> doSearchProdukController(@RequestParam(required = false) String id,
    String tipeProduk, String namaProduk, String recStatus, Double ltv, Double ltvSampai, Double jasaPenyimapanan, 
    Double jasaPenyimpananSampai) {
        // request
        ProdukModel produk = new ProdukModel();
        produk.setId(id);
        produk.setTipeProduk(tipeProduk);
        produk.setNamaProduk(namaProduk);
        produk.setRecStatus(recStatus);
        produk.setLtv(ltv);
        produk.setLtvSampai(ltvSampai);
        produk.setJasaPenyimpanan(jasaPenyimapanan);
        produk.setJasaPenyimpananSampai(jasaPenyimpananSampai);
        List<ProdukEntity> produks = produkService.doSearchProduk(produk);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(produks);
        return ResponseEntity.ok(response);
        
    }

    @GetMapping(value = "/doGetDetailProduk/{id}")
    public ResponseEntity<ResponseModel> doGetDetailProdukController(@PathVariable String id) {
        // request
        ProdukEntity produk = produkService.findById(id);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(produk);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/doInsert")
    public ResponseEntity<ResponseModel> doInsertProdukController(
            @Valid @RequestBody ProdukModel produkModel) {
        ProdukEntity produk = produkService.doInsert(produkModel);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("New produk is successfully added");
        response.setData(produk);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/doUpdate")
    public ResponseEntity<ResponseModel> doUpdateProdukController(
            @RequestBody ProdukModel produkModel) {
        // request
        ProdukEntity produk = produkService.doUpdate(produkModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Produk is successfully updated");
        response.setData(produk);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/doDelete")
    public ResponseEntity<ResponseModel> doDeleteProdukController(
            @RequestBody ProdukModel produkModel) {
        // request
        ProdukEntity produk = produkService.doDelete(produkModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Produk is successfully deleted");
        response.setData(produk);
        return ResponseEntity.ok(response);
    }
}
