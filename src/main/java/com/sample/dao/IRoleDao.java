package com.sample.dao;

import com.sample.domain.Role;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:36
 **/
public interface IRoleDao {
    List<Role> findAll();
}
