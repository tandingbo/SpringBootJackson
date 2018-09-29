package cn.hy.springbootjackson.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.sun.tools.javac.util.StringUtils;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 创建时间为 下午7:26-2018/9/28
 * 项目名称 SpringBootJackson
 * </p>
 *
 * @author shao
 * @version 0.0.1
 * @since 0.0.1
 */


@SuppressWarnings("unused")
public enum TimeUnitEnum {

    MILLISECONDS("MILLISECONDS", TimeUnit.MILLISECONDS),
    milliseconds("milliseconds", TimeUnit.MILLISECONDS),
    SECOND("SECOND", TimeUnit.SECONDS),
    second("second", TimeUnit.SECONDS),
    MINUTES("MINUTES", TimeUnit.MINUTES),
    minutes("minutes", TimeUnit.MINUTES),
    HOURS("HOURS", TimeUnit.HOURS),
    hours("hours", TimeUnit.HOURS),
    DAYS("DAYS", TimeUnit.DAYS),
    days("days", TimeUnit.DAYS);

    private static Map<String, TimeUnit> timeUnitMap = Stream.of(TimeUnitEnum.values()).collect(Collectors.toMap(one -> one.unit, TimeUnitEnum::getTimeUnit));

    @Getter
    @JsonValue
    private String unit;

    @Getter
    private TimeUnit timeUnit;

    TimeUnitEnum(String unit, TimeUnit timeUnit) {
        this.unit = unit;
        this.timeUnit = timeUnit;
    }

    /**
     * @param value
     * @return
     */
    @JsonCreator
    public static TimeUnit forValue(String value) {
        return Optional.ofNullable(timeUnitMap.get(StringUtils.toUpperCase(value))).orElseThrow(() -> new IllegalArgumentException(value));
    }

}
