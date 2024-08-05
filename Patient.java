import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private int id;
    private String name;
    private String ailment;
    private String appointmentTime;
    private static int idCounter = 1;

    public Patient(String name, String ailment, String appointmentTime) {
        this.id = idCounter++;
        this.name = name;
        this.ailment = ailment;
        this.appointmentTime = appointmentTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return ailment;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Ailment: %s, Appointment: %s", id, name, ailment, appointmentTime);
    }
}

class Doctor {
    private int id;
    private String name;
    private String specialization;
    private static int idCounter = 1;

    public Doctor(String name, String specialization) {
        this.id = idCounter++;
        this.name = name;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Specialization: %s", id, name, specialization);
    }
}

class Admin {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();

    public void addPatient(String name, String ailment, String appointmentTime) {
        patients.add(new Patient(name, ailment, appointmentTime));
        System.out.println("Patient added successfully.");
    }

    public void addDoctor(String name, String specialization) {
        doctors.add(new Doctor(name, specialization));
        System.out.println("Doctor added successfully.");
    }

    public void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    public void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors available.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    public void connectDonors() {
        // This is a placeholder. In a real application, this would interact with a donor database.
        System.out.println("Connecting to potential organ and blood donors...");
    }
}

public class VirtualMedicineHome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        int choice;

        do {
            System.out.println("\nVirtual Medicine Home");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctors");
            System.out.println("5. Connect Donors");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter patient ailment: ");
                    String ailment = scanner.nextLine();
                    System.out.print("Enter appointment time: ");
                    String appointmentTime = scanner.nextLine();
                    admin.addPatient(patientName, ailment, appointmentTime);
                    break;
                case 2:
                    admin.viewPatients();
                    break;
                case 3:
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter doctor specialization: ");
                    String specialization = scanner.nextLine();
                    admin.addDoctor(doctorName, specialization);
                    break;
                case 4:
                    admin.viewDoctors();
                    break;
                case 5:
                    admin.connectDonors();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
