/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Estructuras.ListaArray;


import org.graphstream.graph.Graph;


/**
 *
 * @author Antonella
 * @param <E>
 */
public class Grafo<E> {
    private final ListaArray<Vertice> vertices;
    private final ListaArray<Arista> aristas;

    public Grafo() {
        this.vertices = new ListaArray<>(10);
        this.aristas = new ListaArray<>(10);
    }
    
    public void Construir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            Vertice vertice = new Vertice(i);
            AgregarVertice(vertice);
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 1) {
                    Arista arista = new Arista(vertices.get(i),vertices.get(j));
                    AgregarArista(arista);
                }
            }
        }
    }

    public void AgregarVertice(Vertice vertice){
            vertices.insertar(vertice);
    }
    public void AgregarArista(Arista arista){
            aristas.insertar(arista);
            }
    
//    
//      public void GrafoVisual(Grafo grafo){
//        Graph graf=new SingleGraph("Grafo");
//        
//        for (int i = 0; i < grafo.vertices.getSize(); i++) {
//            grafo.vertices.get(i);
//            g
//        }
//        
//    }
    
    
    
    
    
            }


