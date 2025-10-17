# Port Numbers Quick Reference Card
## Security+ Essential Ports - MEMORIZE THESE!

### Web Traffic
| Port | Protocol | Encrypted? | Purpose |
|------|----------|------------|---------|
| **80** | HTTP | ❌ NO | Unencrypted web traffic |
| **443** | HTTPS | ✅ YES | Encrypted web traffic (SSL/TLS) |

### Remote Access
| Port | Protocol | Encrypted? | Purpose |
|------|----------|------------|---------|
| **22** | SSH | ✅ YES | Secure remote access & SFTP |
| **23** | Telnet | ❌ NO | Unencrypted remote access (DON'T USE) |
| **3389** | RDP | ✅ YES* | Remote Desktop Protocol (*if configured properly) |

### File Transfer
| Port | Protocol | Encrypted? | Purpose |
|------|----------|------------|---------|
| **20/21** | FTP | ❌ NO | Unencrypted file transfer (DON'T USE) |
| **22** | SFTP | ✅ YES | Secure file transfer (uses SSH) |
| **989/990** | FTPS | ✅ YES | FTP over SSL/TLS |

### Email
| Port | Protocol | Encrypted? | Purpose |
|------|----------|------------|---------|
| **25** | SMTP | ❌ NO | Send email (outgoing) |
| **587/465** | SMTPS | ✅ YES | Secure SMTP |
| **110** | POP3 | ❌ NO | Receive email (downloads & deletes) |
| **995** | POP3S | ✅ YES | Secure POP3 |
| **143** | IMAP | ❌ NO | Receive email (syncs) |
| **993** | IMAPS | ✅ YES | Secure IMAP |

### Network Services
| Port | Protocol | Purpose |
|------|----------|---------|
| **53** | DNS | Domain name resolution |
| **67/68** | DHCP | Automatic IP address assignment |

### Directory Services
| Port | Protocol | Encrypted? | Purpose |
|------|----------|------------|---------|
| **389** | LDAP | ❌ NO | Directory queries (like Active Directory) |
| **636** | LDAPS | ✅ YES | Secure LDAP |

### File Sharing & Database
| Port | Protocol | Purpose |
|------|----------|---------|
| **445** | SMB | Windows file sharing (BLOCK AT FIREWALL!) |
| **1433** | MS SQL | Microsoft SQL Server |
| **3306** | MySQL | MySQL Database |
| **161** | SNMP | Network device management |

---

## Memory Tips

**Pattern Recognition:**
- Protocols ending in "S" are usually encrypted (HTTPS, FTPS, LDAPS, etc.)
- SSH (22) is one less than Telnet (23) and infinitely more secure!
- Common web: 80 (HTTP) and 443 (HTTPS)
- Email receiving: 110 (POP3) and 143 (IMAP)

**Critical Security Ports:**
- **22** - SSH (secure remote access)
- **443** - HTTPS (secure web)
- **445** - SMB (ransomware spreads here - BLOCK IT!)
- **3389** - RDP (common attack target)

**Port Ranges:**
- 0-1023: Well-known ports (memorize these!)
- 1024-49151: Registered ports
- 49152-65535: Dynamic/ephemeral ports

---

## Study Strategy
✅ Make flashcards for each port
✅ Quiz yourself daily: "What port is HTTPS?"
✅ Practice scenario questions: "Port 3389 is being scanned - what service?"
✅ Group by function: web, email, file transfer, etc.

**Security+ Exam Reality:** You WILL see multiple questions about port numbers. This is non-negotiable memorization!