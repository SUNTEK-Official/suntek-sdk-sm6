package com.suntek.sample.sm6;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.pos.devices.Printer;
import com.rscja.deviceapi.RFIDWithISO14443A;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int initCode = Printer.DLL_PrnInit();
        int prnStatus = Printer.DLL_PrnGetStatus(0);
        String rfidState;
        try {
            RFIDWithISO14443A rfid = RFIDWithISO14443A.getInstance();
            rfidState = rfid != null ? "Ready" : "Unavailable";
        } catch (Throwable t) {
            rfidState = "Requires SM6 hardware service";
        }
        TextView view = new TextView(this);
        view.setText("SUNTEK SM6 Sample\nPrinter init=" + initCode + " status=" + prnStatus + "\nRFID=" + rfidState);
        setContentView(view);
    }
}
