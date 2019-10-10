package com.mid.api.takefresh.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author kongyilei
 * @since 2019-10-10
 */
@Data
@TableName("take_fresh_commit")
public class TakeFreshCommit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 联系方式
     */
    @TableField("phoneNo")
    private String phoneNo;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 学习方向
     */
    private String direction;

    /**
     * 专业
     */
    private String prof;

    /**
     * 爱好或特长
     */
    private String hobby;

    /**
     * 自我介绍
     */
    private String description;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commitTime;

    /**
     * 推荐人
     */
    private String referrer;

    /**
     * 删除标志位
     */
    @TableField(fill = FieldFill.INSERT)
    @TableLogic(value = "0", delval = "1")
    private Integer delflag;

}
