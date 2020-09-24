package com.myapp.myviewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class DataGenerator extends ViewModel {

   private String TAG= this.getClass().getName();
   private MutableLiveData<String> random_number;

    public MutableLiveData<String> getRandom_number(){
        Log.i(TAG, "Get number");
        if(random_number == null){
            //if null set the object of mutable live data
            random_number = new MutableLiveData<>();
            createNumber();
        }
        return random_number;
    }

    public void createNumber() {
    Log.i(TAG, "create number");
        Random random= new Random();
        random_number.setValue("Number:"+ (random.nextInt(10-1)+1));
    }

}
