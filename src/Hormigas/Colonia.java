/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hormigas;

import Estructuras.Archivo;
import Estructuras.HashMap;
import Estructuras.ListaArray;
import Interfaces.MenuSimulacion;

/**
 *
 * @author Antonella
 */
public class Colonia {
    
    private ListaArray<Hormiga> hormigas;
    private double[][] feromonas;
    private double[][] distancias;
    
    // Asignados por el usuario
    private double α;
    private double β;
    private double ρ;
    private int ciudad_inicio;
    private int ciudad_destino;
    private int nro_ciclos;
    private int nro_hormigas;

    public Colonia() {
        MenuSimulacion datos = new MenuSimulacion();
        
        this.α = Double.parseDouble(datos.getImportanciaFeromona());
        this.β = Double.parseDouble(datos.getGradoVisibilidadCiudad());
        this.ρ = Double.parseDouble(datos.getFactorEvaporacion());
        this.ciudad_inicio = Integer.parseInt((String) datos.getCiudadInicio());
        this.ciudad_destino = Integer.parseInt((String) datos.getCiudadDestino());
        this.nro_ciclos = Integer.parseInt(datos.getCiclos());
        this.nro_hormigas = Integer.parseInt(datos.getHormigas());
        
        this.hormigas= new ListaArray(this.nro_hormigas);
        for (int i = 0; i < this.nro_hormigas; i++) {
            this.hormigas.insertar(new Hormiga(this.ciudad_inicio, this.feromonas, this.distancias));
        }
    }

    
    
    public void Inicializar(){
        Archivo data= new Archivo();
         HashMap<String, ListaArray> relaciones = data.leerRelaciones();
         ListaArray<String> ciudades=data.obtCiudades(relaciones);
        
        distancias=new double[ciudades.getSize()][ciudades.getSize()];
        feromonas=new double[ciudades.getSize()][ciudades.getSize()];
        
        for (int i = 0; i < ciudades.getSize(); i++) {
            for (int j = 0; j < ciudades.getSize(); j++) {
                distancias[i][j]= data.obtenerDistancia(ciudades.get(i).toString(), ciudades.get(j).toString());
                feromonas[i][j]= 1.0/ ciudades.getSize();
            }
        }
    }
    
    public void Ejecutar(){
        for (int i = 0; i < nro_ciclos; i++) {
            for (int j = 0; j < nro_hormigas; j++) {
                Hormiga hormiga=(Hormiga) hormigas.get(j);
                while (!hormiga.HaAlcanzado(ciudad_destino)){
                    int ciudad_siguiente= hormiga.seleccionarSiguienteCiudad(α, β);
                    hormiga.mover(ciudad_siguiente);
                }
                   
                    }
            
            //actualizar feromonas
            for (int j = 0; j <feromonas.length; j++) {
                for (int k = 0; k < feromonas[j].length; k++) {
                    feromonas[j][k] *= (1- ρ); //evaporacion
                    
                    for (int l = 0; l < hormigas.getSize(); l++) {
                          Hormiga hormiga = (Hormiga) hormigas.get(l);
                          feromonas[j][k] += hormiga.depositarFeromonas(j, k); //Incremento
                    }
                            
                }
            }
            //Reiniciar para el siguiente ciclo 
            for (int j = 0; j < hormigas.getSize(); j++) {
                Hormiga hormiga = (Hormiga) hormigas.get(i);
                hormiga.reiniciar(ciudad_inicio);
            }
    }
   
}
}
