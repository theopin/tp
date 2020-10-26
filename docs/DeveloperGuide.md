# Developer Guide

# Table of Contents
* [1. Introduction](#1-introduction)
    + [1.1. Purpose](#11-purpose)
    + [1.2. Product Scope](#12-product-scope)
        - [1.2.1. Target User Profile](#121-target-user-profile)
        - [1.2.2. Value Proposition](#122-value-proposition)
    + [1.3. Definitions](#13-definitions)
* [2. Setting Up, Getting Started](#2-setting-up-getting-started)
    + [2.1. Prerequisites](#21-prerequisites)
    + [2.2. Running the Project](#22-running-the-project)
    + [2.3 Importing into IntelliJ [optional]](#23-importing-into-intellij-optional)
* [3. Design](#3-design)
    + [3.1. Architecture](#31-architecture)
    + [3.2. Components](#32-components)
    + [3.2.1. User Interface (Abner)](#321-user-interface-abner)
    + [3.2.2. Command Parser (Brandon)](#322-command-parser-brandon)
    + [3.2.3. Cheat Sheet Structure (Aldo)](#323-cheat-sheet-structure-aldo)
    + [3.2.4. Cheat Sheet Management (Adhy)](#324-cheat-sheet-management-adhy)
    + [3.2.5. Data Storage (Theo)](#325-data-storage-theo)
* [4. Implementation](#4-implementation)
    + [4.1. Parsing of Data to Construct Commands](#41-parsing-of-data-to-construct-commands)
    + [4.2. Editing Feauture](#42-editing-feauture)
    + [4.3. Sorting Feature](#43-sorting-feature)
    + [4.4. Storage & Reading of Cheatsheet files](#44-storage--reading-of-cheatsheet-files)
    + [4.5. [Proposed] Colour coding for code snippet](#45-proposed-colour-coding-for-code-snippet)
* [5. Documentation, logging, testing, configuration, dev-ops](#5-documentation-logging-testing-configuration-dev-ops)
* [6. Appendix: Requirements](#6-appendix-requirements)
    + [6.1 Product scope](#61-product-scope)
    + [6.2 User stories](#62-user-stories)
    + [6.3 Use cases](#63-use-cases)
    + [6.4 Non-Functional Requirements](#64-non-functional-requirements)
    + [6.5 Glossary](#65-glossary)
* [7. Appendix: Instructions for manual testing](#7-appendix-instructions-for-manual-testing)


## 1. Introduction



### 1.1. Purpose

This document specifies the architecture and software design decisions taken to develop our application, CheatLogs. 
Targeted towards developers who are or want to work on CheatLogs.

### 1.2. Product Scope

This document will cover the high-level architecture of the program, as well as the details for the implementation of the features.

#### 1.2.1. Target User Profile

{Describe the target user profile}

#### 1.2.2. Value Proposition

{Describe the value proposition: what problem does it solve?}

#### 1.3. Design Goals

Our main goal is to design a cheatsheet management system that will help novice and beginner programmers to learn and adapt to various programming languages. 
Our cheatsheet app comes with a set of preloaded cheatsheets. 
Additionally, the user can input their own cheat sheets into the application. 
This will make cheatlogs a comprehensive, one-stop solution for every student to manage their cheatsheet.

#### 1.4. Definitions



## 2. Setting Up, Getting Started



### 2.1. Prerequisites

1. JDK 11.0.8
2. Java IDE (IntelliJ Recommended)

CheatLogs has been developed on Java 11 and may not be supported on other versions. 
You are free to use any java file editor and run the program by following the step by step guide below. 

### 2.2. Running the Project

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest cheatlogs.jar from here.
3. Move the file to a folder you want to use as the home folder for this application.
4. Invoke java -jar cheatlogs.jar on the command line to run the program. A welcome message should appear, as shown below.

### 2.3 Importing into IntelliJ [optional]



## 3. Design

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

### 3.1. Architecture



### 3.2. Components



#### 3.2.1. User Interface (Abner)



#### 3.2.2. Command Parser (Brandon)



#### 3.2.3. Cheat Sheet Structure (Aldo)



#### 3.2.4. Cheat Sheet Management (Adhy)



#### 3.2.5. Data Storage (Theo)



## 4. Implementation



### 4.1. Parsing of Data to Construct Commands



### 4.2. Editing Feauture



### 4.3. Sorting Feature



### 4.4. Storage & Reading of Cheatsheet files



### 4.5. [Proposed] Colour coding for code snippet



## 5. Documentation, logging, testing, configuration, dev-ops



## 6. Appendix: Requirements



### 6.1 Product scope



### 6.2 User stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see a short and comprehensive guide|refer to them when I forget how to use the application|
|v1.0|user|search and filter the cheat sheets by name|open them quickly and easily|
|v1.0|intermediate user|write and add my own cheat sheets|use the application to help me in matters not strictly related to programming|
|v1.0|experienced user|delete all cheat sheets|create and customize everything by myself|
|v2.0|user|edit the cheat sheets|update the cheat sheet and keep them relevant as the time progresses|
|v2.0|user|customize the settings|add and edit the cheat sheets|

### 6.3 Use cases



### 6.4 Non-Functional Requirements

{Give non-functional requirements}

### 6.5 Glossary

* *glossary item* - Definition

## 7. Appendix: Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}



<!---
There are few major components inside the code, and those components are broken down into separate classes. 
All components can be accessed from the CheatLogs class.
### CheatSheetList
All cheatsheets are stored inside a static class CheatSheetList to allow other classes to easily access and write data to the list.
-->
