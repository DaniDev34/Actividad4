public class Alumno {
    private String matricula;
    private String nombre;
    private int edad;
    private Curso curso;

    public Alumno() {
        matricula = "";
        nombre = "";
        edad = 0;
        curso = null;
    }

    public Alumno(String matricula, String nombre, int edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = null;
    }

    public Alumno(Alumno otro) {
        this.matricula = otro.matricula;
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.curso = (otro.curso == null) ? null : new Curso(otro.curso);
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = new Curso(curso); }

    public void mostrar() {
        System.out.println("Alumno: " + nombre + " | Matricula: " + matricula + " | Edad: " + edad);
        if (curso == null) {
            System.out.println("Curso: no asignado");
        } else {
            System.out.println("Curso: " + curso.getNombre() + " | Creditos: " + curso.creditosTotales());
        }
    }
}
