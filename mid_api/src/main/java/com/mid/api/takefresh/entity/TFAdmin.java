package com.mid.api.takefresh.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;


@Data
@TableName("take-fresh_admin")
public class TFAdmin {
    @TableId(type = IdType.AUTO)
    private Long id; // 主键ID
    private String admin_id; // 负责人id
    private String admin_name; // 姓名
    private String admin_password; // 密码
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer delFlag; // 删除标志：0 未删除 1 已删除
}
