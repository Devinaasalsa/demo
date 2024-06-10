package com.example.demo_fds2.TransactionEnginee.Dto;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EndpointDto {
    private String url;
    private Boolean isAuth;

    private Long configId;
    private Long specId;
}

