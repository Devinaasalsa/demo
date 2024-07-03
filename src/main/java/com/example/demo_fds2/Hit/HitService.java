package com.example.demo_fds2.Hit;

import com.example.demo_fds2.TransactionEnginee.TransDataAttribute.TransDataAttribute;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class HitService {

    public String hit() {
        System.out.println("Tes endpoint");
        return "Tes endpoint berhasil";
    }


//    public ResponseEntity<String> postBIFASTTf(Long endpointId, Map<String, String> request) {
//        List<TransDataAttribute> dataAttributes = dataAttributeService.getDataAttributesByEndpointId(endpointId);
//
//        // Process the request with dataAttributes
//        for (TransDataAttribute dataAttribute : dataAttributes) {
//            String value = request.get(dataAttribute.getFieldTag());
//            // Perform your processing with the attribute value
//            System.out.println("Processing attribute: " + dataAttribute.getAttribute() + " with value: " + value);
//        }
//
//        return ResponseEntity.ok("Processed request for endpointId: " + endpointId);
//    }
}
