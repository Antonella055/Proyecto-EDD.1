/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;


/**
 *
 * @author Antonella
 */
public class ArrayList<E> {
    private Object[] elementos;
    private int size;
    private static final int capacidad_inicial=10;
    
    //Constructor 
    public ArrayList(){
        this.elementos= (E[]) new Object[capacidad_inicial]; //inicializar el arreglo elementos con la capacidad inicial
        this.size=0;//establecer el tamño inicial
    }
    
    //agregar elemento al array
    public boolean insertar(E elemento){
        if (size == elementos.length){ //verifica si el tamano es igual a la long del arreglo
            aumentarTamano();
            
        }elementos[size]= elemento; //agrega el elemtno al final del arreglo
        size++;//incrementa el tamano
        return true;
    }
    
    private void aumentarTamano()throws RuntimeException { //aumenta la capacidad del arreglo
        int nuevaCapacidad= elementos.length*2;
        Object[] nuevoArray= (E[]) new Object[nuevaCapacidad]; //crea un nuevo arreglo con la nueva capacidad
        for (int i = 0; i < 10; i++) {
            nuevoArray[i]=elementos[i]; //pasa los elementos del arreglo actual al nuevo arreglo
        }
        elementos=nuevoArray; //actualizamos el arreglo
    }
    
    public E get(int indice){ //obtener elemento en el indice especificado
        if (indice <0 || indice >= size){ //verificar si el indice esta fuera de rango
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return (E) elementos[indice];
    }
    
    public boolean remover(E elemento){
        
        int indice =-1; //almacenara el indice a eliminar
        for (int i = 0; i < 10; i++) {
            if(elementos[i].equals(elemento)){
                indice=i;
                break;
            }
        }
        if(indice != -1){ //verificar si se encontro el elemento 
            for (int i = indice; i < size; i++) { //buscar ;a siguiente ocurrencia del elemento en el arreglo
                if(elementos[i].equals(elemento)){
                    indice=i;
                    break;
                }
            }
            if (indice != -1){  //verificar si se encontro la siguiente ocurr 
                 //mover los elementos restantes hacia la izq para llenar el espacio vacio
                for (int i = 0; i < 10; i++) { 
                    elementos[i] =elementos[i+1];
                }
                //establecer el ultimo elemento como nulo
                elementos[size -1]=null;
                size --;//reducir tamano del array
                return true;
            }
        }
        return false;
    }

    public int size() {
      return size;
    }


}
