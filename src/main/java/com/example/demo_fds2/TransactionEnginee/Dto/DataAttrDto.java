package com.example.demo_fds2.TransactionEnginee.Dto;

import com.example.demo_fds2.TransactionEnginee.Constant.StateType;
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
    private StateType stateType;
    private Long parentId;
    private String dataType;
}