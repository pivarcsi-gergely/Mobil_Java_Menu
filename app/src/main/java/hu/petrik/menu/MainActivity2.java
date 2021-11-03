package hu.petrik.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextNev;
    private Button buttonMentes;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        buttonMentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextNev.getText().toString().equals("")){
                    editTextNev.setError("Nem lehet üres a név!");
                }
                else {
                    editor.putString("nev", editTextNev.getText().toString());
                    editor.commit();
                    editor.apply();
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    public void init(){
        editTextNev = findViewById(R.id.editTextNev);
        buttonMentes = findViewById(R.id.buttonMentes);
        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
}