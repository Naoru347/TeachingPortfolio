# ✅ Virtual Appliance Creation & Configuration Checklist  
*For Instructor Use – Project 2: Network Security & Defense*

---

## 🖥 1. Choose a Base OS for Each VM
- Recommended OS:
  - **Ubuntu Server** or **Ubuntu Desktop (lightweight)**
  - **Kali Linux** (for attacker-style or scanning machines)
- VM Specs:
  - **RAM**: 1024–2048 MB
  - **Disk**: 10–15 GB dynamically allocated
  - **Processor**: 1 core
  - **Video**: 16 MB, 3D Acceleration off
  - **Network**: Internal Network → `CyberLabNet`

---

## 🛠 2. Initial VM Setup in VirtualBox
1. Create new VMs for:
   - `Server01`: Simulated Linux server with open services
   - `Server02`: Logging or backup node
   - `Client01`: User workstation (optional GUI)
2. Set the **network adapter** to `Internal Network` with the name `CyberLabNet`
3. Install OS and create user: `student` / `cyberlab2024`

---

## 🌐 3. Set Static IP Addresses
For each VM, configure a static IP (so scans and firewall rules are consistent):
- Example IPs:
  - Server01 → `192.168.56.101`
  - Server02 → `192.168.56.102`
  - Client01 → `192.168.56.103`
- Modify `/etc/netplan/*.yaml` (Ubuntu) or equivalent

---

## 🔧 4. Install Required Tools
```bash
sudo apt update
sudo apt install -y nmap wireshark net-tools ufw iptables openssh-server curl wget
```
Add `student` to Wireshark group:
```bash
sudo dpkg-reconfigure wireshark-common
sudo usermod -aG wireshark student
```

---

## 🔓 5. Introduce Deliberate Vulnerabilities (Optional)
On `Server01`, install and start basic services:
```bash
sudo apt install apache2 vsftpd
sudo ufw allow 22 80 8080
sudo systemctl enable apache2 vsftpd
```
- Leave UFW disabled — students will configure it
- Leave shared passwords, open ports, or outdated packages if desired

---

## 🔐 6. Setup Logging or Monitoring on Server02 (Optional)
- Configure `rsyslog`, enable logging ports, or install monitoring tools
- Optionally simulate a partially hardened machine with basic defenses

---

## 📸 7. Test the Lab Network
1. Boot all VMs
2. Confirm network visibility:
```bash
ping 192.168.56.102
nmap 192.168.56.0/24
```
3. Test SSH and web access from other machines

---

## 🧼 8. Clean Up Before Export
```bash
history -c
sudo apt clean
sudo rm -rf /tmp/*
```
- Shut down the VM cleanly (do not save state)

---

## 📦 9. Export Virtual Appliances
1. In VirtualBox: File → Export Appliance
2. Select VM → choose `.ova`
3. Use descriptive filenames:
   - `CyberLab_Server01.ova`, etc.

---

## 🧪 10. Test the Exports
- Import each `.ova` on a different machine or profile
- Verify:
  - Boot success
  - IP addresses persist
  - Student credentials work
  - Services and tools are intact

---

## 📂 11. Distribute to Students
- Upload to LMS or shared drive
- Provide:
  - This setup guide
  - IP map
  - Credentials
  - Required tasks