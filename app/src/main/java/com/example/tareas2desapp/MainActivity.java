package com.example.tareas2desapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etFecha;
    Button continuar;


    EditText name;
    EditText fecha;
    EditText email;
    EditText desc;
    EditText tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFecha = (EditText) findViewById(R.id.Fecha);
        etFecha.setOnClickListener(this);

        continuar = (Button) findViewById(R.id.Continuar);
        continuar.setOnClickListener(pasar);


        Bundle datos = getIntent().getExtras();

        if(datos != null){
            name = (EditText) findViewById(R.id.text_nombre);
            fecha = (EditText) findViewById(R.id.Fecha);
            email = (EditText) findViewById(R.id.text_correo);
            desc = (EditText) findViewById(R.id.text_descripcion);
            tel = (EditText) findViewById(R.id.text_tel);

            String nombre = datos.getString("Name");
            name.setText(nombre);

            String Fnac = datos.getString("Fecha");
            fecha.setText(Fnac);

            String Tel = datos.getString("Tel");
            tel.setText(Tel);

            String Email = datos.getString("Email");
            email.setText(Email);

            String Desc = datos.getString("Desc");
            desc.setText(Desc);
        }

    }



    //esto se hace cuando se declara una función específica.
    private View.OnClickListener pasar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            /* EditText name = (EditText) findViewById(R.id.text_nombre);
            EditText fecha = (EditText) findViewById(R.id.Fecha);
            EditText email = (EditText) findViewById(R.id.text_correo);
            EditText desc = (EditText) findViewById(R.id.text_descripcion);
            EditText tel = (EditText) findViewById(R.id.text_tel);
*/

            name = (EditText) findViewById(R.id.text_nombre);
            fecha = (EditText) findViewById(R.id.Fecha);
            email = (EditText) findViewById(R.id.text_correo);
            desc = (EditText) findViewById(R.id.text_descripcion);
            tel = (EditText) findViewById(R.id.text_tel);

            Intent intent = new Intent(MainActivity.this,Page2.class);
            //putExtra("nombreComoSeLLamaVariable",LoqueSeVayaAMandar)
//            intent.putExtra("Name",getResources().getString(R.string.etNombre));
            /* otra forma es usarlo a partir del ID
             primero hay que declarar el EditText para que exista en esta parte de forma local
            EditText name = (EditText) findViewById(R.id.text_nombre);
            // Luego, una vez declarado el intent. llamar de la forma:
            intent.putExtra("Name",name.getText().toString()); //y listo
            */

            intent.putExtra("Name",name.getText().toString());
            intent.putExtra("Fecha",fecha.getText().toString());
            intent.putExtra("Tel",tel.getText().toString());
            intent.putExtra("Email",email.getText().toString());
            intent.putExtra("Desc",desc.getText().toString());

            startActivity(intent);
            finish();

         // */
        }
    };

    //esto se corre si solo le haces al setOnClickListener el this, si no, debes declararlo como esta arriba
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        final Calendar c = Calendar.getInstance();
        int ano = c.get(Calendar.YEAR);
        int mes = c.get(Calendar.MONTH);
        int dia = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int day, int month, int year) {
                etFecha.setText(year+"/"+(month+1)+"/"+day);
            }
        }, ano, mes, dia);
        datePickerDialog.show();

    }


}