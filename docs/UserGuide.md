



<h1 align="center">  CheatLogs User Guide </h1>

![Our Logo](https://i.ibb.co/VxzKbbz/a1.png)

Welcome to the official user guide of CheatLogs, a free and open-source cheatsheet manager with blazing fast organization and searching via a command-line interface (CLI). 	

This user guide serves as a reference for using the features of CheatLogs. The level of technicality within this document is tailored towards our target audience, novice programmers. For new users, we recommend reading this from the very [start](#before-start).

The table of contents below lets you easily access the documentation for installation, specific features, and frequently asked questions. 

> <font size = "5" >:bulb: Here are some patterns you will come across and their meanings.
> ------
>|Pattern|Meaning  |
>|--|--|
>| :bulb: |Tip on current section  |
>|:exclamation:|Warning of potential error|
>|<font size="3"> [:arrow_up_small:](#table-of-contents)</font>| Returns to table of contents on left click|
>|**bold**|Key terms specific to CheatLogs|
>|*italics*|Files|
>|`Snippets`|Typed input to CheatLogs|

<br>

## Table of contents

* [1. Before you start](#before-start)
* [2. Running CheatLogs](#start)
* [3. GUI text editor](#editor)
* [4. Commands](#commands)
   * [4.1. Storage commands](#storage-command-type)
     * [4.1.1. Adding a cheatsheet: `/add`](#add-command)
	  * [4.1.2. Deleting a cheatsheet: `/delete`](#delete-command)
	  * [4.1.3. Clearing all entries: `/clear`](#clear-command)
  * [4.2.  Manipulation commands](#manipulation-command-type)
		* [4.2.1. Editing a cheatsheet: `/edit` ](#edit-command)
		* [4.2.2. Favouriting a cheatsheet: `/fav` ](#favourite-command)
  * [4.3.  Viewing commands](#viewing-command-type)
		* [4.3.1. Locating a cheatsheet by name: `/find`](#find-command)
		* [4.3.2. Viewing the cheatsheet: `/view`](#view-command)
		* [4.3.3. Listing all cheatsheets: `/list`](#list-command)
  * [4.4.  General commands](#general-command-type)
	   * [4.4.1. Viewing help: `/help`](#help-command)
	   * [4.4.2. Set  program settings: `/set`](#settings-command)
	   * [4.4.3. Exiting the program: `/exit`](#exit-command)
* [5. Data storage](#data-storage)
* [6. Archiving data files](#archiving-data-files)
* [7. FAQ](#faq)
* [8. Command Cheatsheet](#command-cheatsheet)

<br>

<a id="before-start"></a>
##  1. Before you start<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
CheatLogs requires Java 11 or above installed on your computer. To install Java 11 and verify:
> &nbsp;:exclamation: If you use earlier versions of Java, there may be compatibility issues. Thus, we recommend using the same one we developed on, Java 11. 
> 
 1. Download Java JDK 11 for your system from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
 2. Run and follow the installation instruction in the wizard.
 3. Check the Java version.
	 * For computers on Windows, invoke`java -version` on the command prompt.
	 * For MacOs or Linux distros, invoke `java -version` on the terminal.
4. Verify that the version installed follows the "11.x.x" format. Refer to the image below for what you should expect to see.
![Java 11 installed message](https://i.ibb.co/tzV9GX3/image.png)

<br>

<a id="start"></a>
##  2. Running CheatLogs<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
CheatLogs is easy to get running. You can follow the  steps below to do so.
1.  You can download the latest version of CheatLogs from [here](https://github.com/AY2021S1-CS2113T-W11-3/tp/releases).
2. Scroll to the latest release.
3. Download only the *CheatLogs.jar* file highlighted in the orange box below.

	![](https://i.ibb.co/C24vhGg/image.png)
2. Create a new directory anywhere on your PC, This is the home folder where CheatLogs will be creating its own subdirectories to store cheatsheets. 
3. Move *CheatLogs.jar* to the new directory.
4. On the command Line or Terminal,  navigate to the directory.
5. Invoke `java -jar cheatlogs.jar` to run the program. If a welcome message appears as shown below then great! CheatLogs is up and running.
![CheatLogs welcome screen]( https://i.ibb.co/pK6CtPv/image.png)


6. Try typing some commands in the terminal and hit Enter to execute.
   Here are some example commands you can try, don't worry if you don't know them yet!
   
   * `/help`: Shows help info on how to use the application.
   * `/list`: Lists all cheatsheets.
   * `/exit`: Exits the app.
   
 <br>
 
<a id="editor"></a>
##  3. GUI text editor<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
CheatLogs provides a simple graphical user interface (GUI) text editor that automatically pops up on certain commands. These comands include: `add` and `edit`. This allow you to have an easier time manipulating of data, perform simple operations such as cut, copy and paste or even using your mouse which are typically unavailable on the CLI. Below is what you can expect to see and be able to do when it pops up.
<p align="center">
   <img width="500" height="350" src="https://i.ibb.co/YbC11XB/ezgif-6-567f275ee84a.gif">
</p>

### Tab functions
Additional functionalities of the editor above are found in the tabs.
| Actions tab | Edit tab |
|--|--|
|  ![image](https://i.ibb.co/1TB0F3L/image.png)| ![image](https://i.ibb.co/jRwTQB3/image.png)|

Here are brief explanations for the above tabs. <br>
Action tab
 - Save : Save the text inputed, exits the text editor
 - Clear All : Remove all text, remains in the text editor.
 - Cancel : Remove all text, exit the text editor.

Edit tab
  - Copy : Copies the text higlighted in the editor to the system clipboard.
 -  Cut : Cuts the text higlighted in the editor to the system clipboard.
 -  Paste : Pastes from the system clipboard to the position of the text cursor.

<br>
  
<a id="commands"></a>
## 4. Commands<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Commands are how you interact with Cheatlogs. To understand the terminology being used in the later sections, we want to you to undestand the typical structure of a command, illustrated below.

<p align="center">
   <img width="540" height="390" src="https://i.ibb.co/r3JjNZs/Sprite-0005.png">
</p>

The anatomy of the command is broken down to color coded sections in the picture. These elements are all that are all used to execute the command and are elaborated below:
* **Command identifier**: Every command needs one. It isused to exactly what type of command needs to be run. In the commmand above, `/add` is the command identifier for adding cheatsheets
* **Flag**: Akin to options or parameters of the command, these are additional information passed to CheatLogs to use. Flags are sometimes optional and you don't always need to type them. In the commmand above, `/n`  and `/s` are used to indicate the names and subject of the cheatsheet respectively with `/s` being an optional flag.
* **Flag description**: Used when the flag itself is does not provide enough information, CheatLogs takes in additional information for each flag through that flag's description. Not all flags have flag descriptions but each flags description need to accompany a flag. In the commmand above, it is the  name flag `n` is decribed by `help` and the subject flag `s` is decribed by `me`.

> :bulb: You need not worry if you forget the exact flags for each command. CheatLogs prompts you to enter the flag description for each missing neccesary flags.

<br>

<a id="storage-command-type"></a>
### 4.1. Storage Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
These are are some of the most used command type in CheatLogs. They allow you manage the input and ouput of cheatsheets to and from the entire list of cheatsheets. CheatLogs only has one list of cheatsheets and the following storage commands all refer to this as **the List**.

<a id="add-command"></a>
#### 4.1.1. Adding a cheatsheet: `/add` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 

Format: `/add /n <CHEATSHEET_NAME> /s <SUBJECT>` <br>
Flag optionality: `/n` (required)`/s` (optional)

A cheatsheet is first constructed with the name `CHEATSHEET_NAME` and subject `SUBJECT`. The text editor will then pop up for you to enter the description of the cheatsheet.

If a non-empty description is saved, the cheatsheet is added to the List and stored to the */data* folder in the jar file directory. Below is the expected outcome in the CLI.
![image](https://i.ibb.co/hV499yH/image.png)
Else if the description is blank or the text editor was canceled, the error message below is shown and the cheatsheet is not saved.
 ![image](https://i.ibb.co/qxkMwtV/image.png)

If you try to enter a cheatsheet with a name already in the List. You will get a message to input another another one, this is depicted below.
![image](https://i.ibb.co/mhgrwN0/image.png)

Examples:
* `/add /n classes s/Java`
* `/add /n Cppthings`

 <a id="delete-command"></a>
#### 4.1.2. Deleting a cheatsheet: `/delete`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
To be used after using /list, Deletes the cheatsheet at INDEX items down the list. The first cheatsheet has an index of 1. This cheatsheet will be deleted from the /data folder.
 
Format 1: `/delete i/INDEX`

Examples:
* `/list`

* `/delete i/2` 

<a id="clear-command"></a>
#### 4.1.3. Clearing all entries: `/clear`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Clears all entries from the cheatsheet.
 
Format: `/clear`
  
Format 2: `/delete n/CHEATSHEET_NAME` 

Examples:
* `/delete n/MyPythonCheatSheet`


<a id="manipulation-command-type"></a>
### 4.2. Manipulation Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
These are commands can change the properties of specific cheatsheets.

<a id="edit-command"></a>
#### 4.2.1. Editing a cheatsheet: `/edit` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
TBC

<a id="favourite-command"></a>
#### 4.2.2. Favouriting a cheatsheet: `/fav` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
TBC


<a id="viewing-command-type"></a>
### 4.3. Viewing Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
These are commands look up the list of cheatsheets.

<a id="find-command"></a>
#### 4.3.1. Locating a cheatsheet by name: `/find`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Finds a cheatsheet whose names contain any of the given keywords.
 
Format: `/find l/PROGRAMMING LANGUAGE k/KEYWORDS`

Notes:
* The search is **case-insensitive**. e.g python will match `Python`
* The order of the keywords does not matter. e.g. `C++ guide` will match `guide C++`
  * Only the name is searched.
* Only full words will be matched e.g. `Java` will not match `Java11`
* Cheatsheets matching at least one keyword will be returned (i.e. OR search). 
  * e.g. `python` will return `Introduction to python`, `my python`

Examples:
* `/find Java` returns `java - cheatsheet` and `JAVA11`

<a id="view-command"></a>
#### 4.3.2. Viewing the cheatsheet: `/view`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
View the contents of a cheatsheet either by the name or index

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

<a id="list-command"></a>
#### 4.3.3. Listing all cheatsheets: `/list`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Shows of all the cheatsheets that are stored in the application.
 
Format: `/list`


<a id="general-command-type"></a>
### 4.4. General Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
These are useful  general purpose commands that do no fit into the other catergories.
<a id="help-command"></a>

#### 4.4.1 Viewing help: `/help`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Lists all the possible commands that can be executed in the application.

Format: `/help`

<a id="settings-command"></a>
#### 4.4.2 Set  program settings: `/set`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 

<a id="exit-command"></a>
#### 4.4.3 Exiting the program: `/exit`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
Exits the application.
 
Format: `/exit`

<br>

<a id="data-storage"></a>
### 5. Data storage<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 

Data related to this application is saved in the `/data` folder automatically after 
any command that changes it is given. 
There is no need to save manually. 
You can find this folder in the same directory as `cheatlogs.jar`. 
 
To allow the application to safely read the files stored in the `/data` folder, 
please refrain from modifying them externally. 
You can edit attributes associated with that cheatsheet through the application itself.

<br>

<a id="archiving-data-files"></a>
### 6. Archiving data files [coming in v2.0]<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
TBC

<br>

<a id="fa
q"></a>
## 7. FAQ<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
**Q**: How do I transfer my data to another computer? <br>

**A**: You can simply drag and drop the `cheatlogs.jar`  and the `/data` directory in that same folder into the other computer.

**Q**: Why is CheatLogs so strict on formatting!?<br>
**A**: CheatLogs is still under development but we plan to provide better ways for you to input ways in the future.

**Q**: Will future updates break my current cheatsheets?<br>
**A**: The current structure of cheatsheets may change in the future, but we plan to provide you ways to convert so that you can enjoy the new features. 

<br>

<a id="command-cheatsheet"></a>
## 8. Command Cheatsheet<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
The table below is for quick and easy reference to the CheatLogs commands with examples of use.
Action | Format | Examples
-------- | ---------- | ------------
Add | /add /n <CHEATSHEET_NAME> /s <SUBJECT> | /add /n List /s Java
Delete | /delete /i <CHEATSHEET_INDEX> <br> /delete /n <CHEATSHEET_NAME> | /delete /n List , /delete /i 1
Clear | /clear |
Edit | /edit /i <CHEATSHEET_INDEX> <br> /edit /n <CHEATSHEET_NAME> | /edit /i 1 , /edit /n List
Favourite | /fav /i <CHEATSHEET_INDEX> <br> /fav /n <CHEATSHEET_NAME> | /fav /i 2 , /fav /n Cheat
Find | /find /s <SUBJECT> /k <KEYWORD> | /find /s Java , /find /s Java /k cheater
View | /view /i <CHEATSHEET_INDEX> <br>/view /n <CHEATSHEET_NAME> | /fav /i 3 , /fav /n List
List | /list |
Help | /help |
Settings | /set /c <OPTION_NUMBER> | /set /c 1
Exit | /exit |

