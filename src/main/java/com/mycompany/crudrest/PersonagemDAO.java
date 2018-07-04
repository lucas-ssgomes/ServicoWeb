/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudrest;

import java.util.ArrayList;

/**
 *
 * @author 20151D12GR0413
 */
public class PersonagemDAO {
    
    private final ArrayList<Personagem> personagens = new ArrayList<>();
    private static PersonagemDAO instance;
    
    public PersonagemDAO(){  
    }
    
    public boolean adicionar(Personagem personagem) {
        return this.personagens.add(personagem);
    }
    
    public static PersonagemDAO getInstance() {
        if (instance == null) {
            instance = new PersonagemDAO();
        }
        return instance;
    }


    public Personagem recuperar(String nome) {
        Personagem l = null;
        for(int i=0;i<this.personagens.size();i++){
            if(personagens.get(i).getNome().equals(nome)){
                l = personagens.get(i);
            }
        }
        return l;
    }
    
    public boolean alterar(String nome, Personagem l) {
        for(int i=0;i<this.personagens.size();i++){
            if(personagens.get(i).getNome().equals(nome)){
                personagens.add(i, l);
            }
        }
        return true;
    }
    
    public boolean deletar(String nome){
         for(int i=0;i<this.personagens.size();i++){
            if(personagens.get(i).getNome().equals(nome)){
                personagens.remove(i);
            }
        }
        return true;
    }
    
    public  ArrayList<Personagem> recuperarTodos(){
        return this.personagens;
    }
}
