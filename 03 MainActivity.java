package com.example.tuhinbd2k.tuhinbrowser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etWebAddress;
    WebView wvDisplay;
    Button btnClear, btnGo, btnExit;
    String myurl;
    Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWebAddress = (EditText) findViewById(R.id.editTextWebAddress);
        wvDisplay    = (WebView) findViewById(R.id.webViewDisplay);
        btnClear     = (Button) findViewById(R.id.buttonClear);
        btnGo        = (Button) findViewById(R.id.buttonGo);
        btnExit      = (Button) findViewById(R.id.buttonExit);

        myurl = etWebAddress.getText().toString();
        flag = false;

        Intent intentApp3 = getIntent();
        myurl = intentApp3.getDataString();
//        Uri sentdata = intentApp3.getData();
//        URL sentURL = null;

        //myurl = intentApp3.getData().toString();

//        try {
//            sentURL = new URL(sentdata.getScheme(), sentdata.getHost(), sentdata.getPath());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }

//        if (myurl == null) {
//            wvDisplay.loadUrl(myurl);
//        } else {
//            wvDisplay.loadUrl(myurl);
//        }

        etWebAddress.setText(myurl);


        btnGo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View viewApp3Go) {
                        String goURL = etWebAddress.getText().toString();
                        wvDisplay.getSettings().setLoadsImagesAutomatically(true);
                        wvDisplay.getSettings().setJavaScriptEnabled(true);
                        wvDisplay.loadUrl(goURL);
                    }
                }
        );

        btnClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View viewApp3Clear) {
                        etWebAddress.setText("");
                    }
                }
        );

        btnExit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View viewApp3Exit) {
                        finish();
                    }
                }
        );
    }
}
