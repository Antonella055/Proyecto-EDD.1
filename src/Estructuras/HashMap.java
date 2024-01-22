/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Antonella
 * @param <K>
 * @param <V>
 */
public class HashMap<K,V>{ //almacenara elementos en pares clave-valor
    private static final int capacidad_inicial=16;
    private Entry<K,V>[] tabla;
    private int tamano;

    public HashMap() {
        this.tabla = new Entry[capacidad_inicial];
        this.tamano = 0;
    }
    
    public void insertar (K clave, V valor){
        int indice= obtenerIndice(clave);
        Entry<K,V> entrada= tabla[indice]; //obt la primera entrda en la lista enlazda 
        
        while (entrada !=null){ //recorre hasta el final o hasta encontrar una entrada con la misma clave
            if (entrada.clave.equals(clave)){
                entrada.valor=valor;
                return;
            }
            entrada= entrada.siguiente;
        }
        //se crea una nv entrada con clave-valor proporcionados. 3r arg representa la siguiente  entrada en la lista 
        Entry<K, V> nuevaEntrada = new Entry<>(clave, valor,entrada);
        nuevaEntrada.siguiente= tabla[indice];
        tabla[indice]=nuevaEntrada; //establece la nueva entrada como la primera 
        tamano++; //incrementa el tamano del Hash
    }
    
    public V get (K clave){
         int indice= obtenerIndice(clave);
        Entry<K,V> entrada= tabla[indice]; //obt la primera entrda en la lista enlazda 
        
        while (entrada !=null){ //recorre hasta el final o hasta encontrar una entrada con la misma clave
            if (entrada.clave.equals(clave)){
                return entrada.valor;
            }
            entrada= entrada.siguiente;
        }
        return null;
    }
    
    public void remover(K clave){
        int indice =obtenerIndice(clave);
        Entry<K,V> entrada=tabla[indice];
        Entry<K,V> previo=null; //recorrera la lista y almacenara el valor de la entrada anterior a nuesta entrada 
        
        while (entrada != null){
            if (entrada.clave.equals(clave)){ //validar si la clave de la entrada actual es igual a la que se busca
                if(previo ==null){ //valida si la entr actual es la primera en la lista
                    tabla[indice]= entrada.siguiente; //actualiza el 1er elemnto de la lista en el indice calculado en el arreglo tabla al sig elemnto de la lista
                }else{
                    //actualiza el campo sig de la entrada anterior para que apunte al sig elemnto de la lista, saltando la entrada actual
                    previo.siguiente= entrada.siguiente;
                }
                tamano--;
                return;
            }
            previo= entrada; //avanza al sig elemnto de la lista 
            entrada= entrada.siguiente;
        }
    }
    
    public int tamano(){
        return tamano;
    }
    
    private int obtenerIndice(K clave) {
      int hashCode= clave.hashCode();// obtenemos el codigo hash de la clave proporcionada.
      return hashCode % tabla.length; //calcula el indice del arreglo 
    }
    
    public boolean containsKey(K clave){
        int indice= obtenerIndice(clave);
        Entry<K,V> entrada= tabla[indice];
        
        while(entrada != null){
            if (entrada.clave.equals(clave)){
                return true;
            }entrada= entrada.siguiente;
        }
        return false;
    }
    
    
    public static class Entry<K, V> { //representa un par clvae-valor en la tabla 
    K clave;
    V valor;
    Entry<K,V> siguiente; //maneja colisiones en la tabla mediante listas enlazadas

    public Entry(K clave, V valor, Entry<K, V> siguiente) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = siguiente;
    }
}
}
