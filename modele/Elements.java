package com.example.poste.covertisseurdemonnaie.modele;

import java.util.Date;

/**
 * Created by Poste on 23/03/2018.
 */

public class Elements {


    ////////

    ////////
    //propriété
    //base locale
    private Date datemesure;
    private static  final double changebis = 0.8091;
    private float saisi;
    private float resultat;
    private Integer monnaie1;
    private Integer monnaie2;
    //private float change1 ;
    //private float change2;
    private String message;

   /* public Elements(float saisi, Integer monnaie1,Integer monnaie2, float change1,float change2) {
        this.saisi = saisi;
        this.monnaie1 = monnaie1;
        this.monnaie2 = monnaie2;
        this.change1 = change1;
        this.change2 = change2;
        //pour quelle soit appeler des le début
        this.ConvertMonnaie();
        this.indexMessage();
    }*/
    public Elements(Date datemesure,float saisi, Integer monnaie1,Integer monnaie2) {
       this.datemesure = datemesure;
        this.saisi = saisi;
        this.monnaie1 = monnaie1;
        this.monnaie2 = monnaie2;

        //pour quelle soit appeler des le début
        this.ConvertMonnaie();
        this.indexMessage();
    }

    public float getSaisi() {
        return saisi;
    }

    public float getResultat() {
        return resultat;
    }

    public Integer getMonnaie1() {
        return monnaie1;
    }
    public  Integer getMonnaie2(){
        return  monnaie2;
    }

   /* public float getChange1() {
        return change1;
    }
    public float getChange2(){
        return change2;
    }*/
    public Date getDatemesure() {
        return datemesure;
    }

    public String getMessage() {
        return message;
    }

    private void ConvertMonnaie(){
        if(monnaie1==1) {
            if(monnaie2==2) {
                //this.resultat = (float) (saisi * change1);
                this.resultat = (float) (saisi * changebis);

            }else if(monnaie2==3){
                this.resultat = (float) (saisi * 104);

            }else{
                this.resultat = (float)saisi;
            }
        }
        if (monnaie1==2){
            if(monnaie2==1){
                //this.resultat = (float)(saisi/change1);
                this.resultat = (float)(saisi/changebis);
            }
            if(monnaie2==2){
                this.resultat = (float)saisi;
            }if(monnaie2==3){
               //this.resultat = (saisi/change1) *change2;
                this.resultat = (float)((saisi/changebis) *104);

            }
        }
        if(monnaie1==3){
            if(monnaie2==1){
               // this.resultat = (float)saisi/change1;
                this.resultat = (float)(saisi/104);
            }
            if(monnaie2==2){
                //this.resultat = (saisi/change1) *change2;
                this.resultat = (float)((saisi/104) *changebis);
            }
            if(monnaie2==3){
                this.resultat = (float)saisi;
            }
        }



    }

    private void indexMessage(){
        if(monnaie2==1){
          message = "USD";
        }
        if(monnaie2==2){
          message = "EUR";
        }
        if(monnaie2==3){
           message = "YEN";
        }
    }

}
