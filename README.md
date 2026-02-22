# 📦 LogiNext Delivery Assignment System

## 📖 Description
This Java application simulates a delivery driver assignment system.  
It assigns delivery drivers to customer orders based on order placement time and driver availability.

The system ensures efficient allocation using a simple scheduling strategy.

---

## ⚙️ Assignment Logic
- Each driver can handle **only one order at a time**
- Drivers become available again after completing travel time
- The **lowest indexed available driver** is assigned first
- If all drivers are busy, the system prints:

```
No Food :-(
```

---

## 🧠 How It Works
1. Orders are processed sequentially.
2. For each order:
   - The system checks which drivers are free.
   - Assigns the earliest available driver.
   - Updates driver availability time.
3. If no driver is available → prints failure message.

---

## 🛠 Tech Stack
- Java (Core Java)
- JDBC (PostgreSQL Driver)
- Git & GitHub

---

## ▶️ How to Run

### Compile
```bash
javac -cp "lib/postgresql-42.7.10.jar;src" -d bin src/App.java
```

### Run
```bash
java -cp "lib/postgresql-42.7.10.jar;bin" App
```

---

## 🧾 Input Format
```
N M
O1 T1
O2 T2
...
```

Where:
- `N` = Number of orders
- `M` = Number of drivers
- `Oi` = Order time
- `Ti` = Travel time

---

## 📌 Sample Input
```
6 2
1 10
4 10
15 5
22 20
24 10
25 10
```

---

## 📌 Sample Output
```
C1 - D1
C2 - D2
C3 - D1
C4 - D1
C5 - D2
C6 - No Food :-(
```

---

## 👨‍💻 Author
**Manish Tiwari**  
M.Sc. Physics | Data Science & AI Enthusiast  
GitHub: https://github.com/manisht21
