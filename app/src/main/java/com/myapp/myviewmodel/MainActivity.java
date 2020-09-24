package com.myapp.myviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String TAG =this.getClass().getName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      final  TextView textView= findViewById(R.id.textView);
        Button button= findViewById(R.id.button);
                //  DataGenerator dg= new DataGenerator();
      final DataGenerator model =  ViewModelProviders.of(this).get(DataGenerator.class);
       final LiveData<String> random_number=model.getRandom_number();

        //observe that live data coming from method getRandom_number by using the observe method,
        // first param lifecycle owner, 2nd param is onchange method control what happens when livedata object is changed
        random_number.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

      button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              model.createNumber();
          }
      });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "view model is destroyed");
    }
}