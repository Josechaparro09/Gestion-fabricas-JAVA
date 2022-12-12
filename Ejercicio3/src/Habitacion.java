/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
   /*
Diseñar una clase Habitación, con atributos para su largo, ancho y altura en metros. Implemente métodos habituales, 
así mismo, un método que permita calcular la cantidad de metros cuadrados que se requiere de enchape para el piso 
de la habitación, y otro que calcule cuantos metros cuadrados de papel se requiere para tapizar sus paredes.
*/
/**
 *
 * @author josec
 */
public class Habitacion {
    
    private float largoHabitacion;
    private float anchoHabitacion;
    private float alturaPared;
    
    public float enchapePiso(){
        return (this.largoHabitacion*(this.anchoHabitacion));
        
    }
    public float tapizarPared(){
        
        return (((this.anchoHabitacion)*(this.alturaPared)*2)+(((this.largoHabitacion)*(this.alturaPared))*2));
        
    }
    
    
}
