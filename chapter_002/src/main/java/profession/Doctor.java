package profession;

public class Doctor extends Profession {

    public Diagnose heal(Patient patient) {
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }

    public void cure(Patient patient) {
    }
}
