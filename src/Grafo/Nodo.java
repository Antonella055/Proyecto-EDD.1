/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

/**
 *
 * @author Antonella
 */
public class Nodo <E>{
    E valor;
    Nodo<E> siguiente;
    
    public Nodo(E valor){
        this.valor= valor;
        this.siguiente=null;
    }
}

