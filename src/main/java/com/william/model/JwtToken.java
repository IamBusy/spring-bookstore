package com.william.model;

import lombok.Data;

/**
 * Created by william on 17/04/2017.
 */
@Data
public class JwtToken {
    private String token;
    private String expired_in;
}
