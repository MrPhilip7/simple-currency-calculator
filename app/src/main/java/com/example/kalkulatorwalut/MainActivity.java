package com.example.kalkulatorwalut;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText editTextKursDolara, editTextKursEuro, editTextkwotaPLN;
    Button buttonPrzelicz;
    TextView kwotaUSD, kwotaEUR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextKursDolara = findViewById(R.id.editTextKursDolara);
        editTextKursEuro = findViewById(R.id.editTextKursEuro);
        editTextkwotaPLN = findViewById(R.id.editTextKwotaPLN);
        buttonPrzelicz = findViewById(R.id.buttonPrzelicz);
        kwotaUSD = findViewById(R.id.textViewDolary);
        kwotaEUR = findViewById(R.id.textViewEuro);

        buttonPrzelicz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kursDolaraValue = Double.parseDouble(editTextKursDolara.getText().toString());
                double kursEuroValue = Double.parseDouble(editTextKursEuro.getText().toString());

                // Sprawdź, czy tekst zawiera przecinek
                String text = editTextkwotaPLN.getText().toString();
                boolean hasComma = Pattern.compile(",").matcher(text).find();

                // Jeśli tekst zawiera przecinek, zastąp wszystkie przecinki kropkami
                if (hasComma) {
                    text = text.replace(",", ".");
                }

                // Konwertuj tekst na liczbę
                double kwotaPLNValue = Double.parseDouble(text);


                double wynikUSD = kwotaPLNValue / kursDolaraValue;
                double wynikEUR = kwotaPLNValue / kursEuroValue;

                kwotaUSD.setText(String.format("%.2f", wynikUSD));
                kwotaEUR.setText(String.format("%.2f", wynikEUR));
            }
        });
    }
}
