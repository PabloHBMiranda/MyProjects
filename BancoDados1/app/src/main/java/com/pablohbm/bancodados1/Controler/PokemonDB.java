package com.pablohbm.bancodados1.Controler;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.pablohbm.bancodados1.Model.Pokemon;

public class PokemonDB extends SQLiteOpenHelper {

    private static final int version = 1;
    private static final String nomeDB = "db_pokemon";
    private static final String c_cod = "cod";
    private static final String c_nome = "nome";
    private static final String c_tipo = "tipo";
    private static final String c_numero = "numero";
    private static final String tb_pokemon = "pokedex";
    public static Context contexto;

    public PokemonDB(@Nullable Context context) {
        super(context, nomeDB, null, version);
        contexto = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREATE TABLE pokemon (cod INTEGER PRIMAY KEY, ...)
        String query = "CREATE TABLE "+tb_pokemon +
                "(" + c_cod + " INTEGER PRIMARY KEY, " +
                c_nome + " TEXT, " +
                c_tipo + " TEXT, " +
                c_numero + " TEXT)";
        sqLiteDatabase.execSQL(query);

    }

    public Pokemon selectPokemon(int cod){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tb_pokemon, new String[]{
                c_cod, c_nome,c_tipo, c_numero
        },cod + " = ?",new String[]{String.valueOf(cod)},null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        else{
            return null;
        }
        Pokemon pkm = new Pokemon(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3));
        return pkm;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
