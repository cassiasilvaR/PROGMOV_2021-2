package com.example.eshelf;

import java.time.LocalDateTime;

public class Acao  {
    private int id, ato;
    private LocalDateTime data;
    private String cpf_usuario;
    private String ibsn_livro;;

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getIbsn_livro() {
        return ibsn_livro;
    }

    public void setIbsn_livro(String ibsn_livro) {
        this.ibsn_livro = ibsn_livro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public int getAto() {
        return ato;
    }

    public void setAto(int ato) {
        this.ato = ato;
    }
}
