package com.sample.dao;

import com.sample.domain.QueryVo;
import com.sample.domain.QueryVoIds;
import com.sample.domain.User;

import java.util.List;

/**
 * @author liubi
 * @date 2020-09-02 15:13
 **/

public interface IUserDao {
/*    @Select("select * from user")*/
    List<User> findAll();
    User findById(Integer userId);
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer userId);
    List<User> findByName(String username);
    List<User> findByNameNew(String username);
    int count();
    List<User> findByVo(QueryVo vo);
    List<User> findInIds(QueryVoIds qv);
}
