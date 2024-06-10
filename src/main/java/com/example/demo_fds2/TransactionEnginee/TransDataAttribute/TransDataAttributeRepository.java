package com.example.demo_fds2.TransactionEnginee.TransDataAttribute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;

import java.util.List;

public interface TransDataAttributeRepository extends JpaRepository<TransDataAttribute, Long> {

    // List<TransDataAttribute> findAllByAddtData();
    // List<TransDataAttribute> findAllByEndpointId(Endpoint endpoint);
    @Query("SELECT t FROM TransDataAttribute t WHERE t.endpointId.endpointId = :endpointId")
    List<TransDataAttribute> findAllByEndpointId(@Param("endpointId") Long endpointId);
}