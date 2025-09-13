# Lab 7 – Command Reference Sheet: Basic Linux Hardening

This reference sheet provides the essential Linux commands you’ll need for Lab 7. Each command includes a brief description, its syntax, and an example with sample output where applicable.

---

## 🔄 System Updates

### `sudo apt update && sudo apt upgrade`
**Description:** Refreshes package list and installs available updates.  
**Syntax:**
```bash
sudo apt update && sudo apt upgrade -y
```
**Example Output:**
```bash
Get:1 http://security.ubuntu.com/ubuntu focal-security InRelease [114 kB]
Reading package lists... Done
The following packages will be upgraded: bash openssl
...
```

---

## 👤 User and Account Management

### `sudo passwd -l guest`
**Description:** Locks the guest account to prevent logins.  
**Syntax:**
```bash
sudo passwd -l [username]
```
**Example Output:**
```bash
passwd: password expiry information changed.
```

### `sudo userdel -r username`
**Description:** Deletes a user and their home directory.  
**Syntax:**
```bash
sudo userdel -r [username]
```
**Example:**
```bash
sudo userdel -r testuser
```

### `cat /etc/passwd`
**Description:** Lists all user accounts on the system.
**Example Output:**
```bash
student:x:1000:1000:Student,,,:/home/student:/bin/bash
guest:x:1001:1001:Guest Account,,,:/home/guest:/bin/bash
```

---

## 🔧 Services and Startup

### `systemctl list-unit-files --type=service`
**Description:** Lists services and their startup status.  
**Example Output:**
```bash
ssh.service                          enabled
cups.service                         disabled
```

### `sudo systemctl disable service-name`
**Description:** Disables a service from starting on boot.  
**Example:**
```bash
sudo systemctl disable cups.service
```

---

## 🔐 Password and Authentication

### `sudo nano /etc/login.defs`
**Description:** Opens configuration for password aging policies.  
**Edit lines like:**
```text
PASS_MAX_DAYS   90
PASS_MIN_DAYS   7
PASS_WARN_AGE   14
```

### `sudo chage -l username`
**Description:** Displays password aging information for a user.  
**Example:**
```bash
sudo chage -l student
```
**Example Output:**
```bash
Last password change                    : Sep 10, 2025
Password expires                        : Dec 09, 2025
```

---

## 🔒 Permissions and File Inspection

### `ls -la /home`
**Description:** Lists all user home directories with permissions.

### `find / -perm -4000 -type f 2>/dev/null`
**Description:** Finds files with the SUID bit set (can be a security risk).

---

## 📋 Log and Audit

### `sudo less /var/log/auth.log`
**Description:** Views authentication logs.

### `sudo journalctl --priority=err`
**Description:** Views system error messages.

---

Use this reference as a guide while working through the hardening checklist. When in doubt, use `man [command]` to learn more.

