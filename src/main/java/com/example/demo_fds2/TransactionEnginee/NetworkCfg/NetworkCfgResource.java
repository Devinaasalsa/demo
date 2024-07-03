package com.example.demo_fds2.TransactionEnginee.NetworkCfg;

import java.util.List;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import com.example.demo_fds2.TransactionEnginee.Domain.ResponseResourceEntity;

import com.example.demo_fds2.TransactionEnginee.Dto.NetworkCfgDto;
import com.example.demo_fds2.TransactionEnginee.Dto.ResponseData;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/networkCfg")
public class NetworkCfgResource {

    @Autowired
    private NetworkCfgService networkCfgService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<NetworkCfg> findAll() {
        return networkCfgService.findAll();
    }

    @GetMapping("/{configId}")
    public NetworkCfg findOne(@PathVariable("configId") Long configId) {
        return networkCfgService.findOne(configId);
    }

    @PostMapping
    public ResponseEntity<ResponseData<NetworkCfg>> create(@Valid @RequestBody NetworkCfgDto networkCfgDto, Errors errors) {
        ResponseData<NetworkCfg> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        NetworkCfg data = modelMapper.map(networkCfgDto, NetworkCfg.class);

        responseData.setStatus(true);
        responseData.setPayload(networkCfgService.save(data));
        return ResponseEntity.ok(responseData);
    }

    @DeleteMapping("/delete/{configId}")
    public void removeOne(@PathVariable("configId") Long configId) {
        networkCfgService.removeOne(configId);
    }

    @GetMapping("/find/spec/{specId}")
    public List<NetworkCfg> getConfigBySpec(@PathVariable("specId") Long specId){
        return networkCfgService.findBySpecId(specId);
    }
}
