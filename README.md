# 👥 Employee Management Backend

A backend service that provides **CRUD (Create, Read, Update, Delete)** operations for managing employee data. This project exposes RESTful APIs to handle employee records efficiently and can be easily integrated with any frontend application.

---

## ✨ Features
- ➕ Add new employee records  
- 📄 Retrieve employee details (all or by ID)  
- ✏️ Update employee information  
- ❌ Delete employee records  

---

## 🚀 Tech Stack
- **Backend**: Spring Boot 
- **Database**: PostgreSQL
- **Build Tool**: Maven

---

## 📡 API Endpoints

| Method | Endpoint              | Description                |
|--------|-----------------------|----------------------------|
| POST   | `/api/employees`      | Create new employee        |
| GET    | `/api/employees`      | Get all employees          |
| GET    | `/api/employees/{id}` | Get employee by ID         |
| PUT    | `/api/employees/{id}` | Update employee by ID      |
| DELETE | `/api/employees/{id}` | Delete employee by ID      |
