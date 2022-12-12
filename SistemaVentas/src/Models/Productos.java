
package Models;

public class Productos {
    private int id;
    private String codigo;
    private String descripcion;
    private int cantidad;
    private double precio_compra;
    private double precio_venta;
    private int id_proveedor;
    private int id_medida;
    private int id_categoria;
    private String estado;
    private String proveedor;
    private String medida;
    private String categoria;

    public Productos() {
    }

    public Productos(int id, String codigo, String descripcion, int cantidad, double precio_compra, double precio_venta, int id_proveedor, int id_medida, int id_categoria, String estado, String proveedor, String medida, String categoria) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.id_proveedor = id_proveedor;
        this.id_medida = id_medida;
        this.id_categoria = id_categoria;
        this.estado = estado;
        this.proveedor = proveedor;
        this.medida = medida;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_medida() {
        return id_medida;
    }

    public void setId_medida(int id_medida) {
        this.id_medida = id_medida;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

   
    
    
    
}
