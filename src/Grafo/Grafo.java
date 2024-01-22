/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Estructuras.Archivo;
import Estructuras.ArrayList;
import java.io.IOException;

/**
 *
 * @author Antonella
 */
public class Grafo {
    public String archivo_seleccionado;
    private final ArrayList<Nodo> nodos;
    private static ArrayList<Arista> aristas;

    public Grafo(ArrayList<Arista> aristas) {
        this.nodos = new ArrayList<>();
        this.aristas = new ArrayList<>();   
    }
    
 public static void Construir() throws IOException{
     ArrayList<String> lineas= Archivo.leerArchivo();
     ArrayList<Arista> aristas= new ArrayList<>();
     Archivo a= new Archivo();
     
     Nodo nodoOrigen= new Nodo(a.nodoOrigen);
     Nodo nodoDestino=new Nodo(a.nodoDestino);
     
     Arista arista= new Arista(nodoOrigen, nodoDestino, a.peso);
     aristas.insertar(arista);
    
 }
 
 public void imprimirGrafo(){
     System.out.println("Nodo: ");
     for (int i = 0; i < nodos.size(); i++) {
         String nodo=nodos.toString();
         System.out.println(nodo);
     }
     System.out.println("Aristas: ");
     for (int i = 0; i < aristas.size(); i++) {
         String arista=aristas.toString();
         System.out.println(arista);
     }
     
     
}
}