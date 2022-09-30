package hu.petrik.android.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button buttonSubmit;
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adatMentes();
            }


        });
    }

    private void adatMentes() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String seged = editTextInput.getText().toString();
        if (seged.equals("")){
            editTextInput.setError("Muszáj kitölteni");
        } else {
            editor.putString("editTextErteke", seged);
            editor.commit();
            editor.apply();
            Intent intent = new Intent(MainActivity.this, MasodikActivity.class);
            startActivity(intent);

            finish();
        }

    }
    private void init(){

        buttonSubmit = findViewById(R.id.buttonSubmit);
        editTextInput = findViewById(R.id.editTextInput);


    }

}