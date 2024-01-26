/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Antonella
 */
public class ListaDobleEnlazada {
    NodoLista pFirst;
    NodoLista pLast;
    int size;

    public ListaDobleEnlazada() {
        this.pFirst = null;
        this.pLast =null;
        this.size = 0;
    }
    
    public void agregarInicio(Object data){
        NodoLista newNodo=new NodoLista(data);
        if (pFirst==null){
            pFirst=pLast= newNodo;
        }else{
            pFirst.setBefore(newNodo);
            newNodo.setNext(pFirst);
            pFirst=newNodo;
        }size++;
    }
    
    public void agregarFinal(Object data){
        NodoLista newNodo=new NodoLista(data);
        if (pFirst==null){
            pFirst=pLast= newNodo;
        }else{
            pLast.setNext(newNodo);
            newNodo.setBefore(pFirst);
            pLast=newNodo;
        }size++;
    }
    
    public boolean eliminar(Object data){
        NodoLista actual=pFirst;
        while(actual !=null){
            if(actual.getData().equals(data)){
                if (actual==pFirst){
                    pFirst= actual.getNext();
                    if (pFirst != null){
                        pFirst.setBefore(null);
                    }
                }else if (actual==pLast){
                    pLast= actual.getBefore();
                    pLast.setNext(null);
                }else{
                    actual.getBefore().setNext(actual.getNext());
                    actual.getNext().setBefore(actual.getBefore());
                }
                size--;
                return true;
            }
            actual= actual.getNext();
        }
        return false;
    }
    
    public boolean buscar(Object elemento){
        NodoLista aux= pFirst;
        while(aux != null){
            if (aux.getData().equals(elemento)){
                 return true;
            }
               aux=aux.getNext();
        }
         return false;
    }
    
    public Object obtener(int indice){
        if (indice <0 || indice >= size) {
            throw new IndexOutOfBoundsException("indice fuera de rango");
            
        }NodoLista aux =pFirst;
        for (int i = 0; i < indice; i++) {
            aux=aux.getNext();
        }
        return aux.getData();
    }
}
