package br.edu.ifc.videira.arduinocontroller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditActivity extends Activity {

   private Button btsave;
   EditText ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8, ed9;
//   String aux1, aux2, aux3, aux4, aux5, aux6, aux7, aux8, aux9;

    ControllerActivity c = new ControllerActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        btsave = findViewById(R.id.buttonsave);

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                c.bt1 = ed1.getText().toString();
//                c.bt2 = ed2.getText().toString();
//                c.bt3 = ed3.getText().toString();
//                c.bt4 = ed4.getText().toString();
//                c.bt5 = ed5.getText().toString();
//                c.bt6 = ed6.getText().toString();
//                c.bt7 = ed7.getText().toString();
//                c.bt8 = ed8.getText().toString();
//                c.bt9 = ed9.getText().toString();
                Intent intent2 = new Intent(getApplicationContext(), ControllerActivity.class);
                startActivity(intent2);
                finishAffinity();
            }
        });

    }

//    public void toController(View view){
//        Intent intent2 = new Intent(EditActivity.this, ControllerActivity.class);
//        startActivity(intent2);
//    }

}
