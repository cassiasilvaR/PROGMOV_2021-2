package com.example.eshelf;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static int versao=1;
    private static String name ="BaseDados_Cadastro.db";
    public DBHelper(Context context){
        super(context, name, null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE Usuario(cpf TEXT PRIMARY KEY, nome TEXT, email TEXT, celular INTEGER, senha TEXT);";
        db.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS Usuario;");
        onCreate(db);
    }

    public long CriarUsuario(String cpf, String nome, String email, int celular, String senha){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("cpf",cpf);
        cv.put("nome",nome);
        cv.put("email", email);
        cv.put("celular", celular);
        cv.put("senha", senha);

        long result = db.insert("Usuario",null, cv);
        return 0;
    }
    public String ValidarLogin(String email, String senha){
        return "";
    }
}
