
public class Triangulo {

    private double base;
    private double altura;

    public Triangulo() {
    }

    public double isBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double isAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double areaTriangulo(){
        return (this.base*this.altura)/2 ;
    }
//    public double longitudLados(){
//        return la longitud del los lados se halla partiendo el triangulo en 2 y  hallando la hipotenusa de uno
//               con la formula: 
//               lado1 ^2 + lado2^2 = h^2 donde lado1 = base/2 y lado2 =altura
//               
//    }
//}
   public void perimetroTriangulo(){
       //perimetro = lado*2+base
   }
}
