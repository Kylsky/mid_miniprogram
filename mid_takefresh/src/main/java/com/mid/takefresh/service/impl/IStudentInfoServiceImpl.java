package com.mid.takefresh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mid.api.takefresh.entity.StudentInfo;
import com.mid.takefresh.mapper.StudentInfoMapper;
import com.mid.takefresh.service.IStudentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IStudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo>
        implements IStudentInfoService {
    @Resource
    StudentInfoMapper studentInfoMapper;

    /**
     * @Description: 用户提交申请表
     * @Author: kongyilei
     * @Date: 2019/10/8
    */
    int insertCommit(StudentInfo studentInfo){
        return studentInfoMapper.insert(studentInfo);
    }


    @Override
    public boolean save(StudentInfo entity) {
        return super.save(entity);
    }
}
