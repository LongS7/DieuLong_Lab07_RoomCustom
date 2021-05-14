package com.longs7.android_lab07_lt_02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.longs7.android_lab07_lt_02.entity.Place;

public class MainActivity extends AppCompatActivity {

    private CustomTravelAdapter adapter;
    private EditText edtPlaceName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvTravel = findViewById(R.id.lvTravel);
        adapter = new CustomTravelAdapter(this, R.layout.place_item);

        lvTravel.setAdapter(adapter);

        edtPlaceName = findViewById(R.id.edtPlace);

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            if(!edtPlaceName.getText().toString().trim().isEmpty())
                adapter.add(new Place(edtPlaceName.getText().toString().trim()));
        });
    }
}