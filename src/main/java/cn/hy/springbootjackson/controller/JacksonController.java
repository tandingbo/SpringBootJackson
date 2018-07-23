package cn.hy.springbootjackson.controller;

import cn.hy.springbootjackson.pojo.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 创建时间为 上午12:15-2018/7/23
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@RestController
public class JacksonController {

    @PostMapping("/")
    public UserDTO postUserDTO(@RequestBody UserDTO userDTO){
        return userDTO;
    }

}
