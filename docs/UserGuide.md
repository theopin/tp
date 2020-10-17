# CheatLogs User Guide

## Introduction

**CheatLogs** is a Command Line Interface Application that is targeted at novice or beginner programmers 
to help them develop their own applications. 
It has a text based interface that allows the user to 
access cheat sheets and notes for various programming syntax and functions.

## Index
* Quick Start 
* Features
  * Viewing help: `/help`
  * Adding a cheat sheet: `/add`
  * Listing all cheat sheets: `/list`
  * Locating a cheat sheet by name: `/find`
  * Deleting a cheat sheet: `/delete`
  * Clearing all entries: `/clear`
  * Exiting the program: `/exit`
  * Viewing the cheatsheet: `/view`
  * Editing a cheat sheet: `/edit` [coming in v2.0]
  * Data storage
  * Archiving data files [coming in v2.0]
* FAQ
* Command Summary

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest cheatlogs.jar from here.
3. Copy the file to the folder you want to use as the home folder for this application.
4. Use java -jar cheatlogs.jar to run the program. A welcome message should appear, as shown below.

## Features 

{Give detailed description of each feature}

### Adding a todo: `todo`
Adds a new item to the list of todo items.

Format: `todo n/TODO_NAME d/DEADLINE`

* The `DEADLINE` can be in a natural language format.
* The `TODO_NAME` cannot contain punctuation.  

Example of usage: 

`todo n/Write the rest of the User Guide d/next week`

`todo n/Refactor the User Guide to remove passive voice d/13/04/2020`

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Drag and drop the jar file as well as the /data directory into the other
    computer.

## Command Summary

Action | Format | Examples
-------- | ---------- | ------------
Add | `/add n/CHEAT_SHEET_NAME d/”DESCRIPTION”` | `/add n/Python d/”This my secret cheat sheet to success”` `/add n/Java d/version11` `/add n/Cpp`
Clear | `clear` | -
Delete | `/delete i/<CHEAT_SHEET_INDEX>` | `/delete i/2`
Edit | `/edit <PROGRAMMING LANGUAGE> <SECTION>` | `/edit l/python k/pointers` `/edit l/python`
Find | `/find <PROGRAMMING LANGUAGE> <KEYWORD>` | `/find l/python k/functions`
View | `/view n/<NAME>` `/view i/<INDEX>` | `/view n/MyPythonCheatSheet` `/view i/2`
List | `/list` | -
Help | `/help` | -
