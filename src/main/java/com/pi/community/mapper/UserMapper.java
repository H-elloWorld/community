package com.pi.community.mapper;

import com.pi.community.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Mendax
 * @date 2019/12/29
 **/
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,create_time,update_time) values (#{name},#{accountId},#{token},#{createTime},#{updateTime})")
    void saveUser(User user);

    @Select("select id,name,account_id,token,create_time,update_time from user where token=#{token}")
    User getUser(String token);
}
