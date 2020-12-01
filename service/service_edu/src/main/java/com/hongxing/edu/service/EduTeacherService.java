package com.hongxing.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hongxing.edu.entity.EduTeacher;
import com.hongxing.edu.entity.vo.TeacherQuery;
import org.springframework.data.domain.Page;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author sijia
 * @since 2020-11-25
 */
public interface EduTeacherService extends IService<EduTeacher> {
    void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery);
}
