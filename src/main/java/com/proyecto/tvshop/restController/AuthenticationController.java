package com.proyecto.tvshop.restController;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @GetMapping
    public String authenticatedUser(OAuth2AuthenticationToken userToken) {
        //return userToken.getPrincipal().getAttributes(); salida tipo Object
        return "/index";
    }
}
