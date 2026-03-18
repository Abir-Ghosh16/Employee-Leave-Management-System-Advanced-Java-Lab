# 🗓️ Employee Leave Management System

A console-based **Employee Leave Management System** built in Java that demonstrates core OOP principles — including abstract classes, inheritance, generics, and date-based calculations — through a realistic HR leave application workflow.

---

## 📁 Project Structure

```
employee-leave-management-java/
├── src/
│   ├── Main.java              # Entry point — interactive console menu
│   ├── Employee.java          # Abstract base class for all employee types
│   ├── Officer.java           # Concrete employee type — Officer
│   ├── Staff.java             # Concrete employee type — Staff
│   ├── Report.java            # Employee registry (stores & retrieves employees)
│   └── ReportGenerator.java   # Generic leave calculator using joining date
└── README.md
```

---

## 🧠 Concepts Demonstrated

| Concept | Where Used |
|---|---|
| Abstract Class & Inheritance | `Employee.java` → `Officer`, `Staff` |
| Generics (`<T extends Employee>`) | `ReportGenerator<T>` |
| `ArrayList` & Collection handling | `Report.java` — employee registry |
| Date handling (`LocalDate`, `ChronoUnit`) | `ReportGenerator`, `Main` — date parsing & diff |
| Pro-rated leave calculation | `ReportGenerator.LeaveCalculation()` |
| Interactive console I/O | `Main.java` — `Scanner`-based menu loop |
| Exception handling | Date parse errors in `ReportGenerator`, `Main` |

---

## 🔍 Class Breakdown

### `Employee` (Abstract Class)
Base class for all employees. Holds common fields — `id`, `name`, `dateOfBirth`, `email`, `joiningDate`, `type` — along with vacation and sick leave balances. Provides a `Details()` method to print a formatted employee summary.

---

### `Officer` & `Staff` (Concrete Subclasses)
Both extend `Employee` and pass data to the superclass constructor. Leave entitlements differ by type:

| Employee Type | Vacation Leave | Sick Leave |
|---|---|---|
| Officer | 15 days/year | 10 days/year |
| Staff | 10 days/year | 7 days/year |

---

### `ReportGenerator<T>` (Generic Class)
Calculates **pro-rated leave entitlement** based on the employee's joining date within the year. An employee who joins mid-year receives a proportional share of their annual leave, rounded to the nearest whole day. Handles leap years correctly (366-day calculation).

**Formula:**
```
Leave = (Days remaining in year × Annual entitlement) / Days in year
```

---

### `Report` (Employee Registry)
Maintains an `ArrayList<Employee>` and provides `addEmployee()` and `getEmployee(id)` lookup methods.

---

### `Main` (Console Application)
Interactive program flow:
1. Collects data for 5 employees via `Scanner`
2. Prompts whether the user wants to apply for leave
3. Looks up the employee by ID and generates their leave report
4. Accepts a leave type (vacation / sick) and a date range
5. Approves or rejects based on remaining balance and updates it

---

## ▶️ How to Run

### Prerequisites
- Java 8 or higher
- Any IDE (IntelliJ IDEA recommended) or terminal with `javac`

### Compile & Run (Terminal)

```bash
# Navigate to the src directory
cd src

# Compile all files
javac *.java

# Run the program
java Main
```

### Sample Interaction

```
Add 5 User info

--- Enter Employee 1 data ---
ID: 101
Name: Rahim Uddin
DOB (YYYY-MM-DD): 1995-03-15
Email: rahim@example.com
Joining Date (YYYY-MM-DD): 2024-07-01
Enter Type (Officer/Staff/etc): Officer

...

Do you want Leave Application? If(YES) Type (Y/N): Y
Please Give me Your Employee Id: 101
Employee Verified

Leave Information (vacation or sick): vacation

Employee Details---------
ID: 101
Employee Type: Officer
Name: Rahim Uddin
Vacation Leave Remaining: 8
Sick Leave Remaining: 5

Please Provide Leave Date From (Format Year-Month-Date): 2024-08-01
Please Provide Leave Date To (Format Year-Month-Date): 2024-08-03
Vacation Leave Accepted
```

---

## 🧮 Leave Calculation Logic

Pro-rated leave is calculated from the employee's **joining date to December 31** of the same year:

```java
long totalDays = ChronoUnit.DAYS.between(joinDate, endYearDate) + 1;
float vacation = (float)(totalDays * vacationDays) / daysInYear;
// Rounded to nearest whole day (>= 0.5 rounds up)
```

**Example:** An Officer joining on July 1 (184 days remaining in a 365-day year):
- Vacation: `(184 × 15) / 365 = 7.56 → 8 days`
- Sick: `(184 × 10) / 365 = 5.04 → 5 days`

---

## 🏫 Course Info

**Course:** Advanced Programming with Java
**Topic:** OOP, Generics, Date API, Collections, Console I/O
**IDE:** IntelliJ IDEA

---
