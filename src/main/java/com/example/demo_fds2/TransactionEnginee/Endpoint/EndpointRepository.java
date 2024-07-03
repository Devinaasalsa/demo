package com.example.demo_fds2.TransactionEnginee.Endpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

import javax.websocket.EndpointConfig;

import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {
    List<Endpoint> findByUrlContainsOrderByEndpointIdAsc(String name);
    List<Endpoint> findAllByConfigOrderByUrlAsc(Long configId);
    
    List<Endpoint> findBySpec_SpecId(Long specId);
    List<Endpoint> findByConfig_ConfigId(Long configId);
    Endpoint findByUrl(String url);

    Optional<Endpoint> findByEndpointId(Long endpointId);

}
