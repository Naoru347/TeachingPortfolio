# Lab 10 – Firewall Policy Drafting

## Overview
In this lab, you'll act as a junior network security analyst tasked with writing basic firewall rules for a fictional small business. You'll receive a network diagram, a list of devices and services, and a set of business requirements. Your job is to develop a **firewall policy** that balances security with functionality. You'll write high-level rules and translate them into **example UFW syntax** (Uncomplicated Firewall – used in Ubuntu).

This exercise builds your understanding of firewall concepts such as traffic filtering, port control, and service-based access rules. You'll also gain experience translating security requirements into actionable configurations.

---

## Objectives
By the end of this lab, you will be able to:
- Identify and justify traffic that should be allowed or denied on a small network
- Write clear, basic firewall rules to enforce access control
- Apply network security principles such as least privilege and defense-in-depth

---

## Scenario: Metro Books – Independent Bookstore with Online Orders
**Metro Books** is a small independent bookstore with both a retail storefront and a growing online order system. The business operates a basic IT environment that includes the following:

### Network Devices:
- **Storefront POS System** (192.168.10.10)
- **Inventory Server** (192.168.10.20)
- **Public Web Server** (192.168.10.30) – hosts the online catalog
- **Employee Workstations** (192.168.10.50–192.168.10.60)
- **Guest Wi-Fi Router** (isolated network)
- **Management PC** (192.168.10.100)

### Business Requirements:
- POS System must access Inventory Server on TCP port 3306 (MySQL)
- Public Web Server must be accessible from the internet (TCP 80 and 443)
- Employees should access the Web Server internally via port 443
- Management PC must have full access to all internal systems
- All systems should be updated via the Ubuntu APT repository (TCP 80/443 to `security.ubuntu.com`)
- Block all other traffic by default

---

## Tasks
1. **Write a high-level firewall policy** (e.g., Allow POS → Inventory on port 3306)
2. **Translate each rule into UFW syntax**, for example:
```bash
sudo ufw allow from 192.168.10.10 to 192.168.10.20 port 3306 proto tcp
```
3. **Document your justification** for each rule — why is it needed, what risk does it manage?
4. **List default deny rules** (e.g., deny all other inbound/outbound traffic)
5. **Bonus**: Add logging rules or a command to review active rules

---

## Deliverable
- Submit your answers in the provided worksheet
- Upload as a PDF to LMS by **11:59 PM Sunday (Week 10)**
- Filename: `Lastname_Firstname_Lab10.pdf`

---

## Materials Provided
- Network diagram (see LMS)
- IP table with device assignments
- UFW reference handout

---

## Tip
- Start with high-level logic before jumping into syntax
- Apply the principle of least privilege: allow only what’s needed
- Test your rules in your own VM environment with `sudo ufw status verbose`

---

**Good firewall policies reduce risk, support business operations, and make troubleshooting easier. Draft yours thoughtfully!**

