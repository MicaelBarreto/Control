package br.edu.ifc.videira.arduinocontroller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class ControllerActivity extends AppCompatActivity {


    Button btconect, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    String bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    TextView status;
    private static final int SOLICITA_BLUETOOTH = 1;
    private static final int SOLICITA_CONEXAO = 2;

    BluetoothAdapter meuBluetoothAdapter = null;
    BluetoothDevice meuDevice = null;
    BluetoothSocket meuSocket = null;

    ConnectedThread connectedThread;

    public boolean conexao = false;

    private static String MAC = null;

    UUID meuUUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controller);

        btconect = findViewById(R.id.btconect);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        status = findViewById(R.id.status);

        bt1 = null;
        bt2 ="f";
        bt3 = null;
        bt4 = "l";
        bt5 = "s";
        bt6 = "r";
        bt7 = "-";
        bt8 = "b";
        bt9 = "+";

        button1.setText(bt1);
        button2.setText(bt2);
        button3.setText(bt3);
        button4.setText(bt4);
        button5.setText(bt5);
        button6.setText(bt6);
        button7.setText(bt7);
        button8.setText(bt8);
        button9.setText(bt9);

        meuBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (meuBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Não há Bluetooth no seu dispositivo", Toast.LENGTH_LONG).show();
        } else if(!meuBluetoothAdapter.isEnabled()){
            Intent ativarBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(ativarBluetooth, SOLICITA_BLUETOOTH);
        }

        btconect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (conexao){
                    //desconecta
                    try{
                        meuSocket.close();
                        conexao = false;
                        btconect.setText("Conectar");
                        Toast.makeText(getApplicationContext(), "Bluetooth desconectado", Toast.LENGTH_LONG).show();

                        status.setText("Status: Desconectado");
                        status.setTextColor(Color.parseColor("#ff0000"));

                    }catch (IOException erro){
                        Toast.makeText(getApplicationContext(), "ERRO" + erro, Toast.LENGTH_LONG).show();
                    }

                } else {
                    //conecta
                    Intent openlist = new Intent(ControllerActivity.this, DevicesActivity.class);
                    startActivityForResult(openlist, SOLICITA_CONEXAO);
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt1 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt1);
                        button1.setText(bt1);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt2 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt2);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt3 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt3);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt4 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt4);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt5 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt5);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt6 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt6);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt7 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt7);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt8 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt8);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conexao){
                    if (bt9 == null){
                        Toast.makeText(getApplicationContext(), "Este botão não está configurado", Toast.LENGTH_LONG).show();
                    } else {
                        connectedThread.write(bt9);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Não há conexão", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {

            case SOLICITA_BLUETOOTH:
                if (resultCode == Activity.RESULT_OK){
                    Toast.makeText(getApplicationContext(), "Bluetooth ativado", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Não foi possível conectar", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;

            case SOLICITA_CONEXAO:
                if (resultCode == Activity.RESULT_OK){
                    MAC = data.getExtras().getString(DevicesActivity.ENDERECO_MAC);
                    meuDevice = meuBluetoothAdapter.getRemoteDevice(MAC);

                    try {
                        meuSocket = meuDevice.createRfcommSocketToServiceRecord(meuUUID);
                        meuSocket.connect();
                        conexao = true;
                        btconect.setText("Desconectar");

                        connectedThread = new ConnectedThread(meuSocket);
                        connectedThread.start();

                        Toast.makeText(getApplicationContext(), "Conexão efetuada com sucesso", Toast.LENGTH_LONG).show();
                        status.setText("Status: Conectado com " + MAC);
                        status.setTextColor(Color.parseColor("#00ff00"));


                    } catch (IOException erro) {
                        conexao = false;
                        Toast.makeText(getApplicationContext(), "Ocorreu um erro" , Toast.LENGTH_LONG).show();

                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Falha ao obter o MAC", Toast.LENGTH_LONG).show();
                }
        }
    }

    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;

        public ConnectedThread(BluetoothSocket socket) {

            InputStream tmpIn = null;
            OutputStream tmpOut = null;

            // Get the input and output streams, using temp objects because
            // member streams are final
            try {
                tmpIn = socket.getInputStream();
                tmpOut = socket.getOutputStream();
            } catch (IOException e) { }

            mmInStream = tmpIn;
            mmOutStream = tmpOut;
        }

        public void run() {
            byte[] buffer = new byte[1024];  // buffer store for the stream
            int bytes; // bytes returned from read()

//            while (true) {
//                try {
//                    // Read from the InputStream
//                    bytes = mmInStream.read(buffer);
//                    // Send the obtained bytes to the UI activity
//                    mHandler.obtainMessage(MESSAGE_READ, bytes, -1, buffer)
//                            .sendToTarget();
//                } catch (IOException e) {
//                    break;
//                }
//            }
        }

        public void write(String envio) {
            byte[] msgBuffer = envio.getBytes();
            try {
                mmOutStream.write(msgBuffer);
            } catch (IOException e) { }
        }

    }


    public void toEdit(View view){
        Intent intent5 = new Intent(ControllerActivity.this, EditActivity.class);
        startActivity(intent5);
    }


}
