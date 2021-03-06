package com.sakura.rain.api;

import com.sakura.rain.entity.UserInfo;
import com.sakura.rain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

/**
 * @ClassName UserApi
 * @function [业务功能]
 * @notice 控制层只做入参出参处理
 * @Author lcz
 * @Date 2020/06/08 14:57
 */
@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public ResponseEntity<List<UserInfo>> getUserList() {
        /*为了验证feign的效果，这里设置查询结果的时候动态返回成功失败的机会*/
        int nextInt = new Random().nextInt(100);
        if (nextInt % 3 == 0) {
            System.out.println("执行错误返回机制");
            return ResponseEntity.badRequest().body(null);
        }
        if (nextInt % 3 == 1) {
            System.out.println("执行了超时返回操作");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ResponseEntity.ok(userService.getUserList());
        }
        return ResponseEntity.ok(userService.getUserList());
    }
}
