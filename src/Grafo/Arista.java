/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;



/**
 *
 * @author Antonella
 */
public class Arista {
    private final Vertice origen;
    private final Vertice destino;
    int distancia;
    

    public Arista(Object origen, Object destino,int distancia) {
        this.origen = (Vertice) origen;
        this.destino = (Vertice)  destino;
        this.distancia = distancia;
       
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public int getdistancia() {
        return distancia;
    }
    
    
    }
        

