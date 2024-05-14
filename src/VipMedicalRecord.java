import com.sun.media.sound.InvalidDataException;

public class VipMedicalRecord extends MedicalRecord{
    private String vipType;
    private String vipDuration;

    public VipMedicalRecord(String medicalCode, String patientCode, String patientName, String admissionDate, String dischargeDate, String reason, String vipType, String vipDuration) {
        super(medicalCode, patientCode, patientName, admissionDate, dischargeDate, reason);
        this.vipType = vipType;
        this.vipDuration = vipDuration;
    }

    @Override
    public void validate() throws InvalidDataException {
        if (!vipType.equals("VIP I") && !vipType.equals("VIP II") && !vipType.equals("VIP III")) {
            throw new InvalidDataException("Invalid VIP type");
        }
    }

    @Override
    public void display() {
        super.display();
        System.out.println("VIP Type: " + vipType);
        System.out.println("VIP Duration: " + vipDuration);
    }

    public String getVipType() {
        return vipType;
    }

    public String getVipDuration() {
        return vipDuration;
    }
}
