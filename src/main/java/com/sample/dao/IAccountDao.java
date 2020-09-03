package com.sample.dao;

import com.sample.domain.AccountUser;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:25
 **/
public interface IAccountDao {
    List<AccountUser> findAll();
}
