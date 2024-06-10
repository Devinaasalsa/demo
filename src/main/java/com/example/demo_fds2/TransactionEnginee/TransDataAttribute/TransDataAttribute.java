package com.example.demo_fds2.TransactionEnginee.TransDataAttribute;

import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "data_attribute")
public class TransDataAttribute implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attrId;

    private String attribute;
    private String fieldTag;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "endpoint_id", referencedColumnName = "endpointId")
    private Endpoint endpointId;
}
