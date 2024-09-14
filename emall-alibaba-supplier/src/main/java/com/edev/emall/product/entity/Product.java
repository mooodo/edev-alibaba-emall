package com.edev.emall.product.entity;

import com.edev.emall.supplier.entity.Supplier;
import com.edev.support.entity.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class Product extends Entity<Long> {
    private Long id; // 商品ID
    private String name; // 商品名称
    private String description; // 商品详细描述
    private Double price; // 商品售价
    private Long supplierId; // 所属供应商的ID
    private Long categoryId; // 商品的分类ID
    private Long brandId; // 商品的品牌ID
    private String image; // 商品的展示图片
    private String tip; // 商品的提示标签
    private String status; // 商品状态，如上架、下架、缺货等
    private Date createTime; // 创建时间
    private Date modifyTime; // 更新时间
    private Supplier supplier;
    private ProductCategory productCategory;
    private Brand brand;
}
