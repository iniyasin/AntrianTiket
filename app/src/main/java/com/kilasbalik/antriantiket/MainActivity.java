package com.kilasbalik.antriantiket;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edTextNama;
    private EditText edTextNotelp;
    private EditText edTextAlamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTextNama = (EditText) findViewById(R.id.nama);
        edTextNotelp = (EditText) findViewById(R.id.notelp);
        edTextAlamat = (EditText) findViewById(R.id.alamat);
        Button btnLoketSatu = (Button) findViewById(R.id.btn_loket_satu);
        Button btnLoketDua = (Button) findViewById(R.id.btn_loket_dua);

        btnLoketSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoketSatu.class);
                startActivity(intent);
                daftarAntrianLoketSatu();
                edTextNama.setText("");
                edTextNotelp.setText("");
                edTextAlamat.setText("");
            }
        });
        btnLoketDua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoketDua.class);
                startActivity(intent);
                daftarAntrianLoketDua();
                edTextNama.setText("");
                edTextNotelp.setText("");
                edTextAlamat.setText("");
            }
        });
    }

    private void daftarAntrianLoketSatu(){
        final String nama = edTextNama.getText().toString().trim();
        final String notelp = edTextNotelp.getText().toString().trim();
        final String alamat = edTextAlamat.getText().toString().trim();

        class DaftarAntrianLoketSatu extends AsyncTask<Void, Void, String> {
            private ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menambahkan...", "Tunggu....", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA, nama);
                params.put(Konfigurasi.KEY_NOTELP, notelp);
                params.put(Konfigurasi.KEY_ALAMAT, alamat);

                RequestHandler rh = new RequestHandler();
                return rh.sendPostRequest(Konfigurasi.URL_ADD_LOKET_SATU, params);
            }
        }
        DaftarAntrianLoketSatu da = new DaftarAntrianLoketSatu();
        da.execute();
    }

    private void daftarAntrianLoketDua(){
        final String nama = edTextNama.getText().toString().trim();
        final String notelp = edTextNotelp.getText().toString().trim();
        final String alamat = edTextAlamat.getText().toString().trim();

        class DaftarAntrianLoketDua extends AsyncTask<Void, Void, String>{
            private ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menambahkan...", "Tunggu....", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String, String> params = new HashMap<>();
                params.put(Konfigurasi.KEY_NAMA, nama);
                params.put(Konfigurasi.KEY_NOTELP, notelp);
                params.put(Konfigurasi.KEY_ALAMAT, alamat);

                RequestHandler rh = new RequestHandler();
                return rh.sendPostRequest(Konfigurasi.URL_ADD_LOKET_DUA, params);
            }
        }
        DaftarAntrianLoketDua da = new DaftarAntrianLoketDua();
        da.execute();
    }

    @Override
    public void onClick(View view) {
    }
}
