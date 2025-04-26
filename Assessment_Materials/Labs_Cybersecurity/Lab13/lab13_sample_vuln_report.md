# 🔢 Sample Vulnerability Report Excerpt

**Target Host:** 192.168.10.30 (Web Server)  
**Scan Date:** Week 13 Lab Environment  
**Scanner:** Simulated Nessus/OpenVAS Output

---

## 🔶 Finding 1: OpenSSH Server Version Outdated
- **Risk:** High (CVSS 8.2)
- **Description:** The OpenSSH server version is vulnerable to multiple security issues including buffer overflow vulnerabilities that could allow remote code execution.
- **Evidence:** SSH Banner detected: OpenSSH_7.2p2 Ubuntu-4ubuntu2.10
- **Remediation:** Update to the latest supported OpenSSH server version.

---

## 🔶 Finding 2: HTTP Strict Transport Security (HSTS) Not Enabled
- **Risk:** Medium (CVSS 6.5)
- **Description:** The web server does not enforce HTTPS-only connections, exposing users to man-in-the-middle attacks.
- **Evidence:** HTTP response headers show absence of "Strict-Transport-Security" header.
- **Remediation:** [Students must propose]

---

## 🔶 Finding 3: MySQL Server Accessible to External Networks
- **Risk:** Critical (CVSS 9.0)
- **Description:** The MySQL database is accessible over the public internet, greatly increasing the risk of unauthorized access and database compromise.
- **Evidence:** Port 3306 open to 0.0.0.0/0 (detected via Nmap scan)
- **Remediation:** [Students must propose]

---

## 🔶 Finding 4: Outdated PHP Version Detected
- **Risk:** High (CVSS 8.0)
- **Description:** The server is running an outdated version of PHP with known vulnerabilities including remote code execution and information disclosure.
- **Evidence:** PHP Version: 7.0.33
- **Remediation:** [Students must propose]

---

## 🔶 Finding 5: Anonymous FTP Login Enabled
- **Risk:** Medium (CVSS 6.8)
- **Description:** The FTP server allows anonymous (unauthenticated) logins, exposing potentially sensitive files.
- **Evidence:** FTP Banner detected; anonymous login successful during scan.
- **Remediation:** [Students must propose]

---

## 🔶 Finding 6: Weak TLS/SSL Cipher Suites Supported
- **Risk:** Medium (CVSS 6.0)
- **Description:** The server supports outdated SSL/TLS cipher suites vulnerable to cryptographic attacks (e.g., SWEET32, POODLE).
- **Evidence:** SSL/TLS scan results show support for TLS 1.0 and weak ciphers like DES-CBC3-SHA.
- **Remediation:** [Students must propose]

---

## 🔶 Finding 7: Default Credentials Detected on Admin Interface
- **Risk:** Critical (CVSS 9.8)
- **Description:** A known administrative panel (e.g., phpMyAdmin) is accessible with default credentials (admin/admin123), leaving the system highly vulnerable.
- **Evidence:** Successful login detected during automated credential test.
- **Remediation:** [Students must propose]

---

# 🔹 Instructions for Students
Using this sample report:
- Complete the prioritization, remediation, and critical analysis tasks outlined in the Lab 13 worksheet.
- Remember to think about **business risk**, not just technical severity!

