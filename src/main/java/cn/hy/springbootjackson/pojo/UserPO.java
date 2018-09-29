package cn.hy.springbootjackson.pojo;

import cn.hy.springbootjackson.enums.TimeUnitEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 创建时间为 下午7:09-2018/9/28
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
public class UserPO {

    @JsonIgnore
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private String name;

//    ColorEnum colorEnum;
    @NotNull
    private TimeUnitEnum timeEnum;

    @Override
    public String toString() {
//        MAPPER.configure(SerializationFeature.WRAP_ROOT_VALUE,true);
        try {
            return MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }


}
