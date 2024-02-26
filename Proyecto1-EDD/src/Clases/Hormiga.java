/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Estructuras.List;
import Grafo.Arista;
import Grafo.Grafo;
import Grafo.Vertice;

/**
 *
 * @author Antonella
 */
public class Hormiga {
    private int ciudadActual;
    private Grafo grafo;
    private List<Integer> ciudadesVisitadas;
    private double distRecorrida;


    public Hormiga(int ciudadActual, Grafo grafo) {
        this.ciudadActual = ciudadActual;
        this.grafo = grafo;
        this.ciudadesVisitadas = new List(ciudadActual);
        this.distRecorrida = 0;
    }


    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getCiudadActual() {
        return ciudadActual;
    }

    public void setCiudadActual(int ciudadActual) {
        this.ciudadActual = ciudadActual;
    }
    
    public List<Integer> getVisitados() {
        return ciudadesVisitadas;
    }

    public void setVisitados(List<Integer> visitados) {
        this.ciudadesVisitadas = visitados;
    }

    public double getDistRecorrida() {
        return distRecorrida;
    }

    public void setDistRecorrida(double distRecorrida) {
        this.distRecorrida = distRecorrida;
    }

    public List<Integer> getCiudadesVisitadas() {
        return ciudadesVisitadas;
    }

    public void setCiudadesVisitadas(List<Integer> ciudadesVisitadas) {
        this.ciudadesVisitadas = ciudadesVisitadas;
    }
          
    public void sumDistancia(double distancia){
        distRecorrida += distancia;
    }
    
    //Obtener nodos adyacentes a un vertice
    public List adyacentes(){
        int id = ciudadActual;
        List<Arista> listaAdy = grafo.getAristas();
        List<Arista> adyacentes  = new List();
        
        for (int i = 0; i < listaAdy.getSize(); i++) {
            Arista auxArista = listaAdy.get(i);
            
            if(auxArista.getOrigen().getValor() == id){
                if(!ciudadVisitada(auxArista.getDestino().getValor())){
                    adyacentes.insertarFinal(auxArista);                                   
                }
            }
            else if(auxArista.getDestino().getValor() == id){
                if(!ciudadVisitada(auxArista.getOrigen().getValor())){
                    adyacentes.insertarFinal(auxArista);                                   
                }
            }
        }
        
        return adyacentes;
    }
    
    
    //La hormiga llega a una calle ciega o calle destino
    public boolean antFinaliza(int ciudadDestino){
       if(this.ciudadActual == ciudadDestino){
           return true;
        }    
       else{          
           List auxLista = adyacentes();
           return auxLista.isEmpty();
       }
    }   
 
    // Reiniciar las hormigas 
    public void reiniciar(int ciudadInicio){
       this.ciudadActual = ciudadInicio;
       this.ciudadesVisitadas.vaciar();
       this.ciudadesVisitadas.insertarFinal(ciudadInicio);
   }

    //Si ya pasó por este camino
    public boolean ciudadVisitada(int id){
       return ciudadesVisitadas.contiene(id);
    }
    

} 
    
