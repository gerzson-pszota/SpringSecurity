package com.greenfoxrepository.springadvanced.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/api/v1/auth/authenticate")
    public String authenticate() {
        return "authenticate";
    }
}
