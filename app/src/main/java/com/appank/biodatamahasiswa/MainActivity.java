package com.appank.biodatamahasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Jurusan = {"Teknik Informatika", "Sistem Informatika", "Farmasi.", "Ilmu Hukum", " Sastra & Bahasa Asing",
            "Ilmu Kelautan dan Perikanan", "Ilmu Sosial dan Ilmu Politik", "Sosiologi",
            "Kedokteran", " Kesehatan Masyarakat ", "Kedokteran Gigi", "Pendidikan Dokter Gigi", "Kehutanan", "Peternakan"};
    String[] Angkatan = {"2010", "2011", "2012", "2013", "2014","2015", "2016", "2017", "2018", "2019 ",
            "2020", "2021", "2022", "2023", "2024", "2025",
            "2026", "2027", "2028", "2029","2030"};
    Spinner jurusan, angkatan;
    Button button,clear;
    EditText editText_Nim, editText_NamaLengkap, editText_No_HP, editText_Alamat;
    RadioButton radioButton_L, radioButton_P;


    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton_L = findViewById(R.id.radioButton_L);
        radioButton_P = findViewById(R.id.radioButton_P);
        editText_Nim = findViewById(R.id.editText_Nim);
        editText_NamaLengkap = findViewById(R.id.editText_NamaLengkap);
        editText_No_HP = findViewById(R.id.editText_No_HP);
        editText_Alamat = findViewById(R.id.editText_Alamat);
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CLEAR();
            }
        });
        jurusan = findViewById(R.id.jurusan);
        jurusan.setOnItemSelectedListener(this);
        angkatan= findViewById(R.id.angkatan);
        angkatan.setOnItemSelectedListener(this);
        checkBox = findViewById(R.id.checkBox);
        ArrayAdapter jjurusan = new
                ArrayAdapter(this, android.R.layout.simple_spinner_item, Jurusan);

        jjurusan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter aangkatan = new
                ArrayAdapter(this, android.R.layout.simple_spinner_item, Angkatan);

        aangkatan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        jurusan.setAdapter(jjurusan);
        angkatan.setAdapter(aangkatan);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nim = editText_Nim.getText().toString();
                String Nama_lengkap = editText_NamaLengkap.getText().toString();
                String No_Hp = editText_No_HP.getText().toString();
                String Alamat = editText_Alamat.getText().toString();
                String jk = (radioButton_L.isChecked()) ? " Laki - Laki" :
                        (radioButton_P.isChecked()) ? " Perempuan" : "";
                String status = "Status : \b";
                if (checkBox.isChecked()) {
                    status += "Mahasiswa";
                }
                String jur = String.valueOf(jurusan.getSelectedItem());
                String angk = String.valueOf(angkatan.getSelectedItem());
                String maessage = "NIM :\b" + Nim + "\n" +
                        "Nama Lengkap :\b" + Nama_lengkap + "\n" +
                        "No Handpohne :\b" + No_Hp + "\n" +
                        "Alamat :\b" + Alamat + "\n" +
                        "Jenis Kelamin :\b" + jk + "\n" +
                        status + "\n" +
                        "Jurusan :\b" + jur + "\n" +
                        "Angkatan :\b" + angk + "\n";
                Toast.makeText(MainActivity.this, maessage,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        String msg = "\n";
        switch (view.getId()) {
            case R.id.radioButton_L:
                if (checked)
                    msg = "You Clicked Laki - Laki";
                break;
            case R.id.radioButton_P:
                if (checked)
                    msg = "You Clicked Perempuan ";
                break;
        }
        Toast.makeText(getApplicationContext(), msg,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long
            l) {
        Toast.makeText(getApplicationContext(), Jurusan[i],
                Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(), Angkatan[i],
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
    private void CLEAR() {
        editText_Nim.setText("");
        editText_NamaLengkap.setText("");
        editText_No_HP.setText("");
        editText_Alamat.setText("");
        checkBox.setChecked(false);
        radioButton_L.setChecked(false);
        radioButton_P.setChecked(false);
    }
}