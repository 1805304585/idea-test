package com.lianglongwei.mapper;

import com.lianglongwei.model.User;
import com.lianglongwei.model.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserMapper extends Mapper<User> {
    public List<UserVo> getAllUsers();
    public List<UserVo> searchUser(@Param("key") String key);
}