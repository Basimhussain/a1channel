package com.a1channel.restapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration properties for the API
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "api")
public class ApiProperties {
    
    /**
     * API version
     */
    private String version = "1.0.0";
    
    /**
     * Enable/disable API documentation
     */
    private boolean docsEnabled = true;
    
    /**
     * Default page size for pagination
     */
    private int defaultPageSize = 10;
    
    /**
     * Maximum page size for pagination
     */
    private int maxPageSize = 100;
    
    /**
     * Enable/disable API rate limiting
     */
    private boolean rateLimitingEnabled = false;
    
    /**
     * Maximum requests per minute for rate limiting
     */
    private int maxRequestsPerMinute = 60;
} 