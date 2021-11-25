package com.example.eshelf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "eShelf.db";

    SQLiteDatabase db;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuario(cpf text primary key, nome text not null, " +
                "email text not null, senha text not null, numero integer not null);");
        db.execSQL("create table endereco(id int primary key autoincrement, cpf_usuario text " +
                "not null, cidade text not null, uf text not null, bairro text not null, " +
                "rua text not null, numero_casa int not null, foreign key(cpf_usuario) references usuario(cpf));");
        db.execSQL("create table livro(ibsn text primary key, nome text not null, edicao text not null, " +
                "autor text not null, categoria text not null, ano int not null, preco_compra real not null, preco_emprestimo real not null);");
        db.execSQL("create table acao(id int primary key autoincrement, data datetime not null default current_timestamp, ibsn_livro " +
                "text not null, cpf_usuario text not null, ato int not null, " +
                "foreign key(ibsn_livr) references livro(ibsn), foreign key(cpf_usuario) references usuario(cpf));");
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS endereco");
        db.execSQL("DROP TABLE IF EXISTS livro");
        this.onCreate(db);
    }

    public void inserirUsuario(Usuario usuario){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cpf", usuario.getCpf());
        values.put("nome", usuario.getNome());
        values.put("email", usuario.getEmail());
        values.put("senha", usuario.getSenha());
        values.put("numero", usuario.getNumero());

        db.insert("usuario", null, values);
        db.close();
    }

    public void inserirEndereco(Endereco endereco){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("cpf_usuario", endereco.getCpfUsuario());
        values.put("cidade", endereco.getCidade());
        values.put("uf", endereco.getUf());
        values.put("bairro", endereco.getBairro());
        values.put("rua", endereco.getRua());
        values.put("numero", endereco.getNumeroCasa());

        db.insert("endereco", null, values);
        db.close();
    }

    public void inserirLivro(Livro livro){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ibsn", livro.getIbsn());
        values.put("nome", livro.getNome());
        values.put("edicao", livro.getEdicao());
        values.put("ano", livro.getAno());
        values.put("autor", livro.getAutor());
        values.put("categoria", livro.getCategoria());
        values.put("preco_compra", livro.getPrecoCompra());
        values.put("preco_emprestimo", livro.getPrecoEmprestimo());

        db.insert("livro", null, values);
        db.close();
    }

    public void registrarAcao(Acao acao){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ato", acao.getAto());
        values.put("cpf_usuario", acao.getCpf_usuario());
        values.put("ibsn_livro", acao.getIbsn_livro());

        db.insert("acao", null, values);
        db.close();
    }
    public String buscarSenha(String email){
        db = this.getReadableDatabase();
        String query = "select email, senha from " + "usuario";
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b = "Usuário não encontrado";

        if(cursor.moveToFirst()){
            do {
                a = cursor.getString(0);
                if(a.equals(email)){
                    b = cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        cursor.close();
        return b;
    }
}
