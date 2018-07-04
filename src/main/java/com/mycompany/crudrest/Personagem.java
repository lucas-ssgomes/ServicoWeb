/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudrest;

/**
 *
 * @author 20151D12GR0413
 */
public class Personagem {
    
    private String nome;
    private String classe;
    private int vida;
    private String arma;
    
    public Personagem(String nome, String classe,int vida, String arma ){
        this.nome = nome;
        this.classe = classe;
        this.vida = vida;
        this.arma = arma;
    }
    
    public String getNome() {
        return nome;
    }
    
     public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getClasse() {
        return classe;
    }
    
     public void setClasse(String classe) {
        this.classe = classe;
    }
     
    public int getVida(){
        return vida;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public String getArma() {
        return arma;
    }
    
     public void setArma(String arma) {
        this.arma = arma;
    }
}
