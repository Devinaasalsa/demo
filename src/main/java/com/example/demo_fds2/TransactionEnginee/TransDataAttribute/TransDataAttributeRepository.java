package com.example.demo_fds2.TransactionEnginee.TransDataAttribute;

import com.example.demo_fds2.TransactionEnginee.Constant.StateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;

import java.util.List;
import java.util.Optional;

public interface TransDataAttributeRepository extends JpaRepository<TransDataAttribute, Long> {

    List<TransDataAttribute> findByStateType(StateType stateType);
    Optional<TransDataAttribute> findByAttribute(String attribute);
    Optional<TransDataAttribute> findByAttributeAndEndpoint_EndpointIdAndParentId(String attribute, Long endpointId, Long parentId);
    List<TransDataAttribute> findByEndpoint_EndpointId(Long endpointId);

}