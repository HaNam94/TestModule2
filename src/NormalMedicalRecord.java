import com.sun.media.sound.InvalidDataException;

public class NormalMedicalRecord extends MedicalRecord{
    private double hospitalFee;
    public NormalMedicalRecord(String recordId, String medicalCode, String patientCode, String patientName, String admissionDate, String dischargeDate, double reason) {
        super(recordId, medicalCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.hospitalFee = hospitalFee;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (hospitalFee < 0) {
            throw new InvalidDataException("Hospital fee cannot be negative");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Hospital Fee: " + hospitalFee);
    }

    public double getHospitalFee() {
        return hospitalFee;
    }
}
