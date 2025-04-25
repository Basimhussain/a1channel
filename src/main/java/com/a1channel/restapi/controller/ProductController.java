package com.a1channel.restapi.controller;

import com.a1channel.restapi.dto.ApiResponse;
import com.a1channel.restapi.dto.ProductDTO;
import com.a1channel.restapi.exception.ResourceNotFoundException;
import com.a1channel.restapi.model.Product;
import com.a1channel.restapi.service.ProductService;
import com.a1channel.restapi.util.ProductMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "Operations for managing products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Operation(summary = "Get all products", description = "Returns a list of all products")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved products", 
                    content = @Content(mediaType = "application/json", 
                    schema = @Schema(implementation = ApiResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDTO> productDTOs = productMapper.toDTOList(products);
        return ResponseEntity.ok(ApiResponse.success(productDTOs));
    }

    @Operation(summary = "Get product by ID", description = "Returns a product by its ID")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved product"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductDTO>> getProductById(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> {
                    ProductDTO dto = productMapper.toDTO(product);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Operation(summary = "Create a new product", description = "Creates a new product with the provided details")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Product successfully created"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductDTO>> createProduct(
            @Parameter(description = "Product to create", required = true) @Valid @RequestBody ProductDTO productDTO) {
        
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productService.saveProduct(product);
        ProductDTO savedDTO = productMapper.toDTO(savedProduct);
        
        return new ResponseEntity<>(
                ApiResponse.success("Product created successfully", savedDTO), 
                HttpStatus.CREATED);
    }

    @Operation(summary = "Update a product", description = "Updates an existing product with the provided details")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Product successfully updated"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Invalid input data"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<ProductDTO>> updateProduct(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id,
            @Parameter(description = "Updated product details", required = true) @Valid @RequestBody ProductDTO productDTO) {
        
        Product product = productMapper.toEntity(productDTO);
        Product updatedProduct = productService.updateProduct(id, product);
        ProductDTO updatedDTO = productMapper.toDTO(updatedProduct);
        
        return ResponseEntity.ok(ApiResponse.success("Product updated successfully", updatedDTO));
    }

    @Operation(summary = "Delete a product", description = "Deletes a product by its ID")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Product successfully deleted"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Product not found")
    })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<Void>> deleteProduct(
            @Parameter(description = "Product ID", required = true) @PathVariable Long id) {
        
        productService.deleteProduct(id);
        return ResponseEntity.ok(ApiResponse.success("Product deleted successfully", null));
    }

    @Operation(summary = "Get products by category", description = "Returns products filtered by category")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    @GetMapping(value = "/category/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByCategory(
            @Parameter(description = "Category name", required = true) @PathVariable String category) {
        
        List<Product> products = productService.getProductsByCategory(category);
        List<ProductDTO> productDTOs = productMapper.toDTOList(products);
        
        return ResponseEntity.ok(ApiResponse.success(productDTOs));
    }

    @Operation(summary = "Search products by name", description = "Returns products that contain the search term in their name")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<ProductDTO>>> searchProducts(
            @Parameter(description = "Search term", required = true) @RequestParam String name) {
        
        List<Product> products = productService.searchProductsByName(name);
        List<ProductDTO> productDTOs = productMapper.toDTOList(products);
        
        return ResponseEntity.ok(ApiResponse.success(productDTOs));
    }

    @Operation(summary = "Get products by maximum price", description = "Returns products with price less than or equal to the specified maximum")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Successfully retrieved products")
    })
    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse<List<ProductDTO>>> getProductsByPrice(
            @Parameter(description = "Maximum price", required = true) @RequestParam double maxPrice) {
        
        List<Product> products = productService.getProductsWithPriceLessThan(maxPrice);
        List<ProductDTO> productDTOs = productMapper.toDTOList(products);
        
        return ResponseEntity.ok(ApiResponse.success(productDTOs));
    }
} 