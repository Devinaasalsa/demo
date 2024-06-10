package com.example.demo_fds2.TransactionEnginee.Endpoint;

import java.util.*;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_fds2.TransactionEnginee.Domain.ResponseResourceEntity;
import com.example.demo_fds2.TransactionEnginee.Dto.EndpointDto;
import com.example.demo_fds2.TransactionEnginee.Dto.NetworkCfgDto;
import com.example.demo_fds2.TransactionEnginee.Dto.ResponseData;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/endpoint")
public class EndpointResource extends ResponseResourceEntity<Object> {

    protected final EndpointService endpointService;

    @Autowired
    public EndpointResource(EndpointService endpointService) {
        this.endpointService = endpointService;
    }

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("list/{id}")
    public ResponseEntity<?> fetchAll(@PathVariable("id") long configId) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            List<Endpoint> fetchedData = endpointService.findAll(configId);
            httpStatus = OK;
            httpMessage = "Channel Endpoint Fetched Successfully";
            return responseWithListObjectData(httpStatus, httpMessage, fetchedData);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return responseWithListData(httpStatus, httpMessage, new ArrayList<>());
        }
    }

    // @GetMapping("findByConfig/{configId}")
    // public ResponseEntity<?> fetchByConfigId(@PathVariable("configId") long configId) {
    //     HttpStatus httpStatus;
    //     String httpMessage;
    //     try {
    //         List<Endpoint> fetchedData = endpointService.findByConfigId(configId);
    //         httpStatus = HttpStatus.OK;
    //         httpMessage = "Channel Endpoint Fetched Successfully";
    //         return responseWithListObjectData(httpStatus, httpMessage, fetchedData);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    //         httpMessage = e.getMessage();
    //         return responseWithListData(httpStatus, httpMessage, new ArrayList<>());
    //     }
    // }
    @GetMapping("/by-config/{configId}")
    public ResponseEntity<List<Endpoint>> getEndpointsByConfigId(@PathVariable NetworkCfg configId) {
        List<Endpoint> endpoints = endpointService.getEndpointsByConfigId(configId);
        if (endpoints.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(endpoints, HttpStatus.OK);
    }

    @GetMapping("find/{endpointId}")
    public Endpoint findByEndpointId(@PathVariable("endpointId") long endpointId) {
        return endpointService.findOne(endpointId);
        // HttpStatus httpStatus;
        // String httpMessage;
        // try {
        //     Endpoint fetchedData = endpointService.findOne(endpointId);
        //     if(fetchedData != null){
        //     httpStatus = OK;
        //     httpMessage = "Channel Endpoint Fetched Successfully";
        //     return responseWithData(httpStatus, httpMessage, fetchedData);
        //     } else {
        //         httpStatus = HttpStatus.NOT_FOUND;
        //         httpMessage = "Data not found";
        //         return response(httpStatus, httpMessage);
    
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     httpStatus = INTERNAL_SERVER_ERROR;
        //     httpMessage = e.getMessage();
        //     return responseWithData(httpStatus, httpMessage, null);
        // }
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestBody EndpointDto reqBody) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            Endpoint endpoint = new Endpoint();
            endpoint.setUrl(reqBody.getUrl());
            endpoint.setIsAuth(reqBody.getIsAuth());

            TransSpec transSpec = new TransSpec();
            transSpec.setSpecId(reqBody.getSpecId());
            endpoint.setSpecId(transSpec);

            NetworkCfg networkCfg = new NetworkCfg();
            networkCfg.setConfigId(reqBody.getConfigId());
            endpoint.setConfigId(networkCfg);

            Endpoint fetchedData = endpointService.save(endpoint);
            httpStatus = OK;
            httpMessage = "Channel Endpoint Fetched Successfully";
            return responseWithListObjectData(httpStatus, httpMessage, fetchedData);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return new ResponseEntity<>(httpMessage, httpStatus);
        }
    }

    @PostMapping("update")
    public ResponseEntity<?> update(@RequestBody EndpointDto reqBody) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            Endpoint endpoint = modelMapper.map(reqBody, Endpoint.class);
            endpointService.update(endpoint);
            httpStatus = OK;
            httpMessage = "Channel Endpoint updated Successfully";
            return response(httpStatus, httpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return response(httpStatus, httpMessage);
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        HttpStatus httpStatus;
        String httpMessage;
        try {
            endpointService.removeOne(id);
            httpStatus = OK;
            httpMessage = "Channel Endpoint deleted Successfully";
            return response(httpStatus, httpMessage);
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = INTERNAL_SERVER_ERROR;
            httpMessage = e.getMessage();
            return response(httpStatus, httpMessage);
        }
    }

    @GetMapping("/find/spec/{specId}")
    public List<Endpoint> getEndpointBySpec(@PathVariable("specId") Long specId){
        return endpointService.findBySpecId(specId);
    }
}
