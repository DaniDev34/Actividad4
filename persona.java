public abstract class persona {
    protected String nombre;
    protected String telefono;

    // Constructor por defecto
    public persona() {
        this.nombre = "Sin nombre";
        this.telefono = "Sin teléfono";
    }

    // Constructor con parámetros
    public persona(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    // Constructor de copia
    public persona(persona otra) {
        this.nombre = otra.nombre;
        this.telefono = otra.telefono;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono.trim();
    }
}
