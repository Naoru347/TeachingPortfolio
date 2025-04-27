# Lab 6 – Command Line Scavenger Hunt

## Overview

In this lab, you'll explore core system-level concepts by using common command line tools to examine operating system internals. You'll use basic **Linux commands** inside a pre-configured **Linux virtual machine (VM)** provided by your instructor. This VM will be run in **VirtualBox** on lab computers.

This scavenger hunt builds your comfort with the command line, improves your troubleshooting skills, and lays the foundation for tasks like log analysis, process monitoring, and system auditing.

---

## Objectives
By the end of this lab, you should be able to:
- Navigate a file system using command line tools
- List and describe running processes
- Inspect user accounts and group permissions
- View startup programs and scheduled tasks
- Identify system configurations and logs

---

## Setup Instructions
1. Launch **VirtualBox** from your lab desktop.
2. Select and start the provided Linux VM (your instructor will specify the filename and configuration).
3. Log in using the credentials provided on the board or in the LMS.
4. Open a terminal window to begin the scavenger hunt.

---

## Instructions
You may work **individually or in pairs** for this lab. Answer each question below by running the appropriate command in the Linux VM and briefly describing what it does.

Complete your answers in the worksheet provided on the LMS.

---

### Scavenger Hunt Tasks

#### 📁 File System & Navigation
1. What is the full path to the Desktop directory for the current user?
2. Use a command to list all files, including hidden ones, in your home directory.
3. What command would you use to search for a file called `seclab.txt`?

#### 👷‍♂️ User & Group Information
4. What is the current username and user ID of the logged-in user?
5. List all user accounts on the system.
6. What groups does your user belong to?

#### ⚙️ Processes & Services
7. List all currently running processes.
8. Find the process ID (PID) for the terminal you are using.
9. What command shows system services or daemons?

#### 🌐 Networking & Configuration
10. What is the IP address of your system?
11. List all open network connections and listening ports.
12. Display your system’s hostname and DNS server info.

#### 📋 Logs & Startup Behavior
13. Where are system logs stored on this OS?
14. What command shows recently rebooted or shutdown sessions?
15. List the programs that are set to run at system startup.

---

## Deliverable
- Complete the worksheet provided on the LMS.
- Submit as a PDF via the LMS by **11:59 PM Sunday (Week 6)**.
- Filename: `Lastname_Firstname_Lab6.pdf`

---

## Tips
- Use `man` to learn more about any Linux command.
- Try piping commands through `more` or `less` to make long output easier to read.
- Document your answers as you go to save time later.

This lab is your introduction to the investigative mindset of a security analyst — so dig deep, explore, and take notes on what surprises you!

