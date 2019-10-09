package com.mid.takefresh.rest;

import com.mid.api.common.CommonResult;
import com.mid.api.takefresh.entity.StudentInfo;
import com.mid.takefresh.service.IStudentInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping("/takefresh")
@Api(value = "Take Fresh控制器")
public class TakeFreshController {

    @Resource
    IStudentInfoService iStudentInfoService;

    @PostMapping("/infocommit")
    @ApiOperation(value = "信息提交")
    public CommonResult commitMsg(
            @ApiParam(name = "studentInfo",value = "申请用户")@RequestParam StudentInfo studentInfo){

        boolean result = iStudentInfoService.save(studentInfo);
        if (result){
            return CommonResult.success("提交成功");
        }else {
            return CommonResult.failed("提交失败");
        }
    }
}
