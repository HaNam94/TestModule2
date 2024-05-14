import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MedicalRecordManager {
    private static final String FILE_PATH = "src/data/medical_records.csv";
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();

    public static void main(String[] args) {
        loadMedicalRecords();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("--Chương trình quản lý bệnh án—");
            System.out.println("Chọn chức năng để tiếp tục:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Sửa");
            System.out.println("4. Xem danh sách bệnh án");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewMedicalRecord(scanner);
                    break;
                case 2:
                    deleteMedicalRecord(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    displayMedicalRecords();
                    break;
                case 5:
                    System.out.println("Đã thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);
    }

    private static void loadMedicalRecords() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    NormalMedicalRecord record = new NormalMedicalRecord(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], Double.parseDouble(parts[7]));
                    medicalRecords.add(record);
                } else if (parts.length == 9) {
                    VipMedicalRecord record = new VipMedicalRecord(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7], parts[8]);
                    medicalRecords.add(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addMedicalRecord(MedicalRecord record) {
        medicalRecords.add(record);
        writeToFile();
    }

    private static void writeToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (MedicalRecord record : medicalRecords) {
                String[] row = {String.valueOf(record.getRecordId()), record.medicalCode, record.patientCode, record.patientName, record.admissionDate, record.dischargeDate, String.valueOf(record.reason)};
                if (record instanceof NormalMedicalRecord) {
                    writer.println(String.join(",", row) + "," + ((NormalMedicalRecord) record).getHospitalFee());
                } else if (record instanceof VipMedicalRecord) {
                    writer.println(String.join(",", row) + "," + ((VipMedicalRecord) record).getVipType() + "," + ((VipMedicalRecord) record).getVipDuration());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addNewMedicalRecord(Scanner scanner) {
        System.out.println("--Thêm mới bệnh án—");
        System.out.print("Nhập mã bệnh án: ");
        String medicalCode = scanner.nextLine();
        System.out.print("Nhập mã bệnh nhân: ");
        String patientCode = scanner.nextLine();
        System.out.print("Nhập tên bệnh nhân: ");
        String patientName = scanner.nextLine();
        System.out.print("Nhập ngày nhập viện (dd/MM/yyyy): ");
        String admissionDate = scanner.nextLine();
        System.out.print("Nhập ngày ra viện (dd/MM/yyyy): ");
        String dischargeDate = scanner.nextLine();
        System.out.print("Nhập lý do nhập viện: ");
        String reason = scanner.nextLine();
        System.out.println("Nhập phí nằm viện: ");
        double hospitalFee = scanner.nextDouble();
        NormalMedicalRecord newRecord = new NormalMedicalRecord(medicalCode, patientCode, patientName, admissionDate, dischargeDate, reason, hospitalFee);
        addMedicalRecord(newRecord);
        System.out.println("Thêm mới thành công.");
    }

    private static void deleteMedicalRecord(Scanner scanner) {
        System.out.println("--Xóa bệnh án—");
        System.out.print("Nhập mã bệnh án cần xóa: ");
        String medicalCode = scanner.nextLine();
        Iterator<MedicalRecord> iterator = medicalRecords.iterator();
        while (iterator.hasNext()) {
            MedicalRecord record = iterator.next();
            if (record.medicalCode.equals(medicalCode)) {
                iterator.remove();
                System.out.println("Bệnh án với mã " + medicalCode + " đã được xóa.");
                writeToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh án với mã " + medicalCode + ".");
    }

    private static void displayMedicalRecords() {
        System.out.println("--Danh sách bệnh án—");
        for (MedicalRecord record : medicalRecords) {
            record.display();
            System.out.println();
        }
    }
}
