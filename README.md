# Actividad 4  

Dentro de este repositorio se encuentra la documentación de la actividad 4, cuyo objetivo es aplicar los conocimientos adquiridos en programación orientada a objetos para diseñar e implementar un sistema de control escolar en Java.  

El sistema permite gestionar profesores, alumnos, cursos y materias, aplicando conceptos como encapsulamiento, composición, agregación, constructores, métodos funcionales y uso de objetos.

---

## Instrucciones  

1. Diseñar las clases necesarias para modelar un sistema escolar que permita manejar:
   - Profesores
   - Alumnos
   - Cursos
   - Materias

2. Consideraciones del modelo:
   - Un profesor solo puede impartir una materia.
   - Un profesor puede existir sin tener materia asignada.
   - Un alumno pertenece a un curso.
   - Un curso está compuesto siempre por tres materias.
   - Cada materia tiene nombre, clave, créditos y horas semanales.
   - El sueldo semanal del profesor depende de las horas que imparte y su sueldo por hora.
   - Los créditos totales del curso son la suma de los créditos de sus tres materias.

3. Cada clase debe incluir:
   - Atributos privados.
   - Constructor vacío.
   - Constructor con parámetros.
   - Constructor de copia.
   - Métodos getters y setters.
   - Métodos funcionales necesarios.

4. La clase principal (Main) debe:
   - Permitir al usuario interactuar mediante un menú.
   - Registrar materias, cursos, profesores y alumnos.
   - Asignar materias a profesores.
   - Asignar cursos a alumnos.
   - Mostrar la información almacenada.

---

## Desarrollo de la actividad  

A continuación se presentan los códigos utilizados para desarrollar el sistema de control escolar.

---

## Clase Materia

```java
public class Materia {
    private String nombre;
    private String clave;
    private int creditos;
    private int horasSemanales;

    public Materia() {
        nombre = "";
        clave = "";
        creditos = 0;
        horasSemanales = 0;
    }

    public Materia(String nombre, String clave, int creditos, int horasSemanales) {
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.horasSemanales = horasSemanales;
    }

    public Materia(Materia otra) {
        this.nombre = otra.nombre;
        this.clave = otra.clave;
        this.creditos = otra.creditos;
        this.horasSemanales = otra.horasSemanales;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public int getHorasSemanales() { return horasSemanales; }
    public void setHorasSemanales(int horasSemanales) { this.horasSemanales = horasSemanales; }

    public void mostrar() {
        System.out.println("Materia: " + nombre + " | Clave: " + clave +
                " | Creditos: " + creditos + " | Horas: " + horasSemanales);
    }
}
```

---

## Clase Curso

```java
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
        System.out.println("Horas totales: " + horasTotales());
    }
}
```

---

## Clase Profesor

```java
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
        materia = null;
        horasQueImparte = 0;
    }

    public Profesor(Profesor otro) {
        this.nombre = otro.nombre;
        this.nomina = otro.nomina;
        this.sueldoPorHora = otro.sueldoPorHora;
        this.materia = (otro.materia == null) ? null : new Materia(otro.materia);
        this.horasQueImparte = otro.horasQueImparte;
    }

    public void asignarMateria(Materia materia, int horas) {
        this.materia = new Materia(materia);
        this.horasQueImparte = horas;
    }

    public double sueldoSemanal() {
        return sueldoPorHora * horasQueImparte;
    }

    public void mostrar() {
        System.out.println("Profesor: " + nombre + " | Nomina: " + nomina);
        if (materia == null) {
            System.out.println("Materia no asignada");
        } else {
            System.out.println("Materia: " + materia.getNombre());
            System.out.println("Sueldo semanal: " + sueldoSemanal());
        }
    }
}
```

---

## Clase Alumno

```java
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
        curso = null;
    }

    public Alumno(Alumno otro) {
        this.matricula = otro.matricula;
        this.nombre = otro.nombre;
        this.edad = otro.edad;
        this.curso = (otro.curso == null) ? null : new Curso(otro.curso);
    }

    public void setCurso(Curso curso) {
        this.curso = new Curso(curso);
    }

    public void mostrar() {
        System.out.println("Alumno: " + nombre + " | Matricula: " + matricula);
        if (curso == null) {
            System.out.println("Curso no asignado");
        } else {
            System.out.println("Curso: " + curso.getNombre());
        }
    }
}
```

---

## Clase Principal (Main)

Este programa incluye un menú interactivo que nos permite:

- Registrar materias
- Registrar cursos
- Registrar profesores
- Registrar alumnos
- Asignar materias a profesores
- Asignar cursos a alumnos
- Mostrar la información almacenada

El usuario interactúa mediante consola utilizando el Scanner.

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Materia> materias = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<Profesor> profesores = new ArrayList<>();
    static ArrayList<Alumno> alumnos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("==== Menu ====");
            System.out.println("1) Alta materia");
            System.out.println("2) Alta curso (3 materias)");
            System.out.println("3) Alta profesor");
            System.out.println("4) Asignar materia a profesor");
            System.out.println("5) Alta alumno");
            System.out.println("6) Asignar curso a alumno");
            System.out.println("7) Mostrar todo");
            System.out.println("0) Salir");

            opcion = leerEntero("Opcion: ");

            switch (opcion) {
                case 1: altaMateria(); break;
                case 2: altaCurso(); break;
                case 3: altaProfesor(); break;
                case 4: asignarMateriaProfesor(); break;
                case 5: altaAlumno(); break;
                case 6: asignarCursoAlumno(); break;
                case 7: mostrarTodo(); break;
                case 0: break;
                default: System.out.println("Opcion invalida"); break;
            }

        } while (opcion != 0);

        sc.close();
    }

    static void altaMateria() {
        System.out.println("--- Alta materia ---");
        String nombre = leerTexto("Nombre: ");
        String clave = leerTexto("Clave: ");
        int creditos = leerEntero("Creditos: ");
        int horas = leerEntero("Horas semanales: ");

        Materia m = new Materia(nombre, clave, creditos, horas);
        materias.add(m);
        System.out.println("Materia guardada");
    }

    static void altaCurso() {
        if (materias.size() < 3) {
            System.out.println("Necesitas al menos 3 materias para crear un curso");
            return;
        }

        System.out.println("--- Alta curso ---");
        String nombreCurso = leerTexto("Nombre del curso: ");

        System.out.println("Lista de materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.print(i + ") ");
            materias.get(i).mostrar();
        }

        int i1 = leerEntero("Indice materia 1: ");
        int i2 = leerEntero("Indice materia 2: ");
        int i3 = leerEntero("Indice materia 3: ");

        if (!indicesValidos(i1, i2, i3, materias.size())) {
            System.out.println("Indices invalidos o repetidos");
            return;
        }

        Curso c = new Curso(nombreCurso, materias.get(i1), materias.get(i2), materias.get(i3));
        cursos.add(c);
        System.out.println("Curso guardado");
    }

    static void altaProfesor() {
        System.out.println("--- Alta profesor ---");
        String nombre = leerTexto("Nombre: ");
        String nomina = leerTexto("Nomina: ");
        double sueldoHora = leerDouble("Sueldo por hora: ");

        Profesor p = new Profesor(nombre, nomina, sueldoHora);
        profesores.add(p);
        System.out.println("Profesor guardado (sin materia)");
    }

    static void asignarMateriaProfesor() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores");
            return;
        }
        if (materias.isEmpty()) {
            System.out.println("No hay materias");
            return;
        }

        System.out.println("--- Asignar materia a profesor ---");

        System.out.println("Profesores:");
        for (int i = 0; i < profesores.size(); i++) {
            System.out.println(i + ") " + profesores.get(i).getNombre());
        }
        int ip = leerEntero("Indice profesor: ");
        if (ip < 0 || ip >= profesores.size()) {
            System.out.println("Indice invalido");
            return;
        }

        System.out.println("Materias:");
        for (int i = 0; i < materias.size(); i++) {
            System.out.println(i + ") " + materias.get(i).getNombre());
        }
        int im = leerEntero("Indice materia: ");
        if (im < 0 || im >= materias.size()) {
            System.out.println("Indice invalido");
            return;
        }

        int horas = leerEntero("Horas que impartira: ");
        profesores.get(ip).asignarMateria(materias.get(im), horas);
        System.out.println("Materia asignada");
    }

    static void altaAlumno() {
        System.out.println("--- Alta alumno ---");
        String matricula = leerTexto("Matricula: ");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");

        Alumno a = new Alumno(matricula, nombre, edad);
        alumnos.add(a);
        System.out.println("Alumno guardado (sin curso)");
    }

    static void asignarCursoAlumno() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos");
            return;
        }
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos");
            return;
        }

        System.out.println("\nAsignar curso a alumno");

        System.out.println("Alumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ") " + alumnos.get(i).getNombre());
        }
        int ia = leerEntero("Indice alumno: ");
        if (ia < 0 || ia >= alumnos.size()) {
            System.out.println("Indice invalido");
            return;
        }

        System.out.println("Cursos:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ") " + cursos.get(i).getNombre());
        }
        int ic = leerEntero("Indice curso: ");
        if (ic < 0 || ic >= cursos.size()) {
            System.out.println("Indice invalido");
            return;
        }

        alumnos.get(ia).setCurso(cursos.get(ic));
        System.out.println("Curso asignado");
    }

    static void mostrarTodo() {
        System.out.println("\nMaterias:");
        for (Materia m : materias) {
            m.mostrar();
        }

        System.out.println("\nCursos:");
        for (Curso c : cursos) {
            c.mostrar();
            System.out.println();
        }

        System.out.println("\nProfesores:");
        for (Profesor p : profesores) {
            p.mostrar();
            System.out.println();
        }

        System.out.println("\nAlumnos:");
        for (Alumno a : alumnos) {
            a.mostrar();
            System.out.println();
        }
    }

    static String leerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    static int leerEntero(String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                sc.nextLine();
                return val;
            } else {
                sc.nextLine();
                System.out.println("Debes ingresar un entero");
            }
        }
    }

    static double leerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            } else {
                sc.nextLine();
                System.out.println("Debes ingresar un numero");
            }
        }
    }

    static boolean indicesValidos(int a, int b, int c, int size) {
        if (a < 0 || a >= size) return false;
        if (b < 0 || b >= size) return false;
        if (c < 0 || c >= size) return false;
        if (a == b || a == c || b == c) return false;
        return true;
    }
}
```

---

## Relaciones entre clases

- Curso y Materia → Relación de composición (el curso se compone de tres materias).
- Profesor y Materia → Relación de agregación (un profesor puede existir sin materia).
- Alumno y Curso → Relación de agregación (el alumno pertenece a un curso).

---

## Conclusión

En esta actividad se aplicaron algunos de los principios fundamentales de la programación orientada a objetos como:

- Encapsulamiento mediante atributos privados.
- Uso de constructores múltiples.
- Métodos getters y setters.
- Métodos funcionales para cálculos.
- Relación entre clases mediante composición y agregación.
- Creación e interacción de objetos desde una clase principal.

Este sistema permite simular un entorno básico de un control escolar mediante la consola, cumpliendo con los requisitos establecidos en la actividad 4 en plataforma Canva.
