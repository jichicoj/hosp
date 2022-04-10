import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class main {
    public static void main (String args[]) {
        Scanner keyboard = new Scanner(System.in); // Variable que obtiene le input
        boolean exit = false; // Variable de control para salir del menú
        int option = 0;

        while (!exit) {
            System.out.println("Ingrese el número de la opción a realizarse. \n 1. VectorHeap \n 2. Priority queue");
            option = getNumber(keyboard);

            if (option != 1 && option != 2) {
                System.out.println("ERROR. La opción ingresada no se encuentra disponible.");
            } else {
                exit = true;
            }
        }

        switch (option) {
            case 1:
                VectorHeap<Patient> patients = getVectorHeap();

                while (!patients.isEmpty()) {
                    Patient pat = patients.remove();
                    System.out.println(pat.getName() + ", " + pat.getEmergencyDescription());
                    System.out.println("Presione enter para mostrar el siguiente paciente");
                    keyboard.nextLine();
                }
                break;
            case 2:
                PriorityQueue<Patient> pats = getPriorityQueue();

                while (!pats.isEmpty()) {
                    Patient pat = pats.remove();
                    System.out.println(pat.getName() + ", " + pat.getEmergencyDescription());
                    System.out.println("Presione enter para mostrar el siguiente paciente");
                    keyboard.nextLine();
                }
                break;
        }

        System.exit(0);
    }

    /**
     * Return a vector heap with the patients in the pacientes.txt
     * @return
     */
    public static VectorHeap<Patient> getVectorHeap () {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado
        VectorHeap<Patient> data = new VectorHeap<>();
        BufferedReader buffer = null; // Lee el archivo

        try {
            buffer = new BufferedReader(new FileReader(dir));
            String line = buffer.readLine();

            while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                String[] info = line.split(",");
                Patient patient = new Patient(info[0], info[1], info[2]);

                data.add(patient);

                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Return a priority queue with the patients in the pacientes.txt
     * @return
     */
    public static PriorityQueue<Patient> getPriorityQueue () {
        FileDialog dialog = new FileDialog((Frame) null, "Seleccion el archivo con las operaciones");
        dialog.setFile("*.txt"); // Solo permite que se seleccionen archivos .txt
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        dialog.setAlwaysOnTop(true);
        String dir = dialog.getDirectory() + dialog.getFile(); // Obtiene el directorio del archivo seleccionado
        PriorityQueue<Patient> data = new PriorityQueue<>();
        BufferedReader buffer = null; // Lee el archivo

        try {
            buffer = new BufferedReader(new FileReader(dir));
            String line = buffer.readLine();

            while (line != null) { // Cada línea del archivo la agrega al arraylist de datos
                String[] info = line.split(",");
                Patient patient = new Patient(info[0], info[1], info[2]);

                data.add(patient);

                line = buffer.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static Integer getNumber(Scanner keyboard) {
        String number = keyboard.nextLine(); // Obtiene el input
        boolean isNumber = false;

        while (!isNumber) { // Vuelve a pedir input hasta que este sea un número
            try {
                int nm = Integer.parseInt(number); // Verifica que el input sea un número
                isNumber = true;
            } catch (NumberFormatException nft) {
                System.out.println("ERROR. Verifique que el valor ingresado sea numérico e intente de nuevo.");
                number = keyboard.nextLine();
            }
        }

        return Integer.valueOf(number);
    }
}
