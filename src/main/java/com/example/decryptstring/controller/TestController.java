package com.example.decryptstring.controller;

import com.example.decryptstring.AES;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by : maru
 * Date  : 2/12/2020
 * Time  : 2:07 PM
 */

@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping
    public  HashMap<String, String> index(@RequestParam String originalString) {
        final String secretKey = "sky-booking";

        String encryptedString = AES.encrypt(originalString, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        HashMap<String, String> response = new HashMap<>();
        response.put("originalString", originalString);
        response.put("encryptedString", encryptedString);
        response.put("decryptedString", decryptedString);

        return response;
    }
}
