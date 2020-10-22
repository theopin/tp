# CheatLogs User Guide

## Introduction

**CheatLogs** is a Command Line Interface Application that is targeted at novice or beginner programmers 
to help them develop their own applications. 
It has a text based interface that allows the user to 
access cheat sheets and notes for various programming syntax and functions.

## Index
* [Quick Start](#quick-start) 
* [Features](#features)
  * [Adding a cheat sheet: `/add`](#adding-a-cheat-sheet-add)
  * [Clearing all entries: `/clear`](#clearing-all-entries-clear)
  * [Deleting a cheat sheet: `/delete`](#deleting-a-cheat-sheet-delete)
  * [Editing a cheat sheet: `/edit` [coming in v2.0]](#editing-a-cheat-sheet-edit-coming-in-v20)
  * [Exiting the program: `/exit`](#exiting-the-program-exit)
  * [Locating a cheat sheet by name: `/find`](#locating-a-cheat-sheet-by-name-find)
  * [Viewing help: `/help`](#viewing-help-help)
  * [Listing all cheat sheets: `/list`](#listing-all-cheat-sheets-list)
  * [Viewing the cheatsheet: `/view`](#viewing-the-cheatsheet-view)
  * [Data storage](#data-storage)
  * [Archiving data files [coming in v2.0]](#archiving-data-files-coming-in-v20)
* FAQ
* Command Summary

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.
2. Download the latest `cheatlogs.jar` from here.
3. Copy the file to the folder you want to use as the home folder for this application.
4. Use java -jar `cheatlogs.jar` to run the program. A welcome message should appear, as shown below.
```
 ________  ___  ___  _______   ________  _________  ________  ___  ___  _______   _______  _________
|\   ____\|\  \|\  \|\  ___ \ |\   __  \|\___   ___\\   ____\|\  \|\  \|\  ___ \ |\  ___ \|\___   ___\
\ \  \___|\ \  \\\  \ \   __/|\ \  \|\  \|___ \  \_\ \  \___|\ \  \\\  \ \   __/|\ \   __/\|___ \  \_|
 \ \  \    \ \   __  \ \  \_|/_\ \   __  \   \ \  \ \ \_____  \ \   __  \ \  \_|/_\ \  \_|/__  \ \  \
  \ \  \____\ \  \ \  \ \  \_|\ \ \  \ \  \   \ \  \ \|____|\  \ \  \ \  \ \  \_|\ \ \  \_|\ \  \ \  \
   \ \_______\ \__\ \__\ \_______\ \__\ \__\   \ \__\  ____\_\  \ \__\ \__\ \_______\ \_______\  \ \__\
    \|_______|\|__|\|__|\|_______|\|__|\|__|    \|__| |\_________\|__|\|__|\|_______|\|_______|   \|__|
                                      ___       ________  ________
                                     |\  \     |\   __  \|\   ____\
                                     \ \  \    \ \  \|\  \ \  \___|
                                      \ \  \    \ \  \\\  \ \  \  ___
                                       \ \  \____\ \  \\\  \ \  \|\  \
                                        \ \_______\ \_______\ \_______\
                                         \|_______|\|_______|\|_______|
--------------------------------------------------------------------------------------------------------
Welcome to CheatLogs, the one stop cheat sheet management systems
Your CAP is our upmost priority
--------------------------------------------------------------------------------------------------------

Please Enter a Command:
```


5. Type a command in the terminal and press Enter to execute it.
   Some example commands you can try:
   * `/list`: Lists all cheat sheets.
   * `/find CS2113`: Find cheat sheet containing “CS2113T” in the name field. 
   * `/exit`: Exits the app.
   
## Features 

### Adding a cheat sheet: `/add`
Adds a new cheat sheet to the application and prompts user to include data into the cheat sheet. <br>
This cheat sheet will be added to the `/data` folder.
 
Format: `/add n/NAME d/DESCRIPTION`
 
Examples:
* `/add n/Python d/”This my secret cheat sheet to success”`
* `/add n/Java d/version11`
* `/add n/Cpp`

### Clearing all entries: `/clear`
Clears all entries from the cheat sheet.
 
Format: `/clear`
  
### Deleting a cheat sheet: `/delete`
To be used after using /list, Deletes the cheat sheet at INDEX items down the list. The first cheat sheet has an index of 1. This cheatsheet will be deleted from the /data folder.
 
Format 1: `/delete i/INDEX`

Examples:
* `/list`

* `/delete i/2` 

 
Format 2: `/delete n/CHEAT_SHEET_NAME` 

Examples:
* `/delete n/MyPythonCheatSheet`

### Editing a cheat sheet: `/edit` [coming in v2.0]
TBC

### Exiting the program: `/exit`
Exits the application.
 
Format: `/exit`

### Locating a cheat sheet by name: `/find`
Finds a cheat sheet whose names contain any of the given keywords.
 
Format: `/find l/PROGRAMMING LANGUAGE k/KEYWORDS`

Notes:
* The search is **case-insensitive**. e.g python will match `Python`
* The order of the keywords does not matter. e.g. `C++ guide` will match `guide C++`
  * Only the name is searched.
* Only full words will be matched e.g. `Java` will not match `Java11`
* Cheat sheets matching at least one keyword will be returned (i.e. OR search). 
  * e.g. `python` will return `Introduction to python`, `my python`

Examples:
* `/find Java` returns `java - cheatsheet` and `JAVA11`

### Listing all cheat sheets: `/list`
Shows of all the cheat sheets that are stored in the application.
 
Format: `/list`

### Viewing help: `/help`
Lists all the possible commands that can be executed in the application.

Format: `/help`

### Viewing the cheatsheet: `/view`
View the contents of a cheat sheet either by the name or index

Format 1: `/view n/NAME` 

Examples:
* `/view n/MyPythonCheatSheet`
 
Format 2: `/list` followed by `/view i/INDEX` 

Examples:
* `/list` 
* `/view i/2`

Format 3: `/find KEYWORD` followed by `/view i/INDEX`

Examples:
* `/find CheatSheet` 
* `/view i/2`


### Archiving data files [coming in v2.0]
TBC

### Data storage
Data related to this application is saved in the `/data` folder automatically after 
any command that changes it is given. 
There is no need to save manually. 
You can find this folder in the same directory as `cheatlogs.jar`. 
 
To allow the application to safely read the files stored in the `/data` folder, 
please refrain from modifying them externally. 
You can edit attributes associated to that cheatsheet through the application itself.

## FAQ
**Q**: How do I transfer my data to another computer? 

**A**: Drag and drop the `cheatlogs.jar` file as well as the `/data` directory into the other
    computer.

## Command Summary
Action | Format | Examples
-------- | ---------- | ------------
Add | `/add n/CHEAT_SHEET_NAME d/”DESCRIPTION”` | `/add n/Python d/”This my secret cheat sheet to success”` `/add n/Java d/version11` `/add n/Cpp`
Clear | `clear` | -
Delete | `/delete i/<CHEAT_SHEET_INDEX>` | `/delete i/2`
Edit | `/edit <PROGRAMMING LANGUAGE> <SECTION>` | `/edit l/python k/pointers` `/edit l/python`
Find | `/find <PROGRAMMING LANGUAGE> <KEYWORD>` | `/find l/python k/functions`
List | `/list` | -
Help | `/help` | -
View | `/view n/<NAME>` `/view i/<INDEX>` | `/view n/MyPythonCheatSheet` `/view i/2`