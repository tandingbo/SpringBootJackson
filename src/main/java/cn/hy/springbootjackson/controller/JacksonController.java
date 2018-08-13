package cn.hy.springbootjackson.controller;

import cn.hy.springbootjackson.pojo.ResultBean;
import cn.hy.springbootjackson.pojo.UserDTO;
import cn.hy.springbootjackson.pojo.UserVO;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    @JsonView(ResultBean.ResultSimpleView.class)
    public ResultBean<UserVO> getUserVO(){

        UserVO vo = new UserVO();
        vo.setField1("field1");
        vo.setField2("field2");
        ResultBean<UserVO> resultBean = new ResultBean<>();
        resultBean.setData(vo);
        return resultBean;
    }

}
