package com.daxueshi.sqlwork.controller;

import com.daxueshi.sqlwork.VO.Result;
import com.daxueshi.sqlwork.domain.User;
import com.daxueshi.sqlwork.enums.ResultEnums;
import com.daxueshi.sqlwork.service.UserService;
import com.daxueshi.sqlwork.utils.JwtUtils;
import com.daxueshi.sqlwork.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户请求")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result login(@RequestBody @Valid User u){
        User user = userService.login(u.getEmail(),u.getPassword());
        if(user != null){
            String token = jwtUtils.createJwt(user);
            Map map = new HashMap();
            map.put("token",token);
            map.put("name",user.getNickname());
            map.put("portrait",user.getPortraitUrl());
            return  ResultUtils.success(map);
        }else{
            return ResultUtils.error(ResultEnums.LOGIN_ERROR);
        }
    }




}
