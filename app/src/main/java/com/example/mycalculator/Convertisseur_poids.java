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

public class Convertisseur_poids extends AppCompatActivity {

    Button btnresulta;
    TextView afficheReponse;
    EditText getvalue;
    RadioButton Rcm,RM,Rdm,Rmm,Rcm1,RM1,Rmm1,Rdm1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertisseur_poids);
        btnresulta =(Button) findViewById(R.id.btnresultat);
        afficheReponse=(TextView) findViewById(R.id.result);
        getvalue=(EditText) findViewById(R.id.inputnumber);
        Rcm=(RadioButton) findViewById(R.id.btncg);
        RM=(RadioButton)findViewById(R.id.btng);
        Rdm=(RadioButton)findViewById(R.id.btndg);
        Rmm=(RadioButton)findViewById(R.id.btnmg);
        Rcm1=(RadioButton)findViewById(R.id.btnCg);
        RM1=(RadioButton)findViewById(R.id.btng2);
        Rmm1=(RadioButton)findViewById(R.id.btnMg);
        Rdm1=(RadioButton)findViewById(R.id.btnDg);
        btnresulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getvalue.getText().toString().isEmpty()){
                    afficheReponse.setText("please enter a number");}
                else
                {
                    Double x=Double.parseDouble(String.valueOf(getvalue.getText()));
                    if(RM.isChecked() && RM1.isChecked())
                    {
                        x=x;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(RM.isChecked() && Rcm1.isChecked())
                    {
                        x=x*100;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(RM.isChecked() && Rmm1.isChecked())
                    {
                        x=x*1000;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    else if(RM.isChecked() && Rdm1.isChecked())
                    {
                        x=x*10;
                        afficheReponse.setText(String.valueOf(x));
                    }
                    if(Rcm.isChecked())
                    {
                        if(Rcm1.isChecked())
                        {
                            x=x;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(Rdm1.isChecked())
                        {
                            x=x*0.1;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(Rmm1.isChecked())
                        {
                            x=x*10;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(RM1.isChecked())
                        {
                            x=x*0.01;
                            afficheReponse.setText(String.valueOf(x));
                        }
                    }
                    if(Rdm.isChecked())
                    {
                        if(Rdm1.isChecked())
                        {
                            x=x;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(Rcm1.isChecked())
                        {
                            x=x*10;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(Rmm1.isChecked())
                        {
                            x=x*100;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        else if(RM1.isChecked())
                        {
                            x=x*0.1;
                            afficheReponse.setText(String.valueOf(x));
                        }

                    }
                    if(Rmm.isChecked())
                    {
                        if(Rmm1.isChecked())
                        {
                            x=x;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        if(Rdm1.isChecked())
                        {
                            x=x*0.1;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        if(Rcm1.isChecked())
                        {
                            x=x*0.01;
                            afficheReponse.setText(String.valueOf(x));
                        }
                        if(RM1.isChecked())
                        {
                            x=x/1000;
                            afficheReponse.setText(String.valueOf(x));
                        }

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
                Intent intent3 = new Intent(Convertisseur_poids.this,HomePage.class);
                startActivity(intent3);
                return true;
            case R.id.Standard:
                Toast.makeText(this,"Calculatrice Standard selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Convertisseur_poids.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.Scientifique:
                Toast.makeText(this,"Calculatrice Scientifique selected",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(Convertisseur_poids.this,MainActivity2.class);
                startActivity(intent2);
                return true;
            case R.id.Graphique:
                Toast.makeText(this,"Calculatrice Graphique selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.poids:
                Toast.makeText(this,"Convertisseur de poids",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.temperature:
                Toast.makeText(this,"Convertisseur de Temperature",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(Convertisseur_poids.this,Temperature_convert.class);
                startActivity(intent5);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}