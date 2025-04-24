# ✅ Virtual Appliance Creation & Configuration Checklist  
*For Instructor Use – Lab 6: Command Line Scavenger Hunt*

---

## 🖥 1. Choose Base OS & VirtualBox Specs
- **Base OS:** Ubuntu 22.04 LTS (Desktop or lightweight flavor)
- **VM Specs:**
  - **RAM:** 1024 MB (minimum)
  - **Disk:** 10 GB dynamically allocated
  - **CPU:** 1 core
  - **Video Memory:** 16 MB (3D Acceleration off)
  - **Network Adapter:** NAT or Bridged (for IP commands to work)

---

## 🛠 2. Initial Virtual Machine Setup
1. Create new VM in VirtualBox
2. Name: `CLH-Lab6` or similar
3. Set user credentials:
   - **Username:** `student`
   - **Password:** `lab6pass`
4. Install Guest Additions (optional but helpful)

---

## 🌐 3. Configure Basic Environment
- Ensure internet access for package installs
- Set hostname (optional):
```bash
sudo hostnamectl set-hostname lab6-student
```

---

## 🔧 4. Install Required Tools
Run the following commands:
```bash
sudo apt update
sudo apt install -y net-tools iproute2 psmisc procps whois dnsutils \
  lsof man file tree less curl wget zip unzip \
  openssh-server bash-completion systemd
```

Optional but helpful:
```bash
sudo apt install -y htop neofetch
```

---

## 📁 5. Pre-Create Student Workspace
- Create a `~/Lab6/` directory
- Add a few test files:
```bash
mkdir ~/Lab6
cd ~/Lab6
wget https://example.com/seclab.txt -O seclab.txt
mkdir .hiddenfiles
touch .hiddenfiles/notes.md
```

---

## 📋 6. Clean Up & Prepare for Export
```bash
history -c
sudo apt clean
sudo rm -rf /tmp/*
sudo poweroff
```

---

## 📦 7. Export the VM
1. File → Export Appliance
2. Export as `.ova`
3. Use filename: `CLH_Lab6_VM.ova`

---

## 🧪 8. Test the VM
- Re-import on a clean system
- Verify:
  - Terminal opens
  - All commands from lab work
  - `student` user can access all directories and tools
  - No saved states

---

## 📂 9. Distribute to Students
- Upload `.ova` to LMS or shared drive
- Provide:
  - Username/password
  - Network type used
  - Any startup instructions or troubleshooting tips

