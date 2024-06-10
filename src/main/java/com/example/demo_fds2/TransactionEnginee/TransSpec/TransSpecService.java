package com.example.demo_fds2.TransactionEnginee.TransSpec;

import java.util.List;
import java.util.Optional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.util.Supplier;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpecRepository;

@Service
@Transactional
public class TransSpecService {
    // @PersistenceContext
    // protected final TransSpecRepository TransSpecRepository;

@Autowired
    private TransSpecRepository transSpecRepository;

    public Iterable<TransSpec> findAll(){
        return transSpecRepository.findAll();
    }

    public TransSpec save(TransSpec transSpec){
        return transSpecRepository.save(transSpec);
    }
    
    public TransSpec findOne(Long specId){
        Optional<TransSpec> transSpec = transSpecRepository.findById(specId);
        if(!transSpec.isPresent()){
            return null;
        }
        return transSpec.get();
    }

    public List<TransSpec> findByName(String name){
        return transSpecRepository.findByNameContainsOrderBySpecIdAsc(name);
    }
    
    public void removeOne(Long specId){
        transSpecRepository.deleteById(specId);
    }

}
