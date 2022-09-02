package id.co.nds.gadai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class ViewUserController {

    @GetMapping(value = "/")
    public String user() {
        return "user";
    }
}
