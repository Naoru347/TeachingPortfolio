# 📟 Incident Scenario Packet: Ransomware Attack on NovaHealth Solutions

---

## 📅 Incident Timeline
- **Date:** Thursday, November 14
- **Time:** 7:30 AM (first alerts)
- **Discovery:** 8:15 AM (IT Support Ticket)
- **Escalation:** 8:30 AM (Reported to IT Manager)

---

## 📁 Initial Observations

**Reported by:** Morning shift staff

- Multiple employees could not access critical files on the shared drive (\ServerFiles\ClientData)
- Files had unusual extensions appended (e.g., `.locked`, `.novaext`)
- Pop-up messages appeared on some computers demanding Bitcoin payment for decryption keys
- Internal CRM application hosted on `crm.novahealth.local` was inaccessible
- Some desktop backgrounds replaced with ransom demands titled "_NovaHealthDataLocked.png_"

---

## 📂 Affected Systems
- **Shared File Server:** `FS01.novahealth.local`
- **CRM Application Server:** `CRM01.novahealth.local`
- **Several Windows 10 workstations** (unknown total impact)
- **One cloud-based backup repository** (AWS S3 bucket linked to FS01) shows missing or corrupted recent backups

---

## 📉 Symptoms Summary
- Loss of access to critical client and financial files
- Application downtime (internal CRM)
- Visual ransom notes and desktop alterations
- Some endpoints locked out or unusually slow
- Reports of odd network activity overnight from server logs (high volume file access outside business hours)

---

## 👥 Key Stakeholders Involved
- **IT Manager:** Brian Leung (primary incident lead)
- **Executive Leadership:** CEO (Danielle Cruz), CFO (Omar Patel)
- **Legal Counsel:** Alisha Morgan
- **Public Relations Officer:** Jordan Sinclair
- **Managed Security Service Provider (MSSP) Contact:** TechGuard Solutions

---

## 🔎 Limited Forensic Information (Initial Findings)
- Event logs show unauthorized login attempts using the username `helpdesk_support` at 2:42 AM
- Antivirus software on affected machines flagged and quarantined a suspicious executable: `updater_patch.exe`
- Recent unpatched Windows Server vulnerabilities include CVE-2022-26923 (Active Directory Privilege Escalation)
- VPN logs indicate a successful remote login overnight from an unusual IP address (originating in another country)
- No formal incident response plan was fully implemented prior to this event

---

## 🔐 Notes for Student Teams
- Assume that NovaHealth Solutions must comply with general data privacy standards but is **not** currently governed by HIPAA or federal breach notification laws.
- Leadership is concerned about: business continuity, client confidence, potential legal consequences, and public image.
- Your team must prioritize response actions to contain the breach, preserve evidence, and plan for communication.

