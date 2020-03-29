package com.tech.kamboj.common;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class BaseResponse {
    private int status;
    private String responseMsg;
    private String responseCode;
    private Instant responseTime = Instant.now();
}
