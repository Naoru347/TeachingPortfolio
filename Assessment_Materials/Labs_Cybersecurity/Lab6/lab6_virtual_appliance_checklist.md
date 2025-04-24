# ✅ Virtual Appliance Creation & Configuration Checklist  
*For Instructor Use – Lab 6: Command Line Scavenger Hunt*

---

## 🖥 1. Choose Base OS & VirtualBox Specs
- **Base OS:** Ubuntu 22.04 LTS (Desktop)
- **VM Specs:**
  - **RAM:** 1024 MB
  - **Disk:** 10 GB dynamically allocated
  - **CPU:** 1 core
  - **Network Adapter:** NAT or Bridged

---

## 🛠 2. Initial VM Setup
1. Create a new VM in VirtualBox
2. Set hostname: `lab6-student`
3. Create user:
   - **Username:** `student`
   - **Password:** `lab6pass`
4. Enable passwordless sudo for ease of use (optional)

---

## 🌐 3. Network Settings
- Set adapter to **NAT** (or Bridged if static IP needed)
- Confirm internet access works inside VM
- Optional: Set a static IP if desired for scan repeatability

---

## 🔧 4. Install Required Tools
```bash
sudo apt update && sudo apt install -y \
  net-tools iproute2 psmisc procps whois dnsutils \
  lsof man file tree less curl wget zip unzip \
  openssh-server bash-completion systemd htop neofetch
```

---

## 🧪 5. Seed the Environment with Discoverables

### Files & Hidden Content
- Create a working directory:
```bash
mkdir ~/Lab6 && cd ~/Lab6
```
- Add files:
```bash
echo 'This is the target file' > seclab.txt
mkdir .hidden && echo 'Secret notes' > .hidden/notes.txt
```

### Users & Groups
- Create a low UID user manually (non-system):
```bash
sudo useradd -u 850 legacyuser
```
- Add `student` to `sudo` and `wireshark` groups:
```bash
sudo usermod -aG sudo,wireshark student
```

### Services & Processes
- Enable a few services:
```bash
sudo systemctl enable ssh
sudo systemctl enable cups
```
- Start an idle web server (optional):
```bash
sudo apt install -y apache2 && sudo systemctl start apache2
```

### Logs & System History
- Reboot the VM 2–3 times before export to populate `last` log
- Optionally simulate a crash by running `sudo shutdown now` and restarting manually

---

## 📋 6. Clean Up & Export
```bash
history -c
sudo apt clean
sudo rm -rf /tmp/*
sudo poweroff
```

### Export as OVA
- Use: `Lab6_CLI_ScavengerHunt.ova`
- File → Export Appliance → Follow prompts

---

## 🧪 7. Test Import & Checklist
- Import into a clean VirtualBox instance
- Verify:
  - Terminal opens
  - All tools installed
  - `Lab6` directory with seeded files exists
  - All accounts and services behave as expected

---

## 📂 8. Distribution Notes
- Upload `.ova` to LMS or cloud folder
- Provide:
  - Username: `student`
  - Password: `lab6pass`
  - Network adapter setting
  - Brief troubleshooting section for VirtualBox (e.g., login delay, no network)

---

**Use this checklist to ensure each student VM includes consistent, traceable data for command-line discovery.**

