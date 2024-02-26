/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;



import Estructuras.List;
import Grafo.Arista;
import Grafo.Grafo;
import java.util.Random;

/**
 *
 * @author Antonella
 */
public class Colonia {
    
    private List<Hormiga> hormigas;
    private Grafo grafo;
    
    // Asignados por el usuario
    private double alfa;
    private double beta;
    private double ro;
    private int ciudad_inicio;
    private int ciudad_destino;
    private int nro_ciclos;
    private int nro_hormigas;

    public Colonia(Grafo grafo, double alfa, double beta, double ro, int ciudad_inicio, int ciudad_destino, int nro_ciclos, int nro_hormigas) {
        this.hormigas = new List();
        this.grafo = grafo;
        this.alfa = alfa;
        this.beta = beta;
        this.ro = ro;
        this.ciudad_inicio = ciudad_inicio;
        this.ciudad_destino = ciudad_destino;
        this.nro_ciclos = nro_ciclos;
        this.nro_hormigas = nro_hormigas;
    }

    public List<Hormiga> getHormigas() {
        return hormigas;
    }

    public void setHormigas(List<Hormiga> hormigas) {
        this.hormigas = hormigas;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    public double getRo() {
        return ro;
    }

    public void setRo(double ro) {
        this.ro = ro;
    }

    public int getCiudad_inicio() {
        return ciudad_inicio;
    }

    public void setCiudad_inicio(int ciudad_inicio) {
        this.ciudad_inicio = ciudad_inicio;
    }

    public int getCiudad_destino() {
        return ciudad_destino;
    }

    public void setCiudad_destino(int ciudad_destino) {
        this.ciudad_destino = ciudad_destino;
    }

    public int getNro_ciclos() {
        return nro_ciclos;
    }

    public void setNro_ciclos(int nro_ciclos) {
        this.nro_ciclos = nro_ciclos;
    }

    public int getNro_hormigas() {
        return nro_hormigas;
    }

    public void setNro_hormigas(int nro_hormigas) {
        this.nro_hormigas = nro_hormigas;
    }
    
    /**
     * Comenzar a producir feromonas
     */
    public void iniciarFeromonas(){
        List adyList = grafo.getAristas();
        
        for (int i = 0; i < adyList.getSize(); i++) {
            Arista arista = (Arista) adyList.get(i);
            double vertices = grafo.getVertices().getSize();
            arista.setFeromona(1.0/vertices);            
        }               
    }
    
    /**
     * Crear hormigas y agregarlas a la lista de hormigas
     */
    public void crearHormigas(){
        for (int i = 0; i < this.nro_hormigas; i++) {
           Hormiga hormiga = new Hormiga(ciudad_inicio, grafo);
           this.hormigas.insertarFinal(hormiga);                        
        }
    }
    
    /**
     * 
     * @param arista
     * @param hormiga
     * @return 
     */
    public double calcularProbabilidad(Arista arista, Hormiga hormiga){
        double visibilidadAB = 1.0/arista.getDistancia();
        double feromonasAB = arista.getFeromona();
        
        double sumAB = 0.0;
        List ciudadesAdyacentes = hormiga.adyacentes();
        for (int i = 0; i < ciudadesAdyacentes.getSize(); i++) {
            Arista aristaTemporal = (Arista) ciudadesAdyacentes.get(i);
            
            sumAB += Math.pow(aristaTemporal.getFeromona(), beta) * Math.pow((1.0/aristaTemporal.getDistancia()), alfa);
        }
        
        return ((Math.pow(visibilidadAB, alfa) * Math.pow(feromonasAB, beta))/sumAB) * 100.0;
    }
    
    public void actualizarIncremento(Arista arista){
        double nuevoValor = 0.0;
        for (int i = 0; i < arista.getHormiga().getSize(); i++) {
            Hormiga hormiga = (Hormiga) arista.getHormiga().get(i);
            nuevoValor += 1.0/hormiga.getDistRecorrida();
        }
        arista.setFeromona(arista.getFeromona() + nuevoValor);
    }
    
    public void actualizarEvaporacion(){
        List adyList = grafo.getAristas();
        for (int i = 0; i < adyList.getSize(); i++) {
            Arista arista = (Arista) adyList.get(i);
            
            arista.setFeromona((1 - ro) * arista.getFeromona());
        }
    }
    
    public void elegirSiguienteCamino(Hormiga h){
        if(!h.antFinaliza(ciudad_destino)){
            List ciudadesAdyacentes = h.adyacentes();
            List probabilidades = new List();
                      
            double t = 0.0;
            for (int i = 0; i < ciudadesAdyacentes.getSize(); i++) {
                double probabilidad = calcularProbabilidad((Arista) ciudadesAdyacentes.get(i), h);
                t += probabilidad;
                probabilidades.insertarFinal(probabilidad);
            }
            
            Random random = new Random();
            double nrorandom = random.nextDouble() * t;
            double contadorPorcentaje = 0.0;
            int indice = -1;
            
            for (int i = 0; i < probabilidades.getSize(); i++) {
                double numero = (double) probabilidades.get(i);
                contadorPorcentaje += numero;
                if (nrorandom <= contadorPorcentaje) {
                    indice = i;
                    break;
                }
            }
            
            Arista siguienteCiudad = (Arista) ciudadesAdyacentes.get(indice);
            h.sumDistancia(siguienteCiudad.getDistancia());
            siguienteCiudad.getHormiga().insertarFinal(h);
            
            
            if(h.getCiudadActual() == siguienteCiudad.getOrigen().getValor()){
                h.getCiudadesVisitadas().insertarFinal(siguienteCiudad.getDestino().getValor());
                h.setCiudadActual(siguienteCiudad.getDestino().getValor());
                actualizarIncremento(siguienteCiudad);
            }
            else if(h.getCiudadActual() == siguienteCiudad.getDestino().getValor()){
                h.getCiudadesVisitadas().insertarFinal(siguienteCiudad.getOrigen().getValor());
                h.setCiudadActual(siguienteCiudad.getOrigen().getValor());
                actualizarIncremento(siguienteCiudad);
            }            
        }       
    }
    
    public boolean terminoCiclo(){
        for (int i = 0; i < hormigas.getSize(); i++) {
            Hormiga hormiga = hormigas.get(i);
            if(!hormiga.antFinaliza(ciudad_destino)){
                return false;
            }
        }
        return true;
    }
    
    public void reiniciar(){
        for (int i = 0; i < hormigas.getSize(); i++) {
            Hormiga hormiga = hormigas.get(i);
            hormiga.reiniciar(ciudad_inicio);
        }
    }
    
    

}

     
