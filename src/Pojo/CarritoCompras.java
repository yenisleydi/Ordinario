package Pojo;

import java.util.ArrayList;

public class CarritoCompras {
    private static ArrayList<CarritoCompras> carritoCompras = new ArrayList<>();

    private String producto;
    private int cantidad;
    private double precio;
    public void agregarItemCarrito() {
        carritoCompras.add(this);
    }

    public CarritoCompras(String producto, int cantidad, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public String toString() {
        return "Producto: " + producto + ", Cantidad: " + cantidad + ", Precio: $" + precio;
    }
}
