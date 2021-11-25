package com.example.eshelf;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Cadastrar extends AppCompatActivity {

    private EditText edtNomeCompleto, edtCpf, edtEmail, edtEmailConfirmacao, edtCelular, edtSenha1, edtSenha2;
    private DBHelper helper = new DBHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        edtNomeCompleto= findViewById(R.id.edt_nome_completo);
        edtCpf = findViewById(R.id.edt_cpf);
        edtEmail = findViewById(R.id.edt_email_cadastro);
        edtEmailConfirmacao = findViewById(R.id.edt_email_confirmar);
        edtCelular = findViewById(R.id.edt_celular);
        edtSenha1 = findViewById(R.id.edt_senha_cadastro);
        edtSenha2 = findViewById(R.id.edt_senha_cadastro_repeat);

    }

    public void cadastrar(View view) {
        String nome = edtNomeCompleto.getText().toString();
        String cpf= edtCpf.getText().toString();
        String email = edtEmail.getText().toString();
        String confirmaEmail = edtEmailConfirmacao.getText().toString();
        String celular = edtCelular.getText().toString();
        String senha = edtSenha1.getText().toString();
        String senha2 = edtSenha2.getText().toString();

        if(cpf.equals("")){
            Toast.makeText(Cadastrar.this, "CPF não inserido, tente novamente.", Toast.LENGTH_SHORT).show();
        }
        else if(nome.equals("")){
            Toast.makeText(Cadastrar.this, "Nome não inserido, tente novamente.", Toast.LENGTH_SHORT).show();
        }
        else if(email.equals("")){
            Toast.makeText(Cadastrar.this, "Email não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else if(celular.equals("")){
            Toast.makeText(Cadastrar.this, "Celular não inserido, tente novamente", Toast.LENGTH_SHORT).show();
        }
        else if(!email.equals(confirmaEmail)) {
            Toast.makeText(Cadastrar.this, "E-mail difere da confirmação de e-mail.", Toast.LENGTH_SHORT).show();
        }
        else if (!senha.equals(senha2)){
            Toast.makeText(Cadastrar.this, "Senha difere da confirmação de senha.", Toast.LENGTH_SHORT).show();
            edtSenha1.setText("");
            edtSenha2.setText("");
        }
        else {
            int numero = Integer.parseInt(edtCelular.getText().toString());

            Usuario user = new Usuario();
            user.setCpf(cpf);
            user.setEmail(email);
            user.setNome(nome);
            user.setSenha(senha);
            user.setNumero(numero);

            helper.inserirUsuario(user);
            Toast.makeText(Cadastrar.this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();
            limpar();
        }
    }

    private void limpar() {
        edtCpf.setText("");
        edtNomeCompleto.setText("");
        edtEmail.setText("");
        edtEmailConfirmacao.setText("");
        edtCelular.setText("");
        edtSenha1.setText("");
        edtSenha2.setText("");
    }

    public void cancelar(View view) {
        finish();
    }
}