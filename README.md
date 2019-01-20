# NFC HCT(Host Capability Tester)

This is an Android application(compatible with APIs above Level 28) to test the NFC capability of the host device. It shows whether the Android host system supports following capabilities:
1. HCE-A/B or HCE-F capabilities(which includes NFC-A/B or NFC-F capability, duh)
2. eSE/microSD SE/SIM SE capabilities with available readers

What is this for?
------------------

This is useful to determine whether your device "truely" doesn't support Korean/Japanese(Osaifu-Keitai)/whatever payment system based on NFC with (SIM)SE, FeliCa, etc.

For example, currently(2019-01-21) Japanese Osaifu-Keitai payment requires FeliCa with SIM-based SE support(or for some devices(like Google Pixel series), HCE-F or FeliCa with eSE is enough). Also, Korean payment systems like T-Money or Cashbee requires NFC-A/B with SIM SE, and Railplus or Justouch requires only HCE-A/B.
