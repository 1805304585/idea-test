package com.lianglongwei.service;

import com.lianglongwei.mapper.DeptMapper;
import com.lianglongwei.mapper.UserMapper;
import com.lianglongwei.model.Dept;
import com.lianglongwei.model.User;
import com.lianglongwei.model.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description user和dept的service
 **/
@Service
public class IService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private RedisService<Dept> redisService;
    /**
     * @Author LLW
     * @Description 得到所有的user
     * @Date 2020/3/30
     * @Param []
     * @return java.util.List<com.lianglongwei.vo.UserVo>
     **/
    public List<UserVo> getUsers(){
        try {
            return userMapper.getAllUsers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author LLW
     * @Description 添加user
     * @Date 2020/3/30
     * @Param [user]
     * @return java.lang.Integer
     **/
    public Integer addUser(User user){
        try {
            return userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author LLW
     * @Description 得到所有的dept
     * @Date 2020/3/30
     * @Param []
     * @return java.util.List<com.lianglongwei.model.Dept>
     **/
    public List<Dept> getDepts(){
        try {
            //使用redis
            List<Dept> depts = redisService.getList("my_dept_key");
            if(null!=depts&&depts.size()!=0){
                System.out.println("reids存在数据");
                return depts;
            }else {
                System.out.println("reids没有数据");
                depts = deptMapper.selectAll();
                Boolean res = redisService.set("my_dept_key", depts);
                if(!res)
                    redisService.set("my_dept_key", depts);
                else
                    System.out.println("向redis存数据成功");
            }
            return depts;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * @Author LLW
     * @Description 模糊搜索电话和姓名
     * @Date 2020/3/30
     * @Param []
     * @return java.util.List<com.lianglongwei.model.UserVo>
     **/
    public List<UserVo> search(String key){
        try {
            List<UserVo> userVos = userMapper.searchUser(key);
            return userVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
