package com.example.realtimedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText nameEdit, ageEdit;
    private Button btn;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference("Students");

        nameEdit = findViewById(R.id.nameEditText);
        ageEdit = findViewById(R.id.ageEditText);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }

            private void saveData() {
                String name = nameEdit.getText().toString().trim();
                String age = ageEdit.getText().toString().trim();

                String key = databaseReference.push().getKey();

                DataModem student = new DataModem(name,age);
                databaseReference.child(key).setValue(student);
                Toast.makeText(getApplicationContext(),"Student info is added",Toast.LENGTH_LONG).show();
            }
        });
    }
}





































