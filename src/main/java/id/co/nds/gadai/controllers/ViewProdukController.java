package id.co.nds.gadai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/produk")
public class ViewProdukController {

    @GetMapping(value = "/")
    public String user() {
        return "produk";
    }
}
