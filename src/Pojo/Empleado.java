package Pojo;

public class Empleado extends Persona{
    private int numEmpleado;
    private String cargo;
    private String diaDescanso;
    public Empleado(String nombre, String apellidoP, String apellidoM, int edad, String direccion, int telefono, String ine,int numEmpleado,String cargo,String diaDescanso) {
        super(nombre, apellidoP, apellidoM, edad, direccion, telefono, ine);
        this.numEmpleado=numEmpleado;
        this.cargo=cargo;
        this.diaDescanso=diaDescanso;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDiaDescanso() {
        return diaDescanso;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre() + '\'' +
                ", apellidoP='" + getApellidoP() + '\'' +
                ", apellidoM='" + getApellidoM() + '\'' +
                ", edad=" + getEdad() +
                ", direccion='" + getDireccion() + '\'' +
                ", telefono=" + getTelefono() +
                ", ine='" + getIne() + '\'' +
                ", numEmpleado=" + numEmpleado +
                ", cargo='" + cargo + '\'' +
                ", diaDescanso='" + diaDescanso + '\'' +
                '}';
    }

}
