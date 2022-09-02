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
import id.co.nds.gadai.models.PelangganModel;
import id.co.nds.gadai.services.PelangganService;
import id.co.nds.gadai.entities.PelangganEntity;

@RestController
@RequestMapping(value = "/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;

    @GetMapping(value = "/doGetAllPelanggan")
    public ResponseEntity<ResponseModel> doGetAllPelanggan() {
        // request
        List<PelangganEntity> pelanggan = pelangganService.doGetAllPelanggan();
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(pelanggan);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doSearchPelanggan")
    public ResponseEntity<ResponseModel> doSearchPelangganController(@RequestParam(required = false) 
    String nomorKtp, String namaPelanggan, String id, String recStatus, String nomorHp, String jenisUsaha) {
        // request
        PelangganModel pelanggan = new PelangganModel();
        pelanggan.setNomorKtp(nomorKtp);
        pelanggan.setNamaPelanggan(namaPelanggan);
        pelanggan.setId(id);
        pelanggan.setRecStatus(recStatus);
        pelanggan.setNomorHp(nomorHp);
        pelanggan.setJenisUsaha(jenisUsaha);
        List<PelangganEntity> pelanggans = pelangganService.doSearchPelanggan(pelanggan);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(pelanggans);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/doGetDetailPelanggan/{id}")
    public ResponseEntity<ResponseModel> doGetDetailPelangganController(@PathVariable String id) {
        // request
        PelangganEntity pelanggan = pelangganService.findById(id);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Request successfully");
        response.setData(pelanggan);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/doInsert")
    public ResponseEntity<ResponseModel> doInsertPelangganController(
            @Valid @RequestBody PelangganModel pelangganModel) {
        PelangganEntity pelanggan = pelangganService.doInsert(pelangganModel);
        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("New pelanggan is successfully added");
        response.setData(pelanggan);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/doUpdate")
    public ResponseEntity<ResponseModel> doUpdatePelangganController(
            @RequestBody PelangganModel pelangganModel) {
        // request
        PelangganEntity pelanggan = pelangganService.doUpdate(pelangganModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Pelanggan is successfully updated");
        response.setData(pelanggan);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/doDelete")
    public ResponseEntity<ResponseModel> doDeletePelangganController(
            @RequestBody PelangganModel pelangganModel) {
        // request
        PelangganEntity pelanggan = pelangganService.doDelete(pelangganModel);

        // response
        ResponseModel response = new ResponseModel();
        response.setMsg("Pelanggan is successfully deleted");
        response.setData(pelanggan);
        return ResponseEntity.ok(response);
    }
}
