package com.example.jihong_min.nfchct;

import android.content.pm.PackageManager;
import android.se.omapi.SEService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements SEService.OnConnectedListener {
    private SEService se_service;
    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_view = findViewById(R.id.text_view);

        ExecutorService pool = Executors.newSingleThreadExecutor();
        se_service = new SEService(this, pool, this);

        // NFC Type-A/B HCE Capability Test
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC_HOST_CARD_EMULATION)) {
            text_view.setText(text_view.getText() + "HCE-A/B: supported\n");
        } else {
            text_view.setText(text_view.getText() + "HCE-A/B: not supported\n");
        }

        // NFC Type-F HCE Capability Test
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_NFC_HOST_CARD_EMULATION_NFCF)) {
            text_view.setText(text_view.getText() + "HCE-F: supported\n");
        } else {
            text_view.setText(text_view.getText() + "HCE-F: not supported\n");
        }
    }

    @Override
    public void onConnected() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text_view.setText(text_view.getText() + "[Available SE Device List]\n");
                for (int i = 0; i < se_service.getReaders().length; i++) {
                    text_view.setText(text_view.getText() + se_service.getReaders()[i].getName() + "\n");
                }
            }
        });
    }
}
