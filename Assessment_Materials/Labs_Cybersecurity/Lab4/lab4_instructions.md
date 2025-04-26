# Lab 4 – Rogue Access Point Identification Simulation

## Overview
This lab focuses on wireless network security and introduces students to one of the most common Wi-Fi-related threats: rogue access points (APs). Rogue APs can be malicious or misconfigured devices that mimic trusted networks or open insecure backdoors into otherwise protected environments.

Working in small groups, students will analyze simulated traffic or system logs to identify telltale signs of rogue APs in a network environment.

---

## Learning Objectives
By the end of this lab, you will be able to:
- Recognize the characteristics of rogue access points
- Analyze wireless network logs and traffic capture data
- Identify suspicious SSIDs, MAC addresses, or network behaviors
- Communicate findings as a collaborative security team

---

## Group Work Instructions
Students will work in groups of **3–4 people**. Each group will submit **one lab report** that reflects their collaborative analysis.

### Step 1: Review the Scenario Packet
Your group will receive a packet containing:
- Simulated Wi-Fi traffic logs (CSV or printed format)
  - traffic_logs.md
- Sample `airodump-ng` output from a basic scan
  - airodump_logs.md
- Network map and authorized device list (MAC addresses, SSIDs)
  - authorized_devices.md
  - network_map.jpg

Take a few minutes as a team to:
- Review what “normal” should look like
- Identify devices and APs that seem unfamiliar, misconfigured, or suspicious

### Step 2: Analyze the Data
As a group, investigate signs of rogue AP activity:
- Duplicate SSIDs with different MACs?
- Open networks using company names?
- Devices connected to strange BSSIDs?
- Abnormally strong signal from unexpected locations?
- Devices appearing with frequent disconnects or unexpected channel activity?

Document any anomalies and discuss how they might indicate a rogue AP or security misconfiguration.

### Step 3: Prepare the Group Report
Your write-up (1–2 pages) should include:
- **Summary of Findings**: Which entries or behaviors were suspicious?
- **Evidence**: Specific lines or details from logs that support your claim
- **Conclusion**: Whether your group believes there was a rogue AP, and why
- **Recommendations**: Steps that could be taken to monitor or prevent rogue AP activity in real-world settings

Use bullet points, tables, or annotated screenshots as needed. Keep it concise but well-reasoned.

---

## Deliverable
Submit a **single PDF** per group containing:
1. A 1–2 page report of your findings and analysis
2. Group member names and roles/contributions (briefly listed at the top or bottom)

**File Naming Convention:** `GroupX_Lab4_RogueAP.pdf` (e.g., Group3_Lab4_RogueAP.pdf)

---

## Suggested Time: 65 minutes
This is an in-class group activity. You are expected to complete your analysis and submit your group’s findings by the end of the lab session.

---

## Optional Tools and Resources
- [How Rogue Access Points Work – TechTarget](https://www.techtarget.com/searchsecurity/definition/rogue-access-point)
- [Kismet Wireless Tool Overview](https://www.kismetwireless.net/)
- [Intro to airodump-ng (Kali Linux Wireless Recon)](https://www.aircrack-ng.org/doku.php?id=airodump-ng)

---

This lab is designed to build your forensic thinking and teamwork skills — essential traits for detecting real-world wireless threats. Your job today is to think like a SOC (Security Operations Center) analyst and flag what doesn’t belong.

