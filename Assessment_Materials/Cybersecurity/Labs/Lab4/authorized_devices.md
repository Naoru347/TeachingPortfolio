# Authorized Wireless Access Points – Internal Reference Sheet

This document lists the approved wireless access points (APs) for internal use. Any access point not on this list should be treated as suspicious or potentially rogue.

```
SSID: SecureNet
  - MAC: 00:11:22:33:44:55
  - MAC: E1:E2:E3:E4:E5:E6
  - MAC: CA:FE:BA:BE:12:34

SSID: CorpWiFi
  - MAC: 00:AA:BB:CC:DD:EE
  - MAC: 00:AA:BB:CC:DD:01

SSID: GuestNet
  - MAC: 66:77:88:99:AA:BB
  - MAC: 66:77:88:99:CC:DD

SSID: IoT_Devices
  - MAC: 12:34:56:78:9A:BC
```

---

## Internal Notes:
- **SecureNet** is the primary internal SSID for employees. All approved MACs are WPA2-encrypted and operate on **Channel 6**.
- **CorpWiFi** is an internal network used by administrative staff. All MACs should use **WPA2 with PSK** and operate on **Channel 11**.
- **GuestNet** is a WPA2-encrypted guest SSID for visitors. It also operates on **Channel 11**.
- **IoT_Devices** is used for smart sensors and internal IoT traffic. This SSID should appear only on **Channel 1**.

---

This list should be used in conjunction with the Wi-Fi traffic logs and airodump-ng output to detect unauthorized access points broadcasting known SSIDs or unexpected SSIDs altogether.

