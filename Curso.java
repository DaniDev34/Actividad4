public class Curso {
    private String nombre;
    private Materia m1;
    private Materia m2;
    private Materia m3;

    public Curso() {
        nombre = "";
        m1 = new Materia();
        m2 = new Materia();
        m3 = new Materia();
    }

    public Curso(String nombre, Materia m1, Materia m2, Materia m3) {
        this.nombre = nombre;
        this.m1 = new Materia(m1);
        this.m2 = new Materia(m2);
        this.m3 = new Materia(m3);
    }

    public Curso(Curso otro) {
        this.nombre = otro.nombre;
        this.m1 = new Materia(otro.m1);
        this.m2 = new Materia(otro.m2);
        this.m3 = new Materia(otro.m3);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Materia getM1() { return m1; }
    public void setM1(Materia m1) { this.m1 = new Materia(m1); }

    public Materia getM2() { return m2; }
    public void setM2(Materia m2) { this.m2 = new Materia(m2); }

    public Materia getM3() { return m3; }
    public void setM3(Materia m3) { this.m3 = new Materia(m3); }

    public int creditosTotales() {
        return m1.getCreditos() + m2.getCreditos() + m3.getCreditos();
    }

    public int horasTotales() {
        return m1.getHorasSemanales() + m2.getHorasSemanales() + m3.getHorasSemanales();
    }

    public void mostrar() {
        System.out.println("Curso: " + nombre);
        m1.mostrar();
        m2.mostrar();
        m3.mostrar();
        System.out.println("Creditos totales: " + creditosTotales());
        System.out.println("Horas semanales totales: " + horasTotales());
    }
}
