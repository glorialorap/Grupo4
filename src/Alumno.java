import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Alumno {
    Scanner scanner = new Scanner(System.in);

    public void alumno() throws IOException {
        int opcion = 0;
        do {
            System.out.println("======OPCIONES======");
            System.out.println("1. Crear archivo");
            System.out.println("2. Modificar archivo");
            System.out.println("3. Eliminar archivo");
            System.out.println("4. Buscar archivo");
            System.out.println("5. Calcular promedio");
            System.out.println("ingrese su opción: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    CrearAlumno();
                    break;
                case 2:
                    ModificarAlumno();
                    break;
                case 3:
                    EliminarAlumno();
                    break;
                case 4:
                    BuscarAlumno();
                    break;
                case 5:
                    CalcularPromedio();
                    break;
                default:
                    System.out.println("opcion invalida");
            }

        } while (opcion != 0);
    }

    public void CrearAlumno() throws IOException {
        System.out.println("Ingrese el numero del alumno: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su primera calificacion: ");
        double cali1 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese su segunda calificacion: ");
        double cali2 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese su tercera calificacion: ");
        double cali3 = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingrese su cuarta calificacion: ");
        double cali4 = scanner.nextDouble();
        scanner.nextLine();

        File archivo = new File("Datos alumnos");
        FileWriter writer = new FileWriter(archivo, true); // Añade al final del archivo

        writer.write("Numero agregado: " + numero + "\n" +
                "Nombre ingresado: " + nombre + "\n" +
                "primera calificación: " + cali1 + "\n" +
                "segunda calificación: " + cali2 + "\n" +
                "tercera calificación: " + cali3 + "\n" +
                "Cuarta calificación: " + cali4 + "\n");

        writer.flush();
        writer.close();

        System.out.println("Se a creado tu archivo");
    }

    public void ModificarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del alumno a modificar:");
        String buscarnom = scanner.nextLine().trim();

        File file = new File("Datos alumnos");
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }

        File tempFile = new File("Alumno_modificado_temp.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));

        String Filas;
        boolean alumnoEncontrado = false;
        while ((Filas = bufferedReader.readLine()) != null) {
            if (Filas.startsWith("Nombre ingresado:")) {
                String nombreAlumno = Filas.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarnom)) {
                    alumnoEncontrado = true;
                    System.out.println("Alumno encontrado, ingrese la nueva información:");

                    System.out.println("Ingrese el numero del alumno: ");
                    int nuevonumero = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su primera calificación: ");
                    int nuevacal1 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su segunda calificación: ");
                    int nuevacal2 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su tercera calificación: ");
                    int nuevacal3 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su cuarta calificación: ");
                    int nuevacal4 = Integer.parseInt(scanner.nextLine());

                    bufferedWriter.write("Nombre ingresado: " + nombreAlumno + "\n");
                    bufferedWriter.write("Numero agregado: " + nuevonumero + "\n");
                    bufferedWriter.write("Primera calificación: " + nuevacal1 + "\n");
                    bufferedWriter.write("segunda calificación: " + nuevacal2 + "\n");
                    bufferedWriter.write("tercera calificación: " + nuevacal3 + "\n");
                    bufferedWriter.write("cuarta calificación: " + nuevacal4 + "\n");

                    bufferedReader.readLine(); // Saltar la línea antigua "Partidos jugados"
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                } else {
                    bufferedWriter.write(Filas + "\n");
                }
            } else {
                bufferedWriter.write(Filas + "\n");
            }
        }

        bufferedReader.close();
        bufferedWriter.close();

        if (!alumnoEncontrado) {
            System.out.println("Alumno no encontrado");
            tempFile.delete();
        } else {
            file.delete();
            tempFile.renameTo(file);
            System.out.println("su Archivo se a modificado");
        }
    }

    public void EliminarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el nombre del alumno a eliminar:");
        String buscarNom = scanner.nextLine().trim();
    
        File file = new File("Datos alumnos");
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    
        File tempFile = new File("Alumno_temp.txt");
    
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));
    
        String Filas;
        boolean alumnoEncontrado = false;
        while ((Filas = bufferedReader.readLine()) != null) {
            if (Filas.startsWith("Nombre ingresado:")) {
                String nombreAlumno = Filas.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarNom)) {
                    alumnoEncontrado = true;
                    // Omitir las líneas del alumno a eliminar
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                    bufferedReader.readLine();
                } else {
                    bufferedWriter.write(Filas + "\n");
                }
            } else {
                bufferedWriter.write(Filas + "\n");
            }
        }
    
        bufferedReader.close();
        bufferedWriter.close();
    
        if (!alumnoEncontrado) {
            System.out.println("Alumno no se encuentra registrado");
            tempFile.delete();
        } else {
            file.delete();
            tempFile.renameTo(file);
            System.out.println("El alumno se a eliminado correctamente");
        }
    }

    public void BuscarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el nombre del alumno a buscar:");
        String buscarNom = scanner.nextLine().trim();
    
        File file = new File("Datos alumnos");
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String Filas;
        boolean alumnoEncontrado = false;
    
        while ((Filas = bufferedReader.readLine()) != null) {
            if (Filas.startsWith("Nombre ingresado:")) {
                String nombreAlumno = Filas.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarNom)) {
                    alumnoEncontrado = true;
                    System.out.println("Alumno encontrado:");
                    System.out.println(Filas);
                    System.out.println(bufferedReader.readLine()); // Número agregado
                    System.out.println(bufferedReader.readLine()); // Primera calificación
                    System.out.println(bufferedReader.readLine()); // Segunda calificación
                    System.out.println(bufferedReader.readLine()); // Tercera calificación
                    System.out.println(bufferedReader.readLine()); // Cuarta calificación
                    break;
                }
            }
        }
    
        bufferedReader.close();
    
        if (!alumnoEncontrado) {
            System.out.println("Alumno no encontrado");
        }
    }
    
    public void CalcularPromedio() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno para calcular el promedio:");
        String buscarNom = scanner.nextLine().trim();
    
        File file = new File("Datos alumnos");
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String linea;
        double promedio = 0.0;
    
        while ((linea = bufferedReader.readLine()) != null) {
            if (linea.startsWith("Nombre ingresado:")) {
                String nombreAlumno = linea.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarNom)) {
                    double[] calificaciones = obtenerCalificaciones(bufferedReader);
                    if (calificaciones.length > 0) {
                        promedio = calcularPromedio(calificaciones);
                        System.out.println("El promedio de calificaciones del alumno " + buscarNom + " es: " + promedio);
                    } else {
                        System.out.println("No se encontraron calificaciones válidas para el alumno " + buscarNom);
                    }
                    break;
                }
            }
        }
    
        bufferedReader.close();
    
        if (promedio == 0.0) {
            System.out.println("Alumno no encontrado");
        }
    }
    
    private double[] obtenerCalificaciones(BufferedReader bufferedReader) throws IOException {
        double[] calificaciones = new double[4];
        int contador = 0;
    
        bufferedReader.readLine(); // Saltar la línea "Numero agregado"
    
        String linea;
        for (int i = 0; i < 4; i++) {
            linea = bufferedReader.readLine();
            if (linea != null && !linea.isEmpty()) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].contains("calificación")) {
                    try {
                        calificaciones[contador] = Double.parseDouble(partes[1].trim());
                        contador++;
                    } catch (NumberFormatException e) {
                        // Ignorar calificaciones no válidas
                    }
                }
            }
        }
    
        // Crear un nuevo arreglo con solo las calificaciones válidas
        double[] calificacionesValidas = new double[contador];
        System.arraycopy(calificaciones, 0, calificacionesValidas, 0, contador);
        return calificacionesValidas;
    }
    
    private double calcularPromedio(double[] calificaciones) {
        double suma = 0.0;
        for (double calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / calificaciones.length;
    }
}
