/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.show.model;

import java.io.Serializable;

/**
 *
 * @author ronifabio
 */
public class Extra implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean necessidadeEspecial;
    private String telefone;
    private int idade;
    private Integer avaliação;
    private String comentario;

    public Extra() {
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public Integer getAvaliação() {
        return avaliação;
    }

    public void setAvaliação(Integer avaliação) {
        this.avaliação = avaliação;
    }

    public void setNecessidadeEspecial(boolean necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
