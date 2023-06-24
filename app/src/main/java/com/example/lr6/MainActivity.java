package com.example.lr6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.yandex.mapkit.MapKitFactory;


public class MainActivity extends AppCompatActivity {

    private final String MAPKIT_API_KEY = "fab79335-94c8-4707-acbf-dd664dd6f52d";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapKitFactory.setApiKey(MAPKIT_API_KEY);

    }

    public void nextEvent(View v) {
        EditText name = findViewById(R.id.name);
        EditText surname = findViewById(R.id.surname);
        EditText e_mail = findViewById(R.id.e_mail);
        if (name.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Заполните обязательное поле", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User(name.getText().toString(), surname.getText().toString(), e_mail.getText().toString());

            /*Намерение (Intent) - это механизм для описания одной операции. В Android-приложениях многие операции работают через намерения.
              Наиболее распространённый сценарий использования намерения - запуск другой активности в своём приложении. */

            Intent intent = new Intent(this, ActivityList.class);
            intent.putExtra("user", user);  // передаем данные из одной активности в другу
            startActivity(intent);
        }
    }
}
