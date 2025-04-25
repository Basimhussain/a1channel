package com.a1channel.restapi.controller;

import com.a1channel.restapi.model.Product;
import com.a1channel.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    private final ProductService productService;

    @Autowired
    public WebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"/", "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("newProduct", new Product());
        return "dashboard";
    }

    @GetMapping("/products/view/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> model.addAttribute("product", product));
        return "product-details";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        productService.getProductById(id).ifPresent(product -> model.addAttribute("product", product));
        return "product-edit";
    }

    @PostMapping("/products/save")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/dashboard";
    }

    @PostMapping("/products/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        productService.updateProduct(id, product);
        return "redirect:/dashboard";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/dashboard";
    }

    @GetMapping("/products/by-category")
    public String getProductsByCategory(@RequestParam String category, Model model) {
        model.addAttribute("products", productService.getProductsByCategory(category));
        model.addAttribute("categoryName", category);
        model.addAttribute("newProduct", new Product());
        return "category";
    }

    @GetMapping("/products/find")
    public String searchProducts(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.searchProductsByName(name));
        model.addAttribute("searchTerm", name);
        model.addAttribute("newProduct", new Product());
        return "search-results";
    }
} 