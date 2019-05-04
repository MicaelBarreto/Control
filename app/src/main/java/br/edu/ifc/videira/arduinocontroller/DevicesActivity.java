package br.edu.ifc.videira.arduinocontroller;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class DevicesActivity extends ListActivity {

    private BluetoothAdapter meuBluetoothAdapter2 = null;

    static String ENDERECO_MAC = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ArrayAdapter<String> ArrayBluetooth = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        meuBluetoothAdapter2 = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = meuBluetoothAdapter2.getBondedDevices(); //pega os dispositivos pareados e coloca no array

        if (pairedDevices.size() > 0){
            for(BluetoothDevice device : pairedDevices){
                String nomeBt = device.getName();
                String macBt = device.getAddress();
                ArrayBluetooth.add(nomeBt + "\n" + macBt);
            }
        }
        setListAdapter(ArrayBluetooth);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String info = ((TextView) v).getText().toString();
//        Toast.makeText(getApplicationContext(),"Info: " + info, Toast.LENGTH_LONG).show();

        String enderecoMac = info.substring(info.length() - 17);
//        Toast.makeText(getApplicationContext(),"Info: " + enderecoMac, Toast.LENGTH_LONG).show();

        Intent retornaMac = new Intent();
        retornaMac.putExtra(ENDERECO_MAC, enderecoMac); //armazena o MAC e envia para a outra classe
        setResult(RESULT_OK, retornaMac);
        finish();

    }
}
