# Sample Airodump-ng Output – Lab 4 Supplementary Data

This is a simulated output from `airodump-ng` capturing surrounding wireless access points and their associated details. This data is intended for in-class analysis as part of Lab 4 – Rogue Access Point Identification Simulation.

```
BSSID              PWR  Beacons    #Data, #/s  CH  MB   ENC  CIPHER AUTH ESSID

00:11:22:33:44:55  -42       105      50    5   6  54e  WPA2 CCMP   PSK  SecureNet
AA:BB:CC:DD:EE:FF  -50        88      22    2   6  54e  OPN          --  SecureNet
66:77:88:99:AA:BB  -60       110      85    4  11  54e  WPA2 CCMP   PSK  GuestNet
12:34:56:78:9A:BC  -70        97      30    1   1  54e  WPA2 CCMP   PSK  IoT_Devices
98:76:54:32:10:FE  -40       130      70    6   6  54e  OPN          --  FreeCoffeeWiFi
00:AA:BB:CC:DD:EE  -65        99      60    2  11  54e  WPA2 CCMP   PSK  CorpWiFi
01:AA:BB:CC:DD:EE  -38        45       0    0  11  54e  WPA2 CCMP   PSK  CorpWiFi
CA:FE:BA:BE:12:34  -41        78      28    1   6  54e  WPA2 CCMP   PSK  SecureNet
DE:AD:BE:EF:00:00  -35        66      14    1   3  54e  OPN          --  UnknownSSID
22:33:44:55:66:77  -45        92      44    3   9  54e  OPN          --  TargetGuest
AA:00:BB:11:CC:22  -78        34       8    0   1  54e  WPA2 CCMP   PSK  XfinityWiFi
E1:E2:E3:E4:E5:E6  -39        89      35    2   6  54e  WPA2 CCMP   PSK  SecureNet
BA:AD:F0:0D:BE:EF  -49        80      52    3  11  54e  OPN          --  StarbucksGuest
00:AA:BB:CC:DD:01  -58        93      58    2  11  54e  WPA2 CCMP   PSK  CorpWiFi
66:77:88:99:CC:DD  -63        84      41    1  11  54e  WPA2 CCMP   PSK  GuestNet
FE:ED:FA:CE:01:02  -33        72      16    1   4  54e  OPN          --  UnknownSSID
F1:F2:F3:F4:F5:F6  -44        59       0    0   6  54e  OPN          --  HackNet
```

## Key for Columns:
- **BSSID** – MAC address of the access point
- **PWR** – Signal strength (approximate)
- **Beacons** – Beacon frames sent (used for network advertisement)
- **#Data / #/s** – Number of data packets seen / per second
- **CH** – Channel number
- **MB** – Maximum speed supported
- **ENC / CIPHER / AUTH** – Encryption, cipher method, and authentication method
- **ESSID** – Name of the network (SSID)

---

Use this output together with the traffic log and known device list to:
- Spot SSID spoofing (same ESSID, different BSSID or encryption)
- Identify APs broadcasting on unexpected channels
- Detect suspiciously strong signal strengths from unknown MACs
- Flag open networks that mimic internal naming conventions

This is simulated output. You are not expected to master every detail but should be able to spot clear anomalies with guidance and teamwork.

