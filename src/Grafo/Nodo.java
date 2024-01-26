/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

/**
 *
 * @author Antonella
 * @param <E>
 */
public class Nodo <E>{
    E valor;
    Nodo<E> next;
    Nodo<E>before;
    
    public Nodo(E valor){
        this.valor= valor;
        this.next=null;
        this.before=null;
    }
}

