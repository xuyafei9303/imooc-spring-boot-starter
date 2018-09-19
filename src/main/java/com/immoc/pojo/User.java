package com.immoc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
@Data
public class User {

    private String name;

    @JsonIgnore // 不希望显示在json中的字段用这个注解来隐藏
    private String password;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:MM:ss a", locale = "zh", timezone = "GMT+8") // 修改时间显示的格式，修改地点为中国，修改时区为东八区
    private Date brithday;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 在赋值的时候如果这个参数没有值，那么在json显示的时候不会显示出来，否则的话会显示null，不友好
    private String desc;
}
