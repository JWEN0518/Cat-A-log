# 🐾 Cat-A-log: Campus Cat Registration System

**Course:** SECJ2154 (Object-Oriented Programming)  
**Group Name:** Meow-Mate  

Cat-A-log is a comprehensive, Java-based Command Line Interface (CLI) application designed to collect, manage, and track data regarding stray cats living around the university campus. By replacing scattered manual notes with a centralized digital system, Cat-A-log facilitates better care, monitoring, and community support for campus cats.

---

## 📖 Table of Contents
* [About the Project](#about-the-project)
* [Problem Statement](#problem-statement)
* [Features & User Roles](#features--user-roles)
* [Object-Oriented Programming (OOP) Concepts](#oop-concepts-implemented)
* [System Architecture](#system-architecture)

---

## 🎯 About the Project

The Cat-A-log system serves as a bridge between university staff, supportive volunteers, generous donors, and casual cat-loving guests. It allows users to register cat profiles, log daily feedings, track veterinary visits, report incidents, and manage donations. The project is built entirely on core Object-Oriented Programming principles to ensure a modular, scalable, and maintainable codebase.

---

## ⚠️ Problem Statement

Before Cat-A-log, campus cat management faced several critical challenges:
* **Fragmented Information:** Details about a cat's location, health, and incidents were lost in casual messages or human memory.
* **Unreported Incidents:** Passersby had no official channel to report emergencies (e.g., pregnant cats, accidents, or fights).
* **Poor Care Tracking:** Staff couldn't track feeding patterns (leading to over/underfeeding) or view centralized medical histories, risking duplicate vet checks.
* **Area Confusion:** Staff lacked a digital assignment system to clearly identify which cats belonged to their specific campus zones.
* **Inefficient Donations:** Supporters had no secure, digitized way to donate food, funds, or medicine, forcing staff to log contributions manually.
* **Low Visibility:** Cat lovers had no search tool to find specific cats (e.g., "Calico near the library") without asking around.

---

## ✨ Features & User Roles

The system is divided into four distinct portals, each with specific permissions:

### 1. Staff Portal (Requires Registration & Login)
* Manage the campus cat database (Add/Remove cats).
* Update personal staff profiles and view assigned coverage areas.
* Record feedings, log vet visits, and file incident reports.
* View global feeding logs and detailed donation records/summaries.

### 2. Volunteer Portal
* Record cat feedings and log veterinary visits.
* File incident reports involving one or multiple cats.
* *Note: Volunteers can contribute immediately without a formal account setup.*

### 3. Donor Portal
* Make contributions across four specific categories: **Food, Money, Medicine, and Others**.
* Automatically generates a Donation ID and logs the contribution timestamp.

### 4. Guest Portal
* Browse and view the profiles of registered Staff, Volunteers, and Donors.
* Search for specific cats filtering by **Campus Area** or **Breed**.
* View a cat's detailed profile, including its health records and incident history.

---

## 💻 OOP Concepts Implemented

This project heavily utilizes Java Object-Oriented Programming techniques to structure the system:

* **Encapsulation:** Private attributes in classes (e.g., `Cat`, `Staff`) accessed via getters and setters.
* **Inheritance:** `Staff`, `Volunteer`, and `GuestDonor` inherit from the abstract `User` superclass.
* **Polymorphism & Abstraction:** The `User` class is abstract with abstract methods like `getUserInfo()`. 
* **Interfaces:** The `CatCareAction` interface is implemented by `Staff` and `Volunteer` to standardize care methods (`recordFeeding`, `logVetVisit`, `reportIncident`).
* **Composition:** The `Cat` class inherently contains `Feeding` and `HealthRecord` objects.
* **Aggregation:** The `Cat` class and `IncidentReport` class share an aggregation relationship (an incident report can exist independently of a specific cat).
* **Association:** Users have association relationships with Feedings, Incident Reports, and Donations.
* **Exception Handling:** Custom exceptions like `InvalidAreaException` and `InvalidDonationAmountException` ensure system stability against invalid inputs.
* **Enumerations (ENUM):** Used to strictly define `DonationType` (FOOD, MONEY, MEDICINE, OTHERS).
* **Collections:** Extensive use of `Vector` and `ArrayList` to manage dynamic lists of users, cats, and records.

---

## 🗂️ System Architecture

The repository is structured around logical domain entities:

* `Catalog.java` - The main driver class containing the CLI menus and system loop.
* `CatCareAction.java` - Interface defining standard cat care behaviors.
* **User Entities:** `User.java` (Abstract), `Staff.java`, `Volunteer.java`, `GuestDonor.java`.
* **Cat Entity:** `Cat.java` (Manages cat attributes, health records, and feeding histories).
* **Functional Entities:** `Feeding.java`, `HealthRecord.java`, `IncidentReport.java`, `Donation.java`.
* **Custom Exceptions:** `InvalidAreaException.java`, `InvalidDonationAmountException.java`.

