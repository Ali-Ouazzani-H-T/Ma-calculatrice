package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Temperature_convert extends AppCompatActivity {
    Button btnresulta;
    TextView afficheReponse;
    EditText getvalue;
    RadioButton Rk,Rk2,Rc,Rc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_convert);
        btnresulta =(Button) findViewById(R.id.btnresultat);
        afficheReponse=(TextView) findViewById(R.id.result);
        getvalue=(EditText) findViewById(R.id.inputnumber);
        Rk=(RadioButton) findViewById(R.id.btnK);
        Rc=(RadioButton)findViewById(R.id.btnC);
        Rk2=(RadioButton)findViewById(R.id.btnK2);
        Rc2=(RadioButton)findViewById(R.id.btnC2);

        btnresulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getvalue.getText().toString().isEmpty()){
                    afficheReponse.setText("please enter a number");}
                else
                {
                    Double x=Double.parseDouble(String.valueOf(getvalue.getText()));
                    if(Rk.isChecked() && Rk2.isChecked())
                    {
                        x=x;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(Rk.isChecked() && Rc2.isChecked())
                    {
                        x=x-273.15;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(Rc.isChecked() && Rc2.isChecked())
                    {
                        x=x;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(Rc.isChecked() && Rk2.isChecked())
                    {
                        x=x+273.15 ;
                        afficheReponse.setText(String.valueOf(x));
                    }
                }

            }
        });
    }
    ////////////MEnu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.Home:
                Toast.makeText(this,"Home page selected",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(Temperature_convert.this,HomePage.class);
                startActivity(intent3);
                return true;
            case R.id.Standard:
                Toast.makeText(this,"Calculatrice Standard selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Temperature_convert.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.Scientifique:
                Toast.makeText(this,"Calculatrice Scientifique selected",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Temperature_convert.this,MainActivity2.class);
                startActivity(intent2);
                return true;
            case R.id.Graphique:
                Toast.makeText(this,"Calculatrice Graphique selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.poids:
                Toast.makeText(this,"Convertisseur de poids",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(Temperature_convert.this,Convertisseur_poids.class);
                startActivity(intent5);
                return true;
            case R.id.temperature:
                Toast.makeText(this,"Convertisseur de Temperature",Toast.LENGTH_SHORT).show();

                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}