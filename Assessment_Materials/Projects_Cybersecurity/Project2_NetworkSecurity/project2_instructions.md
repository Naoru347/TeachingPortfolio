# Project 2: Network Security & Defense Lab

## Overview
In this project, you will simulate the role of a cybersecurity technician responsible for configuring basic network defenses and analyzing vulnerabilities. You will work in a sandboxed environment using **VirtualBox with pre-configured networked virtual appliances**. This lab environment allows you to practice monitoring and securing a live network with multiple connected machines.

The goal is to help you apply practical defensive strategies using essential cybersecurity tools, understand how to interpret network traffic, and make informed decisions about reducing attack surfaces.

## Scenario
Your organization is preparing to deploy a small internal server network that includes two Linux machines and one simulated client machine. Before it goes live, you’ve been asked to:
- Lock down each system's network access
- Identify vulnerable or unnecessary services across the network
- Monitor traffic between systems
- Ensure only authorized communication is allowed

You’ll complete this task using VirtualBox and the provided VM appliances.

## Tasks
1. **Firewall Configuration**
   - On each Linux VM, install and configure basic firewall rules using `ufw` or `iptables`
   - Deny all incoming traffic by default and allow only essential services (e.g., SSH between machines, ICMP for ping)
   - Provide screenshots of your firewall rule sets and terminal outputs

2. **Traffic Monitoring with Wireshark**
   - Capture traffic between the VMs as you perform simulated actions (e.g., pings, SSH, web access)
   - Apply filters to analyze specific protocols (e.g., TCP, HTTP, ICMP)
   - Identify at least one example of insecure, suspicious, or unnecessary traffic
   - Include 1–2 annotated screenshots of your packet analysis

3. **Vulnerability Scanning with Nmap**
   - Run a scan (`-sV`, `-A`, or `-Pn`) across the network to identify open ports and running services on all VMs
   - Interpret the results to assess which services are necessary, and which should be closed
   - Justify any firewall rule changes you would make based on the findings
   - Include your command(s), output, and brief interpretation

4. **Recommendations & Documentation**
   - Summarize your configuration and findings in a **1–2 page narrative**
   - Discuss:
     - Firewall strategies used across the machines
     - Key vulnerabilities or misconfigurations identified
     - Wireshark analysis and suspicious findings
     - Nmap output and resulting decisions
   - Use screenshots, filtered logs, and code snippets where helpful

## Deliverables
- Narrative report (1–2 pages), written in **collegenAPA format**, including:
  - 12-point Times New Roman, Arial, Garamond, or Aptos font, double-spaced text, and 1-inch margins
  - Clear section headings
  - In-text citations for any sources used (e.g., manuals, documentation, external references)
  - A references page with proper APA formatting
- Screenshots of:
  - Firewall rules on each VM
  - Wireshark packet analysis
  - Nmap scan results
- Any configuration files or scripts used (if applicable)
- Submit all materials in a zipped folder or single PDF document through the LMS

## Tools & Environment
- **VirtualBox with Instructor-Provided Networked VM Appliances** (Required)
- You will receive:
  - Two Linux virtual appliances (e.g., Ubuntu/Kali)
  - One client virtual appliance (simulated user machine)
  - Instructions for importing and networking them in VirtualBox (host-only or internal network mode)
- **Required Tools:** Wireshark, Nmap, ufw/iptables

## Evaluation Criteria
| **Criterion**         | **Description**                                                                                     | **Weight** |
|-----------------------|-----------------------------------------------------------------------------------------------------|------------|
| **Configuration**     | Firewall rules applied correctly and explained with rationale                                       | 25%        |
| **Analysis**          | Interprets Nmap and Wireshark results clearly, identifies risks and relevant traffic               | 30%        |
| **Documentation**     | Narrative is complete, clear, and accurately describes process and decisions                        | 25%        |
| **Professionalism**   | Screenshots and formatting are clear; submission is complete and well-organized                    | 20%        |

## Tips for Success
- Take screenshots and notes during configuration and scanning
- Be ready to explain *why* you allowed or denied specific services
- Ensure your terminal outputs and packet captures are legible and annotated
- Follow ethical scanning practices: only scan the instructor-provided VMs
- Reach out if you have trouble setting up the network in VirtualBox

**This project emphasizes practical, real-world skills that are directly transferable to entry-level cybersecurity work. Treat it like your first network hardening assignment — and good luck!**

