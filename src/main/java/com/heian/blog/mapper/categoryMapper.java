package com.heian.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heian.blog.entity.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface categoryMapper extends BaseMapper<Category> {
}
