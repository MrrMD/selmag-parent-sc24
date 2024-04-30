package ru.smallstash.manager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.smallstash.manager.controller.payload.UpdateProductPayload;
import ru.smallstash.manager.entity.Product;
import ru.smallstash.manager.service.ProductService;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products/{productId:\\d+}")
public class ProductController {

    private final ProductService productService;

    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId){
        return this.productService.findProduct(productId).orElseThrow();
    }

    @GetMapping
    public String getProduct(@PathVariable("productId") int productId, Model model){
        return "catalogue/products/product";
    }

    @GetMapping("edit")
    public String getProductEditPage(@PathVariable("productId") int productId, Model model){
        return "catalogue/products/edit";
    }

    @PostMapping("edit")
    public String updateProduct(@ModelAttribute("product") Product product, UpdateProductPayload payload){
        this.productService.updateProduct(product.getId(), product.getTitle(), product.getDetails());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }
}
