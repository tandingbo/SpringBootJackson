package cn.hy.springbootjackson.controller;

import cn.hy.springbootjackson.enums.TimeUnitEnum;
import cn.hy.springbootjackson.pojo.UserDO;
import cn.hy.springbootjackson.pojo.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
public class JacksonJsonController {

    @PostMapping("/userdo")
    public UserDO postUserDO(@RequestBody UserDO userDTO) {
        log.info(userDTO.toString());
        return userDTO;
    }

    @PostMapping("/userpo")
    public UserPO postUserPO(@RequestBody @Valid UserPO userPO) throws Exception{
        log.info(userPO.toString());
        TimeUnitEnum.forValue(userPO.getTimeEnum().getUnit()).sleep(1);
        return userPO;
    }

}
