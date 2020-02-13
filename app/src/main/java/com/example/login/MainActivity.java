package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MyMessage";


    private EditText editText;
    private EditText Id;
    private EditText Password;
    private Button saveButton;
    private Button logoutButton;




    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String ID = "id";
    public static final String PASSWORD = "password";


    private String text;
    private String id;
    private String password;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.edittext);
        Id = (EditText) findViewById(R.id.LOGINID);
        Password = (EditText) findViewById(R.id.PASSWORD);



        saveButton = (Button) findViewById(R.id.save_button);
        logoutButton = (Button)findViewById(R.id.Logout_button);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }
        });

        loadData();


            if(text.length()==0) {

                Intent i = new Intent(this, Demo.class);
                startActivity(i);

            }

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, editText.getText().toString());
        editor.putString(ID, Id.getText().toString());
        editor.putString(PASSWORD, Password.getText().toString());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
        //Intent i = new Intent(this, Login.class);
        //startActivity(i);
    }





    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        id = sharedPreferences.getString(ID, "");
        password = sharedPreferences.getString(PASSWORD, "");

        editText.setText(text);
        Password.setText(id);
        Id.setText(password);

      //  Toast.makeText(this,text, Toast.LENGTH_SHORT).show();

    }





    public void logout()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove(TEXT);
        editor.remove(ID);
        editor.remove(PASSWORD);


        editor.apply();

        Intent i = new Intent(this, Demo.class);
        startActivity(i);

    }
}


