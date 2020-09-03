package com.sample.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liubi
 * @date 2020-09-02 17:22
 **/
@Data
public class Account implements Serializable {
    private Integer id;
    private Integer uid;
    private Double money;
}
