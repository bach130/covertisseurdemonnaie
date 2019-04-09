package com.example.poste.covertisseurdemonnaie.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.poste.covertisseurdemonnaie.outils.BaseLocalMysqlite;

import java.util.Date;

/**
 * Created by Poste on 24/03/2018.
 */
//class qui exploite la class BaseLocalMysqlite
public class AccesLocal {


    //propriété,mémérosé le nom de la BD
    private String nomBase ="bdConvertisseurMonnaie.sqlite";
    private Integer versionBase = 1;
    //objet qui accede à la class BaseLocalMysqlite
    private BaseLocalMysqlite accesBD;
    // une propriété qui permet de creer des canneaux pour lire et ecrire dans la BD
    private SQLiteDatabase bd;
    private String req;

    /**
     * constructeur
     * @param context
     */
    // il faudra envoyer le context qu'on instencira la class
    public AccesLocal(Context context){
        accesBD = new BaseLocalMysqlite(context,nomBase,null,versionBase);
    }
    //methode qui permet d'ajouter un profile

    /**
     * ajout d'un element dans la BD
     * @param element
     */
    public void ajout(Elements element){
        //ecrire avec le getWrit...
        bd = accesBD.getWritableDatabase();
       String req = "insert into element (datemesure,saisi,monnaie1,monnaie2) values";
        req+= "(\""+element.getDatemesure()+"\","+element.getSaisi()+","+element.getMonnaie1()+","+element.getMonnaie2()+")";
        bd.execSQL(req);
        /*req = "insert into profil (datemesure, saisi, monnaie1, monnaie2) values(\"" + element.getDatemesure() + "\"," + element.getSaisi() +
                "," + element.getMonnaie1() + "," + element.getMonnaie2() + ")";
        bd.execSQL(req);*/

    }
    // methode permet de recp  le dernier element inséré dans la BD

    /**
     * Recuparatio du dernier element da la BD
     * @return
     */
    public Elements recupDernier(){

        bd = accesBD.getReadableDatabase();
        Elements element = null;
         req = "select * from element";
        // quand on travail avec le resultat d'une requete select on a besion //
        // d'un curseur qui lira ligne par ligne le info recup par le select
        Cursor curseur = bd.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast()){
            Date date = new Date();
            float saisi = curseur.getInt(1);
            Integer monnaie1 = curseur.getInt(2);
            Integer monnaie2 = curseur.getInt(3);
            element = new Elements(date,saisi,monnaie1,monnaie2);

        }
        curseur.close();
        return  element;
    }
}
