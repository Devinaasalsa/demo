package com.example.demo_fds2.TransactionEnginee.Endpoint;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import com.example.demo_fds2.TransactionEnginee.TransSpec.TransSpec;
import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
import com.example.demo_fds2.TransactionEnginee.TransDataAttribute.TransDataAttribute;

import java.io.Serializable;
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
    private TransSpec specId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "config_id", referencedColumnName = "configId")
    private NetworkCfg configId;

    @OneToMany(mappedBy = "endpointId", fetch = FetchType.EAGER)
    private Set<TransDataAttribute> dataAttributes;
}
