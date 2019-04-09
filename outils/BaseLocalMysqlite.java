package com.example.poste.covertisseurdemonnaie.outils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Poste on 24/03/2018.
 */

public class BaseLocalMysqlite extends SQLiteOpenHelper {
    //propriété

    private String creerTable = "create table element("
            + "datemesure Text PRIMARY KEY,"
            + "saisi REAL NOT NULL,"
            + "monnaie1 INTEGER NOT NULL,"
            + "monnaie2 INTEGER NOT NULL);";

    /**
     * constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public BaseLocalMysqlite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * que s''il y a changement de base de donneé (elle s'exécute)
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //exute une fois la creation table, le constructeut
        // vérifie si la table element exisite , s'elle existe il ne la recreer pas
        sqLiteDatabase.execSQL(creerTable);
    }

    /**
     * si changement de version (c'exécute, on travaile avec la meme base de donnee mais avec des version différentes)
     * @param sqLiteDatabase
     * @param i num de ancienne version
     * @param i1 nouvelle version
     */

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
