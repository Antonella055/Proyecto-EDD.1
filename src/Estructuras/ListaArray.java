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
    
    public NodoArray[] copyArray() {
        NodoArray[] newArray = new NodoArray[array.length + 1];
        for (int i = 0; i < getArray().length; i++) {
            newArray[i] = getArray()[i];
        }
        return newArray;
    }
    
    public int buscarEspacio(){
        for (int i = 0; i < getArray().length; i++) {
            if (array[i] == null) {
                return i;
            }
        }
        return -1;
    }
    public int indiceDe(Object elemento) {
    for (int i = 0; i < getArray().length; i++) {
        if (getArray()[i].getElement().equals(elemento)) {
            return i; // Devuelve el índice del elemento si se encuentra
        }
    }
    return -1; // Devuelve -1 si el elemento no se encuentra en la lista
}


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

    
    public void insertarxIndice(T element, int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
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

    
    public Object EliminarxIndice(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
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
    
    public void printSecuencial() {
        for (int i = 0; i < getArray().length; i++) {
            System.out.println("[ "+ getArray()[i].getElement()+ " ]");
        }
    }
    public Object get(int indice) {
    if (indice < 0 || indice >= getArray().length) {
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
    return getArray()[indice].getElement();
}
    
    
}
