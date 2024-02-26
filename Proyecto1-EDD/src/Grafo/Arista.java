/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafo;

import Estructuras.List;



/**
 *
 * @author Antonella
 */
public class Arista {
    private Vertice origen;
    private Vertice destino;
    private double distancia;
    private double feromona;
    private List hormiga;
    

    public Arista(Vertice origen, Vertice destino, double distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.feromona = 0;
        this.hormiga = new List();
       
    }

    public Vertice getOrigen() {
        return origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public double getFeromona() {
        return feromona;
    }

    public void setFeromona(double feromona) {
        this.feromona = feromona;
    }

    public List getHormiga() {
        return hormiga;
    }

    public void setHormiga(List hormiga) {
        this.hormiga = hormiga;
    }
    
    public String toString(){
        return "Origen: " + origen.getValor() + " / Destino: " + destino.getValor() + " / Feromonas: " + feromona; 
    }
    
    
    
    
    
    }
        

