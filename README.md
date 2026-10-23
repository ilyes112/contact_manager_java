# Contact Manager

A clean and efficient Java application designed to manage contacts using **PostgreSQL** as the database and the **DAO (Data Access Object)** design pattern for clean separation of concerns.

## Features
* **Full CRUD Operations:** Seamlessly add, view, update, and manage contacts[cite: 2].
* **PostgreSQL Integration:** Connects securely using JDBC and `PreparedStatement` to prevent SQL injection.
* **Timestamp Tracking:** Automatically records creation (`created_at`) and modification (`updated_at`) timestamps[cite: 2].
* **Robust Entity Modeling:** Comprehensive contact records storing names, phone numbers, emails, and custom descriptions[cite: 2].

## Tech Stack
* **Language:** Java
* **Database:** PostgreSQL[cite: 2]
* **Build Tool:** Maven
* **Database Connectivity:** JDBC

## Database Schema
The application relies on a `contact` table with the following structure[cite: 2]:

| Column | Type | Constraints |
| :--- | :--- | :--- |
| `id` | INTEGER | Primary Key (PK)[cite: 2] |
| `first_name` | VARCHAR(100) | Not Null[cite: 2] |
| `last_name` | VARCHAR(100) | Not Null[cite: 2] |
| `phone_number` | VARCHAR(20) | Not Null[cite: 2] |
| `email` | VARCHAR(255) | -[cite: 2] |
| `description` | TEXT | -[cite: 2] |
| `created_at` | TIMESTAMP | Default current time[cite: 2] |
| `updated_at` | TIMESTAMP | Default current time[cite: 2] |

## Getting Started
1. Clone the repository:
   ```bash
   git clone git@github.com:ilyes112/contact_manager_java.git
