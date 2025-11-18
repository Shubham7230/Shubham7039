import java.util.*;

class Patient {
    String name;
    List<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void showDoctors() {
        for (Doctor d : doctors) System.out.println(d.name);
    }
}

class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient p) {
        if (!patients.contains(p)) patients.add(p);
        if (!p.doctors.contains(this)) p.addDoctor(this);
        System.out.println(name + " consulted " + p.name);
    }

    void showPatients() {
        for (Patient p : patients) System.out.println(p.name);
    }
}

class Hospital {
    String name;
    List<Doctor> doctors = new ArrayList<>();
    List<Patient> patients = new ArrayList<>();

    Hospital(String name) {
        this.name = name;
    }

    void addDoctor(Doctor d) {
        doctors.add(d);
    }

    void addPatient(Patient p) {
        patients.add(p);
    }

    void showDoctors() {
        for (Doctor d : doctors) System.out.println(d.name);
    }

    void showPatients() {
        for (Patient p : patients) System.out.println(p.name);
    }
}

public class HospitalMain{
    public static void main(String[] args) {
        Hospital h = new Hospital("City Hospital");

        Doctor d1 = new Doctor("Dr. Verma");
        Doctor d2 = new Doctor("Dr. Rao");

        Patient p1 = new Patient("Amit");
        Patient p2 = new Patient("Sneha");

        h.addDoctor(d1);
        h.addDoctor(d2);

        h.addPatient(p1);
        h.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        System.out.println("Dr. Verma Patients:");
        d1.showPatients();

        System.out.println("Amit Doctors:");
        p1.showDoctors();
    }
}
