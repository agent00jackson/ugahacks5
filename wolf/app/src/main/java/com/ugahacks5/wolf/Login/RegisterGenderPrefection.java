package com.ugahacks5.wolf.Login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ugahacks5.wolf.R;
import com.ugahacks5.wolf.Utils.User;


/**
 * DatingApp
 * https://github.com/quintuslabs/DatingApp
 * Created on 25-sept-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class RegisterGenderPrefection extends AppCompatActivity {

    String password;
    User user;
    boolean preferMale = true;
    private Button preferenceContinueButton;
    private Button hobbiesContinueButton;
    private Button maleSelectionButton;
    private Button femaleSelectionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_gender_prefection);

        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("classUser");
        password = intent.getStringExtra("password");


        maleSelectionButton = findViewById(R.id.maleSelectionButton);
        femaleSelectionButton = findViewById(R.id.femaleSelectionButton);
        preferenceContinueButton = findViewById(R.id.preferenceContinueButton);
        //By default male has to be selected so below code is added

        femaleSelectionButton.setAlpha(.5f);
        femaleSelectionButton.setBackgroundColor(Color.GRAY);


        maleSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleButtonSelected();
            }
        });

        femaleSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleButtonSelected();
            }
        });

        preferenceContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAgeEntryPage();
            }
        });


    }

    public void maleButtonSelected() {
        preferMale = true;
        maleSelectionButton.setBackgroundColor(Color.parseColor("#12B8FF"));
        maleSelectionButton.setAlpha(1.0f);
        femaleSelectionButton.setAlpha(.5f);
        femaleSelectionButton.setBackgroundColor(Color.GRAY);
    }

    public void femaleButtonSelected() {
        preferMale = false;
        femaleSelectionButton.setBackgroundColor(Color.parseColor("#12B8FF"));
        femaleSelectionButton.setAlpha(1.0f);
        maleSelectionButton.setAlpha(.5f);
        maleSelectionButton.setBackgroundColor(Color.GRAY);
    }

    public void openAgeEntryPage() {
        String preferSex = preferMale ? "male" : "female";
        user.setPreferSex(preferSex);
        Intent intent = new Intent(this, RegisterAge.class);
        intent.putExtra("password", password);
        intent.putExtra("classUser", user);
        startActivity(intent);
    }
}
