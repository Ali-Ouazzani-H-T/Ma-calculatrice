package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

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
                return true;
            case R.id.Standard:
                Toast.makeText(this,"Calculatrice Standard selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.Scientifique:
                Toast.makeText(this,"Calculatrice Scientifique selected",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(HomePage.this,MainActivity2.class);
                startActivity(intent2);
                return true;
            case R.id.Graphique:
                Toast.makeText(this,"Calculatrice Graphique selected",Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(HomePage.this,graphique.class);
                startActivity(intent3);
                return true;
            case R.id.poids:
                Toast.makeText(this,"Convertisseur de poids",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(HomePage.this,Convertisseur_poids.class);
                startActivity(intent4);
                return true;
            case R.id.temperature:
                Toast.makeText(this,"Convertisseur de Temperature",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(HomePage.this,Temperature_convert.class);
                startActivity(intent5);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}