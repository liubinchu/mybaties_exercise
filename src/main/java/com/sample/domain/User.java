package com.sample.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 15:11
 **/

@Data
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;
    private List<Account> accounts;
}

