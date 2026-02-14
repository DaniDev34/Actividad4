public class Profesor {
    private String nombre;
    private String nomina;
    private double sueldoPorHora;
    private Materia materia;
    private int horasQueImparte;

    public Profesor() {
        nombre = "";
        nomina = "";
        sueldoPorHora = 0;
        materia = null;
        horasQueImparte = 0;
    }

    public Profesor(String nombre, String nomina, double sueldoPorHora) {
        this.nombre = nombre;
        this.nomina = nomina;
        this.sueldoPorHora = sueldoPorHora;
        this.materia = null;
        this.horasQueImparte = 0;
    }

    public Profesor(Profesor otro) {
        this.nombre = otro.nombre;
        this.nomina = otro.nomina;
        this.sueldoPorHora = otro.sueldoPorHora;
        this.materia = (otro.materia == null) ? null : new Materia(otro.materia);
        this.horasQueImparte = otro.horasQueImparte;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNomina() { return nomina; }
    public void setNomina(String nomina) { this.nomina = nomina; }

    public double getSueldoPorHora() { return sueldoPorHora; }
    public void setSueldoPorHora(double sueldoPorHora) { this.sueldoPorHora = sueldoPorHora; }

    public Materia getMateria() { return materia; }
    public int getHorasQueImparte() { return horasQueImparte; }

    public void asignarMateria(Materia materia, int horas) {
        this.materia = new Materia(materia);
        this.horasQueImparte = horas;
    }

    public double sueldoSemanal() {
        return sueldoPorHora * horasQueImparte;
    }

    public void mostrar() {
        System.out.println("Profesor: " + nombre + " | Nomina: " + nomina + " | Sueldo/Hora: " + sueldoPorHora);
        if (materia == null) {
            System.out.println("Materia: no asignada");
            System.out.println("Sueldo semanal: 0");
        } else {
            System.out.println("Materia: " + materia.getNombre() + " | Horas: " + horasQueImparte);
            System.out.println("Sueldo semanal: " + sueldoSemanal());
        }
    }
}
