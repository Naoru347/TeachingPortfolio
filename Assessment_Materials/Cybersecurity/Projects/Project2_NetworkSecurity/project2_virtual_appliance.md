# VirtualBox Lab Setup Guide: Importing & Configuring Cybersecurity VMs

This guide walks you through the process of importing and configuring your instructor-provided virtual appliances in **VirtualBox** for Project 2. These virtual machines (VMs) are preconfigured to simulate a basic internal network of Linux servers and a client device.

---

## ✅ What You'll Need
- A laptop or desktop computer with at least **8 GB RAM** and **30 GB of free disk space**
- **VirtualBox** installed (latest version recommended)
- Instructor-provided virtual appliance files (e.g., `.ova` or `.vdi` bundles)
- A stable internet connection for download and updates

---

## 📦 Step 1: Install VirtualBox

If you don’t already have VirtualBox installed:

1. Visit [https://www.virtualbox.org](https://www.virtualbox.org)
2. Download the installer for your operating system (Windows, macOS, or Linux)
3. Run the installer and follow the on-screen instructions

Optional but recommended: Install the **VirtualBox Extension Pack** for additional features (USB support, etc.)

---

## 🗂 Step 2: Import the Virtual Appliances

You will receive 2–3 `.ova` files (or zipped `.vdi` and `.vbox` files) for the following machines:
- `Server01.ova` (Linux server)
- `Server02.ova` (Linux server)
- `Client01.ova` (optional user/client system)

To import each `.ova` file:

1. Open VirtualBox
2. Go to **File → Import Appliance**
3. Browse to the `.ova` file and click **Next**
4. Review the settings (leave defaults unless told otherwise)
5. Click **Import** and wait for the process to complete

Repeat this process for each provided VM.

---

## 🌐 Step 3: Set Up the Internal Network

To allow the VMs to communicate securely in isolation, we’ll use the **Internal Network** mode:

1. Select each VM and click **Settings → Network**
2. In **Adapter 1**:
   - Set **Attached to**: `Internal Network`
   - Name the network: `CyberLabNet`
   - Leave other settings at default unless instructed
3. Click **OK**

Repeat this for all VMs you’ve imported. They must all share the same internal network name (`CyberLabNet`).

---

## 🚀 Step 4: Start Your VMs

1. Start each VM using the **Start** button
2. Log in using credentials provided by your instructor (e.g., `student` / `cyberlab2024`)
3. Verify network connectivity:
   - On one VM, open a terminal and type: `ping 192.168.56.102` (replace with another VM’s IP)
   - Use `ip a` or `ifconfig` to check IPs of each machine

If pings succeed, your network is set up correctly.

---

## 🛠 Step 5: Tools Check

Each VM should have the following tools installed:
- `ufw` or `iptables`
- `nmap`
- `wireshark`

If any tools are missing, use the following commands:

```bash
sudo apt update
sudo apt install nmap ufw wireshark
```

Note: Wireshark may ask to install non-root permissions for packet capturing. You may need to run as root or add your user to the `wireshark` group.

---

## 🧾 Tips for Smooth Setup
- Always **shut down VMs gracefully** (don’t force close)
- **Take snapshots** before starting configurations so you can roll back
- Keep **VirtualBox up to date** to avoid compatibility issues
- Ask for help if your network adapters don’t work as expected

---

## 🧠 Final Checks Before You Begin
- ✅ All VMs imported and start without errors
- ✅ All VMs are connected to the same internal network
- ✅ You can ping between the machines
- ✅ Required tools are installed and launching properly

Once your environment is ready, you can begin work on Project 2.

If you encounter any issues, bring screenshots and error messages to class or office hours.

---

**Remember:** These VMs are isolated for your safety and the safety of others. Never scan or attack systems outside the lab environment.

Good luck, and have fun learning how to secure networks like a pro!

