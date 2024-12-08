# PaymentService - Payment Gateway Integration

This repository contains the **PaymentService** module for handling payment processing in an e-commerce platform, developed using **Java Spring Boot**. The service integrates with **Razorpay** as the third-party payment gateway to handle payment operations.

## Key Features

- **Payment Gateway Integration:** Integrated **Razorpay** for processing payments securely.
- **Method for Payment Link:** Exposed an API to generate a payment link using the Razorpay API.
- **Scalability:** Designed with scalability in mind, with the option to add more payment methods in the future.
- **Security:** Ensured secure communication with Razorpay through API keys and token-based authentication.

## Core Functionality

The service currently includes the following method:

1. **Generate Payment Link:**
   - Creates a payment link for initiating a payment process.
   - Exposed as a POST API: `/generatePaymentLink`
   - This method integrates with **Razorpay's API** to create a payment link that can be used for customer payments.

### Planned Features (Future Updates)
- **Support for Multiple Payment Methods:** Additional methods to handle different payment operations like refunds, payment capture, etc.
- **Invoice Generation:** Capability to generate invoices after successful payments.

## Tech Stack

- **Java Spring Boot**: Main framework for developing the backend service.
- **Razorpay API**: Third-party payment gateway for securely processing payments.
- **RESTful API**: For communication between microservices and client applications.
- **Security**: Secure API integration using Razorpay's authentication methods.

## Installation and Setup

### 1. Set Up Razorpay API Credentials

1. **Razorpay API:**
   - You need a **Razorpay account** to get the **API Key** and **Secret Key**.
     - Sign up and log in at [Razorpay](https://razorpay.com/).
     - After logging in, get your **API Key** and **Secret Key** from the Razorpay dashboard.

### 2. Configure the `application.properties` File

Update the `application.properties` file with the following configuration for Razorpay:

- **Razorpay:**
   ```properties
   razorpay.key_id=your_razorpay_key_id
   razorpay.key_secret=your_razorpay_key_secret

### 3. Run the Application

- **Using Maven:** You can run the application with the following command:

   ```bash
  mvn spring-boot:run

- **Using IDE:**
Alternatively, you can run the application directly from your IDE (such as IntelliJ IDEA or Eclipse).

