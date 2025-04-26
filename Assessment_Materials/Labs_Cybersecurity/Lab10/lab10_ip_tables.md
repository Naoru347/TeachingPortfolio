# Lab 10 – IP Address Table: Metro Books Network

Use the table below to reference the IP addresses and device roles in the Metro Books network scenario. These assignments will help guide your firewall policy decisions in this lab.

| **Device Name**        | **IP Address**     | **Role / Notes**                                                  |
|------------------------|--------------------|--------------------------------------------------------------------|
| **POS System**         | 192.168.10.10      | Point-of-sale system used in the storefront                        |
| **Inventory Server**   | 192.168.10.20      | Backend database (MySQL) accessed by POS system                    |
| **Web Server**         | 192.168.10.30      | Hosts public-facing catalog website (HTTP/HTTPS access)            |
| **Employee PC #1**     | 192.168.10.50      | Office workstation                                                |
| **Employee PC #2**     | 192.168.10.51      | Office workstation                                                |
| **Employee PC #3**     | 192.168.10.52      | Office workstation                                                |
| **Guest Wi-Fi Router** | (Isolated network) | Provides wireless internet to guests — *not* part of internal LAN  |
| **Management PC**      | 192.168.10.100     | Used by store owner/manager — requires full access to all systems |

### Default Gateway (Router): 192.168.10.1
### Subnet: 255.255.255.0

---

## Tips for Firewall Policy Creation
- Use the IP addresses above in your UFW commands
- Assume that all devices are part of the same internal network unless noted otherwise
- Use IP ranges where applicable (e.g., `192.168.10.50/30` for employee PCs)

---

**Note**: The guest Wi-Fi is isolated and should not have access to any internal services.

Be thoughtful in applying the principle of **least privilege** — only allow what's necessary!

