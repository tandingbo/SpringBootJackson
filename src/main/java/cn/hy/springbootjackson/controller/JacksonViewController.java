package cn.hy.springbootjackson.controller;

import cn.hy.springbootjackson.pojo.ResultBean;
import cn.hy.springbootjackson.pojo.UserVO;
import cn.hy.springbootjackson.view.UserVODetailView;
import cn.hy.springbootjackson.view.UserVOSimpleView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

@Slf4j
@RestController
public class JacksonViewController {


    @GetMapping("simple")
    @JsonView(UserVOSimpleView.class)
    public ResultBean<UserVO> getUserSimpleVO() {
        return createUserVO();
    }

    @GetMapping("detail")
    @JsonView(UserVODetailView.class)
    public ResultBean<UserVO> getUserDetailVO() {
        return createUserVO();
    }

    public ResultBean<UserVO> createUserVO() {
        UserVO vo = new UserVO();
        vo.setField1("field1");
        vo.setField2("field2");
        ResultBean<UserVO> resultBean = new ResultBean<>();
        resultBean.setData(vo);
        return resultBean;
    }

}
