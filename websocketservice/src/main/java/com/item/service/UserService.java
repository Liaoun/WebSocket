package com.item.service;

import com.item.bean.User;
import com.item.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper mapper;
    @Cacheable
    public User userLogin(User user){
        return mapper.userLogin(user);
    }

//    @CachePut
    public Boolean signUpUser(User user){
        int i=mapper.signUpUser(user);
        return i>0?true:false;
    }

    public Boolean updatePwd(User user){
        int i= mapper.updatePwd(user);
        return i>0?true:false;
    }


}
