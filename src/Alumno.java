import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Alumno {
    Scanner scanner = new Scanner(System.in);
// metodo para un menu de opciones 
    public void alumno() throws IOException {
        int opcion = 0;//variable de almacenar opcion 
        do {
            System.out.println("======OPCIONES======");
            System.out.println("1. Crear archivo");
            System.out.println("2. Modificar archivo");
            System.out.println("3. Eliminar archivo");
            System.out.println("4. Buscar archivo");
            System.out.println("5. Calcular promedio");
            System.out.println("ingrese su opción: ");
            opcion = scanner.nextInt();//lee la opcion escogida 
            switch (opcion) {
                    //se llama a los metodos para  modificar algun archivo
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
                    System.out.println("opcion invalida");// mensaje de error 
            }

        } while (opcion != 0);
    }
// metodo para crear nuevos registrdo de alumno
    public void CrearAlumno() throws IOException {
        
        System.out.println("Ingrese el nombre del profesor a cargo: ");
          String nprofesor = scanner.nextLine();
        
        System.out.println("Ingrese el numero del alumno: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese el nombre del alumno: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Ingrese la edad del alumno: ");
        int edad = scanner.nextInt();
        
        System.out.println("Ingrese el grado de estudio del alumno: ");
        int grado = scanner.nextInt();

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
// se crea un archivo que va a guardar los datos del alumno
        File archivo = new File("Datos alumnos");
        FileWriter writer = new FileWriter(archivo, true); // Añade al final del archivo
// se escriben los datos del alumno en el archivo
        writer.write("nombre del profesor a cargo"+nprofesor+ "\n" 
                +"Numero agregado: " + numero + "\n" +
                "Nombre ingresado: " + nombre + "\n" +
                "edad ingresada: " + edad + "\n" +
                "grado ingresado: " + grado + "\n" +
                "primera calificación: " + cali1 + "\n" +
                "segunda calificación: " + cali2 + "\n" +
                "tercera calificación: " + cali3 + "\n" +
                "Cuarta calificación: " + cali4 + "\n");

        writer.flush();
        writer.close();

        System.out.println("Se a creado tu archivo");
    }
// metodo para modificar los datos de un alumno ya creado
    public void ModificarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del alumno a modificar:");
        String buscarnom = scanner.nextLine().trim();
        // busca el nombre ingresado a ver si se encuentra en archivos de alumnos
        File file = new File("Datos alumnos");
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
//crea un archivo de forma temporal
        File tempFile = new File("Alumno_modificado_temp.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));//
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));//

        String Filas;
        boolean alumnoEncontrado = false;//verifica si se encuentra el alumno
        
        while ((Filas = bufferedReader.readLine()) != null) {
            // condicional el cual busca el nombre ingresado y lo lleva a modificar la informacion del alumno 
            if (Filas.startsWith("Nombre ingresado:")) {
                String nombreAlumno = Filas.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarnom)) {
                    alumnoEncontrado = true;
                    System.out.println("Alumno encontrado, ingrese la nueva información:");

                    //imformacion a modificar 
                    System.out.println("profesor a cargo: "+nprofesor);
                    
                    System.out.println("Ingrese el numero del alumno: ");
                    int nuevonumero = Integer.parseInt(scanner.nextLine());
                    
                    System.out.println("Ingrese el nombre del alumno: ");
                    String nuenombre = scanner.nextLine();

                    System.out.println("Ingrese la edad del alumno: ");
                    int nuevedad = scanner.nextInt();
                    
                    System.out.println("Ingrese el grado de estudio del alumno: ");
                    int nuegrado = scanner.nextInt();
                    
                    System.out.println("Ingrese el grado de estudio del alumno: ");
                    int nuegrado = scanner.nextInt();

                    System.out.println("Ingrese su primera calificación: ");
                    int nuevacal1 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su segunda calificación: ");
                    int nuevacal2 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su tercera calificación: ");
                    int nuevacal3 = Integer.parseInt(scanner.nextLine());

                    System.out.println("Ingrese su cuarta calificación: ");
                    int nuevacal4 = Integer.parseInt(scanner.nextLine());

                    bufferedWriter.write("Nombre ingresado: " + nuenombre + "\n");
                    bufferedWriter.write("Numero agregado: " + nuevonumero + "\n");
                     bufferedWriter.write("edad agregado: " + nuevedad + "\n");
                     bufferedWriter.write("Numero de grado: " + nuegrado + "\n");
                    bufferedWriter.write("Primera calificación: " + nuevacal1 + "\n");
                    bufferedWriter.write("segunda calificación: " + nuevacal2 + "\n");
                    bufferedWriter.write("tercera calificación: " + nuevacal3 + "\n");
                    bufferedWriter.write("cuarta calificación: " + nuevacal4 + "\n");
                    
                    // ignora la imformacion del archivo original
                    // y rescribe en el archivo
                    bufferedReader.readLine(); 
                    bufferedReader.readLine(); 
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
            System.out.println("Alumno no encontrado");
            tempFile.delete();
        } else {
            file.delete();
            tempFile.renameTo(file);
            System.out.println("su Archivo se a modificado");
        }
    }
//metodo para elimar un registro archivo de un alumno 
    public void EliminarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el nombre del alumno a eliminar:");
        String buscarNom = scanner.nextLine().trim();
    //lee el nombre del alumno a eliminar 
        File file = new File("Datos alumnos");
        //condicional que en caso de no aparecer el nombre diligenciado sale del metodo 
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    
        File tempFile = new File("Alumno_temp.txt");//creando um archio temporal
    
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));//leer del archivo original 
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tempFile));//escribe en el archivo temporal
    
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
//metodo para buscar alumno
    public void BuscarAlumno() throws IOException {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el nombre del alumno a buscar:");
        String buscarNom = scanner.nextLine().trim();//lee el nombre a buscar 
    
        File file = new File("Datos alumnos");//condicional para en casi no encontrar el nombre del alumno salir del metodo 
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    // bufferedReader para leer el archivo
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String Filas;
        boolean alumnoEncontrado = false;
    // muestra el archivo a leer
        while ((Filas = bufferedReader.readLine()) != null) {
            if (Filas.startsWith("Nombre ingresado:")) {
                String nombreAlumno = Filas.substring("Nombre ingresado: ".length());
                if (nombreAlumno.equals(buscarNom)) {
                    alumnoEncontrado = true;
                    System.out.println("Alumno encontrado:");
                    //imformacion impresa
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
    //metodo para calcular el promedio del alumno 
    public void CalcularPromedio() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alumno para calcular el promedio:");
        String buscarNom = scanner.nextLine().trim();//lee el nombre a calcular promedio
    
        File file = new File("Datos alumnos");//condicional a verificar si el alumno existe si no sale del metodo
        if (!file.exists()) {
            System.out.println("El archivo no se encuentra registrado");
            return;
        }
    // buffer para mostrar el archivo del alumno
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String linea;
        double promedio = 0.0;// iniciliza la variable para calcular promedio
    // while que muestra el archivo linea por linea 
        while ((linea = bufferedReader.readLine()) != null) {
            if (linea.startsWith("Nombre ingresado:")) {
                String nombreAlumno = linea.substring("Nombre ingresado: ".length());
                
                if (nombreAlumno.equals(buscarNom)) {
                    double[] calificaciones = obtenerCalificaciones(bufferedReader);// se obtiene las calificaciones del alumno
                    if (calificaciones.length > 0) {
                        promedio = calcularPromedio(calificaciones);// calcula el promedio de las calificaciones 
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
        double[] calificaciones = new double[4];//arreglo para almacenar calificaciones
        int contador = 0;
    
        bufferedReader.readLine(); // Saltar la línea "Numero agregado"
    // lee las siguientes 4 lineas para tener las calificaciones 
        String linea;
        for (int i = 0; i < 4; i++) {
            linea = bufferedReader.readLine();
            if (linea != null && !linea.isEmpty()) {
                String[] partes = linea.split(": ");
                if (partes.length == 2 && partes[0].contains("calificación")) {
                    try {
                        calificaciones[contador] = Double.parseDouble(partes[1].trim());//se convierte las calificaciones a double 
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
    //metodo privado para calcular el promedio de un arreglo
    private double calcularPromedio(double[] calificaciones) {
        double suma = 0.0; //incializa la variable suma 
        for (double calificacion : calificaciones) {
            suma += calificacion;// suma cada calificacion
        }
        return suma / calificaciones.length;//calcula y retorna el promedio
    }
}
