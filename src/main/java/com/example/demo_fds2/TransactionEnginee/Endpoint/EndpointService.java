package com.example.demo_fds2.TransactionEnginee.Endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_fds2.TransactionEnginee.Dto.EndpointDto;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpecService;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class EndpointService {
protected final EndpointRepository endpointRepository;

    @Autowired
    public EndpointService(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }
    @Autowired
    private TransSpecService transSpecService;

    public List<Endpoint> findAll(){
        return this.endpointRepository.findAll();
    }

    public List<Endpoint> getEndpointsBySpecId(Long specId) {
        return endpointRepository.findBySpec_SpecId(specId);
    }

    public List<Endpoint> getEndpointsByConfigId(Long configId) {
        return endpointRepository.findByConfig_ConfigId(configId);
    }
    
    public Endpoint save(Endpoint reqBody){
        return this.endpointRepository.save(reqBody);
    }

    public Endpoint update(Endpoint reqBody){
        this.validateDataId(reqBody.getEndpointId());
        return this.endpointRepository.save(reqBody);
    }

    protected void validateDataId(long id) {
        this.endpointRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Data not found"));
    }
    
    public Endpoint findOne(Long endpointId){
        Optional<Endpoint> endpoint = endpointRepository.findById(endpointId);
        if(!endpoint.isPresent()){
            return null;
        }
        return endpoint.get();
    }

    public List<Endpoint> findByUrl(String url){
        return endpointRepository.findByUrlContainsOrderByEndpointIdAsc(url);
    }
    
    public void removeOne(Long endpointId){
        endpointRepository.deleteById(endpointId);
    }


}

