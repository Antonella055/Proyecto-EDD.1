package Estructuras;

import javax.swing.JOptionPane;


/**
 * Clase que representa una lista enlazada 
 * @author Giuseppe Vaccaro
 * @param <T> tipo de dato de los elementos en la lista
 */
public class List<T> {
    //Atributos de la clase
    private Node head;
    private Node tail;
    private int size;
    
       /**
     * Constructor sin parametros
     * En el se inicializa una lista vacia
     */
    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
     /**
    * Constructor que recibe uno o mas elementos para inicializar la lista
    * @param data Elementos a agregar a la lista
    */
    public List(T... data) {
        for (T elemento : data) {
            insertarFinal(elemento);
        }
    }
    
    //Getters and Setters
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    //Procedimientos y Metodos
    
     /**
     * Verifica si la lista esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return head == null;
    }
    
    /**
     * Retorna el tamano de la lista
     * @return tamano
     */
    public int len(){
        return getSize();
    }
    
     /**
     * Vacia la lista, eliminando todos los elementos
     */
    public void vaciar(){
        head = null;
        tail = null;
        size = 0;
    }
    
    /**
     * Agrega un elemento al final de la lista
     * @param data Elemento a agregar
     */
    public final void insertarFinal(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }
    
       /**
     * Agrega un elemento al inicio de la lista
     * @param data Elemento a agregar
     */
    public void insertarInicio(T data){
        Node newNode = new Node(data);
        if(isEmpty() == true){
            head = newNode;
            tail = newNode;
            size++;
        }
        else{
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }
    
        /**
     * Obtiene el valor de la posicion indicada de la lista
     * @param position Posicion del elemento deseado
     * @return  Valor en la posicion indicada o null si la posicion es invalida
     */
    public T get(int position){
        Node pointer = head;
        if(position < 0 || position >= len()){
            return null;
        }
        else if(position == 0){
            return (T) head.getData();
        }
        else if(position == len()-1){
            return (T) tail.getData();
        }
        else{
            for(int x = 0; x < position; x++){
                pointer = pointer.getNext();
            }
            return (T) pointer.getData();
        }
    }
    
     /**
     * Imprime los elementos de la lista
     */
    public void print(){
        Node pointer = head;
        if(isEmpty() == true){
            JOptionPane.showMessageDialog(null, "Lista vacia");
        }
        else{
            String list = "[";
            for(int x = 0; x < getSize(); x++){
                if(x != getSize()-1){
                    list = list + pointer.getData() + ", ";
                    pointer = pointer.getNext();
                }
                else{
                    list = list + pointer.getData() + "]";
                }
            }
            JOptionPane.showMessageDialog(null, list);
        }
    }
    
    /**
    * Inserta un elemento en la poscion indicada
    * @param position Posicion donde se insertará el elemento
    * @param data Elemento a insertar
    */
    public void insert(int position, T data){
        boolean run = true;
        Node newNode = new Node(data);
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    insertarInicio(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 1; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    newNode.setNext(pointer.getNext());
                    pointer.setNext(newNode);
                    size++;  
                    run = false;
                }
            }
        }
    }
    
       /**
    * Reemplaza un elemento en la posicion indicada de la lista
    * @param position Posicion del elemento a reemplazar
    * @param data Nuevo elemento
    */
    public void replace(int position, T data){
        boolean run = true;
 
        while(run == true){
            if(position < 0 || position >= len()){
                run = false;
            }
            else{
                if(position == 0){
                    head.setData(data);
                    run = false;
                }
                else if(position == len()-1){
                    tail.setData(data);
                    run = false;
                }
                else{
                    Node pointer = head;
                    for(int x = 0; x < position; x++){
                        pointer = pointer.getNext();
                    }
                    pointer.setData(data);
                    run = false;
                }
            }
        }
    }
    



/**
 * Elimina el ultimo nodo de la lista y retorna los datos eliminados
 * @return Datos del ultimo nodo eliminado o null si la lista está vacia
 */ 
    public T eliminarFinal(){ 
         if(isEmpty()){
             System.out.println("---  Error: Lista vacia  ---");
             return null;
        }else{
            Node aux = this.head;
             for (int i = 0; i < len()-2; i++) {
                 aux = aux.getNext();
                 
             }
             T data = (T) aux.getNext().getData();
             aux.setNext(null);
             size--;
//            while (aux.getNext().getNext() != null) {
//                aux = aux.getNext();
//            }

            return data; 
            
            
              
        }
  
    }
    
    
    
    /**
     * Eliminar  inicio 
     * @return datos eliminados
     */
    public T eliminarInicio(){ 
        if(isEmpty()){
             System.out.println("---  Error: Lista vacia  ---");
             return null;
        }else{
            T data = (T) this.head.getData();
            this.head = this.head.getNext();
            size--;
            return data;
              
        }
    }
    
    
    
    /**
     * 
     * @param index
     * @return 
     */
    public T pop(int index){
        if (index < 0 ||  index >= len()){
            System.out.println("Error: indice fuera de rango");
            return null;
            
        }else{
    
        if(isEmpty()){
             System.out.println("---  Error: Lista vacia  ---");
             return null;
        }
        else if(index == 0){
            return eliminarInicio();
        }
        else if(index == len()-1){
            return eliminarFinal();
        }
        else{
            Node aux = this.head;
            for (int i = 0; i < index-1; i++){
                aux = aux.getNext();
                
            }
            
            T data = (T) aux.getNext().getData();
            aux.setNext(aux.getNext().getNext());
            size--;
            return data;
            
           }
        }
    }

    
   /**
    * Verificar si en la lista 
    * @param value
    * @return 
    */
    public boolean contiene(T value) {
       Node aux = this.head;
        for (int i = 0; i < len(); i++) {
            if(value == aux.getData()){
                return true;
            }
            aux = aux.getNext();  
            }

        return false; 
    }
    
    public int indiceDe(T data){
        if(isEmpty()){
            System.out.println("Esta lista está vacia");
            return -1;
        }
        else{
            Node aux = this.head;
            
            for (int i = 0; i < len(); i++) {
                if(aux.getData() == data){
                    return i;
                }
                
            }
            return -1;
        }
    }
    
    public List copiar(){
        List newList = new List();
        if(isEmpty()){
            return newList;
        }
        else{
            Node aux = this.head;
            for (int i = 0; i < this.size; i++) {
                newList.insertarFinal(aux.getData());
                aux = aux.getNext();
            }
            return newList;
        }
        
    }
        
    }
   //Indice de, si no se usa ok
    


    
    
  