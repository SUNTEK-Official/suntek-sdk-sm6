# SUNTEK SM6 General API User Guide

General API user guide
Ver:  V1.0
General API user guide0
Ver:  V1.00
1,  Summary3

## 1.1 Introduction3


## 1.2 Change history3

2, Develop environment3
3, API description3

## 3.1 System3


## 3.1.1 Beep(fixed frequency)4


## 3.1.2 Beep (variable frequency)4


## 3.1.3 Read device SN4


## 3.1.4 Write device SN5


## 3.1.5 Get SP firmware version5


## 3.1.6 Read tamper record5


## 3.1.7 Set tamper mode6


## 3.1.8 Clear tamper record6


## 3.1.9 System Reboot6


## 3.1.10 System release7


## 3.1.11 Read RTC7


## 3.1.12 Write RTC7


## 3.2 ICC7


## 3.2.1 ICC open8


## 3.2.2 ICC close10


## 3.2.3 ICC Command10


## 3.2.4 ICC Check12


## 3.2.5 ICC release12


## 3.3 MCR12


## 3.3.1 MCR open13


## 3.3.2 MCR Close13


## 3.3.3 MCR Reset13


## 3.3.4 MCR Check14


## 3.3.5 MCR Data Read14


## 3.3.6 MCR release15


## 3.4 Picc15


## 3.4.1 Picc open15


## 3.4.2 Picc close16


## 3.4.3 Picc check16


## 3.4.4 PICC command exchange18


## 3.4.5 PICC remove the card18


## 3.4.6 PICC reset19


## 3.4.7 PICC antenna on19


## 3.4.8 PICC antenna off20


## 3.4.9 Picc release20


## 3.5 PCI22


## 3.5.1 Get random number23


## 3.5.2 Write master key23


## 3.5.3 Write DUKPT inital key24


## 3.5.4 Write session key24


## 3.5.5 Clear keys25


## 3.5.6 Check keys exist26


## 3.5.7 PIN encryption(TPK)26


## 3.5.8 Message encryption(TAK)27


## 3.5.9 Data encryption(TDK)28


## 3.5.10 Account data encryption(TCHDK)29


## 3.5.11 PIN encryption(AES_TPK)30


## 3.5.12 Message encryption(AES_TAK)31


## 3.5.13 Data encryption(AES_TDK)32


## 3.5.14 Account data encryption(AES_TCHDK)33


## 3.5.15 Offline cipher PIN verificaiton34


## 3.5.16 Offline plain PIN verificaton35


## 3.5.17 PCI release37


## 3.6 Printer38


## 3.6.1 Printer Init38


## 3.6.2 Printer set gray level38


## 3.6.3 Printer get temperature39


## 3.6.4 Printer start caching the printed content39


## 3.6.5 Printer set print font39


## 3.6.6 Printer set the print row and column spacing40


## 3.6.7 Printer print text40


## 3.6.8 Printer print bitmap41


## 3.6.9 Printer print start41

Summary

## 1.1 Introduction

This document is for application developer who will develop the application based on device. Except the module controlled by secure processor, others use Android standard API.

## 1.2 Change history


| Date | Version | Description |
| :--- | :--- | :--- |
| 2025/11/10 | V1.0 | Create |

2, Develop environment

| System configuration | 1G storage memory Windows xp/win 7/8/10 |
| :--- | :--- |
| Develop tool | Android studio, eclipse |
| jar package | securitymoduleapi.jar ,printerlib.jar |
| SO library | libprinter_dll.so |

3, API description

## 3.1 System


| Structure    Function | int Sys(); |
| :--- | :--- |
| Method | int DLL_SysBeep(); |
| - | int DLL_SysBeef(byte mode,byte [] dlyTimeMs); |
| - | int DLL_SysReadSN (byte [] sn); |
| - | int DLL_SysWriteSN(byte snLen, byte[] serialNo); |
| - | int DLL_SysGetVersion (byte * version); |
| - | int DLL_SysReadTamperRecord(byte[] record); |
| - | int DLL_SysSetTriggerMode (byte mode); |
| - | int DLL_SysClearTamperRecord (byte[] active); |
| - | int DLL_SysSoftReset(byte mode); |
| - | int DLL_SysShutdown(); |
| - | int DLL_SysGetDateTime(byte[] str); |
| - | int DLL_SysSetDateTime(byte[] str); |


## 3.1.1 Beep(fixed frequency)


| Prototype | int DLL_SysBeep(); | - |
| :--- | :--- | :--- |
| Function | Sound the beeper | - |
| Parameters | none | - |
| Return value | -1001 | Send error |
| - | -1002 | Recv error |
| - | 0 | Success |
| Note | - | - |


## 3.1.2 Beep (variable frequency)


| Prototype | int DLL_SysBeef(byte mode,byte[] dlyTimeMs); | - |
| :--- | :--- | :--- |
| Function | Sound the beep in specified frequency | - |
| Parameters | mode[in] | Frequency:0~15 Pwm Hz:  (mode + 1) * 300 |
| - | DlyTimeMs[in] | Sound beep continue time.Short to byte array. dlyTimeMs[0] is Hi Byte. dlyTimeMs[1] is Low Byte. |
| Return value | -1001 | send error |
| - | -1002 | recv error |
| - | 0 | success |
| Note | - | - |


## 3.1.3 Read device SN


| Prototype | int DLL_SysReadSN (byte [] sn); | - |
| :--- | :--- | :--- |
| Function | Get the SN of the device | - |
| Parameters | sn [out] | 12 bytes |
| Return value | -1001 | send error |
| - | -1002 | recv error |
| - | 0 | success |
| Note | - | - |


## 3.1.4 Write device SN


| Prototype | int DLL_SysWriteSN(byte snLen, byte[] serialNo) | - |
| :--- | :--- | :--- |
| Function | Write the SN to the device | - |
| Parameters | snLen [in] | the length of serial number:12 bytes |
| - | serialNo[in] | serial number |
| Return value | -1001 | send error |
| - | -1002 | recv error |
| - | 0 | success |
| Note | - | - |


## 3.1.5 Get SP firmware version


| Prototype | int DLL_SysGetVersion (byte * version); | - |
| :--- | :--- | :--- |
| Function | GEt the sp firmware version | - |
| Parameters | version [out] | 6:bytes.1.0.0,1.0.0 (SP boot and SP os version) |
| Return value | -1001 | send error |
| - | -1002 | recv error |
| - | 0 | success |
| Note | - | - |


## 3.1.6 Read tamper record


| Prototype | int DLL_SysReadTamperRecord(byte[] record); | - |
| :--- | :--- | :--- |
| Function | Read the tamper record saved in the internal flash of secure chip. | - |
| Parameters | record [out] | Record: four bytes. 0x00000100: ext dynamic 8 tampered  (S01) 0x00000400: ext dynamic 9 tampered  (S23) 0x00001000: ext dynamic 10 tampered (S45) 0x00004000: ext dynamic 11 tampered (S67) The value of bit is 1 means tampered, is 0 means the corresponding tamper not detected. |
| Return value | 0x00 | Read success |
| - | -900 | Trigger not open |
| - | Others | Read failed |
| Note | Only the last tamper record will be saved. | - |


## 3.1.7 Set tamper mode


| Prototype | int DLL_SysSetTriggerMode (byte mode); | - |
| :--- | :--- | :--- |
| Function | set the tamper mode. | - |
| Parameters | mode [in] | 0x00: Close tamper 0x01: Open tamper |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.1.8 Clear tamper record


| Prototype | int DLL_SysClearTamperRecord (byte[] active); | - |
| :--- | :--- | :--- |
| Function | clear the tamper record. | - |
| Parameters | active [in] | Example ActiveClient or Apidemo2. |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.1.9 System Reboot


| Prototype | int DLL_SysSoftReset(byte mode); | - |
| :--- | :--- | :--- |
| Function | Reboot system. | - |
| Parameters | mode [in] | 1:      reboot. Other:  invalid |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.1.10 System release


| Prototype | int DLL_SysShutdown(); | - |
| :--- | :--- | :--- |
| Function | Device Power Off. | - |
| parameters | none | - |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.1.11 Read RTC


| Prototype | int DLL_SysGetDateTime(byte[] str); | - |
| :--- | :--- | :--- |
| Function | Read time from RTC (Real-Time Clock) hardware | - |
| Parameters | str [out] | Buffer to store the RTC date-time string |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.1.12 Write RTC


| Prototype | int DLL_SysSetDateTime(byte[] str); | - |
| :--- | :--- | :--- |
| Function | Write the system time to RTC (Real-Time Clock) | - |
| Parameters | str [in] | Date-time string to write to RTC hardware |
| Return value | 0x00 | success |
| - | Others | failed |
| Note | - | - |


## 3.2 ICC


| Structure Function | Icc(); |
| :--- | :--- |
| Method | int DLL_IccOpen(byte slot, byte vccMode, byte[] ATR); |
| - | int DLL_IccCommand(byte slot, byte[] apduSend, byte[]  apduResp); |
| - | int DLL_IccClose(byte slot); |
| - | int DLL_IccCheck(byte slot); |
| - | void DLL_IccRelease (); |


## 3.2.1 ICC open


| Prototype | int DLL_IccOpen(byte slot, byte vccMode, byte []ATR); | - |
| :--- | :--- | :--- |
| Function | Reset the ICC | - |
| Parameters | slot [in] | Slot: 0x00－IC card 0x80 -> (non EMV)IC card 0x01－PSAM1 card |
| - | vccMode[in] | Supply voltage 1---5V 2---3V 3---1.8V |
| - | ATR[out] | The content of answer to reset, the first byte is length of ATR. |
| Return value | 0 | success. |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-2403) | Slot NO error |
| - | (-2405) | No card |
| - | (-2404) | Protocol error |
| - | (-2500) | The voltage mode error |
| - | (-2503) | Communicate fail |
| Note | ATR information is different as different card, please refer to IC card manual, to supply the buffer in enough length.(Maximum length is not more than 33 bytes). The card can only be operated after being reset successfully. Details of the IC card command return code   0 success (-2401) Parity Error (-2405) No card (-2402) Parameter cannot be void (-2403) Card slot error (-2400) Data length error (-2404) Protocol error (-2406) Card hasn't been initialized (-2500) IC card reset voltage mode error (-2503) communication failed  Card reset error code details (-2100) TS  error (-2101) TCK error (-2102) ATR response timeout (-2103) TA1 error (-2104) TA2 error (-2105) TA3 error (-2106) TB1 error (-2107) TB2 error (-2108) TB3 error (-2109) TC1 error (-2110) TC2 error (-2111) TC3 error (-2112) TD1 error (-2113) TD2 error (-2114) ATR length error  T=0 card communication error code details (-2200) Card response timeout (-2201) Resend error (-2202) Rereceive error (-2203) Character parity error (-2204) State byte error  T=1 card communication error code details (-2300) BWT error (-2301) CWT error (-2302) ABORT communication error (-2303) EDC error (-2304) Synchronous communication error (-2305) EGT error (-2306) BGT error (-2307) NAD error (-2308) PCB error (-2309) LEN error (-2310) IFSC error (-2311) IFSD error (-2312) Too many times wrong (-2313) Character parity error (-2314) Invalid characters group | - |


## 3.2.2 ICC close


| Prototype | int DLL_IccClose(byte slot); | - |
| :--- | :--- | :--- |
| Function | Deactive the card in the slot. | - |
| Parameters | slot [in] | Slot: 0x00 ->IC card 0x80 -> (non EMV)IC card 0x01 ->PSAM1 card |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | others | Failed |
| Note | - | - |


## 3.2.3 ICC Command


| Prototype | int DLL_IccCommand(byte slot,byte[] apduSend, byte[]apduRecv); | - |
| :--- | :--- | :--- |
| Function | Icc command exchange, and this function support the card with protocol T=0 and T=1. | - |
| Parameters | slot[in] | Slot: 0x00 ->IC card 0x80 -> (non EMV)IC card 0x01 ->PSAM1 card |
| - | apduSend[in] | APDU_SEND structure:  struct{ BYTECommand[4]; WORD  Lc; BYTE   DataIn[512]; WORD  Le; }; |
| - | apduRecv[out] | APDU_RESP structure:  struct{ WORDLenOut; BYTE DataOut[512]; BYTE   SWA; BYTE   SWB; }; |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-2503) | Time out |
| - | (-2405) | Card moved out |
| - | (-2401) | Parity error |
| - | (-2403) | The slot NO. error |
| - | (-2400) | The length of send data too long |
| - | (-2404) | The protocol error(not T=0 and T=1) |
| - | (-2406) | Card reset error |
| Note | APDU_SEND structure:  struct{ BYTECommand[4]; WORD  Lc; BYTE   DataIn[512]; WORD  Le; }; Command[] = {CLA, INS, P1, P2}.  Lc     = the length of DataIn.  DataIn = the data to be sent to ICC.  Le     = the respect length of return data.  Case1: Lc=0; Le=0 No data send, and no data return. Case2: Lc=0; Le>0 No data send, but expect data return, if the length of return data is unsure, Le = 256. Case3: Lc>0; Le=0 Data sent but no data return. Case4: Lc>0; Le>0 Data send and expect data return. if the length of return data is unsure, Le = 256.  APDU_RESP structure:  struct{ WORDLenOut; BYTE DataOut[512]; BYTE   SWA; BYTE   SWB; };  LenOut  = the length of return data from ICC.  DataOut = the return data from ICC.  SWA     = Status Byte 1.  SWB     = Status Byte 2. | - |


## 3.2.4 ICC Check


| Prototype | int DLL_IccCheck(byte slot); | - |
| :--- | :--- | :--- |
| Function | Check if IC card is inserted in the specified slot.. | - |
| Parameters | slot [in] | Slot: 0x00－IC card 0x80 -> (non EMV)IC card 0x01－PSAM1 card |
| Return value | 0 | There is a card inserted |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | others | No card inserted |
| Note | none | - |


## 3.2.5 ICC release


| Prototype | void DLL_IccRelease (); |
| :--- | :--- |
| Function | Before call the system method, require new a system class object, release the service binded when not used. |
| Parameters | none |
| Return value | none |
| Note | - |


## 3.3 MCR


| Structure Function | Mcr(); |
| :--- | :--- |
| Method | int DLL_McrOpen(); |
| - | int DLL_McrClose(); |
| - | int DLL_McrReset(); |
| - | int DLL_McrCheck(); |
| - | int DLL_McrRead(byte []track1Len, byte[] track1, byte [] track2Len,byte[]track2, byte [] track3Len, byte[] track3); |
| - | void DLL_McrRelease (); |


## 3.3.1 MCR open


| Prototype | int DLL_McrOpen(); | - |
| :--- | :--- | :--- |
| Function | Open the card reader | - |
| Parameters | none | - |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | Others | failed |
| Note | Read the magnetic card data by using interrupt way, once open the card reader, the magnetic head can read data as long as there is swipe, even the read function not called. Therefore the magnetic card reader will be better closed when there no need to use the magnetic card reader. | - |


## 3.3.2 MCR Close


| Prototype | int DLL_McrClose(); | - |
| :--- | :--- | :--- |
| Function | Close card Reader | - |
| Parameters | none | - |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | Others | failed |
| Note | - | - |


## 3.3.3 MCR Reset


| Prototype | int DLL_McrReset(); | - |
| :--- | :--- | :--- |
| Function | Reset magnetic card reader and clear the card data buffer | - |
| Parameters | none | - |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | Others | failed |
| Note | Before do the swipe checking cyclically, call this function once to clear the buffer of card data. | - |


## 3.3.4 MCR Check


| Prototype | int DLL_McrCheck(); | - |
| :--- | :--- | :--- |
| Function | Check there is a swipe or not. | - |
| Parameters | none | - |
| Return value | 0 | Card brush |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | -3000 | No card brush |
| Note | This function will return immediately no matter there is a swipe or not. | - |


## 3.3.5 MCR Data Read


| Prototype | int DLL_McrRead(byte []track1Len, byte[] track1, byte [] track2Len,byte[]track2, byte [] track3Len, byte[] track3); | - |
| :--- | :--- | :--- |
| Function | Read the track data of MCR(track 1,track 2, track3) | - |
| Parameters | track1Len[out] | The length of track1 |
| - | track1[out] | The buffer of track1 data |
| - | Track2Len[out] | The length of track2 |
| - | track2[out] | The buffer of track2 data |
| - | Track3Len[out] | The length of track3 |
| - | track3[out] | The buffer of track3 data |
| Return value | 0 | Brush card error |
| - | >0 | bit0 = 1  read track1 data ok bit1 = 1  read track2 data ok bit2 = 1  read track3 data ok bit4 = 1  parity error of track1 data bit5 = 1  parity error of track2 data bit6 = 1  parity error of track3 data |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | Corrdinate with DLL_MCRCheck function. If no need some track data, the corresponding track buffer pointer can be set to NULL, then the track data will not be output. Generally the magnetic card 's data is according to the ISO7811 standard: track1 : 79 bytes track2 : 40 bytes track3 : 107 bytes This function also supports the magnetic card not conform to the ISO7811 standard. | - |


## 3.3.6 MCR release


| Prototype | void DLL_McrRelease (); |
| :--- | :--- |
| Function | Before call the system method, require new a system class object, releasethe service binded when not used. |
| Parameters | none |
| Return value | none |
| Note | - |


## 3.4 Picc


| Structure Function | Picc(); |
| :--- | :--- |
| Method | int DLL_PiccOpen(); |
| - | int DLL_PiccClose(); |
| - | int DLL_PiccCheck(byte mode, byte[] cardType, byte[] serialNo); |
| - | int DLL_PiccCommand(byte[] apduSend, byte[] apduRecv); |
| - | int DLL_PiccRemove(); |
| - | int DLL_PiccReset(); |
| - | int DLL_PiccAntennaOn(); |
| - | int DLL_PiccAntennaOff(); |
| - | void DLL_PiccRelease (); |


## 3.4.1 Picc open


| Prototype | int DLL_PiccOpen(); | - |
| :--- | :--- | :--- |
| Function | Picc open | - |
| Parameters | none | - |
| Return value | 0x00 | success |
| - | others | failed |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | When devcie power on, the contactless module will be in close status default, before the transaction, this function will be called once; If this function not be called, other functions will be failed. This function will fail when the module is not installed or the module is fault. | - |


## 3.4.2 Picc close


| Prototype | int DLL_PiccClose(); | - |
| :--- | :--- | :--- |
| Function | Close the picc module | - |
| Parameters | none | - |
| Return value | 0x00 | success |
| - | others | failed |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | After calling this function, contactless card module will be in a closed state, the module is no longer radiate the carrier .and only the funciton Lib_PiccOpen () will be effective after call this funciton. | - |


## 3.4.3 Picc check


| Prototype | int DLL_PiccCheck(byte mode, byte[] cardType, byte[] serialNo); | - |
| :--- | :--- | :--- |
| Function | Search the card according to the specified mode, select and active the card when searched. | - |
| Parameters | mode[in] | mode: 0:search all A-type card firstly: 1> search for multiple A-type card, return error; 2> no A-type card searched, and then search for all B-type card: 1 search for multiple B-type card, return error; 2. Search a B-type card, activate it; 3. Without search any B-type cards, return no card; 3> search a A-type card, and then search all B-type cards: 1. Search for multiple B-type cards, returns an error; 2. Without search any B-type card, activate the A-type card searched;  'a' or 'A' or 0x0a: search A-type card once( if multiple A-type card searched,only select one card, If a A-type CPU card and a M1 card in the inducing area, M1 card will be selected first.  'b' or 'B' or 0x0b : search B-type card once;  'm' or 'M' --- search M1 card once; if multiple M1 card searched, only selected one of them. |
| - | cardType[out] | card type byte buffer(2 bytes) CardType [0]: 'A' - A-type card searched 'B' - B-type card searched CardType [1]: 'C' - search for the CPU type card 'M' -search for the M1-type card |
| - | serialNo[out] | card serial number information. This information includes the lenth of the serial number and the content of serial number; the length of B-type cards and M1 type card's serial number is 4 bytes; the length of A-type card's serial number is usually 4 bytes, 7 bytes or 10 bytes. SerialNo [0] indicates the length of the serial number, SerialNo [1 ~ 10] to save the serial number (left justified). |
| Return value | 0 | success |
| - | (-16520)or(0x4088) | Conflict, multipul cards detected. |
| - | (-16516)or(0X4084) | timeout |
| - | others | failed |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | This API must be called circularly to search a card. It's not usually a one-time success. | - |


## 3.4.4 PICC command exchange


| Prototype | int DLL_PiccCommand(byte[] apduSend, byte[] apduRecv); | - |
| :--- | :--- | :--- |
| Function | Send APDU formatted data to the card, and receive a response from the card. | - |
| parameters | apduSend[in] | The same with the ICC. |
| - | apduRecv[out] | The same with the ICC. |
| Return value | 0 | success |
| - | other | failed |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | only DLL_PiccCheck ()  was called successfully, we can call this function; otherwise it will be failed. | - |


## 3.4.5 PICC remove the card


| Prototype: | int DLL_PiccRemove(void); | - |
| :--- | :--- | :--- |
| Function | determine whether the card has been removed out inducing area | - |
| parameters | none | - |
| Return value | 0 | Card is removed |
| - | (-3525) | card does not remove the sensor area |
| - | other | Other error. |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | - | - |


## 3.4.6 PICC reset


| Prototype | int DLL_PiccReset(); | - |
| :--- | :--- | :--- |
| Function | Send RATS command only to CPU type A card. no need for other types card. | - |
| Parameters | none | - |
| Return value | 0 | Success |
| - | other | failed |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| Note | The API only used for CPU A-Type card, and this funciton must be called before data exchange done on CPU A-Type card. | - |


## 3.4.7 PICC antenna on


| Prototype | int DLL_PiccAntennaOn(); | - |
| :--- | :--- | :--- |
| Function | Antenna on. | - |
| Parameters | none | - |
| Return value | 0 | Success |
| - | other | Failed |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| Note | - | - |


## 3.4.8 PICC antenna off


| Prototype | int DLL_PiccAntennaOff(); | - |
| :--- | :--- | :--- |
| Function | Antenna off | - |
| Parameters | none | - |
| Return value | 0 | Success |
| - | other | Failed |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| Note | - | - |


## 3.4.9 Picc release


| Prototype | void DLL_PiccRelease (); |
| :--- | :--- |
| Function | Before call the system method, require new a system class object, releasethe service binded when not used. |
| Parameters | none |
| Return value | none |
| Note | - |

error code:
#define PICC_OK                (0)
#define PICC_ChipIDErr         (-3500)
#define PICC_OpenErr           (-3501)
#define PICC_NotOpen           (-3502)
#define PICC_ParameterErr      (-3503)  
#define PICC_TxTimerOut        (-3504)
#define PICC_RxTimerOut        (-3505)
#define PICC_RxDataOver        (-3506)
#define PICC_TypeAColl         (-3507)
#define PICC_FifoOver          (-3508)
#define PICC_CRCErr            (-3509)
#define PICC_SOFErr            (-3510)
#define PICC_ParityErr         (-3511)
#define PICC_KeyFormatErr      (-3512)
#define PICC_RequestErr        (-3513)
#define PICC_AntiCollErr       (-3514)
#define PICC_UidCRCErr         (-3515)
#define PICC_SelectErr         (-3516)
#define PICC_RatsErr           (-3517)
#define PICC_AttribErr         (-3518)
#define PICC_HaltErr           (-3519)
#define PICC_OperateErr        (-3520)
#define PICC_WriteBlockErr     (-3521)
#define PICC_ReadBlockErr      (-3522)
#define PICC_AuthErr           (-3523)
#define PICC_ApduErr           (-3524)
#define PICC_HaveCard          (-3525)
#define PICC_Collision         (-3526)
#define PICC_CardTyepErr       (-3527)
#define PICC_CardStateErr      (-3528)
#define PICC_RxTimerOut2       (-3529)
#define PICC_RxErr             (-3530)
#define PICC_RxOverFlow        (-3531)
#define PICC_ProtocolErr       (-3532)
#define PICC_FastOut           (-3533)
#define PICC_Fsderror          (-3533)
#define PICC_CRCErr2           (-3534)
#define PICC_Continue   (-3535)
#define PICC_RxBlockErr   (-3536)
#define PICC_ApduErr1           (-3540)
#define PICC_ApduErr2          (-3541)
#define PICC_ApduErr3          (-3542)
#define PICC_ApduErr4           (-3543)
#define PICC_ApduErr5           (-3544)
#define PICC_ApduErr6          (-3545)
#define PICC_ApduErr7           (-3546)
#define PICC_ApduErr8           (-3547)
#define PICC_ApduErr9           (-3548)
#define PICC_ApduErr10           (-3549)
#define PICC_ApduErr11           (-3550)
#define PICC_ApduErr12           (-3551)
#define PICC_ApduErr13           (-3552)
#define PICC_ApduErr14           (-3553)
#define PICC_ApduErr15           (-3554)
#define PICC_ApduErr16           (-3555)
#define PICC_ApduErr17           (-3556)
#define PICC_ApduErr18           (-3557)
#define PICC_ApduErr19           (-3558)
#define PICC_ApduErr20           (-3559)
#define PICC_ApduErr21           (-3560)
#define PICC_ApduErr22           (-3561)
#define PICC_ApduErr23           (-3562)
#define PICC_ApduErr24           (-3563)

## 3.5 PCI


| Structure Function | Pci(); |
| :--- | :--- |
| Method | int  DLL_PciGetRnd (byte []rnd); |
| - | int DLL_PciWriteMKey(byte keyType, byte keyNo, byte keyLen, byte[] keyData, byte mode, byte[] checkValue); |
| - | int DLL_PciWriteDukptKey(byte keyType, byte keyNo, byte bdkLen,  byte[] bdk, byte ksnLen, byte [] ksn, byte mode); |
| - | int DLL_PciWriteSKey(byte keyType, byte keyNo, byte keyLen, byte[] keyData, byte mode, byte mkeyNo); |
| - | int DLL_PciClearKeys(byte keyType, byte keyIndex); |
| - | int DLL_PciCheckKeyExist(byte keyType, byte keyIndex); |
| - | int DLL_PciGetPin(byte keyNo, byte minLen, byte maxLen,byte cardNoLen, byte[] cardNo, byte mode,byte[] pinBlock ,byte mark,byte[] amount,byte waitTimeSec,PinContext ctx); |
| - | int DLL_PciGetMac(byte keyNo, int inLen, byte[] inData, byte[] macOut, byte mode); |
| - | Int DLL_PciGetEncData(byte keyNo, int inLen, byte[] inData,byte[] outData, byte mode); |
| - | int  DLL_PciGetEncAccountData(byte keyNo, int inLen, byte[] inData,byte[] outData, byte mode); |
| - | int DLL_PciGetPinFm4(byte keyNo, byte minLen, byte maxLen,byte cardNoLen, byte[] cardNo, byte mode, byte[] pinBlock,byte mark,byte[] amount,byte waitTimeSec,PinContext ctx); |
| - | int DLL_PciGetMacAes(byte keyNo, int inLen, byte[] inData, byte[] macOut, byte mode); |
| - | int  DLL_PciGetEncDataAes(byte keyNo, int inLen, byte[] inData,  byte[] outData, byte mode); |
| - | int  DLL_PciGetEncAccountDataAes(byte keyNo, int inLen, byte[] inData, byte[] outData, byte mode); |
| - | int  DLL_PciOffLineEncPin(byte slot, byte minLen, byte maxLen, byte waitTimeSec, byte []pk, PinContext ctx); |
| - | int DLL_PciOffLinePlainPin(byte slot, byte minLen, byte maxLen, byte waitTimeSec, PinContext ctxf); |
| - | void DLL_PciRelease (); |


## 3.5.1 Get random number


| Prototype | int  DLL_PciGetRnd (byte *rnd); | - |
| :--- | :--- | :--- |
| Function | Get 16 bytes random number from secure processor. | - |
| Parameters | rnd [out] | Random number |
| Return value | 0 | Success |
| - | others | Abnormal error |
| - | -1001 | send error |
| - | -1002 | recv error |
| Note | - | - |


## 3.5.2 Write master key


| Prototype | int DLL_PciWriteMKey(byte keyType, byte keyNo, byte keyLen, byte[] keyData, byte mode, byte[] checkValue); | - |
| :--- | :--- | :--- |
| Function | Write master key with KCV verification | - |
| Parameters | KeyType [in] | TMK        = (byte)0x00 AES_TMK    = (byte)0x01 |
| - | keyNo [in] | 0~4 |
| - | KeyLen [in] | 16/24 bytes for TMK, 16/32 bytes for AES_TMK |
| - | KeyData | Plain text key data of the specified key type |
| - | mode | Write mode: 0x00:Use plaintext key directly 0x01: Encrypt using the previous master key. 0x81: Decrypt using the previous master key. |
| - | checkValue | Output KCV value for key verification |
| Return value | (0) | Write success |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| - | (-7000) | Pinpad locked |
| - | (-7001) | Key type error |
| - | (-7002) | Key check value error |
| - | (-7003) | Key index error |
| - | (-7004) | Key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7012) | Write failed |
| - | (-7020) | Read MMK failed |
| - | (-7040) | Same key data already exist. |
| Note | This function writes a single master key (either TMK or AES_TMK) and returns its KCV for verification. | - |


## 3.5.3 Write DUKPT inital key


| Prototype | int DLL_PciWriteDukptKey(byte keyType, byte keyNo, byte bdkLen, byte[] bdk, byte ksnLen, byte [] ksn, byte mode); | - |
| :--- | :--- | :--- |
| Function | Write dukpt inital key | - |
| Parameters | keyType[in] | DUKPT_TYPE= (byte)0x0A; |
| - | keyNo[in] | Key index:1. |
| - | bdkLen[in] | Bdk key length, only can be 16 or 24. |
| - | bdk[in] | Dukpt initial key data. |
| - | ksnLen[in] | Ksn length, only can be 10. |
| - | ksn[in] | ksn |
| - | mode[in] | Write mode 0x00: write directly in plain text |
| Return value | (0) | Write success |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| - | (-7000) | Pinpad locked |
| - | (-7001) | Key type error |
| - | (-7002) | Key check value error |
| - | (-7003) | Key index error |
| - | (-7004) | Key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7012) | Write failed |
| - | (-7020) | Read MMK failed |
| - | (-7040) | Same key data already exist. |
| Note | - | - |


## 3.5.4 Write session key


| Prototype | int DLL_PciWriteSKey(byte keyType, byte keyNo, byte keyLen, byte[] keyData, byte mode, byte mkeyNo); | - |
| :--- | :--- | :--- |
| Function | Write session key | - |
| Parameters | keyType[in] | TPK      = (byte)0x02; TAK      = (byte)0x03; TDK      = (byte)0x04; TCHDK    = (byte)0x05; AES_TPK  = (byte)0x06; AES_TAK   = (byte)0x07; AES_TDK   = (byte)0x08; AES_TCHDK  = (byte)0x09; |
| - | keyNo[in] | Session key index, range: 0~4. |
| - | keyLen[in] | key length, for TDEA: can be 16 or 24. For AES: can be 16/24/32 |
| - | keyData[in] | Key data |
| - | mode[in] | Write mode 0x00:Use plaintext key directly 0x01: Encrypt using the previous master key. 0x81: Decrypt using the previous master key. |
| - | mkeyNo[in] | Master key index, range: 0~4. |
| Return value | (0) | Write success |
| - | -1001 | Send error |
| - | -1002 | Recv error |
| - | (-7000) | Pinpad locked |
| - | (-7001) | Key type error |
| - | (-7002) | Key check value error |
| - | (-7003) | Key index error |
| - | (-7004) | Key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7012) | Write failed |
| - | (-7020) | Read MMK failed |
| - | (-7040) | Same key data already exist. |
| Note | The master key with length 16bytes can' be used to decrypt/encrypt the session key with length 24 bytes. | - |


## 3.5.5 Clear keys


| Prototype | int DLL_PciClearKeys(byte keyType, byte keyIndex); | - |
| :--- | :--- | :--- |
| Function | Securely erase specified key from storage | - |
| Parameters | keyType[in] | TPK      = (byte)0x02; TAK      = (byte)0x03; TDK      = (byte)0x04; TCHDK    = (byte)0x05; AES_TPK  = (byte)0x06; AES_TAK  = (byte)0x07; AES_TDK  = (byte)0x08; AES_TCHDK = (byte)0x09; |
| - | keyIndex[in] | Key index: 0~4. |
| Return value | 0 | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7003) | key index error |
| - | (-7011) | Key not exist |
| Note | Permanently deletes key data from flash memory. Cannot be recovered | - |


## 3.5.6 Check keys exist


| Prototype | int DLL_PciCheckKeyExist(byte keyType, byte keyIndex); | - |
| :--- | :--- | :--- |
| Function | Check if specified key exists in storage. | - |
| Parameters | keyType[in] | Key types |
| - | keyIndex[in] | Key index: 0~4. |
| Return value | (0) | Key exists |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7011) | Key not exist |
| Note | This function returns 0 if the specified key exists or -7011 if not found, using different verification methods for regular, DUKPT, and AES_DUKPT key types within the current application context. | - |


## 3.5.7 PIN encryption(TPK)


| Prototype | int DLL_PciGetPin(byte keyNo, byte minLen, byte maxLen,byte cardNoLen, byte[] cardNo, byte mode,byte[] pinBlock ,byte mark,byte[] amount,byte waitTimeSec,PinContext ctx); | - |
| :--- | :--- | :--- |
| Function | Get encrypted PINBLOCK by TPK. | - |
| Parameters | keyNo[in] | Key index: 0~4 |
| - | minLen[in] | minimum length :4. |
| - | maxLen[in] | Maximum length:12. |
| - | cardNoLen[in] | The length of card no |
| - | cardNo[in] | Card NO. |
| - | mode[in] | 0x40: format00x00: format3 |
| - | pinBlock[out] | Encrypted PIN BLOCK,  format0 or format 3 |
| - | mark[in] | Amount exist or not |
| - | amount[in] | Amount |
| - | waitTimeSec[in] | Time to wait.(Unit is second)If the input value is 0, it will be set to default 60s.(2bytes) |
| - | ctx[in] | struct PinContext { byte [] prompt;//prompt font [] font;//prompt font rgb [] background;//background } |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | mode error |
| - | (-7006) | PIN length error |
| - | (-7007) | Input cancel |
| - | (-7009) | Input timeout |
| - | (-7010) | Input interval error |
| - | (-7011) | Key not exist |
| - | (-7015) | Input length error |
| - | (-7016) | No input |
| Note | minLen<= maxLen | - |


## 3.5.8 Message encryption(TAK)


| Prototype | int DLL_PciGetMac(byte keyNo, int inLen, byte[] inData, byte[] macOut, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypte message by MACK | - |
| Parameters | keyNo[in] | Key index: 0~4 |
| - | inLen[in] | The length of message to be encrypted:0~1024 |
| - | inData[in] | The message to be encrypted. |
| - | macOut[out] | The encrypted result. |
| - | mode[in] | 0＝cbc mac |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Input mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note: | The message data is divided into blocks of 8 bytes each. If the last block is less than 8 bytes, it is padded with 0x00. Algorithm 1: BLOCK1 is encrypted with the MAC key using DES/3DES. The encryption result is then bitwise XORed with BLOCK2, and the result of that XOR is again encrypted with the MAC key using DES/3DES. This process continues sequentially, resulting in an 8-byte encrypted output (CBC Mode). Algorithm 2: BLOCK1 and BLOCK2 are bitwise XORed. The result of this XOR is then bitwise XORed with BLOCK3. This process continues sequentially until the last block, producing a final 8-byte XOR result. This result is then encrypted with the MAC key using a DES/3DES operation. Algorithm 3: BLOCK1 is encrypted with the MAC key using DES encryption. The encryption result is bitwise XORed with BLOCK2, and the result is again encrypted with the MAC key using DES encryption. This process continues, but for the final step, TDES encryption is performed to obtain the 8-byte encrypted result. Algorithm 4: BLOCK1 and BLOCK2 are bitwise XORed. The result is then bitwise XORed with BLOCK3, and this process continues sequentially, producing a final 8-byte XOR result. This 8-byte result is then converted into 16 hexadecimal digits. The first 8 bytes (first half) of these digits are encrypted with the MAC key using a DES/3DES operation. The encrypted result is then XORed with the last 8 bytes (second half). The result of this XOR is then encrypted again with the MAC key using a double-length (e.g., 3DES) encryption operation. Finally, the output of this operation is converted into 16 hexadecimal digits, and the first 8 bytes of these digits are taken as the MAC value. | - |


## 3.5.9 Data encryption(TDK)


| Prototype | int  DLL_PciGetEncData(byte keyNo, int inLen, byte[] inData,byte[] outData, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypt data by TDK | - |
| Parameters | keyNo [in] | Key index: 0~4 |
| - | inLen[in] | The length of data to be encrypted, less than 1024 |
| - | inData [in] | The data to be encrypted. |
| - | outData[out] | Encrypt result. |
| - | mode [in] | mode : 1: cbc encryption, 0: ecb encryption |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note | - | - |


## 3.5.10 Account data encryption(TCHDK)


| Prototype | int  DLL_PciGetEncAccountData(byte keyNo, int inLen, byte[] inData,byte[] outData, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypt account data by TCHDK | - |
| Parameters | keyNo [in] | Key index: 0~4 |
| - | inLen[in] | The length of account data to be encrypted, less than 256 |
| - | inData [in] | The account data to be encrypted. |
| - | outData[out] | Encrypt result. |
| - | mode [in] | mode : 1: cbc encryption, 0: ecb encryption |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note | PAN digit entry functions provided by an application cannot display more than one clear-text digit at a time, and that the displayed PAN digit is obfuscated prior to the entry of the next digit | - |


## 3.5.11 PIN encryption(AES_TPK)


| Prototype: | int DLL_PciGetPinFm4(byte keyNo, byte minLen, byte maxLen,byte cardNoLen, byte[] cardNo, byte mode, byte[] pinBlock ,byte mark,byte[] amount,byte waitTimeSec, PinContext ctx); | - |
| :--- | :--- | :--- |
| Function | Get encrypted PINBLOCK by AES_TPK. | - |
| Parameters | keyNo[in] | Key index: 0~4 |
| - | minLen[in] | minimum length :4. |
| - | maxLen[in] | Maximum length:12. |
| - | cardNoLen[in] | The length of card no |
| - | cardNo[in] | Card NO. |
| - | mode[in] | 0x00 |
| - | pinBlock[out] | Encrypted PIN BLOCK(16 bytes),  format 4 |
| - | mark[in] | Amount exist or not |
| - | amount[in] | Amount |
| - | waitTimeSec[in] | Time to wait.(Unit is second)If the input value is 0, it will be set to default 60s.(2bytes) |
| - | ctx[in] | struct PinContext { byte [] prompt;//prompt font [] font;//prompt font rgb [] background;//background } |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | mode error |
| - | (-7006) | PIN length error |
| - | (-7007) | Input cancel |
| - | (-7009) | Input timeout |
| - | (-7010) | Input interval error |
| - | (-7011) | Key not exist |
| - | (-7015) | Input length error |
| - | (-7016) | No input |
| Note | minLen<= maxLen | - |
| - | - | - |


## 3.5.12 Message encryption(AES_TAK)


| Prototype | int DLL_PciGetMacAes(byte keyNo, int inLen, byte[] inData, byte[] macOut, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypte message by AES_TAK | - |
| Parameters | keyNo[in] | Key index: 0~4 |
| - | inLen[in] | The length of message to be encrypted:0~1024 |
| - | inData[in] | The message to be encrypted. |
| - | macOut[out] | The encrypted result. |
| - | mode[in] | 0＝cbc mac |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Input mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note | The message data is divided into blocks of 8 bytes each. If the last block is less than 8 bytes, it is padded with 0x00. Algorithm 1: BLOCK1 is encrypted with the MAC key using DES/3DES. The encryption result is then bitwise XORed with BLOCK2, and the result of that XOR is again encrypted with the MAC key using DES/3DES. This process continues sequentially, resulting in an 8-byte encrypted output (CBC Mode). Algorithm 2: BLOCK1 and BLOCK2 are bitwise XORed. The result of this XOR is then bitwise XORed with BLOCK3. This process continues sequentially until the last block, producing a final 8-byte XOR result. This result is then encrypted with the MAC key using a DES/3DES operation. Algorithm 3: BLOCK1 is encrypted with the MAC key using DES encryption. The encryption result is bitwise XORed with BLOCK2, and the result is again encrypted with the MAC key using DES encryption. This process continues, but for the final step, TDES encryption is performed to obtain the 8-byte encrypted result. Algorithm 4: BLOCK1 and BLOCK2 are bitwise XORed. The result is then bitwise XORed with BLOCK3, and this process continues sequentially, producing a final 8-byte XOR result. This 8-byte result is then converted into 16 hexadecimal digits. The first 8 bytes (first half) of these digits are encrypted with the MAC key using a DES/3DES operation. The encrypted result is then XORed with the last 8 bytes (second half). The result of this XOR is then encrypted again with the MAC key using a double-length (e.g., 3DES) encryption operation. Finally, the output of this operation is converted into 16 hexadecimal digits, and the first 8 bytes of these digits are taken as the MAC value. | - |


## 3.5.13 Data encryption(AES_TDK)


| Prototype | int  DLL_PciGetEncDataAes(byte keyNo, int inLen, byte[] inData,  byte[] outData, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypt data by AES_TDK | - |
| Parameters | keyNo [in] | Key index: 0~4 |
| - | inLen[in] | The length of data to be encrypted, less than 1024 |
| - | inData [in] | The data to be encrypted. |
| - | outData[out] | Encrypt result. |
| - | mode [in] | mode : 1: cbc encryption, 0: ecb encryption |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note | - | - |


## 3.5.14 Account data encryption(AES_TCHDK)


| Prototype | int  DLL_PciGetEncAccountDataAes(byte keyNo, int inLen, byte[] inData, byte[] outData, byte mode); | - |
| :--- | :--- | :--- |
| Function | Encrypt account data by AES_TCHDK | - |
| parameters | keyNo [in] | Key index: 0~4 |
| - | inLen[in] | The length of account data to be encrypted, less than 256 |
| - | inData [in] | The account data to be encrypted. |
| - | outData[out] | Encrypt result. |
| - | mode [in] | mode : 1: cbc encryption, 0: ecb encryption |
| Return value | (0) | success: |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7001) | key type error |
| - | (-7002) | key check value error |
| - | (-7003) | key index error |
| - | (-7004) | key length error |
| - | (-7005) | Mode error |
| - | (-7011) | Key not exist |
| - | (-7015) | Data length error |
| Note | PAN digit entry functions provided by an application cannot display more than one clear-text digit at a time, and that the displayed PAN digit is obfuscated prior to the entry of the next digit. | - |


## 3.5.15 Offline cipher PIN verificaiton


| Prototype | int  DLL_PciOffLineEncPin(byte slot, byte minLen, byte maxLen, byte waitTimeSec, byte []pk, PinContext ctx); | - |
| :--- | :--- | :--- |
| Function | Offline cipher pin verification | - |
| Parameters | slot [in] | ICC slot:0 |
| - | minLen [in] | the minimum length of PIN, range: 4~12. |
| - | maxLen [in] | The maximum length of PIN, range: 4~12. |
| - | waitTimeSec[in] | Time to wait.(Unit is second)If the input value is 0, it will be set to default 60s.(2bytes) |
| - | pk[in] | typedef struct{ unsigned char ModulLen;          //Module length unsigned char Modul[248];        //Module unsignwed char ExponentLen;       //Exponent length unsigned char Exponent[3];       //Exponent }PUBLIC_KEY; |
| - | ctx[in] | struct PinContext { byte [] prompt;//prompt font [] font;//prompt font rgb [] background;//background } |
| Return value | (0) | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7006) | Min or max error |
| - | (-7007) | Input cancel |
| - | (-7009) | Input timeout |
| - | (-7016) | No input |
| - | EMV return value | #define EMV_OK              0 #define ERR_EMVRSP         (-1) #define ERR_APPBLOCK       (-2) #define ERR_NOAPP          (-3) #define ERR_USERCANCEL     (-4) #define ERR_TIMEOUT        (-5) #define ERR_EMVDATA        (-6) #define ERR_NOTACCEPT      (-7) #define ERR_EMVDENIAL      (-8) #define ERR_KEYEXP         (-9) #define ERR_NOPINPAD       (-10) #define ERR_NOPIN          (-11) #define ERR_CAPKCHECKSUM   (-12) #define ERR_NOTFOUND       (-13) #define ERR_NODATA         (-14) #define ERR_OVERFLOW       (-15) #define ERR_NOTRANSLOG     (-16) #define ERR_NORECORD       (-17) #define ERR_NOLOGITEM      (-18) #define ERR_ICCRESET       (-19) #define ERR_ICCCMD         (-20) #define ERR_ICCBLOCK       (-21) #define ERR_ICCNORECORD    (-22) #define ERR_GENAC1_6985    (-23) #define ERR_USECONTACT     (-24) #define ERR_APPEXP         (-25) #define ERR_BLACKLIST      (-26) #define ERR_GPORSP         (-27) #define ERR_TRANSEXCEEDED  (-28) #define ERR_QPBOCFDDAFAIL  (-29) #define ERR_USEMAG         (-30) #define ERR_PINBLOCK       (-38) 1~6:  retry times left: 0~5 |
| Note | - | - |


## 3.5.16 Offline plain PIN verificaton


| Prototype | int DLL_PciOffLinePlainPin(byte slot, byte minLen, byte maxLen, byte waitTimeSec, PinContext ctx); | - |
| :--- | :--- | :--- |
| Function | Offline plain pin verification | - |
| Parameters | slot [in] | Icc slot:0 |
| - | minLen [in] | the minimum length of PIN, range: 4~12. |
| - | maxlen [in] | The maximum length of PIN, range: 4~12. |
| - | waitTimeSec [in] | Time to wait.(Unit is second)If the input value is 0, it will be set to default 60s.(2bytes) |
| - | ctx[in] | struct PinContext { byte [] prompt;//prompt font [] font;//prompt font rgb [] background;//background } |
| Return | (0) | success |
| - | -1001 | send error |
| - | -1002 | recv error |
| - | (-7006) | Min or max error |
| - | (-7007) | Input cancel |
| - | (-7009) | Input timeout |
| - | (-7016) | No input |
| - | EMV return value | #define EMV_OK              0 #define ERR_EMVRSP         (-1) #define ERR_APPBLOCK       (-2) #define ERR_NOAPP          (-3) #define ERR_USERCANCEL     (-4) #define ERR_TIMEOUT        (-5) #define ERR_EMVDATA        (-6) #define ERR_NOTACCEPT      (-7) #define ERR_EMVDENIAL      (-8) #define ERR_KEYEXP         (-9) #define ERR_NOPINPAD       (-10) #define ERR_NOPIN          (-11) #define ERR_CAPKCHECKSUM   (-12) #define ERR_NOTFOUND       (-13) #define ERR_NODATA         (-14) #define ERR_OVERFLOW       (-15) #define ERR_NOTRANSLOG     (-16) #define ERR_NORECORD       (-17) #define ERR_NOLOGITEM      (-18) #define ERR_ICCRESET       (-19) #define ERR_ICCCMD         (-20) #define ERR_ICCBLOCK       (-21) #define ERR_ICCNORECORD    (-22) #define ERR_GENAC1_6985    (-23) #define ERR_USECONTACT     (-24) #define ERR_APPEXP         (-25) #define ERR_BLACKLIST      (-26) #define ERR_GPORSP         (-27) #define ERR_TRANSEXCEEDED  (-28) #define ERR_QPBOCFDDAFAIL  (-29) #define ERR_USEMAG         (-30) #define ERR_PINBLOCK       (-38) 1~6:  retry times left: 0~5 |
| Note | - | - |


## 3.5.17 PCI release


| Prototype | void DLL_PciRelease (); |
| :--- | :--- |
| Function | Before call the system method, require new a system class object, release the service binded when not used. |
| Parameters | none |
| Return value | none |
| Note | - |


## 3.6 Printer


| Structure Function | Printer |
| :--- | :--- |
| Method | int DLL_PrnInit(); |
| - | int DLL_PrnSetGray (int level); |
| - | int DLL_PrnGetTemperature (); |
| - | int DLL_PrnStartCaching(); |
| - | int DLL_PrnSetFont(Typeface tf, int style, int size); |
| - | int DLL_PrnSetSpace(int x, int y); |
| - | int DLL_PrnStr(String text); |
| - | int DLL_PrnBmp(Bitmap bitmap); |
| - | void Dll_PrnStart (PrintCallback<Integer> callback); |


## 3.6.1 Printer Init


| Prototype | int DLL_PrnInit(); |
| :--- | :--- |
| Function | Printer Init |
| Parameters | none |
| Return value | 0: success Other values: error code |
| Note | - |


## 3.6.2 Printer set gray level


| Prototype | int DLL_PrnSetGray (int level); | - |
| :--- | :--- | :--- |
| Function | Printer set gray level | - |
| Parameters | Level[in] | Print grayscale, print grayscale value, the range is 0 to 9, the higher the darker, the slower the speed |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


## 3.6.3 Printer get temperature


| Prototype | int DLL_PrnGetTemperature(); |
| :--- | :--- |
| Function | Get the current print head temperature |
| Parameters | none |
| Return value | Returns the current temperature |
| Note | - |


## 3.6.4 Printer start caching the printed content


| Prototype | int DLL_PrnStartCaching(); |
| :--- | :--- |
| Function | Restore the printer's default Settings and clear the contents of the print buffer, and begin a printing process.A print process starts with a call to DLL_PrnStartCaching and ends with a call to DLL_PrnStart. After a printing process begins, all of the print-related content is simply printed into the cache, and the print function finally outputs the content to the printer paper. |
| Parameters | none |
| Return value | 0: success Other values: error code |
| Note | - |


## 3.6.5 Printer set print font


| Prototype | int DLL_PrnSetFont(Typeface tf, int style, int size); | - |
| :--- | :--- | :--- |
| Function | Set print font.Including the font name(for example:Song typeface, imitation Song-Dynasty-style typeface, boldface And other fonts), Bold, underline, italics and other effects.This setup is done in memory, Once successfully set, the subsequent printStr will be affected.The App will revert to the default font when it restarts | - |
| Parameters | tf[in] | Typeface Type |
| - | style[in] | font-style,It can be the following value: 0x00: Default style (i.e. this parameter does not work); 0x01: With an underlined style; 0x02: With deletion line style. |
| - | size [in] | Text Size |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


## 3.6.6 Printer set the print row and column spacing


| Prototype | int DLL_PrnSetSpace(int x, int y); | - |
| :--- | :--- | :--- |
| Function | Set the print row and column spacing.This setting affects how the printStr function prints.This setting is done in memory and will affect subsequent printStr functions.The App is restored to the default value of 0 after restarting. | - |
| Parameters | x[in] | Word spacing (number of points), default is 0, maximum is 32. |
| - | y[in] | Line spacing (number of points), default is 0, maximum is 32. |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


## 3.6.7 Printer print text


| Prototype | int Dll_PrnStr(String text); | - |
| :--- | :--- | :--- |
| Function | Set the printing style | - |
| Parameters | text[in] | Text to be printed, UTF8 format. If the printed string is out of print range, it will automatically wrap and continue printing. Supports the '\n' [newline] control character in print strings. The '\n' character should be wrapped immediately This function can process a maximum buffer of 2047 bytes at a time |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


## 3.6.8 Printer print bitmap


| Prototype | int Dll_PrnBmp(Bitmap bitmap); | - |
| :--- | :--- | :--- |
| Function | Writes bitmap data to the print cache. | - |
| Parameters | bitmap[in] | Bitmap data to be printed. |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


## 3.6.9 Printer print start


| Prototype | void Dll_PrnStart (PrintCallback<Integer> callback); | - |
| :--- | :--- | :--- |
| Function | Start printing. This function will print the data in the print cache to the printer paper. | - |
| Parameters | callback[in] | Interface callback object, with the result obtained through onResult |
| Return value | 0: success Other values: error code | - |
| Note | - | - |


| Prototype | interface PrintCallback<T>{ void onResult(T t); } |
| :--- | :--- |
| Function | If t is 0 in the onResult function, the printing operation is successful; otherwise, it is an error code |
| Parameters | - |
| Return value | 0: success Other values: error code |
| Note | - |

