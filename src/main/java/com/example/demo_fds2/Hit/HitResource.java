package com.example.demo_fds2.Hit;

import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;
import com.example.demo_fds2.TransactionEnginee.Endpoint.EndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "/fds")

public class HitResource {
    protected final HitService hitService;

    @Autowired
    public HitResource(HitService hitService) {
        this.hitService = hitService;
    }

    @GetMapping("hit")
    public String hitText() {
        return hitService.hit();

    }

//    @PostMapping("/{endpointId}/BIFAST/tf")
//    public ResponseEntity<String> postBIFASTTf(@PathVariable Long endpointId, @RequestBody Map<String, String> request) {
//        return hitService.postBIFASTTf(endpointId, request);
//    }
}