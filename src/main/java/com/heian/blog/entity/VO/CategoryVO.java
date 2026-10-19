package com.heian.blog.entity.VO;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryVO implements Serializable {

	private static final long serialVersionUID = 1L;


	private Long id;

	/** 分类名，如：前端开发 */
	private String name;

	/** URL 标识，如：frontend */
	private String slug;

	/** 分类描述 */
	private String description;

	/** 图标颜色，如：#3b82f6 */
	private String color;

	/** Element Plus 图标名，如：Monitor */
	private String icon;

	/** 排序值，越小越靠前 */
	private Integer sort;

	private Integer articleCount;

	private LocalDateTime createTime;



}