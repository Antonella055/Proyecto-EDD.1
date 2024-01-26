/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Antonella
 */
public class NodoLista {
    Object data;
    NodoLista next;
    NodoLista before;

    public NodoLista(Object data) {
        this.data = data;
        this.next = null;
        this.before = null;
    }

    public Object getData() {
        return data;
    }

    public NodoLista getNext() {
        return next;
    }

    public NodoLista getBefore() {
        return before;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(NodoLista next) {
        this.next = next;
    }

    public void setBefore(NodoLista before) {
        this.before = before;
    }
    
    
   
    
}
