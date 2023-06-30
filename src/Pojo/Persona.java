package Pojo;

public class Persona {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int edad;
    private String direccion;
    private int telefono;
    private String ine;

    public Persona(String nombre, String apellidoP, String apellidoM, int edad, String direccion, int telefono, String ine) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getIne() {
        return ine;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                ", ine='" + ine + '\'' +
                '}';
    }
}
