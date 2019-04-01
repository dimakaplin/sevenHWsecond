package com.dimakaplin143.locale;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String lang;
    private Spinner langSpinner;
    private Button btnOk;
    Locale locale;
    Configuration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        langSpinner = findViewById(R.id.spinner);
        initSpinnerLang();
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(v-> {
            switch (lang) {
                case "Ру":
                    locale = new Locale("ru");
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
                case "En":
                    locale = new Locale("en");
                    config = new Configuration();
                    config.setLocale(locale);
                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
            }
        });



    }

    private void initSpinnerLang() {
        ArrayAdapter<CharSequence> adapterLang = ArrayAdapter.createFromResource(this, R.array.lang, android.R.layout.simple_spinner_item);
        adapterLang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapterLang);
        langSpinner.setSelection(0);

        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] locales = getResources().getStringArray(R.array.lang);
                lang = locales[i];
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
