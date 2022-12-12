
public class Habitacion {
    private double largo;
    private double ancho;
    private double altura;

    public Habitacion() {
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double enchapePiso(){
        return this.largo*this.ancho;
    }
    public double tapizarParedes(){
        return ((this.largo*this.altura)*2)+((this.ancho*this.altura)*2);
    }
}
