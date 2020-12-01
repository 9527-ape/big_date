package com.hongxing.edu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongxing.commonutils.R;
import com.hongxing.edu.entity.EduTeacher;
import com.hongxing.edu.entity.vo.TeacherQuery;
import com.hongxing.edu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author sijia
 * @since 2020-11-25
 */

@Api(description="讲师管理")
@RestController
@RequestMapping("/eduTeacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAllTeacher")
    public R findAllTeacher(){
        List<EduTeacher> list = teacherService.list(null);
       int i = 10/0;
        return R.ok().data("items",list);
    }

    @ApiOperation(value = "根据ID逻辑删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@ApiParam(name = "id" ,value = "讲师ID",required = true)
                        @PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return R.ok();
        }else {
            return R.error();
        }
    }

    @ApiOperation(value = "分页查询讲师")
    @GetMapping("pageTeacher/{page}/{limit}")
    public R pageTeacher(
            @ApiParam(name = "page" ,value = "当前页码",required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit" ,value = "每页记录数",required = true)
            @PathVariable Long limit){
         //创建Page对象
         Page<EduTeacher> pageTeacher = new Page<>(page,limit);
         //调用方法实现分页
         //实现底层封装，mybatis-plus把分页所有数据封装到pageTeacher对象中
         teacherService.page(pageTeacher, null);

        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords();//数据list集合

        return R.ok().data("total",total).data("records",records);

        //        另一种方法数据返回方式
        //        Map map = new HashMap<>();
        //        map.put("total",total);
        //        map.put("records",records);
        //        return R.ok().data(map);
    }

    @ApiOperation(value = "分页条件查询讲师")
    @PostMapping("pageTeacherCondition/{current}/{limit}")
    public R pageTeacherCondition(
            @ApiParam(name = "page" ,value = "当前页码",required = true)
            @PathVariable long current,
            @ApiParam(name = "limit" ,value = "每页记录数",required = true)
            @PathVariable long limit,
            //RequestBody使用json传递数据，把json数据封装到对象里面，提交方式需要改成Post请求
            //required = false 传递的参数值可以为空
            @RequestBody(required = false) TeacherQuery teacherQuery){
        
        //创建page对象
        Page<EduTeacher> teacherPage = new Page<>(current,limit);
        //构造条件
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        //调用方法实现条件查询
        teacherService.page(teacherPage,wrapper);
        long total = teacherPage.getTotal();//总记录数
        List<EduTeacher> records = teacherPage.getRecords();//数据list集合
        return R.error().data("total",total).data("rows",records);
    }

    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public R addTeacher(@ApiParam EduTeacher eduTeacher){
        boolean save = teacherService.save(eduTeacher);
        if(save){
            return R.ok();
        }{
            return R.error();
        }
    }

    @ApiOperation(value = "根据ID查询讲师")
    @PostMapping("getTeacher/{id}")
    public R getTeacher(@ApiParam (name="id",value = "讲师id",required = true)
                            @PathVariable String id
    ){
        EduTeacher teacher = teacherService.getById(id);

        return R.ok().data("teacher",teacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping("updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher eduTeacher
    ){
        boolean result = teacherService.updateById(eduTeacher);
        if(result){
            return R.ok();
        }else {
            return R.error();
        }
    }
}

