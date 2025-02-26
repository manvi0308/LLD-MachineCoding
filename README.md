# Low-Level Design (LLD) Repository

Welcome to the **Low-Level Design (LLD) Repository**! This repository contains detailed design implementations for commonly asked system design problems. Each design follows Object-Oriented Programming (OOP) principles, SOLID principles, and design patterns where applicable.

## Table of Contents
- [Projects](#projects)
  - [Parking Lot System](#parking-lot-system)
  - [Vending Machine](#vending-machine)
  - [Publisher-Subscriber System](#publisher-subscriber-system)
  - [Car Booking System](#car-booking-system)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)

---

## Overview
This repository serves as a reference for understanding and implementing low-level designs for real-world applications. Each system is designed considering scalability, maintainability, and extensibility.

---

## Projects

### Parking Lot System
A scalable parking lot management system that supports:
- Multiple parking levels
- Different vehicle types (bike, car, truck)
- Parking slot allocation and deallocation
- Fee calculation based on duration
- Admin and user roles

**Design Patterns Used:** Singleton, Factory, Strategy

📌 [View Implementation](https://github.com/manvi0308/LLD-MachineCoding/tree/main/src/ParkingLot)

---

### Vending Machine
A vending machine implementation supporting:
- Product selection
- Coin and note insertion
- Change return mechanism
- Inventory management
- State transitions (Idle, Ready, Dispense, ReturnChange)

**Design Patterns Used:** Singleton, State.

📌 [View Implementation](https://github.com/manvi0308/LLD-MachineCoding/tree/main/src/StateDesignPattern/VendingMachine)

---

### Publisher-Subscriber System
A distributed event-driven system that includes:
- Publishers sending messages/events
- Subscribers receiving relevant messages
- Message queues and asynchronous event handling

**Design Patterns Used:** Observer, Mediator

📌 [View Implementation](https://github.com/manvi0308/LLD-MachineCoding/tree/main/src/PubSubSystem)

---

### Car Booking System
A ride-booking system similar to Uber, featuring:
- User registration and authentication
- Ride booking and cancellation
- Driver assignment
- Payment processing

**Design Patterns Used:** Factory, Strategy, Observer

📌 [View Implementation](https://github.com/manvi0308/LLD-MachineCoding/tree/main/src/CarBookingSystem)

---

## Technologies Used
- Java
- Object-Oriented Design (OOD)
- Design Patterns (Singleton, Factory, State, Strategy, Observer, etc.)
- Multithreading & Concurrency
- Data Structures & Algorithms

---

## Contributing
Contributions are welcome! Feel free to raise issues or submit pull requests.

---

🚀 **Happy Coding!**

