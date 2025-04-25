# A1Channel Product Management System

A full-stack product management application with a RESTful API built using Spring Boot and a premium responsive UI.

## Project Overview

This project is a comprehensive product management system that allows for storing, retrieving, updating, and deleting products. It features both a sleek, modern web interface using Thymeleaf templates and a RESTful API for programmatic access.

## Technologies Used

### Backend

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring Data JPA** - For database operations
- **Spring MVC** - For web and REST controllers
- **Hibernate** - ORM for database mapping
- **H2 Database** - In-memory database for development
- **Jakarta Bean Validation** - For input validation

### Frontend

- **Thymeleaf** - Server-side Java template engine
- **HTML/CSS/JavaScript** - For the web interface
- **Custom Responsive CSS** - Premium design system
- **Google Fonts (Inter)** - Typography
- **Unsplash Images** - High-quality product images

### API Documentation

- **SpringDoc OpenAPI** - For API documentation
- **Swagger UI** - For interactive API testing

### Development Tools

- **Maven** - For dependency management and build automation
- **Lombok** - For reducing boilerplate code

## Project Structure

```
src/main/java/com/a1channel/restapi/
├── config/                  # Configuration classes
│   ├── ApiProperties.java   # API configuration properties
│   ├── DataLoader.java      # Initial data loading
│   ├── OpenApiConfig.java   # Swagger/OpenAPI configuration
│   └── WebConfig.java       # WebMvcConfigurer for static resources
├── controller/              # Controllers
│   ├── ProductController.java   # REST API controller
│   └── WebController.java       # Web MVC controller
├── dto/                     # Data Transfer Objects
│   ├── ApiResponse.java     # Generic API response wrapper
│   └── ProductDTO.java      # Product DTO
├── exception/               # Exception handling
│   ├── GlobalExceptionHandler.java  # Centralized exception handler
│   └── ResourceNotFoundException.java  # Custom exception
├── model/                   # Entity models
│   └── Product.java         # Product entity
├── repository/              # Data repositories
│   └── ProductRepository.java  # JPA repository for products
├── service/                 # Business logic
│   ├── ProductService.java      # Service interface
│   └── ProductServiceImpl.java  # Service implementation
├── util/                    # Utilities
│   └── ProductMapper.java   # Entity-DTO mapper
└── RestapiApplication.java  # Main application class

src/main/resources/
├── static/                  # Static resources
│   ├── css/                 # CSS files
│   │   └── styles.css       # Premium UI styles
│   └── js/                  # JavaScript files
│       └── scripts.js       # Enhanced UI interactions
├── templates/               # Thymeleaf templates
│   ├── dashboard.html       # Product dashboard
│   ├── product-details.html # Product details view
│   ├── product-edit.html    # Product edit form
│   ├── search-results.html  # Search results
│   └── category.html        # Category view
└── application.properties   # Application configuration
```

## Key Features

### Premium Web Interface

- Modern, minimalist design with premium styling
- Featured product showcase with enhanced visuals
- Product cards with hover effects and smooth animations
- Category filtering with visual emphasis
- Responsive design that works on all device sizes
- Context-aware product imagery based on product categories
- Interactive form elements with validation feedback

### Web Interface Features

- Product listing with filters by category
- Product search functionality
- Form for creating and editing products
- "New" badges for highlighting recent products
- High-quality product imagery from Unsplash
- Smooth scroll and animation effects

### RESTful API

- Complete CRUD operations for products
- Filtering by category, price, and name
- Standardized response format
- Proper validation and error handling
- Comprehensive API documentation

## UI Design System

The application features a premium design system with:

- Consistent color palette with primary and secondary colors
- Rounded components with elegant shadows
- Clean typography using Inter font family
- Smooth transitions and hover effects
- Proper visual hierarchy and spacing
- Responsive design that adapts to different screen sizes
- Category filters with interactive feedback

## API Endpoints

| Method | Endpoint                           | Description                             |
| ------ | ---------------------------------- | --------------------------------------- |
| GET    | /api/products                      | Get all products                        |
| GET    | /api/products/{id}                 | Get product by ID                       |
| POST   | /api/products                      | Create a new product                    |
| PUT    | /api/products/{id}                 | Update a product                        |
| DELETE | /api/products/{id}                 | Delete a product                        |
| GET    | /api/products/category/{category}  | Get products by category                |
| GET    | /api/products/search?name=query    | Search products by name                 |
| GET    | /api/products/price?maxPrice=value | Get products with price less than value |

## Running the Application

### Prerequisites

- Java 17 or higher
- Maven

### Steps to Run

1. Clone the repository

   ```bash
   git clone https://github.com/yourusername/a1channel.git
   cd a1channel
   ```

2. Build the project

   ```bash
   mvn clean install
   ```

3. Run the application

   ```bash
   mvn spring-boot:run
   ```

4. Access the application
   - Web interface: http://localhost:8080/dashboard
   - API Documentation: http://localhost:8080/swagger-ui
   - H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:restapidb, Username: sa, Password: password)

## UI Components

### Hero Section

A clean, prominent hero section with a subtle background and clear call-to-action text that sets the tone for the application.

### Featured Product

The top product is showcased in a premium featured section with larger imagery and prominent details.

### Product Cards

Clean, elevated product cards with:

- High-quality contextual product images
- Smooth hover animations
- "New" badges for recent products
- Clear price and category information
- Action buttons for view, edit, and delete operations

### Category Filter

Interactive category filter with visual feedback for the active category and hover effects.

### Form Elements

Enhanced form elements with:

- Clear labels
- Proper spacing
- Interactive focus states
- Validation feedback
- Image preview for product images

## Project Architecture

### Layered Architecture

This project follows a standard layered architecture:

1. **Presentation Layer** - Controllers handle HTTP requests and responses
2. **Service Layer** - Business logic implementation
3. **Repository Layer** - Data access and persistence
4. **Model Layer** - Entity and DTO classes

### Design Patterns Used

- **DTO Pattern** - For separating API contracts from internal data models
- **Repository Pattern** - For data access abstraction
- **Dependency Injection** - For loose coupling between components
- **Builder Pattern** - For creating complex objects (via Lombok)
- **Factory Method Pattern** - In API response creation

## Recent Updates

- **Premium UI Redesign** - Complete overhaul of the user interface with modern, minimalist design
- **Smart Image Selection** - Context-aware product imagery based on product categories and names
- **Enhanced Animations** - Smooth transitions and hover effects throughout the interface
- **Improved Typography** - Using Inter font family for better readability
- **Responsive Layout** - Better adaptation to all device sizes
- **Featured Product Section** - New prominent showcase for featured products

## Future Enhancements

- User authentication and authorization
- Role-based access control
- Image upload functionality
- Integration with external payment systems
- Product inventory management
- Order management system
- API rate limiting implementation
- Support for multiple languages
- Advanced search with facets
- Dark mode toggle
- Custom theme options

## License

This project is licensed under the MIT License - see the LICENSE file for details.
