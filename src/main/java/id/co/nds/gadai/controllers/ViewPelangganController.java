package id.co.nds.gadai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.nds.gadai.services.PelangganService;


@Controller
@RequestMapping(value = "/pelanggan")
public class ViewPelangganController {

    @Autowired
    PelangganService pelangganService;

    @GetMapping(value = "/")
    public String pelanggan(Model model) {
        model.addAttribute("jenisUsaha", pelangganService.doGetJenisUsaha());
        return "pelanggan";
    }
}
