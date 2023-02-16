package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_book")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("type")
    private String type;
    @TableField("name")
    private String name;
    @TableField("description")
    private String description;
}
