package br.edu.ifc.videira.arduinocontroller;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostracontroles();
            }
        }, 3000);

    }

    private void mostracontroles(){
        Intent i = new Intent(SplashActivity.this, ControllerActivity.class);
        startActivity(i);
        finish();
    }


}
