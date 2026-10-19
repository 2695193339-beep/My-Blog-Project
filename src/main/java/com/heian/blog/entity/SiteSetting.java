package com.heian.blog.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 站点配置（键值对形式）
 * 例如：config_key = "siteName", config_value = "云深博客"
 *
 * 用键值对的好处：加一个配置项不用改表结构
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("site_setting")
public class SiteSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /** 配置键，如 siteName / author / commentAudit */
    private String configKey;

    /** 配置值（可能是 JSON 字符串） */
    private String configValue;

    /** 备注说明 */
    private String remark;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 注意：这张表没有 deleted 字段，配置项不需要逻辑删除
}