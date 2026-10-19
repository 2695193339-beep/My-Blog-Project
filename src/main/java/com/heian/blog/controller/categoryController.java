package com.heian.blog.controller;


import com.heian.blog.entity.Category;
import com.heian.blog.entity.VO.CategoryVO;
import com.heian.blog.result.Result;
import com.heian.blog.service.categoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Slf4j

public class categoryController {

	@Autowired
	private categoryService categoryService;

	@GetMapping
	public Result getCategory() {
		log.info("正在进行查询回显分类......");
		List<CategoryVO> list = categoryService.getCategory();
		return Result.success(list);
	}


}
