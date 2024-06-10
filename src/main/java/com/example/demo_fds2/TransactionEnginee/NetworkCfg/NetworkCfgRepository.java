package com.example.demo_fds2.TransactionEnginee.NetworkCfg;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;

public interface NetworkCfgRepository extends JpaRepository<NetworkCfg, Long> {
    List<NetworkCfg> findByPortNumberContainsOrderByConfigIdAsc(String name);
    List<NetworkCfg> findBySpecId(TransSpec specId);

    
}
