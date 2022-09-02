package id.co.nds.gadai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.nds.gadai.services.ProdukService;

@Controller
@RequestMapping(value = "/transaksi")
public class ViewTransaksiController {

    @Autowired
    ProdukService produkService;
    
    @GetMapping(value = "/")
    public String transaksi(Model model) {
        model.addAttribute("produkCicilanTetap", produkService.doGetProdukCicilanTetap());
        return "transaksi";
    }
    @GetMapping(value = "/pembayaran")
    public String pembayaran() {
        return "pembayaran";
    }
}
