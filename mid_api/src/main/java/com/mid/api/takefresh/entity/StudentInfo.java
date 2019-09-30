package com.mid.api.takefresh.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("take_fresh_commit")
public class StudentInfo {
    @TableId(type = IdType.AUTO)
    private Long id; // 主键ID
    private String stu_id; // 学号
    private String stu_name; // 姓名
    private String prof;//专业
    private String direction; // 学习方向
    private String hobby; // 爱好或特长
    private String desc; // 自我介绍
    private String referrer; //推荐人
    @TableField(fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commitTime; // 创建时间
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag; // 删除标志：0 未删除 1 已删除
}
