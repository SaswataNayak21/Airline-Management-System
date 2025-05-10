# ✈️ Airline Management System

A comprehensive desktop-based application for managing airline operations, built using **Java (Swing)** and **MySQL**.
This project on Airline Management System is the automation of registration process of
airline system. The system is able to provide much information like passenger’s details, flight
details and the booking details. The system allows us to add records when a passenger reserves a ticket. It also allows to delete and update the records based on passenger’s requirements.

---

## 🚀 Features

- Register and manage airline passengers
- View flight details
- Book and cancel flight reservations
- Store and access all information through a MySQL database backend
- Clean and responsive Java Swing GUI

---

## 🛠 Tech Stack

- **Programming Language:** Java (Core)
- **Frontend:** Java Swing
- **Backend:** MySQL
- **IDE:** NetBeans 14
- **Database Tool:** XAMPP / MySQL Server

---

## 📁 Folder Structure

```bash
.
├── airline/management/system     # Java source code
├── SQL                          # SQL table creation scripts
├── snapshots                    # App screenshots (if included)
├── README.md
└── ...
```

# 🚀 How to Run the Project (Quick Guide)
Install Required Tools:

[✓] Java JDK 8+
[✓] NetBeans 8.2
[✓] MySQL or XAMPP

Set Up the Database:

Open phpMyAdmin (http://localhost/phpmyadmin)
Create a database named airline
Run SQL queries to create tables (e.g., flight, passenger, reservation, etc.)
Configure DB Connection:

In Java code (Conn.java or similar), make sure:

Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "");

Open Project in NetBeans:
Go to File > Open Project
Select your project folder
Open and run Mainframe.java

All records should reflect in your MySQL tables.

Test App Features:
Try booking, cancellation, view flights, etc.
Check records in MySQL

---
# 📌 Requirements
Software:
- JDK 8 or above
- MySQL
- NetBeans 8.2

Hardware:
- Minimum: Core i3, 2GB RAM, 400GB HD
- Recommended: Core i5+, 4GB RAM+



