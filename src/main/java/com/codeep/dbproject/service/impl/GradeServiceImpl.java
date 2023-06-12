package com.codeep.dbproject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codeep.dbproject.mapper.GradeMapper;
import com.codeep.dbproject.model.domain.Grade;
import com.codeep.dbproject.service.GradeService;
import org.springframework.stereotype.Service;

/**
* @author 24796
* @description 针对表【grade(成绩表)】的数据库操作Service实现
* @createDate 2023-06-12 17:42:37
*/
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
    implements GradeService {

}




