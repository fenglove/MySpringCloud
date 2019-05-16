package com.itcpay.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-server/products", decode404 = true)
public interface ProductClient {

    /**
     * 根据产品id查询产品信息
     */
    @GetMapping("/{product_id}")
    String selectProductById(@PathVariable("product_id") Long productId);

}
