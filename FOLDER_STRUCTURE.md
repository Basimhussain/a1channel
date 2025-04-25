# A1Channel Project - Folder Structure Map

## Main Project Structure

```
/Users/basimhussain/a1channel/               # MAIN PROJECT ROOT
├── src/                                      # Source files
│   └── main/
│       ├── java/com/a1channel/restapi/       # Java backend code
│       │   ├── config/                       # Configuration files
│       │   │   ├── ApiProperties.java
│       │   │   ├── DataLoader.java
│       │   │   ├── OpenApiConfig.java
│       │   │   └── WebConfig.java
│       │   ├── controller/                   # Controllers
│       │   │   ├── ProductController.java    # REST API
│       │   │   └── WebController.java        # Web UI
│       │   ├── model/                        # Data models
│       │   │   └── Product.java
│       │   ├── service/                      # Business logic
│       │   │   ├── ProductService.java
│       │   │   └── ProductServiceImpl.java
│       │   └── RestapiApplication.java       # Main application
│       └── resources/                        # Frontend resources
│           ├── static/                       # Static assets
│           │   ├── css/styles.css            # MAIN CSS FILE
│           │   └── js/scripts.js             # MAIN JS FILE
│           ├── templates/                    # HTML templates
│           │   ├── dashboard.html            # MAIN DASHBOARD
│           │   ├── product-details.html
│           │   ├── product-edit.html
│           │   ├── search-results.html
│           │   └── category.html
│           └── application.properties        # Application settings
├── target/                                   # Compiled files
├── pom.xml                                   # Maven configuration
├── README.md                                 # Project documentation
└── FOLDER_STRUCTURE.md                       # This file
```

## Key Files for UI Editing

If you want to modify the UI, these are the main files to edit:

- **CSS Styling**: `/src/main/resources/static/css/styles.css`
- **JavaScript**: `/src/main/resources/static/js/scripts.js`
- **Main Dashboard**: `/src/main/resources/templates/dashboard.html`

## Key Backend Files

- **Main Application**: `/src/main/java/com/a1channel/restapi/RestapiApplication.java`
- **Web Controller**: `/src/main/java/com/a1channel/restapi/controller/WebController.java`
- **Product Model**: `/src/main/java/com/a1channel/restapi/model/Product.java`

## How to Run the Project

From the main directory, run:

```
mvn spring-boot:run
```
