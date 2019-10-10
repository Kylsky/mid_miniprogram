package com.mid.takefresh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mid.api.takefresh.entity.TakeFreshCommit;
import com.mid.takefresh.mapper.TakeFreshCommitMapper;
import com.mid.takefresh.service.ITakeFreshCommitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IStudentInfoServiceImpl extends ServiceImpl<TakeFreshCommitMapper, TakeFreshCommit>
        implements ITakeFreshCommitService {
    @Resource
    TakeFreshCommitMapper takeFreshCommitMapper;

    /**
     * @Description: 用户提交申请表
     * @Author: kongyilei
     * @Date: 2019/10/8
    */
    @Override
    public boolean saveOrUpdate(TakeFreshCommit entity) {
        return this.save(entity);
    }
}
