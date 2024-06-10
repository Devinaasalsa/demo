package com.example.demo_fds2.TransactionEnginee.TransDataAttribute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo_fds2.TransactionEnginee.Domain.HttpResponse;
import com.example.demo_fds2.TransactionEnginee.Domain.ResponseResourceEntity;
import com.example.demo_fds2.TransactionEnginee.Dto.DataAttrDto;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/dataAttribute")

public class TransDataAttributeResource extends ResponseResourceEntity<TransDataAttribute> {
    protected final TransDataAttributeService transDataAttributeService;

    @Autowired
    public TransDataAttributeResource(TransDataAttributeService transDataAttributeService) {
        this.transDataAttributeService = transDataAttributeService;
    }

    @GetMapping("/list")
    public ResponseEntity<HttpResponse<List<TransDataAttribute>>> fetchAllData() {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            List<TransDataAttribute> fetchedData = transDataAttributeService.findAll();
            httpStatus = OK;
            httpMessage = "Data Attribute Fetched Successfully";
            return responseWithListData(httpStatus, httpMessage, fetchedData);
        } catch (Exception e) {
            httpStatus = INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return responseWithListData(httpStatus, httpMessage, new LinkedList<>());
        }
    }

    @GetMapping("find/{attrId}")
    public ResponseEntity<?> findByAttrId(@PathVariable("attrId") long attrId) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            TransDataAttribute fetchedData = transDataAttributeService.findOne(attrId);
            httpStatus = HttpStatus.OK;
            httpMessage = "Data Attribute Fetched Successfully";
            return responseWithData(httpStatus, httpMessage, fetchedData);
        } catch (EntityNotFoundException e) {
            httpStatus = HttpStatus.NOT_FOUND;
            httpMessage = e.getMessage();
            return responseWithData(httpStatus, httpMessage, null);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return responseWithData(httpStatus, httpMessage, null);
        }
    }

    @GetMapping("/listByEndpoint/{id}")
    public ResponseEntity<?> fetchByConfigIdAndEndpointId(@PathVariable("id") long endpointId) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            List<TransDataAttribute> fetchedData = transDataAttributeService.fetchAllByEndpointId(endpointId);
            httpStatus = HttpStatus.OK;
            httpMessage = "Success Fetch Data";
            return responseWithListData(httpStatus, httpMessage, fetchedData);
        } catch (Exception e) {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return responseWithListData(httpStatus, httpMessage, new LinkedList<>());
        }
    }


    @PostMapping
    public ResponseEntity<?> add(@RequestBody DataAttrDto reqbody) {
        DataAttrDto savedAttribute = transDataAttributeService.save(reqbody);
        return new ResponseEntity<>(savedAttribute, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            transDataAttributeService.removeOne(id);
            httpStatus = OK;
            httpMessage = "Data Attribute deleted Successfully";
            return response(httpStatus, httpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return response(httpStatus, httpMessage);
        }
    }
}
