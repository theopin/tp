
<h1 align="center">  CheatLogs User Guide </h1>


![Our Logo](https://i.ibb.co/VxzKbbz/a1.png)

Welcome to the official user guide of CheatLogs, a free and open-source cheatsheet manager with blazing fast organization and searching via a command-line interface (CLI). 	

This user guide serves as a reference for using the features of CheatLogs. The level of technicality within this document is tailored towards our target audience, novice programmers. If you are new, we recommend reading this from the very [start](#before-start).

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
>|`Snippets`|Typed input or output going into or out of CheatLogs|

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
	* [4.4.2. Change program settings: `/set`](#settings-command)
	* [4.4.3. Exiting the program: `/exit`](#exit-command)
* [5. Data storage](#data-storage)
* [6. Archiving data files](#archiving-data-files)
* [7. FAQ](#faq)
* [8. Command Cheatsheet](#command-cheatsheet)

<br>

<a id="before-start"></a>
##  1. Before you start<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
CheatLogs requires Java 11 or above installed on your computer. You can follow the the following instructions to install Java 11:
> &nbsp;:exclamation: If you use earlier versions of Java, there may be compatibility issues. Thus, we recommend using the same one we developed on, Java 11. 
> 
 1. Download Java JDK 11 for your system from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
 2. Run and follow the installation instruction in the wizard.
 3. Check your Java version.
	 * For computers on Windows, invoke`java -version` on the command prompt.
	 * For MacOs or Linux distros, invoke `java -version` on your terminal of choice.
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
5. Create a new directory anywhere on your PC, This is the home folder where CheatLogs will be creating its own subdirectories to store cheatsheets. 

> :bulb: Unfamiliar with navigating the terminal? Click [here](https://www.digitaltrends.com/computing/how-to-use-command-prompt/) for a basic introduction for Windows cmd and [here](https://www.pluralsight.com/guides/beginner-linux-navigation-manual) for macOS/Linux bash terminal.

6. Move *CheatLogs.jar* to the new directory.
7. On the terminal,  navigate to the directory.
8. Invoke `java -jar cheatlogs.jar` to run the program. If a welcome message appears as shown below then great! CheatLogs is up and running.
![CheatLogs welcome screen]( https://i.ibb.co/pK6CtPv/image.png)


9. Try typing some commands in the terminal and hit Enter to execute.
   Here are some example commands you can try, don't worry if you don't know them yet!
   
   * `/help`: Shows help info on how to use the application.
   * `/list`: Lists all cheatsheets.
   * `/exit`: Exits the app.

A bit confused? Here is a video guide on doing steps 4-9 using the terminal (not cmd). Note that CheatLogs.jar already been placed in the Desktop folder.

![ezgif-6-63beb94eab4e](https://i.ibb.co/Q9FShJt/ezgif-6-63beb94eab4e.gif)
 <br>
 
<a id="editor"></a>
##  3. GUI text editor<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
CheatLogs provides a simple graphical user interface (GUI) text editor that automatically pops up on certain commands. These commands include: `add` and `edit`. This allows you to have an easier time manipulating data, performing simple operations such as cut, copy and paste or even using your mouse which are typically unavailable on the CLI. Below is what you can expect to see and be able to do when it pops up.
<p align="center">
   <img width="500" height="350" src="https://i.ibb.co/YbC11XB/ezgif-6-567f275ee84a.gif">
</p>

### Tab functions
Additional functionalities of the editor above are found in the tabs.
| Actions tab | Edit tab |
|--|--|
|  ![image](https://i.ibb.co/1TB0F3L/image.png)| ![image](https://i.ibb.co/jRwTQB3/image.png)|

Here are brief explanations for the above tabs. <br>
Actions tab
 - Save : Save the text inputted, exits the text editor.
 - Clear All : Remove all text, remains in the text editor.
 - Cancel : Remove all text, exit the text editor.

Edit tab
  - Copy : Copies the text highlighted in the editor to the system clipboard.
 -  Cut : Cuts the text highlighted in the editor to the system clipboard.
 -  Paste : Pastes from the system clipboard to the position of the text cursor.

In the following sections, we will be referring to this editor as **the Editor**. 
 
<a id="commands"></a>
## 4. Commands<font size="5"> [:arrow_up_small:](#table-of-contents)</font>
Commands are how you interact with Cheatlogs. To understand the terminology being used in the later sections, we would like you to understand the typical structure of a command, illustrated below.

<p align="center">
   <img width="540" height="390" src="https://i.ibb.co/r3JjNZs/Sprite-0005.png">
</p>

The anatomy of the command is broken down to color coded sections in the picture. These elements are all that are all used to execute the command and are elaborated below:
 * **Command identifier**: Every command needs one. It is used to determine exactly what type of command needs to be run. In the commmand above, `/add` is the command identifier for adding cheatsheets.

 * **Flag**: Akin to options or parameters of the command, these are additional information passed to CheatLogs to use. Flags are sometimes optional and you don't always need to type them. In the command above, `/n`  and `/s` are used to indicate the names and subject of the cheatsheet respectively with `/s` being an optional flag.
	
	Types of flags:
	 * Optional: Flag does not need to be included
	 * Necessary: Flag must be included
	 * At least one: At least one of the a set of flags must be included

* **Flag description**: Used when the flag itself does not provide enough information, CheatLogs takes in additional information for each flag through that flag's description. Not all flags have flag descriptions but each flag description needs to accompany a flag. In the command above, it is the name flag `n` is described by `help` and the subject flag `s` is described by `me`.

> :bulb: You need not worry if you forget the exact flags for each command. CheatLogs prompts you to enter the flag description for each missing necessary flags. <br>
> :exclamation: CheatLogs is case-sensitive, be sure to match the case for flags about names.

<br>

<a id="storage-command-type"></a>
## 4.1. Storage Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
This is one of the most used command type in CheatLogs. They allow you to manage the input and output of cheatsheets to and from the entire list of cheatsheets. CheatLogs only has one list of cheatsheets and the following storage commands all refer to this as **the List**.
___

<a id="add-command"></a>
### 4.1.1. Adding a cheatsheet: `/add` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
You can easily use the **/add** command to add your own cheat sheets to the list by using 2 different methods **easy** and **hard** mode.
#### 4.1.1.1 Adding a cheatsheet using the easy mode
> Format: `add`

The first method that you can use to add cheatsheet is the easy command. Just type `/add` without adding any flag or description. 
You will be prompted to fill in the `NAME` and the `SUBJECT` of your cheatsheet.

Shortly after, a window will pop up to show the editing window.
Enter the details of your cheatsheet there, then click `Actions` then `Save`
![image](https://i.ibb.co/n01kQ4Y/carbon.png)

Congratulations! You have added your first cheatsheet into CheatLogs.

#### 4.1.1.2 Adding a cheatsheet using the advanced mode
>Format: `/add /n <CHEATSHEET_NAME> /s <SUBJECT>` <br>
>Flag optionality: `/n` (required)`/s` (optional)
>
For the more advanced users, you can also add cheatsheets using the advanced command. A cheatsheet is first constructed with the name `CHEATSHEET_NAME` and subject `SUBJECT`. The Editor will then pop up for you to enter the description of the cheatsheet.

If a non-empty description is saved, the cheatsheet is added to the List and stored to the */data* folder in the jar file directory. The expected outcome should be similar to below.
![image](https://i.ibb.co/hV499yH/image.png)
Else if the description is blank or the Editor was canceled, the error message below is shown and the cheatsheet is not saved.
 ![image](https://i.ibb.co/qxkMwtV/image.png)

If you try to enter a cheatsheet with a name already in the List. You will get a message to input another one, this is depicted below.
![image](https://i.ibb.co/mhgrwN0/image.png)

Examples:
* `/add /n classes s/Java`
* `/add /n Cppthings`

Shortly after, an editing window will pop up to show the editing window.
Enter the details of your cheatsheet there, then click `Actions` then `Save`

If you want to clear the editing area, clck `Actions` then click `Clear All`
 <a id="delete-command"></a>
 
#### 4.1.2. Deleting a cheatsheet: `/delete`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
From the previous subsection, we learned how to add a cheatsheet into CheatLogs. 

In this section, you can learn how to use the `/delete` function.

To be used after using /list, Deletes the cheatsheet at INDEX items down the list. The first cheatsheet has an index of 1. This cheatsheet will be deleted from the /data folder.
 
Format 1: `/delete i/INDEX`

>Format: `/delete /n CHEATSHEET_NAME /i CHEATSHEET_INDEX` <br>
>Flag optionality: [`/n`, `/i`] (At least one)

Deletes the matching cheatsheet from the List with name matching `CHEATSHEET_NAME` or index matching `CHEATSHEET_INDEX` whichever you included or you included both. The expected result is similar to below if a matching cheatsheet is found.
![image](https://i.ibb.co/jLrwh03/image.png)
When either the name or index do not match, CheatLogs will specify the error as shown below.
![image](https://i.ibb.co/xHW7tLf/image.png)


Examples:
* `/delete /n if else /i 2`
* `/delete /i 2` 
* `/delete /n string`

___

<a id="clear-command"></a>
### 4.1.3. Clearing all entries: `/clear`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
>Format: `/clear`
>
If you want to reset everything to its original state, you can simply use the `/clear` command instead of using `/delete` multiple times.
This command will delete all cheatsheets from the List on your CheatLogs. No need to worry, `/clear` command will not remove the preloaded cheat sheets.
Here is the expected result if currently you have two cheat sheets stored in the application.![image](https://i.ibb.co/sq8nkp8/image.png)
Example:
* `/clear`
___

<a id="manipulation-command-type"></a>
## 4.2. Manipulation Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
After adding cheatsheets, you may realize some of them need editing. Manipulation commands allow you to modify the properties of a specific cheatsheet in the List.

___

<a id="edit-command"></a>
### 4.2.1. Editing a cheatsheet: `/edit` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 


>Format: `/edit /n CHEATSHEET_NAME /i CHEATSHEET_INDEX` <br>
>Flag optionality: [`/n`, `/i`] (At least one)

After `/edit` command is called, the Editor will pop up and then you can edit the cheatsheet in the List with name matching `CHEATSHEET_NAME` or index matching `CHEATSHEET_INDEX` whichever you included (it will try to match the name if you included both). After you are done editing and close the Editor, the expected result is similar to below if a matching cheatsheet is found and the edited description is not blank.
![image](https://i.ibb.co/c8xq2wY/image.png)
When either the name or index do not match, the Editor does not pop up and CheatLogs will specify the error as shown below.
![image](https://i.ibb.co/rZ6Rhgn/image.png)

CheatLogs does not allow you to save empty saved descriptions. In this case, the cheatsheet is not saved and maintains its previous details. Below is the error message shown on the CLI.
![image](https://i.ibb.co/5k953cy/image.png)
Examples:
* `/edit/n switch /i 2`
* `/edit /i 3` 
* `/edit /n commands`

____

<a id="favourite-command"></a>
### 4.2.2. Favouriting a cheatsheet: `/fav` <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 

>Format: `/fav /n CHEATSHEET_NAME /i CHEATSHEET_INDEX` <br>
>Flag optionality: [`/n`, `/i`] (At least one)

If you have some cheat sheets which are used frequently, you can mark them as favourite so that those cheat sheets will be always displayed on the top of the List. `/fav` marks the cheatsheet with name matching `CHEATSHEET_NAME` or index matching `CHEATSHEET_INDEX` whichever you included or both if you included both.  The expected result is similar to below if a matching cheatsheet is found.
![image](https://i.ibb.co/VW5JZNx/image.png)
When either the name or index do not match, Cheatlogs will specify the error as shown below.
![image](https://i.ibb.co/vPgbnbW/image.png)
Favourted cheatsheets show up a the top of  `/list` command table, with an [*] beside it's name as shown below beside `loops`.  This allows you to easily identify your favourite cheatsheets. 
![image](https://i.ibb.co/XWztfyX/image.png)
Examples:
* `/fav/n Integer /i 2`
* `/fav/i 1` 
* `/fav/n string`


___

<a id="viewing-command-type"></a>
## 4.3. Viewing Commands: <font size="5"> [:arrow_up_small:](#table-of-contents)</font>

These are commands that allow you to quickly look up the List for the cheatsheets you want.

  

Some of these commands present their results in a table form and allow you to sort the results through various filters provided. We will call this **Sorting Mode**.

  

In Sorting Mode, cheat sheets are originally shown in the order they were found inside the List. You can then sort them in [lexicographical order](https://en.wikipedia.org/wiki/Lexicographic_order#:~:text=In%20mathematics%2C%20the%20lexicographic%20or,of%20a%20totally%20ordered%20set.) according to any of the cheatsheet properties. For example , sorting by descending name means to enter`3`in this mode and an illustration of expected output is the image below. To exit this mode, enter anything that is not valid.

![image](https://i.ibb.co/F7fHTvs/image.png)

---

<a id="find-command"></a>
### 4.3.1. Locating cheatsheets with pattern : `/find`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 


>Format: `/find /s <SUBJECT> /k <KEYWORD>` <br>
>Flag optionality: [`/s`, `/k`] (At least one)

Matches and displays a table of cheatsheets from the List whose subject contains `SUBJECT` or description contains `KEYWORD` whichever you included or both if you included both. The expected result is similar to below if matching cheatsheets are found.![image](https://i.ibb.co/7N3w0wQ/image.png)

CheatLogs then enters Sorting Mode. And resumes after you end it.![image](https://i.ibb.co/7N3w0wQ/image.png)

If there are no matches, the output is similar to below and CheatLogs does not enter Sorting Mode.
![image](https://i.ibb.co/t2MT44f/image.png)

> :bulb:  Notes on matching algorithm
> * The search is **case-sensitive** e.g. `help` matches `helpers` but not `Help`. 
> * A match contains the search term as a substring. e.g. `java` matches `java11` and  `Tricks for java`

Examples:
* `/find /s loop`
* `/find /s Integer /k 2`
* `/find /k 1`

 ---
 
<a id="view-command"></a>
### 4.3.2. Viewing a specific cheatsheet: `/view`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
>Format: `/view/n CHEATSHEET_NAME /i CHEATSHEET_INDEX` <br>
>Flag optionality: [`/n`, `/i`] (At least one)

Views and prints the details of the cheatsheet with name matching `CHEATSHEET_NAME` or index matching `CHEATSHEET_INDEX` whichever you included or both if you included both.  The expected result is similar to below if a matching cheatsheet is found.

![image](https://i.ibb.co/9ZttT68/image.png)
When either the name or index do not match, CheatLogs will specify the error as shown below.
![image](https://i.ibb.co/28XQVZL/image.png)
Examples:
* `/view/n Read /i 2`
* `/view/i 1` 
* `/view/n documentation`

---

<a id="list-command"></a>
### 4.3.3. Listing all cheatsheets: `/list`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 

>Format: `/list`

Lists all the cheatsheets in the List in a table. CheatLogs then enters sorting mode. The program continues after returning. The image below illustrated what you may see after executing the command successfully.
 ![image](https://i.ibb.co/C7ztqZz/image.png)
Example:
 *  `/list`

<a id="general-command-type"></a>
## 4.4. General Commands:  <font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
These are useful general purpose commands that don't fit into the other categories but are still very useful for you to know.

---

<a id="help-command"></a>
### 4.4.1 Viewing help: `/help`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
>Format: `/help`
>
Lists all the possible commands that can be executed in the application and formating information. Below is what you should expect to see.

![image](https://i.ibb.co/ZYn38J5/image.png)

Example:
* `/help`
---

<a id="settings-command"></a>
### 4.4.2 Change program settings: `/set`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
>Format: `/set /c COLORSCHEME`
>Flag optionality: `/c`(required) 

Changes the settings of CheatLogs. Currently, only the color scheme of output text can be changed. You can change to any of the 3 additional color scheme options available numbering from 1 to 3 and CheatLogs switch to the one matching `COLORSCHEME`. The image below shows the result of a successful change.

![image](https://i.ibb.co/5GFvnHb/image.png)

Settings outside the available range default to color scheme 0.(this behavior is to be changed in future iterations)

> :exclamation: The colors will likely vary depending on the terminal that you use and differ from the one shown. We suggest simply picking the most readable one.
 
  Example:   
 * `/set /c 2`

---

<a id="exit-command"></a>
### 4.4.3 Exiting the program: `/exit`<font size="5"> [:arrow_up_small:](#table-of-contents)</font> 
>Format: `/exit`

Exits the application. CheatLogs hopes you will open it again.

 Examples:   
 * `/exit`

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

<a id="faq"></a>
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
