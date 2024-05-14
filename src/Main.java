import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        MedicalRecordManager manager = new MedicalRecordManager();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("--Medical Record Management System--");
//            System.out.println("1. Add New Medical Record");
//            System.out.println("2. Delete Medical Record");
//            System.out.println("3. View Medical Records");
//            System.out.println("4. Exit");
//            System.out.print("Choose an option: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (choice) {
//                case 1:
//                    addNewMedicalRecord(manager, scanner);
//                    break;
//                case 2:
//                    deleteMedicalRecord(manager, scanner);
//                    break;
//                case 3:
//                    viewMedicalRecords(manager);
//                    break;
//                case 4:
//                    System.out.println("Exiting...");
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
//    }
//
//    private static void viewMedicalRecords(MedicalRecordManager manager) {
//        System.out.println("--Add New Medical Record--");
//        System.out.print("Enter Record Code: ");
//        Scanner scanner = null;
//        String recordCode = scanner.nextLine();
//        if (!recordCode.matches("BA-\\d+")) {
//            System.out.println("Invalid record code format. Record code must be in the format BA-XXX.");
//            return;
//        }
//        // Check for duplicate record code
//        for (MedicalRecord record : manager.medicalRecords) {
//            if (record.recordCode.equals(recordCode)) {
//                System.out.println("Duplicate record code. Record with this code already exists.");
//                return;
//            }
//        }
//    }
//
//    private static void deleteMedicalRecord(MedicalRecordManager manager, Scanner scanner) {
//        System.out.println("--Delete Medical Record--");
//        System.out.print("Enter Record Code to delete: ");
//        String recordCode = scanner.nextLine();
//    }
//
//    private static void addNewMedicalRecord(MedicalRecordManager manager, Scanner scanner) {
//        System.out.println("--View Medical Records--");
//        manager.displayMedicalRecords();
    }
}