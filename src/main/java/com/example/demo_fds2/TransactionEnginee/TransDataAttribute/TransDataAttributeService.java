package com.example.demo_fds2.TransactionEnginee.TransDataAttribute;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_fds2.TransactionEnginee.Dto.DataAttrDto;
import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;
import com.example.demo_fds2.TransactionEnginee.Endpoint.EndpointRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class TransDataAttributeService {
    protected final TransDataAttributeRepository transDataAttributeRepository;
    protected final EndpointRepository endpointRepository;

    @Autowired
    public TransDataAttributeService(TransDataAttributeRepository transDataAttributeRepository, EndpointRepository endpointRepository) {
        this.transDataAttributeRepository = transDataAttributeRepository;
        this.endpointRepository = endpointRepository;
    }
    @Autowired
    private ModelMapper modelMapper;

    public List<TransDataAttribute> findAll() {
        return transDataAttributeRepository.findAll();
    }

    public DataAttrDto save(DataAttrDto attrDto) {
        TransDataAttribute transDataAttribute = modelMapper.map(attrDto, TransDataAttribute.class);
        
        Endpoint endpoint = endpointRepository.findById(attrDto.getEndpointId())
            .orElseThrow(() -> new RuntimeException("Data not found"));
        
        transDataAttribute.setEndpointId(endpoint);
        
        TransDataAttribute savedAttribute = transDataAttributeRepository.save(transDataAttribute);
        
        return modelMapper.map(savedAttribute, DataAttrDto.class);
    }

    public TransDataAttribute update(TransDataAttribute reqbody){
        this.validateDataId(reqbody.getAttrId());
        return this.transDataAttributeRepository.save(reqbody);
    }

    protected void validateDataId(long id){
        this.transDataAttributeRepository
            .findById(id)
            .orElseThrow(()-> new RuntimeException("Data not found"));
    }

    public TransDataAttribute findOne(Long attrId){
        return transDataAttributeRepository.findById(attrId)
        .orElseThrow(()-> new EntityNotFoundException("data not foundd"));
    }

    public List<TransDataAttribute> fetchAllByEndpointId(Long endpointId) {
        return transDataAttributeRepository.findAllByEndpointId(endpointId);
    }

    public void removeOne(Long attrId){
        transDataAttributeRepository.deleteById(attrId);
    }

}