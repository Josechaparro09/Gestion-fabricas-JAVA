
public class PuebaHabitacion {
    public static void main(String[] args) {
        Habitacion h1 = new Habitacion();
        h1.setAltura(10);
        h1.setAncho(20);
        h1.setLargo(50);
        System.out.println(h1.enchapePiso());
        System.out.println(h1.tapizarParedes());
        
    }
    
}
