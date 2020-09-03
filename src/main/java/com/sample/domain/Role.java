package com.sample.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:35
 **/
@Data
public class Role implements Serializable {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<User> users;
}
