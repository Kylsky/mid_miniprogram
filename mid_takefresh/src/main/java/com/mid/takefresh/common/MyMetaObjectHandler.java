package com.mid.takefresh.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自定义填充处理器
 */
@Component
public class MyMetaObjectHandler implements  MetaObjectHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void insertFill(MetaObject metaObject) {
        //logger.info("start insert fill ....");
        this.setFieldValByName("delFlag", 0, metaObject);//版本号3.0.6以及之前的版本
        this.setFieldValByName("commitTime", new Date(), metaObject);
        //this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);//版本号3.0.6以及之前的版本
        //this.setInsertFieldValByName("operator", "Jerry", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //logger.info("start update fill ....");
        this.setFieldValByName("updateTime", new Date(), metaObject);
        //this.setUpdateFieldValByName("operator", "Tom", metaObject);//@since 快照：3.0.7.2-SNAPSHOT， @since 正式版暂未发布3.0.7
    }
}
