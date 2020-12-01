package com.hongxing.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hongxing.edu.entity.EduTeacher;
import com.hongxing.edu.entity.vo.TeacherQuery;
import com.hongxing.edu.mapper.EduTeacherMapper;
import com.hongxing.edu.service.EduTeacherService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author sijia
 * @since 2020-11-25
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> pageParam, TeacherQuery teacherQuery) {

    }
}
