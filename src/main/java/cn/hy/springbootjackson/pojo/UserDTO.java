package cn.hy.springbootjackson.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * <p>
 * 创建时间为 上午9:58-2018/6/26
 * 项目名称 template
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@Getter
@Setter
// 表示对于pass字段，反序列化和序列化均忽略，而对于Json中存在的未知字段，在反序列化时忽略，ignoreUnknown不对序列化起效。
// 如果要调用第三方的API，可以使用通过@JsonIgnoreProperties(ignoreUnknown = true)忽略掉所有不需要的字段。
//@JsonIgnoreProperties(value = {"pass"}, ignoreUnknown = true)


// 序列化时排除null或者空字符串
//@JsonInclude(JsonInclude.Include.NON_NULL)

// 表示在序列化Person时，将值为null的字段排除掉。
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonRootName("UserDTO")

//作用在类上，被用来指明当序列化时需要对属性做排序，它有2个属性
//一个是alphabetic：布尔类型，表示是否采用字母拼音顺序排序，默认是为false，即不排序
@JsonPropertyOrder(alphabetic = true, value = {"date", "age"})
public class UserDTO {

    @JsonIgnore
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @JsonProperty("first_name")
    private String name;

    private String pass;

    private int age;

    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

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
