package com.demo.controller;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/findAll")
    public String select(Model model){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample);
        model.addAttribute("users",users);
        return "user/userList";
    }

    @RequestMapping("/update/{id}")
    public String toUpdateUser(@PathVariable("id")Integer id,Model model){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> users = userMapper.selectByExample(userExample);
        model.addAttribute("user",users.get(0));
        return "user/update";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id,Model model){
        //先进行删除操作再返回到用户列表
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        userMapper.deleteByExample(userExample);

        UserExample userExample1 = new UserExample();
        UserExample.Criteria criteria1 = userExample1.createCriteria();
        criteria1.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample1);
        model.addAttribute("users",users);
        return "user/userList";
    }
    @PostMapping("/updateUser")
    public String updateUser(User user,Model model){
        UserExample userExample = new UserExample();

        userMapper.updateByExample(user,userExample);
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample);
        model.addAttribute("users",users);
        return "user/userList";
    }
    //跳转到添加用户页面
    @GetMapping("/addUser")
    public String toInsertUser(Model model){
        return "user/add";
    }
    @PostMapping("/addUser")
    public String addUser(User user,Model model){
        UserExample userExample = new UserExample();
        userMapper.insert(user);
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIsNotNull();
        List<User> users = userMapper.selectByExample(userExample);
        model.addAttribute("users",users);
        return "user/userList";
    }
}
