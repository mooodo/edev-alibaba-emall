package com.edev.emall.product.entity;

import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductCategory extends Entity<Long> {
    private Long id;
    private String name;
    private String description;
    private Long parentId; // 上级分类ID
    private Integer layer;
}
