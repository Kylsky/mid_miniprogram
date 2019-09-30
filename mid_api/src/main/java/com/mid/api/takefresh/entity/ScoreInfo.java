package com.mid.api.takefresh.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("take_fresh_evaluate")
public class ScoreInfo {
    @TableId(type = IdType.AUTO)
    private Long id; // 主键ID
    private String stu_id; // 学号
    private String stu_name; // 姓名
    private String direction; // 学习方向
    private double skill; // 技术能力
    private double expression; // 表达能力
    private double other; //其他
    private double sum;//总分
    private String comment;//评价
    private String auditor;//评价人
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date evaluateTime; // 创建时间
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag; // 删除标志：0 未删除 1 已删除
}
