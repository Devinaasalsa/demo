package com.example.demo_fds2.TransactionEnginee.Dto;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TransSpecDto {
    
    @NotEmpty(message="Name is required")
    private String name;

}