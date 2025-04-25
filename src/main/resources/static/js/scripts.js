document.addEventListener("DOMContentLoaded", function () {
  // Initialize relevant images for products based on category
  document.querySelectorAll(".product-image img").forEach((img) => {
    const productCard = img.closest(".product-card");
    let category = "product";

    if (productCard) {
      const categoryText = productCard.querySelector(".product-category span");
      const productName = productCard
        .querySelector("h3")
        .textContent.toLowerCase();

      if (categoryText) {
        category = categoryText.textContent.toLowerCase();
      }

      // Set appropriate fallback images based on product category or name
      img.addEventListener("error", function () {
        // Default category images
        const categoryImages = {
          electronics: [
            "https://images.unsplash.com/photo-1525547719571-a2d4ac8945e2?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Laptop
            "https://images.unsplash.com/photo-1546868871-7041f2a55e12?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Tech
            "https://images.unsplash.com/photo-1588872657578-7efd1f1555ed?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Computer
          ],
          "kitchen appliances": [
            "https://images.unsplash.com/photo-1556911220-e15b29be8c8f?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Kitchen appliance
            "https://images.unsplash.com/photo-1574269906084-67810eb7ffb6?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Mixer
            "https://images.unsplash.com/photo-1522338140262-f46f5913618a?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Kitchen items
          ],
          sports: [
            "https://images.unsplash.com/photo-1552674605-db6ffd4facb5?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Sports shoes
            "https://images.unsplash.com/photo-1517963879433-6ad2b056d712?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Gym
            "https://images.unsplash.com/photo-1535131749006-b7f58c99034b?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80", // Sport balls
          ],
        };

        // Specific product name based images
        if (
          productName.includes("laptop") ||
          productName.includes("computer")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (
          productName.includes("phone") ||
          productName.includes("smartphone")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (
          productName.includes("watch") ||
          productName.includes("wearable")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1546868871-7041f2a55e12?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (productName.includes("camera")) {
          this.src =
            "https://images.unsplash.com/photo-1516724562728-afc824a36e84?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (
          productName.includes("headphone") ||
          productName.includes("earphone")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (
          productName.includes("mixer") ||
          productName.includes("blender")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1574269906084-67810eb7ffb6?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (
          productName.includes("coffee") ||
          productName.includes("maker")
        ) {
          this.src =
            "https://images.unsplash.com/photo-1517701604599-bb29b565090c?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (categoryImages[category]) {
          // Use category-based images if available
          const index = Math.floor(
            Math.random() * categoryImages[category].length
          );
          this.src = categoryImages[category][index];
        } else {
          // Fallback for unknown categories
          this.src =
            "https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        }
      });
    }
  });

  // Update the featured product image if it's present
  const featuredImage = document.querySelector(".featured-product-image img");
  if (featuredImage) {
    featuredImage.addEventListener("error", function () {
      const featuredTitle = document.querySelector(".featured-product-info h2");
      if (featuredTitle) {
        const title = featuredTitle.textContent.toLowerCase();

        if (title.includes("laptop") || title.includes("computer")) {
          this.src =
            "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (title.includes("phone") || title.includes("smartphone")) {
          this.src =
            "https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else if (title.includes("watch")) {
          this.src =
            "https://images.unsplash.com/photo-1546868871-7041f2a55e12?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        } else {
          this.src =
            "https://images.unsplash.com/photo-1523275335684-37898b6baf30?ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80";
        }
      }
    });
  }

  // Update hero image to be relevant to the page
  const heroSection = document.querySelector(".hero");
  if (heroSection) {
    heroSection.style.backgroundImage =
      "url('https://images.unsplash.com/photo-1441986300917-64674bd600d8?ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80')";
  }

  // Smooth scrolling for anchor links
  document.querySelectorAll('a[href^="#"]').forEach((anchor) => {
    anchor.addEventListener("click", function (e) {
      if (this.getAttribute("href") !== "#") {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute("href"));
        if (target) {
          window.scrollTo({
            top: target.offsetTop - 100,
            behavior: "smooth",
          });
        }
      }
    });
  });

  // Add product form toggle with smooth animation
  const addProductNav = document.getElementById("add-product-nav");
  const addProductForm = document.getElementById("add-product-form");
  const cancelAddBtn = document.getElementById("cancel-add");

  if (addProductNav && addProductForm) {
    addProductNav.addEventListener("click", function (e) {
      e.preventDefault();
      addProductForm.classList.remove("hidden");
      addProductForm.style.opacity = "0";
      setTimeout(() => {
        addProductForm.style.opacity = "1";
        addProductForm.scrollIntoView({ behavior: "smooth" });
      }, 10);
    });
  }

  if (cancelAddBtn && addProductForm) {
    cancelAddBtn.addEventListener("click", function () {
      addProductForm.style.opacity = "0";
      setTimeout(() => {
        addProductForm.classList.add("hidden");
      }, 300);
    });
  }

  // Form validation with improved UX
  const productForm = document.getElementById("product-form");
  if (productForm) {
    const formInputs = productForm.querySelectorAll("input, textarea, select");

    // Add focus effects to form fields
    formInputs.forEach((input) => {
      input.addEventListener("focus", function () {
        this.parentElement.classList.add("focused");
      });

      input.addEventListener("blur", function () {
        this.parentElement.classList.remove("focused");

        // Validate on blur
        if (this.required && !this.value.trim()) {
          markInvalid(
            this,
            `${this.previousElementSibling.textContent.trim()} is required`
          );
        } else {
          markValid(this);
        }
      });
    });

    productForm.addEventListener("submit", function (event) {
      const nameInput = document.getElementById("name");
      const priceInput = document.getElementById("price");
      const stockInput = document.getElementById("stockQuantity");

      let valid = true;

      if (!nameInput.value.trim()) {
        markInvalid(nameInput, "Name is required");
        valid = false;
      } else {
        markValid(nameInput);
      }

      if (!priceInput.value || parseFloat(priceInput.value) <= 0) {
        markInvalid(priceInput, "Price must be a positive number");
        valid = false;
      } else {
        markValid(priceInput);
      }

      if (!stockInput.value || parseInt(stockInput.value) < 0) {
        markInvalid(stockInput, "Stock quantity must be a non-negative number");
        valid = false;
      } else {
        markValid(stockInput);
      }

      if (!valid) {
        event.preventDefault();

        // Smooth scroll to first error
        const firstError = document.querySelector(".is-invalid");
        if (firstError) {
          firstError.focus();
        }
      }
    });
  }

  // Product card hover effects
  const productCards = document.querySelectorAll(".product-card");
  productCards.forEach((card) => {
    card.addEventListener("mouseenter", function () {
      this.style.transform = "translateY(-10px)";
      this.style.boxShadow = "0 15px 35px rgba(0, 0, 0, 0.1)";
    });

    card.addEventListener("mouseleave", function () {
      this.style.transform = "translateY(0)";
      this.style.boxShadow = "var(--box-shadow)";
    });
  });

  // Delete confirmation with better UX
  const deleteButtons = document.querySelectorAll(".delete-btn");
  deleteButtons.forEach((button) => {
    button.addEventListener("click", function (event) {
      event.preventDefault();
      const productName =
        this.closest(".product-card").querySelector("h3").textContent;

      if (confirm(`Are you sure you want to delete "${productName}"?`)) {
        window.location.href = this.getAttribute("href");
      }
    });
  });

  // Image preview for product form with fade-in effect
  const imageUrlInput = document.getElementById("imageUrl");
  const imagePreviewContainer = document.getElementById("image-preview");

  if (imageUrlInput && imagePreviewContainer) {
    let previewDebounce;

    imageUrlInput.addEventListener("input", function () {
      clearTimeout(previewDebounce);

      previewDebounce = setTimeout(() => {
        const url = this.value.trim();
        if (url) {
          const img = new Image();
          img.onload = function () {
            imagePreviewContainer.innerHTML = "";
            img.style.opacity = "0";
            imagePreviewContainer.appendChild(img);
            imagePreviewContainer.style.display = "block";

            setTimeout(() => {
              img.style.opacity = "1";
            }, 50);
          };

          img.onerror = function () {
            imagePreviewContainer.innerHTML =
              '<div class="preview-error">Invalid image URL</div>';
            imagePreviewContainer.style.display = "block";
          };

          img.src = url;
          img.alt = "Preview";
          img.style.transition = "opacity 0.3s ease";
          img.style.maxWidth = "100%";
          img.style.borderRadius = "8px";
        } else {
          imagePreviewContainer.innerHTML = "";
          imagePreviewContainer.style.display = "none";
        }
      }, 300);
    });

    // Trigger on load for edit forms
    if (imageUrlInput.value) {
      const img = new Image();
      img.onload = function () {
        imagePreviewContainer.innerHTML = "";
        imagePreviewContainer.appendChild(img);
        imagePreviewContainer.style.display = "block";
      };
      img.src = imageUrlInput.value;
      img.alt = "Preview";
      img.style.maxWidth = "100%";
      img.style.borderRadius = "8px";
    }
  }

  // Add animation to page load
  document.body.classList.add("loaded");
});

function markInvalid(input, message) {
  input.classList.add("is-invalid");

  let errorDiv = input.nextElementSibling;
  if (!errorDiv || !errorDiv.classList.contains("error-message")) {
    errorDiv = document.createElement("div");
    errorDiv.classList.add("error-message");
    errorDiv.style.color = "var(--danger-color)";
    errorDiv.style.fontSize = "0.8rem";
    errorDiv.style.marginTop = "0.3rem";
    errorDiv.style.transition = "opacity 0.3s ease";
    errorDiv.style.opacity = "0";
    input.parentNode.insertBefore(errorDiv, input.nextSibling);

    // Trigger reflow
    errorDiv.offsetHeight;
    errorDiv.style.opacity = "1";
  }

  errorDiv.textContent = message;
}

function markValid(input) {
  input.classList.remove("is-invalid");

  const errorDiv = input.nextElementSibling;
  if (errorDiv && errorDiv.classList.contains("error-message")) {
    errorDiv.style.opacity = "0";
    setTimeout(() => {
      errorDiv.remove();
    }, 300);
  }
}
