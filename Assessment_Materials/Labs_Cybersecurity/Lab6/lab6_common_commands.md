# Lab 6 – Command Line Reference Sheet (Linux)

Use this sheet to help complete the Lab 6 scavenger hunt. It includes commonly used Linux commands, their purpose, syntax, and examples.

---

## 📁 File System & Navigation

### `pwd`
**Purpose:** Print the current working directory.  
**Syntax:** `pwd`  
**Example:**
```bash
$ pwd
/home/student
```

### `ls`
**Purpose:** List files and directories.  
**Syntax:** `ls [options] [path]`  
**Example:**
```bash
$ ls -la ~
```

### `find`
**Purpose:** Search for files in a directory hierarchy.  
**Syntax:** `find [path] -name [filename]`  
**Example:**
```bash
$ find /home/student -name seclab.txt
```

---

## 👷‍♂️ User & Group Info

### `whoami`
**Purpose:** Show current logged-in user.  
**Syntax:** `whoami`  
**Example:**
```bash
$ whoami
student
```

### `id`
**Purpose:** Show user ID (UID), group ID (GID), and group memberships.  
**Syntax:** `id`  
**Example:**
```bash
$ id
uid=1000(student) gid=1000(student) groups=1000(student),27(sudo)
```

### `cat /etc/passwd`
**Purpose:** View user accounts.  
**Syntax:** `cat /etc/passwd`  
**Example:**
```bash
$ cat /etc/passwd | grep bash
```

### `groups`
**Purpose:** Show current user's groups.  
**Syntax:** `groups`  
**Example:**
```bash
$ groups
student sudo
```

---

## ⚙️ Processes & Services

### `ps aux`
**Purpose:** View all running processes.  
**Syntax:** `ps aux`  
**Example:**
```bash
$ ps aux | grep bash
```

### `top` or `htop`
**Purpose:** Monitor real-time processes.  
**Syntax:** `top` or `htop` (if installed)  
**Example:**
```bash
$ top
```

### `systemctl`
**Purpose:** Manage or query system services (for systemd systems).  
**Syntax:** `systemctl [command] [service]`  
**Example:**
```bash
$ systemctl status ssh
```

---

## 🌐 Networking

### `ip a`
**Purpose:** Show IP addresses and interfaces.  
**Syntax:** `ip a`  
**Example:**
```bash
$ ip a
```

### `netstat -tuln` or `ss -tuln`
**Purpose:** Show open ports and listening services.  
**Syntax:** `ss -tuln`  
**Example:**
```bash
$ ss -tuln
```

### `hostnamectl`
**Purpose:** Show or set system hostname.  
**Syntax:** `hostnamectl`  
**Example:**
```bash
$ hostnamectl
```

### `cat /etc/resolv.conf`
**Purpose:** View DNS resolver settings.  
**Syntax:** `cat /etc/resolv.conf`  
**Example:**
```bash
$ cat /etc/resolv.conf
```

---

## 📋 Logs & Startup

### `ls /var/log`
**Purpose:** View log directory contents.  
**Syntax:** `ls /var/log`  
**Example:**
```bash
$ ls /var/log
```

### `last` or `last reboot`
**Purpose:** Show recent logins or reboots.  
**Syntax:** `last` or `last reboot`  
**Example:**
```bash
$ last reboot
```

### `systemctl list-unit-files --type=service`
**Purpose:** Show all services and their startup status.  
**Syntax:** `systemctl list-unit-files --type=service`  
**Example:**
```bash
$ systemctl list-unit-files --type=service | grep enabled
```

---

Feel free to refer to this sheet as you complete the scavenger hunt and use the `man [command]` or `--help` options to learn more about any unfamiliar command.