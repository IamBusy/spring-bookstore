package com.william.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;


/**
 * Created by william on 17/3/23.
 */
@Data
public class User implements Serializable{

    @Id
    private String id;
    private String username;
    private String password;
    private String salt;
    private String photo;
    private List<String> roles;
}
