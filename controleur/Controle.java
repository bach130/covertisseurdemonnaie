package com.example.poste.covertisseurdemonnaie.controleur;

import android.content.Context;

import com.example.poste.covertisseurdemonnaie.modele.AccesLocal;
import com.example.poste.covertisseurdemonnaie.modele.Elements;

import java.util.Date;

/**
 * Created by Poste on 23/03/2018.
 */

public final class Controle {
    private static Controle instance = null;
    //pour labase Locle
    private static Elements element ;
    private static AccesLocal accesLocal;

    public Controle(){
        super();
    }

    public static final Controle getInstance(Context context){
        if(Controle.instance==null){
            Controle.instance = new Controle();
            //BD locale
           accesLocal = new AccesLocal(context);
            element = accesLocal.recupDernier();
        }
        return  Controle.instance;
    }

   /* public void CreerElement(float saisi,Integer monnaie1, Integer monnaie2,float change1,float change2){

        element = new Elements(saisi,monnaie1,monnaie2,change1,change2);
    }*/
    //////////////////////////////////////////////////
    public void CreerElement(float saisi, Integer monnaie1, Integer monnaie2, Context context){

        element = new Elements(new Date(),saisi,monnaie1,monnaie2);
        accesLocal.ajout(element);
    }

    public float getResultat(){
        return  element.getResultat();
    }
    public String getMessage(){
        return  element.getMessage();
    }

    public float getSaisi(){
        if(element == null){
            return Float.parseFloat(null);
            //return  null;
        }else{
            return  element.getSaisi();
        }
    }
    public  Integer getMonnaie1(){
        if(element==null){
            return  null;
        }else{
            return  element.getMonnaie1();
        }
    }
    public  Integer getMonnaie2(){
        if(element==null){
            return  null;
        }else{
            return  element.getMonnaie2();
        }
    }

}
