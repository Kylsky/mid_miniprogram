package com.mid.takefresh.rest;

import com.mid.api.common.CommonResult;
import com.mid.api.takefresh.entity.TakeFreshCommit;
import com.mid.takefresh.service.ITakeFreshCommitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/takefresh")
@Api(value = "Take Fresh控制器")
public class TakeFreshController {

    @Resource
    ITakeFreshCommitService iTakeFreshCommitService;

    @PostMapping("/infocommit")
    @ApiOperation(value = "信息提交")
    public CommonResult commitMsg(
            @ApiParam(name = "studentInfo",value = "申请用户")@RequestBody TakeFreshCommit studentInfo){

        boolean result = iTakeFreshCommitService.saveOrUpdate(studentInfo);
        if (result){
            return CommonResult.success("提交成功");
        }else {
            return CommonResult.failed("提交失败");
        }
    }
}
