package cn.hy.springbootjackson.pojo;

import cn.hy.springbootjackson.view.UserVOSimpleView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 创建时间为 上午10:55-2018/8/3
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@Data
public class ResultBean<T> implements Serializable {

    @JsonIgnore
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @JsonIgnore
    private static final int SUCCESS = 0;

    @JsonIgnore
    private static final int FAIL = 1;

    @JsonView(UserVOSimpleView.class)
    private String message = "success";

    @JsonView(UserVOSimpleView.class)
    private int status = SUCCESS;

    @JsonView(UserVOSimpleView.class)
    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        this.data = data;
    }

    public ResultBean(Throwable throwable) {
        this.status = FAIL;
        this.message = throwable.toString();
    }

    @Override
    public String toString() {
        try {
            return MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}
