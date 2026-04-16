# 🐾 Cat-a-log: A Campus Cat Registration System

**Course:** SECJ2154 Object-Oriented Programming (OOP)  
**Group Name:** Meow-Mate  

**Cat-a-log** is a Java-based Command Line Interface (CLI) application designed to systematically record, manage, and track data regarding stray cats living around the university campus. The system facilitates better care, monitoring, and community support for campus cats by replacing scattered manual records with a centralized digital platform.

---

## 📖 Table of Contents
* [Problem Statement](#-problem-statement)
* [System Features & User Roles](#-system-features--user-roles)
* [OOP Concepts Implemented](#-oop-concepts-implemented)
* [System Architecture](#-system-architecture)
* [Getting Started](#-getting-started)
* [Contributors](#-contributors)

---

## ⚠️ Problem Statement
Before the Cat-a-log system, managing campus cats faced several critical challenges:
1. **Scattered Information:** Cat details (location, health, incidents) were lost in paper notes or people's memories without a centralized platform.
2. **Unreported Incidents:** No official channel existed to report emergencies (e.g., accidents, fights, or pregnant cats).
3. **Inefficient Care Tracking:** Staff couldn't track feeding patterns (leading to over/underfeeding) or view centralized medical histories, risking duplicate vet checks.
4. **Area Assignment Confusion:** Staff lacked a digital system to clearly identify which cats belonged to their specific campus zones.
5. **Donation Inefficiency:** No digital portal existed for supporters to securely donate food, funds, or medicine.
6. **Low Visibility:** Cat lovers had no search tool to find specific cats (e.g., filtering by campus area or breed).

---

## ✨ System Features & User Roles
The system offers four different portals tailored to specific user roles:

### 1. 🧑‍💼 Staff Portal (Requires Login)
* **Cat Management:** Add new cats to the system or remove them (e.g., if adopted).
* **Care Actions:** Record feedings, log vet visits, and file incident reports.
* **Record Viewing:** View global feeding logs and detailed donation records/summaries.
* **Profile Management:** Register, login, update personal staff profiles, and view assigned coverage areas.

### 2. 🙋‍♀️ Volunteer Portal
* **Care Actions:** Record cat feedings and log veterinary visits.
* **Incident Reporting:** File incident reports involving one or multiple cats.
* *Note: Volunteers can contribute immediately without formal account registration.*

### 3. 💝 Donor Portal
* **Make Donations:** Contribute via four specific categories: **Food, Money, Medicine, and Others**.
* Automatically generates a Donation ID and logs the contribution timestamp.

### 4. 🚶 Guest Portal
* **Browse Cats:** Search for specific cats filtering by **Campus Area** or **Breed**.
* **View Details:** View a cat's detailed profile, including its health records and incident history.
* **View Profiles:** Browse the profiles of registered Staff, Volunteers, and Donors.

---

## 💻 OOP Concepts Implemented
The application is built strictly using Object-Oriented Programming principles:
* **Encapsulation:** Private attributes in classes (e.g., `Cat`, `Staff`) accessed via getters and setters.
* **Inheritance:** `Staff`, `Volunteer`, and `GuestDonor` inherit from the abstract `User` superclass.
* **Abstraction & Polymorphism:** The `User` class is abstract with an abstract method `getUserInfo()`. Methods are overridden in subclasses to provide specific outputs.
* **Interfaces:** The `CatCareAction` interface is implemented by `Staff` and `Volunteer` to standardize care methods (`recordFeeding`, `logVetVisit`, `reportIncident`).
* **Composition:** The `Cat` class inherently contains `Feeding` and `HealthRecord` objects.
* **Aggregation:** The `Cat` class and `IncidentReport` class share an aggregation relationship (an incident report can exist independently of a specific cat).
* **Association:** Users have association relationships with Feedings, Incident Reports, and Donations.
* **Exception Handling:** Custom exceptions like `InvalidAreaException` and `InvalidDonationAmountException` ensure system stability and input validation.
* **Enumerations (ENUM):** Used to strictly define `DonationType` (FOOD, MONEY, MEDICINE, OTHERS).
* **Data Structures:** Extensive use of `Vector` and `ArrayList` to manage dynamic data collections.

---

## 🗂️ System Architecture
The project is structured into logical packages and classes:
* **Main Driver:** `Catalog.java` (Contains the CLI menus and main system loop)
* **Interface:** `CatCareAction.java`
* **Entities:**
  * `Cat.java`
  * **User:** `User.java` (Abstract), `Staff.java`, `Volunteer.java`, `GuestDonor.java`
  * **Function:** `Feeding.java`, `HealthRecord.java`, `IncidentReport.java`, `Donation.java`
* **Custom Exceptions:** `InvalidAreaException.java`, `InvalidDonationAmountException.java`

---
