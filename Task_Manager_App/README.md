# 🧾 Task Manager Pro (Java Swing MVC)

A desktop-based Task Management application built using **Java Swing** and structured with the **MVC (Model-View-Controller)** design pattern.
This project allows users to efficiently manage tasks with features like adding, editing, deleting, searching, and marking tasks as completed.

---

## ✨ Features

* ➕ Add new tasks with priority
* ✏️ Edit existing tasks
* ❌ Delete tasks
* ✔️ Mark tasks as completed
* 🔍 Real-time search/filter tasks
* 📋 Dynamic task list updates
* 🎯 Clean MVC architecture

---

## 🏗️ Project Structure

```
src/
└── main/
    └── java/
        └── com/taskmanager/
            ├── controller/
            │   └── TaskController.java
            │
            ├── model/
            │   └── Task.java
            │
            ├── utils/
            │   └── FileHandler.java
            │
            ├── view/
            │   └── MainFrame.java
            │
            └── Main.java
```

---

## ⚙️ Technologies Used

* Java (JDK 8+)
* Java Swing (GUI)
* MVC Design Pattern

---

## ▶️ How to Run

1. Clone the repository:
   git clone https://github.com/shafinahmedbd967-art/Task_Manager_App.git

2. Open the project in:
   IntelliJ IDEA / Eclipse / NetBeans

3. Run the application:
   Execute `Main.java`

---

## 🧠 Architecture Overview

### 🔹 Model

Handles task data (Task.java)

### 🔹 View

Handles UI (MainFrame.java)

### 🔹 Controller

Handles logic & user interaction (TaskController.java)

---

## 🔍 Functional Flow

1. User enters a task
2. Controller processes input
3. Task is added to list
4. Search filters tasks dynamically
5. Edit/Delete/Complete update both UI and data

---

## 🚀 Future Improvements

* 💾 Database integration (MySQL / SQLite)
* 👤 User authentication system
* 📅 Task deadlines & reminders
* 🗂️ Task categories / labels
* ☁️ Cloud sync

---

## 👨‍💻 Author

**Shafin Ahmed**
GitHub: https://github.com/shafinahmedbd967-art

---

## 📄 License

This project is created for educational and portfolio purposes.
