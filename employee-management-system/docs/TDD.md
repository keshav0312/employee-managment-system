# Test Plan - Employee Management System

This document explains how we tested the backend API.

---

## 1. What to Test
| Part | What to check |

| Database | Data saves correctly |
| API | Endpoints provide correct output |
| Validation | Cannot save employee with empty fields |
| Update | Updated data is stored correctly |
| Delete | Deleted employee no longer appears |

---

### 1) Add Employee (Valid Data)
- Input: All fields filled correctly
- Expected: 201 Created + Employee saved

### 2) Add Employee (Invalid Email or Empty Fields)
- Expected: 400 Bad Request

### 3) Phone Number Validation
- Input: Phone shorter/longer than 10-12 digits
- Expected: 400 with "Phone number must be 10 to 12 digits"

### 4) Salary Validation
- Input: Negative or zero salary
- Expected: 400 with "Salary must be positive"

### 5) Date of Joining Missing
- Expected: 400 Bad Request

### 6) Get Employee By ID
- Valid ID → 200 OK
- Invalid ID → 404 Not Found

### 7) Update Employee
- Valid update → 200 OK
- Invalid/Not Found → 404

### 8) Delete Employee
- After deletion → record should not exist

---

## 3. Tools Used
- Postman to test APIs
- MySQL Workbench to check database entries

---

## 4. Result
All test cases performed and verified successfully.
