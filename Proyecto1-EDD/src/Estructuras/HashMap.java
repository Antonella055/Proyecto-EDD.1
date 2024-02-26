/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author Antonella
 * 
 * Clase HashMap que representa una tabla hash que almacena elementos en pares clave-valor.
 * @param <K> El tipo de claves almacenadas en el mapa 
 * @param <V> el tipo de valores almacenados en el mapa 
 */
public class HashMap<K,V>{ //almacenara elementos en pares clave-valor
    private static final int capacidad_inicial=16;
    public Entry<K,V>[] tabla;
    private int tamano;
/**
 * constructor de la clase 
 */
    public HashMap() {
        this.tabla = new Entry[capacidad_inicial];
        this.tamano = 0;
    }
    
    /**
     *  Método para insertar un par clave-valor en el mapa
     * Si la clave ya existe en el mapa, actualiza su valor
     * 
     * @param clave clave del par clave-valor a insertar
     * @param valor valor del par clave-valor a insertar
     */
    public void insertar (K clave, V valor){
        int indice= obtenerIndice(clave);
        Entry<K,V> entrada= tabla[indice]; //obt la primera entrda en la lista enlazda 
        
        while (entrada !=null){ 
            if (entrada.clave.equals(clave)){
                entrada.valor=valor;
                return;
            }
            entrada= entrada.siguiente;
        }
        
        Entry<K, V> nuevaEntrada = new Entry<>(clave, valor,entrada);
        nuevaEntrada.siguiente= tabla[indice];
        tabla[indice]=nuevaEntrada; 
        tamano++; 
    }

    
    /**
     * Método para obtener el valor asociado a una clave en el mapa
     * @param clave  clave cuyo valor asociado se quiere obtener.
     * @return  El valor asociado a la clave, o la clave si no se encuentra en el mapa
     */
    public V get (K clave){
         int indice= obtenerIndice(clave);
        Entry<K,V> entrada= tabla[indice]; 
        
        while (entrada !=null){ 
            if (entrada.clave.equals(clave)){
                return entrada.valor;
            }
            entrada= entrada.siguiente;
        }
        return (V) clave;
    }
    
    
    /**
     * Metodo para remover un par clave-valor del mapa 
     * @param clave La clave del par clave-valor a remover 
     */
    public void remover(K clave){
        int indice =obtenerIndice(clave);
        Entry<K,V> entrada=tabla[indice];
        Entry<K,V> previo=null; //recorrera la lista y almacenara el valor de la entrada anterior a nuesta entrada 
        
        while (entrada != null){
            if (entrada.clave.equals(clave)){ 
                if(previo ==null){ 
                    tabla[indice]= entrada.siguiente;
                }else{
                  
                    previo.siguiente= entrada.siguiente;
                }
                tamano--;
                return;
            }
            previo= entrada; 
            entrada= entrada.siguiente;
        }
    }
    
    /** 
     * Metodo para obtener el tamaño del mapa 
     * @return tamaño 
     */
    public int tamano(){
        return tamano;
    }
    
    /**
     *  Método privado para obtener el índice de una clave en la tabla
     * 
     * @param clave Clave del indice que se busca obtener 
     * @return indice de la clave en la tabla 
     */
    private int obtenerIndice(K clave) {
      int hashCode= clave.hashCode();// obtenemos el codigo hash de la clave proporcionada.
      return hashCode % tabla.length; //calcula el indice del arreglo 
    }
    
    
    /**
     * Método para verificar si una clave está en el mapa
     * @param clave La clave a verificar
     * @return Verdadero si la clave está en el mapa, falso en caso contrario
     */
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
    
    /**
     * Clase estatica Entry que representa yn par clave-valor en la tabla 
     * @param <K> El tipo de las claves almacenadas en la entrada 
     * @param <V> El tipo de los valores almacenados en la entrada 
     */
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
     /**
     * Método para imprimir el contenido del mapa
     * @param hashMap El mapa a imprimir
     */
    public void imprimirHashMap(HashMap<K, V> hashMap) {
    System.out.println("Contenido:");
    for (int i = 0; i < tabla.length; i++) {
        Entry<K, V> entrada = tabla[i];
        while (entrada != null) {
            System.out.println("Clave: " + entrada.clave + ", Valor: " + entrada.valor);
            entrada = entrada.siguiente;
        }
    }
}
    /**
     * Metodo para obtener el conjunto de clavers en el mapa
     * @return Un conjunto con las claves en el mapa
     */
    public Set<K>KeySet(){
        Set<K> llaves=new Set<>();
        for (Entry<K,V> entrada:tabla){
            while(entrada != null){
                llaves.agg(entrada.clave);
                entrada= entrada.siguiente;
            }
        }return llaves;
    }

    /**
     * Clase privada Set que respalda las operaciones del mapa para mantener una copia de las claves presentes en el mapa
     * 
     * @param <E> El tipo de elementos almacenados en el conjunto
     */
    private class Set<E>{
        private final List<E> elementos;

        public Set() {
            this.elementos = new List(10);
        }
        
        public void agg(E elemento){
            elementos.insertarFinal(elemento);
        }
        
    }
    
}
