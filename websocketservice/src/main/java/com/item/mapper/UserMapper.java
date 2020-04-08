package com.item.mapper;

import com.item.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {

    @Select("select * from user where account='${account}' and `password` ='${password}'")
    public User userLogin(User user);

    @Insert("insert into user(email) values()")
    public int signUpUser(User user);


    @Update("update user set password =${password} where email=${email}")
    public int updatePwd(User user);
}
