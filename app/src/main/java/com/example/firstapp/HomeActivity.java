package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText inputNumber=findViewById(R.id.input_number);
        Button btnCompute=findViewById(R.id.compute_btn);
        final TextView textResult=findViewById(R.id.text_result);
        ListView list_view_result=findViewById(R.id.list_view_result);
        ListView lst = new ListView(this);
        List<String> data=new ArrayList<>();
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<>(this,R.layout.mytextview,data);
        list_view_result.setAdapter(stringArrayAdapter);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.orange_500)));


        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double number=Double.parseDouble(inputNumber.getText().toString());
                double result=number*65;
                textResult.setText(String.valueOf(result));
                data.add(number+"=>"+result);
                stringArrayAdapter.notifyDataSetChanged();
                inputNumber.setText("");
            }
        });

    }
}