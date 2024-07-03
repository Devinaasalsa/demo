package com.example.demo_fds2.TransactionEnginee.Endpoint;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransDataAttribute.TransDataAttribute;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "endpoint")
public class Endpoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long endpointId;

    private String url;
    private Boolean isAuth;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spec_id", referencedColumnName = "specId")
    private TransSpec spec;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "config_id", referencedColumnName = "configId")
    private NetworkCfg config;

    @JsonIgnore
    @OneToMany(mappedBy = "endpoint", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TransDataAttribute> dataAttributes;


}
