package com.heian.blog.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.heian.blog.entity.Category;
import com.heian.blog.entity.VO.CategoryVO;
import com.heian.blog.mapper.categoryMapper;
import com.heian.blog.service.categoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class categoryServiceImpl implements categoryService {
	@Autowired
	private categoryMapper categoryMapper;


	@Override
	public List<CategoryVO> getCategory() {

		List<Category> list = categoryMapper.selectList(
				new LambdaQueryWrapper<Category>().orderByAsc(Category::getSort)
		);
		List<CategoryVO> voList = new ArrayList<>();
		list.forEach(category -> {
			CategoryVO categoryVO = new CategoryVO();
			BeanUtils.copyProperties(category, categoryVO);
			categoryVO.setArticleCount(5);
			voList.add(categoryVO);
		});
		return voList;
	}
}
