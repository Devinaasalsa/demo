package com.example.demo_fds2.TransactionEnginee.NetworkCfg;

import java.util.*;

import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpecService;

import javax.transaction.Transactional;

@Service
@Transactional
public class NetworkCfgService {

    @Autowired
    private NetworkCfgRepository networkCfgRepository;
    @Autowired
    private TransSpecService transSpecService;

    public List<NetworkCfg> findAll() {
        return networkCfgRepository.findAll();
    }

    public NetworkCfg save(NetworkCfg networkCfg) {
        return networkCfgRepository.save(networkCfg);
    }

    public NetworkCfg findOne(Long configId) {
        Optional<NetworkCfg> networkCfg = networkCfgRepository.findById(configId);
        return networkCfg.orElse(null);
    }

    public List<NetworkCfg> findByPortNumber(String portNumber) {
        return networkCfgRepository.findByPortNumberContainsOrderByConfigIdAsc(portNumber);
    }

    public void removeOne(Long configId) {
        networkCfgRepository.deleteById(configId);
    }

    public List<NetworkCfg> findBySpecId(Long specId){
        TransSpec transSpec = transSpecService.findOne(specId);
        if(transSpec == null){
            return new ArrayList<>();
        }
        return networkCfgRepository.findBySpecId(transSpec);
    }


}
