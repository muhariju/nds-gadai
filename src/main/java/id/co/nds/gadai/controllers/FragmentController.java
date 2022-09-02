package id.co.nds.gadai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/fragments")
public class FragmentController {

    @GetMapping("/nav")
    public String getNav() {
        return "nav";
    }
}
