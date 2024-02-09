/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Estructuras.ListaArray;

/**
 *
 * @author Antonella
 * @param <E>
 */
public class Vertice {
    int valor;
    Vertice next;
    Vertice before;
    
    public Vertice(int valor){
        this.valor= valor;
        this.next=null;
        this.before=null;
    }
}

