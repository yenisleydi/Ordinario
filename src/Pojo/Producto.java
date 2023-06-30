package Pojo;

public class Producto {
    private String producto;
    private String marca;
    private int cantidadExistencia;
    private String descripcion;
    private Double precio;
    private String departamento;

    public Producto(String producto, String marca, int cantidadExistencia, String descripcion, Double precio, String departamento) {
        this.producto = producto;
        this.marca = marca;
        this.cantidadExistencia = cantidadExistencia;
        this.descripcion = descripcion;
        this.precio = precio;
        this.departamento = departamento;
    }

    public String getProducto() {
        return producto;
    }

    public String getMarca() {
        return marca;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "Producto" +
                "producto='" + producto + '\'' +
                ", marca='" + marca + '\'' +
                ", cantidadExistencia=" + cantidadExistencia +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", departamento='" + departamento;
    }
}
