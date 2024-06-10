package com.example.demo_fds2.TransactionEnginee.TransSpec;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_fds2.TransactionEnginee.Dto.ResponseData;
import com.example.demo_fds2.TransactionEnginee.Dto.TransSpecDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/transSpec")
public class TransSpecResource {

    @Autowired 
    private TransSpecService transSpecService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public Iterable<TransSpec> findAll(){
        return transSpecService.findAll();
    }

    @GetMapping("/{id}")
    public TransSpec findOne(@PathVariable("id") Long specId){
        
        return transSpecService.findOne(specId);
    }

    @PostMapping
    public ResponseEntity<ResponseData<TransSpec>> create(@Valid @RequestBody TransSpecDto transSpecDto, Errors errors){
        ResponseData<TransSpec> responseData = new ResponseData<>();
        if(errors.hasErrors()){
            for(ObjectError error : errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        TransSpec transSpec = modelMapper.map(transSpecDto, TransSpec.class);

        responseData.setStatus(true);
        responseData.setPayload(transSpecService.save(transSpec));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/delete/{id}")
    public void removeOne(@PathVariable("id") Long specId){
        transSpecService.removeOne(specId);
    }
}
