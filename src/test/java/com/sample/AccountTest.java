package com.sample;

import com.sample.dao.IAccountDao;
import com.sample.domain.AccountUser;
import org.junit.Test;
import java.util.*;

/**
 * @author liubi
 * @date 2020-09-02 17:28
 **/
public class AccountTest {

    private IAccountDao accountDao;
    @Test
    public void testFindAll() {
//6.执行操作
        List<AccountUser> accountusers = accountDao.findAll();
        for(AccountUser au : accountusers) {
            System.out.println(au);
        }
        assert accountusers.size() == 3;
    }
}
