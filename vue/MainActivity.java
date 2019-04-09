package com.example.poste.covertisseurdemonnaie.vue;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
//import  com.example.poste.covertisseurdemonnaie.controleur.Controle;

import com.example.poste.covertisseurdemonnaie.R;
import com.example.poste.covertisseurdemonnaie.controleur.Controle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controle = Controle.getInstance(this);
        //this.controle = Controle.getInstance();
    }
    //propriété
    private EditText txtSaisi;
    private  EditText txtResultat;
    private TextView lblResultat;
    private RadioButton rdUsd1;
    private RadioButton rdEur1;
    private RadioButton rdYen1;
    private RadioButton rdUsd2;
    private RadioButton rdEur2;
    private RadioButton rdYen2;
    //private Button btnConvert;
    private Controle controle;
    //fait le lien entre lespropriété et les objet graphique dans activity_main

    /**
     * inituialisation des lien avec les objet graphique
     */
    private void init(){
        txtSaisi = (EditText)findViewById(R.id.txtSaisi);
       // txtResultat = (EditText)findViewById(R.id.txtResultat);
        lblResultat = (TextView)findViewById(R.id.lblResultat);
        rdUsd1 = (RadioButton)findViewById(R.id.rdUsd1);
        rdEur1 = (RadioButton)findViewById(R.id.rdEur1);
        rdYen1 = (RadioButton)findViewById(R.id.rdYen1);
        rdUsd2 = (RadioButton)findViewById(R.id.rdUsd2);
        rdEur2 = (RadioButton)findViewById(R.id.rdEur2);
        rdYen2 = (RadioButton)findViewById(R.id.rdYen2);
        //btnConvert = (Button)findViewById(R.id.btnConvert);
        this.controle = Controle.getInstance(this);
        ecouteConvert();
        recupElement();
    }
    //gerel'evenement convert

    /**
     * ecoute evenement du botton convert
     */
    private void ecouteConvert(){
        ((Button)findViewById(R.id.btnConvert)).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){

               //Toast.makeText(MainActivity.this, "test",Toast.LENGTH_SHORT).show();
                //Log.d("message",":::::::::::clic ok sur le bouttonconver*******************");
                float saisi = 0;
                Integer monnaie1 = 1;
                Integer monnaie2 = 1;
                //récupération des donneés saisis
                try {
                   // saisi = Float.parseFloat(txtSaisi.getText().toString());
                   // saisi = Float.ValueOf(txtSaisi.getText().toString());
                    String str = txtSaisi.getText().toString();
                    float  f = Float.parseFloat(str);
                    saisi = f;
                    //saisi = Integer.parseInt(txtSaisi.getText().toString());
                }catch (Exception e){

                }
                if(rdUsd1.isChecked()){
                    monnaie1 = 1;
                }
                if(rdEur1.isChecked()){
                    monnaie1 = 2;
                }
                if(rdYen1.isChecked()){
                    monnaie1 = 3;
                }
                if(rdUsd2.isChecked()){
                    monnaie2 = 1;
                }
                if(rdEur2.isChecked()){
                    monnaie2 = 2;
                }
                if(rdYen2.isChecked()){
                    monnaie2 = 3;
                }
                //Controle des donneés saisis
                if(saisi==0){
                    Toast.makeText(MainActivity.this, "saisi incorrecte",Toast.LENGTH_SHORT).show();
                }else{
                    afficheResulte(saisi,monnaie1,monnaie2,MainActivity.this);

                }

            }
        });

    }

    /**
     *affichage du resultat et du message
     * @param sais
     * @param monnaie1
     * @param monnaie2
     */
    private void afficheResulte(Float sais, Integer monnaie1, Integer monnaie2, Context context){
        //creation du element et recuperartion des information
        this.controle.CreerElement(sais,monnaie1,monnaie2,context);
        float resulte = this.controle.getResultat();
        String message = this.controle.getMessage();
        //affichage
        if(message=="USD"){

            lblResultat.setText(resulte+" "+message);
           // txtResultat.setText(String.format("%.01",resulte));
        }else{
            if(message=="EUR"){
                lblResultat.setText(resulte+" "+message);
                //txtResultat.setText(String.format("%.01",resulte));
            }else{
                lblResultat.setText(resulte+" "+message);
                //txtResultat.setText(String.format("%.01",resulte));
            }
        }
    }

    /**
     * recupe profile si
     */
    private  void recupElement(){
        if(Float.toString(controle.getSaisi())!= null){
        //if(controle.getSaisi()!= null){
           // txtSaisi.setText( (controle.getSaisi()).toString());
              txtSaisi.setText( Float.toString(controle.getSaisi()).toString());
            if(controle.getMonnaie1()==1){
                rdUsd1.setChecked(true);
                rdEur1.setChecked(false);
                rdYen1.setChecked(false);
            }if (controle.getMonnaie1()==2){
                rdUsd1.setChecked(false);
                rdEur1.setChecked(true);
                rdYen1.setChecked(false);
            }
            if (controle.getMonnaie1()==3){
                rdUsd1.setChecked(false);
                rdEur1.setChecked(false);
                rdYen1.setChecked(true);
            }
            if(controle.getMonnaie2()==1){
                rdUsd2.setChecked(true);
                rdEur2.setChecked(false);
                rdYen2.setChecked(false);
            }
            if(controle.getMonnaie2()==2){
                rdUsd2.setChecked(false);
                rdEur2.setChecked(true);
                rdYen2.setChecked(false);
            }
            if(controle.getMonnaie2()==3){
                rdUsd2.setChecked(false);
                rdEur2.setChecked(false);
                rdYen2.setChecked(true);
            }
            //simule le clic sur le boutton convert

            ((Button)findViewById(R.id.btnConvert)).performClick();
        }

        }


}
