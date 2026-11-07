package com.soa.exam;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristService service;

    private static final String VALID_TOKEN =
            "my-secret-token";

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(
        @RequestHeader(value = "Token", required = false)
        String token) {

        if (!VALID_TOKEN.equals(token)) {
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Unauthorized: Invalid Token Provided");
        }

        List<Tourist> tourists =
                service.getAllTourists();

        return ResponseEntity.ok(tourists);
    }
    
    @PostMapping("/tourists")
    public Tourist addTourist(@RequestBody Tourist tourist) {
        return service.saveTourist(tourist);
    }
}