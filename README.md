# 🎓 SRGI Student and Faculty Management System

A desktop-based **Student and Faculty Management System** built for **S.R. Group of Institutions (SRGI)** using **Java Swing** for the GUI and **MySQL** as the backend database. The system provides a complete solution for managing student and teacher records, leave applications, examination results, and fee details — all through an intuitive graphical interface.

---

## 📋 Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Database Setup](#database-setup)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)
- [Screenshots](#screenshots)
- [Author](#author)

---

## ✨ Features

### 👨‍🎓 Student Management
- Add new students with full details (name, roll number, DOB, address, contact, Aadhar, academic records, course)
- View all student records with search by roll number
- Update student details (address, phone, email, course)
- Print student records directly from the application

### 👨‍🏫 Faculty Management
- Add new teachers with complete profile (employee ID, department, qualification, personal details)
- View all teacher records with search by employee ID
- Update faculty details (address, phone, email, qualification, department)
- Print faculty records

### 🏖️ Leave Management
- Apply leave for students (full day / half day) with date picker
- Apply leave for teachers (full day / half day) with date picker
- View and search leave records for both students and faculty
- Print leave details

### 📝 Examination Module
- Enter semester-wise marks for up to 5 subjects per student
- View examination results by roll number
- Display subject-wise marks in a formatted result sheet

### 💰 Fee Management
- View course-wise fee structure
- Student fee form with roll number, course, and year selection
- Calculate and record fee payments

### 🔐 Authentication
- Secure login screen with username and password validation against the database
- Animated splash screen on application startup

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java (JDK 8+) |
| GUI Framework | Java Swing |
| Database | MySQL |
| JDBC Driver | MySQL Connector/J (`com.mysql.cj.jdbc.Driver`) |
| UI Components | JCalendar (`com.toedter.calendar.JDateChooser`) |
| Table Utility | rs2xml (`net.proteanit.sql.DbUtils`) |

---

## 📁 Project Structure

```
project/
│
├── Splash.java               # Animated splash screen on startup
├── Login.java                # Login authentication screen
├── Project.java              # Main dashboard with navigation menu
│
├── AddStudent.java           # Form to add new student
├── UpdateStudent.java        # Form to update student details
├── StudentDetails.java       # View/search student records
│
├── AddTeacher.java           # Form to add new teacher/faculty
├── UpdateTeacher.java        # Form to update teacher details
├── TeacherDetails.java       # View/search teacher records
│
├── StudentLeave.java         # Apply leave for a student
├── StudentLeaveDetails.java  # View student leave records
├── TeacherLeave.java         # Apply leave for a teacher
├── TeacherLeaveDetails.java  # View teacher leave records
│
├── EnterMarks.java           # Enter semester marks for a student
├── ExaminationDetails.java   # Search student for result
├── Marks.java                # Display result/marksheet
│
├── FeeStructure.java         # View fee structure table
├── StudentFeeForm.java       # Submit student fee payment
│
├── About.java                # About / developer info screen
└── Conn.java                 # MySQL database connection utility
```

---

## 🗄️ Database Setup

1. Open **MySQL** and create the database:

```sql
CREATE DATABASE srgistudentandfacultymanagementsystem;
USE srgistudentandfacultymanagementsystem;
```

2. Create the required tables:

```sql
CREATE TABLE login (
    username VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE student (
    name VARCHAR(100),
    fname VARCHAR(100),
    rollno VARCHAR(50) PRIMARY KEY,
    dob VARCHAR(50),
    address VARCHAR(200),
    phone VARCHAR(15),
    email VARCHAR(100),
    class_x VARCHAR(10),
    class_xii VARCHAR(10),
    aadhar VARCHAR(20),
    course VARCHAR(50)
);

CREATE TABLE teacher (
    name VARCHAR(100),
    fname VARCHAR(100),
    empId VARCHAR(50) PRIMARY KEY,
    dob VARCHAR(50),
    address VARCHAR(200),
    phone VARCHAR(15),
    email VARCHAR(100),
    class_x VARCHAR(10),
    class_xii VARCHAR(10),
    aadhar VARCHAR(20),
    education VARCHAR(50),
    department VARCHAR(100)
);

CREATE TABLE studentleave (
    rollno VARCHAR(50),
    date VARCHAR(50),
    duration VARCHAR(20)
);

CREATE TABLE teacherleave (
    empId VARCHAR(50),
    date VARCHAR(50),
    duration VARCHAR(20)
);

CREATE TABLE subject (
    rollno VARCHAR(50),
    semester VARCHAR(50),
    subject1 VARCHAR(100),
    subject2 VARCHAR(100),
    subject3 VARCHAR(100),
    subject4 VARCHAR(100),
    subject5 VARCHAR(100)
);

CREATE TABLE marks (
    rollno VARCHAR(50),
    semester VARCHAR(50),
    marks1 VARCHAR(10),
    marks2 VARCHAR(10),
    marks3 VARCHAR(10),
    marks4 VARCHAR(10),
    marks5 VARCHAR(10)
);

CREATE TABLE fee (
    course VARCHAR(50),
    year1 VARCHAR(20),
    year2 VARCHAR(20),
    year3 VARCHAR(20),
    year4 VARCHAR(20)
);

CREATE TABLE collegefee (
    rollno VARCHAR(50),
    course VARCHAR(50),
    year VARCHAR(20),
    total VARCHAR(20)
);

-- Insert a default login
INSERT INTO login VALUES ('admin', 'admin123');
```

3. Update the database credentials in `Conn.java` if needed:

```java
c = DriverManager.getConnection(
    "jdbc:mysql:///srgistudentandfacultymanagementsystem",
    "root",        // your MySQL username
    "your_password" // your MySQL password
);
```

---

## ✅ Prerequisites

- Java JDK 8 or higher
- MySQL Server 5.7+
- The following `.jar` libraries added to your project build path:
  - `mysql-connector-java` (JDBC driver)
  - `jcalendar` (for date picker — `JDateChooser`)
  - `rs2xml` (for loading ResultSet into JTable — `DbUtils`)

---

## ▶️ How to Run

1. Clone or download this repository.
2. Set up the MySQL database as described above.
3. Add the required JAR files to your classpath/build path (in Eclipse/IntelliJ).
4. Place all icon images in an `icons/` folder on the classpath.
5. Run `Splash.java` — it will show the splash screen and then redirect to the login page.
6. Log in with your credentials and start using the system.

---

## 👨‍💻 Author

**Suyash Soni**

📧 suyashsoni93@gmail.com
📞 8299664281

---

## 📄 License

This project was developed as an academic project. Feel free to use it for learning and reference purposes.
