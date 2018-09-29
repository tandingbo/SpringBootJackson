package cn.hy.springbootjackson.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 创建时间为 下午7:05-2018/9/28
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ColorEnum {

    BLACK("black"), WHITE("white"), @JsonEnumDefaultValue BLUE("blue");

    private String color;

    private static Map<String, ColorEnum> map = new HashMap<>();

    static {
        map.put("black", BLACK);
        map.put("white", WHITE);
        map.put("blue", BLUE);
    }

    ColorEnum(String color) {
        this.color = color;
    }

    @JsonCreator
    public static ColorEnum forValue(String value) {
        return map.get(value);
    }


    @JsonView
    public String getColor() {
        return color;
    }
}
