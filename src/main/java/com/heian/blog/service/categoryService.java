package com.heian.blog.service;

import com.heian.blog.entity.Category;
import com.heian.blog.entity.VO.CategoryVO;

import java.util.List;

public interface categoryService {
	List<CategoryVO> getCategory();

}
