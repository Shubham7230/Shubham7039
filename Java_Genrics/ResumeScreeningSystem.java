import java.util.*;

abstract class JobRole {
    private String name;
    public JobRole(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract String getRoleType();
    public String toString() { return name + " | " + getRoleType(); }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name) { super(name); }
    public String getRoleType() { return "Software Engineer"; }
}

class DataScientist extends JobRole {
    public DataScientist(String name) { super(name); }
    public String getRoleType() { return "Data Scientist"; }
}

class ProductManager extends JobRole {
    public ProductManager(String name) { super(name); }
    public String getRoleType() { return "Product Manager"; }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();
    public void add(T r) { resumes.add(r); }
    public List<T> getAll() { return resumes; }
}

class Screening {
    public static void process(List<? extends JobRole> list) {
        for (JobRole r : list) System.out.println(r);
    }
}

public class ResumeScreeningSystem{
    public static void main(String[] args) {
        Resume<SoftwareEngineer> seResumes = new Resume<>();
        Resume<DataScientist> dsResumes = new Resume<>();
        Resume<ProductManager> pmResumes = new Resume<>();

        seResumes.add(new SoftwareEngineer("Alice"));
        seResumes.add(new SoftwareEngineer("Bob"));

        dsResumes.add(new DataScientist("John"));
        dsResumes.add(new DataScientist("Sara"));

        pmResumes.add(new ProductManager("Mike"));
        pmResumes.add(new ProductManager("Emma"));

        Screening.process(seResumes.getAll());
        Screening.process(dsResumes.getAll());
        Screening.process(pmResumes.getAll());
    }
}
