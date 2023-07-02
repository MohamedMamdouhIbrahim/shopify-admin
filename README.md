# shopify-admin
# E-Commerce Android App

This repository contains an Android E-Commerce application built using Java and the MVVM architectural pattern. The project utilizes Firebase for user authentication and database management. The app consists of two separate modules: one for users and another for administrators. The user app allows users to browse products, place orders, and view their checkout history. The admin app provides functionality for updating the status of orders.

## Features

### User App

- User Registration and Authentication: Users can create an account, log in, and log out of the application using Firebase Authentication.
- Product Catalog: Users can browse a wide range of products with detailed descriptions and pricing information.
- Shopping Cart: Users can add products to their cart, view the cart contents, update quantities, and remove items.
- Checkout Process: Users can enter shipping and payment details to complete their purchase.
- Order History: Users can view a list of their previous orders, including order status and delivery information.

### Admin App

- Admin Authentication: Administrators can log in to the app using their credentials via Firebase Authentication.
- Order Management: Admins can view a list of all orders and update the status of each order (e.g., pending, shipped, delivered) using Firebase Realtime Database.
- Product Management: Admins can add new products, edit existing products, and remove products from the catalog via Firebase Realtime Database.

## Technologies Used

The E-Commerce Android app is built using the following technologies and libraries:

- Java: The primary programming language for developing the Android application.
- Android SDK: Provides the necessary tools and libraries for Android app development.
- MVVM Architecture: Utilizes the Model-View-ViewModel architectural pattern for better separation of concerns and maintainability.
- Firebase Authentication: Handles user authentication and registration processes.
- Firebase Realtime Database: Stores and manages user accounts, products, and order information.
- Firebase Cloud Messaging: Enables sending push notifications to users for order updates and promotions.
- RecyclerView: A UI component for displaying lists of items efficiently.
- LiveData: Part of the Android Architecture Components, LiveData is used for data observation and synchronization between the ViewModel and UI components.
- ViewModel: Another component of the Android Architecture Components, ViewModel holds and manages the UI-related data in a lifecycle-aware manner.

## Getting Started

To run the Android E-Commerce app locally, follow these steps:

1. Clone the repository: `git clone <repository_url>`
2. Open the project in Android Studio or your preferred IDE.
3. Make sure you have the necessary Firebase configuration files (google-services.json) and dependencies set up.
4. Build the project and resolve any dependencies if prompted.
5. Connect an Android device or use an emulator to run the app.
6. Run the application, and it should launch on the device/emulator.

## Project Structure

The project follows a standard Android project structure, with separate modules for the user and admin apps. Here is a brief overview of the structure:

- `app` module: Contains the user app source code.
  - `java`: Contains Java classes and packages.
    - `com.example.ecommerce.user`: Contains the main activities, adapters, and fragments for the user app.
- `admin` module: Contains the admin app source code.
  - `java`: Contains Java classes and packages.
    - `com.example.ecommerce.admin`: Contains the main activities and fragments for the admin app.
- `res`: Contains XML layout files, strings, and other resources used in the app.
- `manifests`: Contains the AndroidManifest.xml files for both user and admin apps.

## Contributing

Contributions to the E-Commerce Android app are welcome! If you would like to contribute, please fork the repository, make your changes, and
