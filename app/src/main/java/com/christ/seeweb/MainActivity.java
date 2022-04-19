package com.christ.seeweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText urlET = findViewById(R.id.urlET);

        urlET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

                if(i == EditorInfo.IME_ACTION_SEARCH || i==EditorInfo.IME_ACTION_GO || i== EditorInfo.IME_ACTION_DONE){
                    final  String urlTxt = urlET.getText().toString();

                    if(!urlTxt.isEmpty()){

                        urlET.setText("");

                        Intent intent = new Intent(MainActivity.this, BrowserView.class);
                        intent.putExtra("url" , urlTxt);

                        startActivity(intent);

                    }
                }

                return false;
            }
        });


    }
}