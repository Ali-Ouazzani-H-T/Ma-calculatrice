package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MainActivity extends AppCompatActivity {

    TextView workingTV;
    TextView resultTV;
    String enCours = "";




    //Calculatrice Standard
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();


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
                Intent intent3 = new Intent(MainActivity.this,HomePage.class);
                startActivity(intent3);
                return true;
            case R.id.Standard:
                Toast.makeText(this,"Calculatrice Standard selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Scientifique:
                Toast.makeText(this,"Calculatrice Scientifique selected",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                return true;
            case R.id.Graphique:
                Toast.makeText(this,"Calculatrice Graphique selected",Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(MainActivity.this,graphique.class);
                startActivity(intent2);
                return true;
            case R.id.poids:
                Toast.makeText(this,"Convertisseur de poids",Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(MainActivity.this,Convertisseur_poids.class);
                startActivity(intent4);
                return true;
            case R.id.temperature:
                Toast.makeText(this,"Convertisseur de Temperature",Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(MainActivity.this,Temperature_convert.class);
                startActivity(intent5);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void setEnCours(String value)
    {
        enCours += value;
        workingTV.setText(enCours);
    }

    private void initTextViews() {
        workingTV = (TextView) findViewById(R.id.textOperation);
        resultTV = (TextView) findViewById(R.id.textResult);
    }

    public void Onclick_C(View view) {
        workingTV.setText("0");
        resultTV.setText("");
        enCours="";
        bracket = true;
    }

    boolean bracket = true;

    public void Onclick_Brackets(View view) {
        if(bracket)
        {
            setEnCours("(");
            bracket = false;
        }else
        {
            setEnCours(")");
            bracket = true;
        }
    }
    // operations pour la puissance

    String formula = "";
    String tempFormula = "";
    private void checkForPowerOf()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < enCours.length(); i++)
        {
            if (enCours.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = enCours;
        tempFormula = enCours;
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< enCours.length(); i++)
        {
            if(isNumeric(enCours.charAt(i)))
                numberRight = numberRight + enCours.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(enCours.charAt(i)))
                numberLeft = numberLeft + enCours.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private boolean isNumeric(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void OnClick_1(View view) {
        setEnCours("1");
    }

    public void OnClick_pwr(View view) {
        setEnCours("^");
    }

    public void OnClick_division(View view) {
        setEnCours("/");
    }

    public void OnClick_7(View view) {
        setEnCours("7");
    }

    public void OnClick_8(View view) {
        setEnCours("8");
    }

    public void OnClick_9(View view) {
        setEnCours("9");
    }

    public void OnClick_multi(View view) {
        setEnCours("*");
    }

    public void OnClick_6(View view) {
        setEnCours("6");
    }

    public void OnClick_5(View view) {
        setEnCours("5");
    }

    public void OnClick_4(View view) {
        setEnCours("4");
    }

    public void OnClick_substract(View view) {
        setEnCours("-");
    }

    public void OnClick_3(View view) {
        setEnCours("3");
    }

    public void OnClick_2(View view) {
        setEnCours("2");
    }

    public void OnClick_Addition(View view) {
        setEnCours("+");
    }

    public void OnClick_point(View view) {
        setEnCours(".");
    }

    public void OnClick_0(View view) {
        setEnCours("0");
    }

    public void OnClick_egale(View view) {
        Double result  = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();
        try
        {
            result = (double) engine.eval(formula);
            enCours = String.valueOf(result);
        }catch(Exception e)
        {
            Toast.makeText(this,"invalid Input",Toast.LENGTH_SHORT).show();
        }

        if(result != null)
        {
            resultTV.setText(String.valueOf(result.doubleValue()));
        }
    }

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;

}