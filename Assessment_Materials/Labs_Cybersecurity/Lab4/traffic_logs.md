# Simulated Wi-Fi Traffic Logs – Lab 4 Case Data (CSV Format)

Below is a simulated log of wireless access points and connected clients. This dataset is intended for educational use in identifying potentially rogue or misconfigured devices.

```
SSID,MAC Address,Channel,Signal Strength (dBm),Encryption,Connected Clients
SecureNet,00:11:22:33:44:55,6,-42,WPA2,3
SecureNet,AA:BB:CC:DD:EE:FF,6,-50,Open,2
GuestNet,66:77:88:99:AA:BB,11,-60,WPA2,5
IoT_Devices,12:34:56:78:9A:BC,1,-70,WPA2,8
FreeCoffeeWiFi,98:76:54:32:10:FE,6,-40,Open,7
CorpWiFi,00:AA:BB:CC:DD:EE,11,-65,WPA2,4
CorpWiFi,01:AA:BB:CC:DD:EE,11,-38,WPA2,0
SecureNet,CA:FE:BA:BE:12:34,6,-41,WPA2,1
UnknownSSID,DE:AD:BE:EF:00:00,3,-35,Open,1
TargetGuest,22:33:44:55:66:77,9,-45,Open,3
XfinityWiFi,AA:00:BB:11:CC:22,1,-78,WPA2,2
SecureNet,E1:E2:E3:E4:E5:E6,6,-39,WPA2,4
StarbucksGuest,BA:AD:F0:0D:BE:EF,11,-49,Open,5
CorpWiFi,00:AA:BB:CC:DD:01,11,-58,WPA2,3
GuestNet,66:77:88:99:CC:DD,11,-63,WPA2,4
UnknownSSID,FE:ED:FA:CE:01:02,4,-33,Open,2
HackNet,F1:F2:F3:F4:F5:F6,6,-44,Open,0
```

## Notes for Analysis:
- All legitimate SecureNet access points are supposed to be WPA2 encrypted and operated on channel 6.
- The official MAC address range for company-owned APs begins with `00:11` or `00:AA`.
- GuestNet and IoT_Devices are legitimate SSIDs for internal use.
- Check for duplicate SSIDs with mismatched encryption types or MACs.

Use this data in conjunction with the `airodump-ng` output and device authorization list to:
- Identify rogue APs based on SSID spoofing, unauthorized MAC prefixes, or improper encryption
- Determine if any official SSIDs are being broadcast by unknown devices
- Flag suspicious entries for your team report

This log simulates data captured during a wireless scan and is not intended to represent real access point behavior.

