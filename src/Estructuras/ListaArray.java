package Estructuras;
/**
 *
 * @author Antonella
 * @param <T>
 */

public class ListaArray<T>{
    
    private Integer head;
    private int size, maxSize;
    private NodoArray<T>[] array;
    

    public ListaArray(int maxSize) {
        this.head = null;
        this.size = 0;
        this.maxSize = maxSize;
        this.array = new NodoArray[0];
        
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public NodoArray[] getArray() {
        return array;
    }

    public void setArray(NodoArray[] array) {
        this.array = array;
    }

    /**
     * Método para insertar un elemento al inicio de la lista
     * @param element elemento a insertar
     */
    public void insertarInicio(Object element) {
        NodoArray nodo = new NodoArray(element);
        if (getSize() >= getMaxSize()) {
            System.out.println("El maximo ya fue alcanzado");
        } else {
            int position = buscarEspacio();
            if (position == -1) {
                nodo.setNext(getHead());
                NodoArray[] newArray = copyArray();
                newArray[newArray.length-1] = nodo;
                setHead(newArray.length-1);
                setArray(newArray);
            } else {
                nodo.setNext(getHead());
                getArray()[position] = nodo;
                setHead(position);
            }
            size++;
        }
    }
    
/**
 * Metodo para copiar el arreglo actual a uno nuevo 
 * @return 
 */
    public NodoArray[] copyArray() {
        NodoArray[] newArray = new NodoArray[array.length + 1];
        for (int i = 0; i < getArray().length; i++) {
            newArray[i] = getArray()[i];
        }
        return newArray;
    }
    
    /**
     * Metodo para buscar un espacio vacío en el arreglo
     * @return El índice del espacio vacío, o -1 si no hay espacios vacíos
     */
    public int buscarEspacio(){
        for (int i = 0; i < getArray().length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Método para obtener el índice de un elemento en el arreglo
     * @param elemento elemento buscado 
     * @return el indice del elemento, 0-1 si no se encuentra en el arreglo 
     */
    public int indiceDe(Object elemento) {
    for (int i = 0; i < getArray().length; i++) {
        if (getArray()[i].getElement().equals(elemento)) {
            return i; // Devuelve el índice del elemento si se encuentra
        }
    }
    return -1; // Devuelve -1 si el elemento no se encuentra en la lista
}

 /**
     * Metodo para insertar un elemento en el arreglo
     * @param element El elemento a insertar
     */
    public void insertar(Object element) {
        NodoArray nodo = new NodoArray(element);
        if (getSize() >= getMaxSize()) {
            System.out.println("El maximo ya fue alcanzado");
        } else {
            int position = buscarEspacio();
            if (position == -1) {
                nodo.setNext(getHead());
                NodoArray[] newArray = copyArray();
                newArray[newArray.length-1] = nodo;
                setHead(newArray.length-1);
                setArray(newArray);
            } else {
                nodo.setNext(getHead());
                getArray()[position] = nodo;
                setHead(position);
            }
            size++;
        }
    }

    /**
     * funcion para insertar un elemento en un índice específico del arreglo
     * @param element El elemento a insertar
     * @param index El índice donde se insertará el elemento
     */
    public void insertarxIndice(T element, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    /**
     * funcion para eliminar el primer elemnto del arreglo 
     * @return elemento eliminado, o null si el arreglo es vacio 
     */
    public Object EliminarInicio() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoArray pointer = getArray()[getHead()];
            getArray()[getHead()] = null;
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;
            return pointer.getElement();
        }
        return null;
    }

    /**
     * Método para eliminar el último elemento del arreglo.
     * @return El elemento eliminado, o null si el arreglo está vacío.
     */
    public Object EliminarFinal() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
        } else {
            Integer pointer = getHead();
            while (getArray()[pointer] != null) {
                if(getArray()[getArray()[pointer].getNext()].getNext() != null) {
                    pointer = getArray()[pointer].getNext();
                } else {
                    break;
                }
            }
            int pointer2 = getArray()[pointer].getNext();
            getArray()[pointer2] = null;
            getArray()[pointer].setNext(null);
            size--;
        }
        return null;
    }

     /**
     * metodo  para eliminar un elemento en un índice específico del arreglo
     * @param index El índice del elemento a eliminar
     * @return El elemento eliminado
     */
    public Object EliminarxIndice(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo para verificar si es vacio el arreglo 
     * @return verdadero si es vacio, falso si no
     */
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    
     /**
     * Método para imprimir los elementos del arreglo.
     */
    public void print() {
        NodoArray pointer = getArray()[getHead()];
        while (pointer != null) {
            System.out.println("[ "+ pointer.getElement()+ " ]");
            if(pointer.getNext() != null) {
                pointer = getArray()[pointer.getNext()];
            } else {
                break;
            }
            
        }
    }
    
    
      /**
     * Método para imprimir los elementos del arreglo en orden secuencial.
     */
    public void printSecuencial() {
        for (int i = 0; i < getArray().length; i++) {
            System.out.println("[ "+ getArray()[i].getElement()+ " ]");
        }
    }
    
    /**
     * Método para obtener el elemento en un índice específico del arreglo.
     * @param indice El índice del elemento a obtener.
     * @return El elemento en el índice especificado.
     * @throws IndexOutOfBoundsException si el índice está fuera del rango del arreglo.
     */
    public Object get(int indice) {
    if (indice < 0 || indice >= getArray().length) {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
    return getArray()[indice].getElement();
}
    public void vaciar(int n,ListaArray elementos){
        for (int i = 0; i < n; i++) {
            
            
        }
    }
    public void vaciar() {
    
    for (int i = 0; i < getArray().length; i++) {
        getArray()[i] = null;
    }
    size = 0;
    setHead(null);
} 
    
    public boolean contiene(Object elemento) {
    for (int i = 0; i < getArray().length; i++) {
        if (getArray()[i] != null && getArray()[i].getElement().equals(elemento)) {
            return true;
        }
    }
    return false;
}
    
    public ListaArray<T> copiar() {
    ListaArray<T> copia = new ListaArray<>(this.getSize());
    for (int i = 0; i < this.getSize(); i++) {
        copia.insertar(this.get(i));
    }
    return copia;
}
}
