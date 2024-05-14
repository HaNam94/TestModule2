import com.sun.media.sound.InvalidDataException;

public abstract class MedicalRecord {
    protected static int nextId = 1;
    public String recordCode;
    protected String recordId;
    protected String medicalCode;
    protected String patientCode;
    protected String patientName;
    protected String admissionDate;
    protected String dischargeDate;
    protected double reason;

    public MedicalRecord(String recordId, String medicalCode, String patientCode, String patientName, String admissionDate, String dischargeDate, double reason) {
        this.recordId = recordId;
        this.medicalCode = medicalCode;
        this.patientCode = patientCode;
        this.patientName = patientName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.reason = reason;
    }

    public MedicalRecord(String medicalCode, String patientCode, String patientName, String admissionDate, String dischargeDate, String reason) {
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MedicalRecord.nextId = nextId;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public double getReason() {
        return reason;
    }

    public void setReason(double reason) {
        this.reason = reason;
    }

    public abstract void validate() throws InvalidDataException;

    public void display() {
        System.out.println("Medical Record ID: " + recordId);
        System.out.println("Medical Code: " + medicalCode);
        System.out.println("Patient Code: " + patientCode);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Admission Date: " + admissionDate);
        System.out.println("Discharge Date: " + dischargeDate);
        System.out.println("Reason: " + reason);
    }
}
