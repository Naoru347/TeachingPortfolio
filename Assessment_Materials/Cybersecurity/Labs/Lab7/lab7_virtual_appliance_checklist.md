# ✅ Lab 7 – Instructor Virtual Appliance Setup Checklist
*For Instructor Use: Preparing the Hardening Lab Environment (Lab 7)*

This checklist guides you through the creation and configuration of a Linux virtual appliance that students will use to complete their hardening checklist. Ensure each step below is completed so students have meaningful data and misconfigurations to find and fix.

---

## 🖥 1. Base VM Configuration
- **Base OS**: Ubuntu 22.04 LTS Desktop (preferred)
- **VirtualBox Settings**:
  - RAM: 1024 MB
  - Disk: 15 GB (dynamically allocated)
  - CPU: 1 core
  - Network: NAT

## 🔧 2. User Accounts
- Create default user:
  - Username: `UbuntuSA`
  - Password: `Humanity2Others!`
  - Add to `sudo` group

- Create **guest account**:
  - Username: `guest`
  - Password: `guest123`
  - Home directory: `/home/guest`
  - Do NOT lock or delete — students will do this

- Create **additional dummy user**:
  - Username: `tempuser`
  - UID: 850
  - Purpose: Let students identify and assess unusual accounts

## 🔄 3. Package State
- Run:
```bash
sudo apt update
```
- DO NOT run `apt upgrade` — leave ~3 packages outdated
- Example: Hold back `bash`, `curl`, or `openssl`

## ⚙️ 4. System Services
- Ensure the following are enabled:
  - `cups.service` (printing)
  - `ssh.service`
- Ensure these are **running**:
```bash
sudo systemctl enable --now cups.service ssh.service
```
- Bonus: Install and enable one extra unnecessary service (e.g., `avahi-daemon`)

## 🔐 5. Password Policy Configuration
- Open `/etc/login.defs` and set weak policy:
```text
PASS_MAX_DAYS   99999
PASS_MIN_DAYS   0
PASS_WARN_AGE   7
```
- Leave default `chage` settings unchanged for `student` account

## 🗃 6. File Permissions & SUID Files
- Create SUID file:
```bash
touch /usr/local/bin/suspicious
chmod 4755 /usr/local/bin/suspicious
```
- Ensure `/home/student` has standard permissions (no sticky bits, no open permissions)
- Bonus: Add hidden file in home directory: `.secret.txt`

## 📝 7. System Logs
- Simulate failed logins:
```bash
su - wronguser
# enter incorrect passwords multiple times
```
- Reboot the VM 2–3 times to populate logs

## 🧼 8. Cleanup Before Export
```bash
history -c
sudo apt clean
sudo rm -rf /tmp/*
sudo poweroff
```

## 📦 9. Export the VM
- File → Export Appliance → `.ova`
- Filename: `Lab7_Hardening_VM.ova`

## ✅ 10. Test the OVA
- Import and verify:
  - Students can log in with `student`/`lab7pass`
  - Guest account exists and is unlocked
  - Dummy user `tempuser` is visible in `/etc/passwd`
  - Services like `cups` and `ssh` are active
  - Weak password policies are in place
  - Hidden/SUID files can be found

---

**This appliance is designed to simulate a system in need of basic security review. Students should be able to detect and harden each of these elements using commands from their reference sheet.**

