package com.example.tareas2desapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Page2 extends AppCompatActivity implements View.OnClickListener {

    //1 declarr Bundle
    private TextView tvNombre;
    private TextView tvFnac;
    private TextView tvEmail;
    private TextView tvTel;
    private TextView tvDesc;


    Button YES,NO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Bundle datos = getIntent().getExtras();

        String nombre = datos.getString("Name");
        tvNombre = (TextView) findViewById(R.id.tv_p2_Name);
        tvNombre.setText(nombre);

        String Fnac = datos.getString("Fecha");
        tvFnac = (TextView) findViewById(R.id.tv_p2_fecha);
        tvFnac.setText(Fnac);

        String Tel = datos.getString("Tel");
        tvTel = (TextView) findViewById(R.id.tv_p2_tel);
        tvTel.setText(Tel);

        String Email = datos.getString("Email");
        tvEmail = (TextView) findViewById(R.id.tv_p2_email);
        tvEmail.setText(Email);

        String Desc = datos.getString("Desc");
        tvDesc = (TextView) findViewById(R.id.tv_p2_desc);
        tvDesc.setText(Desc);

        YES = (Button) findViewById(R.id.bn_YES);
        NO = (Button) findViewById(R.id.bn_NO);

        YES.setOnClickListener(this);
        NO.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == YES){
            Toast.makeText(this, "Excelente!...", Toast.LENGTH_LONG).show();
        }
        if (view == NO){
            Intent intent = new Intent(Page2.this,MainActivity.class);

            intent.putExtra("Name",tvNombre.getText().toString());
            intent.putExtra("Fecha",tvFnac.getText().toString());
            intent.putExtra("Tel",tvTel.getText().toString());
            intent.putExtra("Email",tvEmail.getText().toString());
            intent.putExtra("Desc",tvDesc.getText().toString());
            startActivity(intent);
            finish();
        }
    }

}