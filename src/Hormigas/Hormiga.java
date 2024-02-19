/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hormigas;

import Estructuras.ListaArray;

/**
 *
 * @author Antonella
 */
public class Hormiga {
    private int ciudadActual;
    private ListaArray<Integer> ciudades_visitadas;
    private double[][] feromonas;
    private double[][] distancias;

    public Hormiga(int ciudad_Inicio, double[][] feromonas, double[][] distancias) {
        this.ciudadActual = ciudad_Inicio;
        this.feromonas = feromonas;
        this.distancias = distancias;
        this.ciudades_visitadas = new ListaArray(10);
        this.ciudades_visitadas.insertar(ciudad_Inicio);
    }

  public boolean CaminoTransitado(int i,int j){ //caminos por donde la hormiga ya paso 
      for (int k = 0; k < ciudades_visitadas.getSize() -1; k++) {
          if (ciudades_visitadas.get(k).equals(i) && ciudades_visitadas.get(k+1).equals(i)){
              return true;
          }
      }
      return false;
  }
  
  public double depositarFeromonas(int i,int j){
      double Q= 100.0; //cantidad total de feromonas que puede depositar una hormiga
       double distancia= DistanciaTotal();
       double feromonasDepositadas= Q/ distancia;
       
       return feromonasDepositadas;
      
  }
    public double DistanciaTotal(){
        double distanciaTotal=0.0;
        
        for(int i=0 ; i< ciudades_visitadas.getSize() -1;i++){
            int ciudad= (int) ciudades_visitadas.get(i);
            int ciudadSiguiente= (int) ciudades_visitadas.get(i+1);
            
            distanciaTotal += distancias[ciudad][ciudadSiguiente];
        }
        return distanciaTotal;
    }
    
    public void mover(int siguiente_ciudad){
        this.ciudades_visitadas.insertar(siguiente_ciudad);
        this.ciudadActual= siguiente_ciudad;
    }
 
       public boolean HaAlcanzado(int ciudadDestino){
        return this.ciudadActual==ciudadDestino;
    }
       
       public void reiniciar(int ciudad_inicio){
           this.ciudadActual=ciudad_inicio;
           this.ciudades_visitadas.vaciar();
           this.ciudades_visitadas.insertar(ciudad_inicio);
       }
       
       public int seleccionarSiguienteCiudad(double α, double β){
           double[] probabilidades= new double[distancias.length];
           double sumaProbabilidades= 0.0;
           
           for (int i = 0; i < distancias.length; i++) {
               if(!ciudades_visitadas.contiene(i)){
                   probabilidades[i]= Math.pow(feromonas[ciudadActual][i],α) *Math.pow(1.0 / distancias[ciudadActual][i], β);
                   sumaProbabilidades += probabilidades[i];
               }
           }
           
           for (int i = 0; i < probabilidades.length; i++) {
               probabilidades[i] /= sumaProbabilidades;
           }
           
           double r= Math.random(); // Seleccionar la siguiente ciudad basándose en las probabilidades
           double suma= 0.0;
           for(int i=0; i<probabilidades.length;i++){
               suma+= probabilidades[i];
               if (suma>= r) {
                   return i;
               }
           }
           return -1; //caso de que no se haya seleccionado ninguna ciudad
       }
       
       public ListaArray<Integer> obtenerCamino() {
           return ciudades_visitadas.copiar();
       }
       public double CalcularLongitudCamino(ListaArray<Integer> caminoHormiga ){ //el camino total que realizaria cada hormiga, hasta caer en calle ciega o su comida
           double longTotal=0.0;
           for (int i =0; i< caminoHormiga.getSize() -1; i++){
                int ciudadactual = (int) caminoHormiga.get(i);
                int ciudadSiguiente = (int) caminoHormiga.get(i + 1);
                
                longTotal += distancias[ciudadActual][ciudadSiguiente];

           }
           return longTotal;
       }
}
