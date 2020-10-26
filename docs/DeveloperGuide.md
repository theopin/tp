# Developer Guide

# Table of Contents
* [1. Introduction](#1-introduction)
    + [1.1. Purpose](#11-purpose)
    + [1.2. Product Scope](#12-product-scope)
        - [1.2.1. Target User Profile](#121-target-user-profile)
        - [1.2.2. Value Proposition](#122-value-proposition)
    + [1.3. Definitions](#13-definitions)
* [2. Design & Implementation](#2-design--implementation)
    * [2.1. Project Overview](#21-project-overview)
        * [2.2. Module Overview](#22-module-overview)
            * [2.2.1. User Interface module](#221-record-module)
            * [2.2.2. Command Parser module](#222-converter-module)
            * [2.2.3. Cheat Sheet Structure module](#223-storage-module)
            * [2.2.4. Cheat Sheet Management module](#224-command-module)
            * [2.2.5. Data Storage Module](#225-parser-module)
* [3. User Stories](#3-user-stories)
* [4. Non-functional requirements](#4-non-functional-requirements)
* [5. Instructions for manual testing](#5-instructions-for-manual-testing)
    + [5.1. Startup, shutdown and restart](#51-startup-shutdown-and-restart-with-saved-list)
    + [5.2. Adding a patient](#52-adding-a-patient)
    + [5.3. Editing a patient](#53-editing-a-patient)
    + [5.4. Deleting a patient](#54-delete-a-patient)
    + [5.5. Adding an appointment](#55-add-an-appointment)
    + [5.6. Editing an appointment](#56-edit-an-appointment)
    + [5.7. Deleting an appointment](#57-delete-an-appointment)
    + [5.8. Finding patients and appointments](#58-find-patients-and-find-appointment)
    + [5.9. Clearing lists](#59-clear-patient-clear-appointment-clear-all-commands)
        
## 1. Introduction

### 1.1. Purpose

### 1.2. Product Scope

#### 1.2.1. Target User Profile

#### 1.2.2. Value Proposition

#### 1.3. Definitions

## 2. Design & Implementation

### 2.1. Project Overview

### 2.2. Module Overview

#### 2.2.1. User Interface module

#### 2.2.2. Command Parser module

#### 2.2.3. Cheat Sheet Structure module

#### 2.2.4. Cheat Sheet Management module

#### 2.2.5. Data Storage module

## 3. User Stories

## 4. Non-functional requirements

## Design & implementation

{Describe the design and implementation of the product. Use UML diagrams and short code snippets where applicable.}

There are few major components inside the code, and those components are broken down into separate classes. All components can be accessed from the CheatLogs class.
### CheatSheetList
All cheatsheets are stored inside a static class CheatSheetList to allow other classes to easily access and write data to the list.

## Product scope
### Target user profile

{Describe the target user profile}

### Value proposition

{Describe the value proposition: what problem does it solve?}

## User Stories

|Version| As a ... | I want to ... | So that I can ...|
|--------|----------|---------------|------------------|
|v1.0|new user|see a short and comprehensive guide|refer to them when I forget how to use the application|
|v1.0|user|search and filter the cheat sheets by name|open them quickly and easily|
|v1.0|intermediate user|write and add my own cheat sheets|use the application to help me in matters not strictly related to programming|
|v1.0|experienced user|delete all cheat sheets|create and customize everything by myself|
|v2.0|user|edit the cheat sheets|update the cheat sheet and keep them relevant as the time progresses|
|v2.0|user|customize the settings|add and edit the cheat sheets|

## Non-Functional Requirements

{Give non-functional requirements}

## Glossary

* *glossary item* - Definition

## Instructions for manual testing

{Give instructions on how to do a manual product testing e.g., how to load sample data to be used for testing}
