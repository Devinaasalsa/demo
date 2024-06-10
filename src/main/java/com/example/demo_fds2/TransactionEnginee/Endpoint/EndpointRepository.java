package com.example.demo_fds2.TransactionEnginee.Endpoint;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;

public interface EndpointRepository extends JpaRepository<Endpoint, Long> {
    List<Endpoint> findByUrlContainsOrderByEndpointIdAsc(String name);
    List<Endpoint> findAllByConfigIdOrderByUrlAsc(Long configId);
    
    List<Endpoint> findBySpecId(TransSpec specId);

    List<Endpoint> findByConfigId(NetworkCfg configId);
    
    Optional<Endpoint> findByEndpointId(Long endpointId);


}
