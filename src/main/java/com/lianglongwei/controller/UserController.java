package com.lianglongwei.controller;


import com.lianglongwei.model.User;
import com.lianglongwei.model.UserVo;
import com.lianglongwei.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @Author LLW
 * @Date 2020/3/30.
 * @Description TODO
 **/
@Controller
public class UserController {
    @Autowired
    private IService service;
    /**
     * @Author LLW
     * @Description 所有user
     * @Date 2020/3/30
     * @Param [model]
     * @return java.lang.String
     **/
    @GetMapping("/allUsers")
    public String allUsers(Model model){
        List<UserVo> users = service.getUsers();
        if (users!=null&&users.size()!=0) {
            model.addAttribute("users",users);
            return "userInfo";
        }
        else {
            model.addAttribute("msg","暂无");
            return "error";
        }
    }
    /**
     * @Author LLW
     * @Description 添加user页面
     * @Date 2020/3/30
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/addUserPage")
    public String addUserPage() {
        return "addUser";
    }
/**
 * @Author LLW
 * @Description 添加user
 * @Date 2020/3/30
 * @Param [user, model]
 * @return java.lang.String
 **/
    @PostMapping("/addUser")
    public String addBook(User user, Model model) {
        Integer res = service.addUser(user);
        if(res > 0) {
            return "redirect:allUsers";
        } else {
            model.addAttribute("msg", "user保存失败！！");
            return "error";
        }
    }
    /**
     * @Author LLW
     * @Description 搜索
     * @Date 2020/3/30
     * @Param [searchKey]
     * @return java.lang.String
     **/
    @GetMapping("/search")
    public String search(@RequestParam("search") String searchKey,Model model){
        //去除两端空格
        List<UserVo> users = service.search(searchKey.trim());
        model.addAttribute("users",users);
        return "userInfo";
    }
}
