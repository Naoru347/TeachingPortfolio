# Lab 7 – Student Worksheet: Hardening a Linux System

## Instructions
Use this worksheet to guide your progress through the Lab 7 hardening checklist. Follow the prompts for each section, document your findings, and describe any configuration changes you make. Submit a completed version as a PDF by **11:59 PM Sunday (Week 7)** on the LMS.

---

## Student Information
**Name:** _________________________  
**Date:** __________________________

---

## Section 1: System Update and Patch Management

✅ **Task 1.1:** Update the package index and upgrade all installed packages.  
**Command Used:**
```

```
**Summary of Output:**

**Any packages upgraded?** Yes / No  

---

## Section 2: Account and Access Control

✅ **Task 2.1:** Identify and lock or delete the guest account.  
**Was guest account present?** Yes / No  
**Action Taken (and command used):**

✅ **Task 2.2:** List all user accounts and identify suspicious entries.  
**Command Used:**

**Did you find any unexpected users? If yes, explain:**

✅ **Task 2.3:** Check user group memberships for elevated permissions.  
**Command Used:**

**Does your user belong to the `sudo` group?** Yes / No  
**Are there any unexpected admin-level users?**

---

## Section 3: Service & Daemon Hardening

✅ **Task 3.1:** List and identify all enabled services.  
**Command Used:**

**Any unnecessary services found? Which ones?**

✅ **Task 3.2:** Disable at least one unnecessary service.  
**Service Disabled:**
**Command Used:**

---

## Section 4: Password Policies

✅ **Task 4.1:** Review the password aging policy.  
**Command Used:**

**Current settings for PASS_MAX_DAYS, PASS_MIN_DAYS, PASS_WARN_AGE:**

✅ **Task 4.2:** Use `chage` to view your account’s password expiration.  
**Command Used:**

**Summary of output:**

---

## Section 5: Permissions and Files

✅ **Task 5.1:** List home directory contents with permissions.  
**Command Used:**

✅ **Task 5.2:** Find all SUID files on the system.  
**Command Used:**

**Any unusual files discovered? If yes, note the path(s):**

---

## Section 6: Log Files and System History

✅ **Task 6.1:** View recent authentication logs.  
**Command Used:**

**Any notable login attempts or errors?**

✅ **Task 6.2:** Review system logs for errors.  
**Command Used:**

**Describe one error or event you observed:**

---

## Reflection
**What is one thing you learned about Linux security hardening from this lab?**

**Was there anything you found surprising or confusing?**

**How confident are you now in applying these techniques on another system? (1–5):** ___

---

**Save and upload your completed worksheet to the LMS as `Lastname_Firstname_Lab7.pdf`.**

