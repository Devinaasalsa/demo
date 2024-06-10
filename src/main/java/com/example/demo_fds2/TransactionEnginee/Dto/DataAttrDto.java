package com.example.demo_fds2.TransactionEnginee.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DataAttrDto
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DataAttrDto {

    private String attribute;
    private String fieldTag;
    private String description;
    private Long endpointId;
}