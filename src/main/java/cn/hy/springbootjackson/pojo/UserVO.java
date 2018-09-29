package cn.hy.springbootjackson.pojo;

import cn.hy.springbootjackson.view.ResultDetailView;
import cn.hy.springbootjackson.view.ResultSimpleView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

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
public class UserVO {

    @JsonView({ResultSimpleView.class, ResultDetailView.class})
    private String field1 = "11";

    @JsonView(ResultDetailView.class)
    private String field2 = "22";


}
