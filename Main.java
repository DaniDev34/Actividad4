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
