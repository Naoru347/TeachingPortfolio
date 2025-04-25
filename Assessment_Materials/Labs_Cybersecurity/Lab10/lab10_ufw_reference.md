# Lab 10 – UFW Command Reference

This handout provides basic **Uncomplicated Firewall (UFW)** commands to help you draft and implement firewall rules during this lab.

---

## 🔧 Getting Started
UFW is a command-line utility that provides a simplified interface for managing firewall rules on Ubuntu systems.

- **Check status:**
```bash
sudo ufw status verbose
```

- **Enable firewall:**
```bash
sudo ufw enable
```

- **Disable firewall:**
```bash
sudo ufw disable
```

- **Reset UFW (clears all rules):**
```bash
sudo ufw reset
```

---

## ✅ Allow Traffic

- **Allow specific port:**
```bash
sudo ufw allow 22/tcp
```

- **Allow traffic from specific IP to a specific port:**
```bash
sudo ufw allow from 192.168.10.10 to any port 3306 proto tcp
```

- **Allow traffic to a specific host:**
```bash
sudo ufw allow to 192.168.10.20 port 3306 proto tcp
```

---

## ❌ Deny Traffic

- **Deny a specific port:**
```bash
sudo ufw deny 21
```

- **Deny access from an IP address:**
```bash
sudo ufw deny from 192.168.10.55
```

- **Deny everything by default (best practice):**
```bash
sudo ufw default deny incoming
sudo ufw default allow outgoing
```

---

## 🕵️ Logging and Inspection

- **Enable logging:**
```bash
sudo ufw logging on
```

- **View current rules:**
```bash
sudo ufw status numbered
```

- **Delete a rule by number:**
```bash
sudo ufw delete <rule_number>
```

---

## 🔐 Tips for Writing Rules
- Always apply the **principle of least privilege**: allow only what’s required
- Specify **IP address, port, and protocol** when writing specific rules
- UFW rules are **evaluated top to bottom**, so order can matter in complex policies
- Use `sudo ufw status verbose` to verify changes after adding rules

---

**Note**: These commands are intended for simulation in a lab environment. Do not modify live firewalls without proper authorization.
