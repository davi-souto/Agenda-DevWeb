/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Contato;
import java.util.ArrayList;

/**
 *
 * @author Raul
 */
public class Agenda {
    
    private ArrayList<Contato> contatos = new ArrayList<Contato>();
    
    public Contato AddContato(String nome, String email, String telefone, String rua, String bairro, String cidade, String estado){
        Contato c = new Contato(nome, email, telefone, rua, bairro, cidade, estado);
        contatos.add(c);
        return c;
    }
    
    public boolean RemoverContato(String nome){
        for(int i = 0; i < contatos.size(); i++){
            if(nome.equals(contatos.get(i).getNome())){
                contatos.remove(i);
            }     
        }
        return true;
    }
    
    public Contato BuscarContato (String nome){
        Contato b = null;
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getNome().equals(i)){
                contatos.get(i);
                b = contatos.get(i);
            }
        }
        return b;
    }
    
    public void AlterarCadastro(String nome, String email, String telefone, String rua, String bairro, String cidade, String estado){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getNome().equals(nome)){
                Contato novo = new Contato(nome, email, telefone, rua, bairro, cidade, estado);
                contatos.set(i, novo);
            }
        }
    }
    
    
}
