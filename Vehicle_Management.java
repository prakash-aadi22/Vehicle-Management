import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class vehicle {
    Scanner sc = new Scanner(System.in);
    FileWriter fw;

    {
        try {
            fw = new FileWriter("vehicle.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void registration(String name) {
        try {
            System.out.print("Enter your vehicle model name: ");
            String vehicleName = sc.nextLine();
            System.out.print("Enter your vehicle number: ");
            String vehicleNumber = sc.nextLine();
            System.out.print("Enter your engine number: ");
            String engineNum = sc.nextLine();
            System.out.print("Enter your chassis number: ");
            String chassisNum = sc.next();
            sc.nextLine();
            System.out.println("Registering.....");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Congratulation, Mr/s. " + name + ", your " + vehicleName + ", of vehicle number: " + vehicleNumber + ", with engine number: " + engineNum + ", and chassis number: " + chassisNum + " has been registered.");
            fw.write("Congratulation, Mr/s. " + name + ", your " + vehicleName + ", of vehicle number: " + vehicleNumber + ", with engine number: " + engineNum + ", and chassis number: " + chassisNum + " has been registered.\n");
            System.out.print("Do you want vehicle Insurance (Yes/No): ");
            String ins = sc.next();
            if (ins.equalsIgnoreCase("yes")) {
                System.out.print("Enter the price of your vehicle: ₹");
                int price = sc.nextInt();
                int insurancePrice = (price * 90) / 100;
                int premiumPrice = (insurancePrice * 5) / 100;
                System.out.println("Processing.....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Your insurance of ₹" + insurancePrice + " has been done.");
                System.out.println("With the premium of: ₹" + premiumPrice);
                Calendar c = Calendar.getInstance();
                int month = c.get(Calendar.MONTH);
                System.out.println("Your insurance and registration date is: " + c.get(Calendar.DATE) + "/" + (month + 1) + "/" + c.get(Calendar.YEAR));
                int max = 999999;
                int min = 100000;
                int insuranceNumber = min + (int) (Math.random() * ((max - min) + 1));
                System.out.println("Insurance Number: " + insuranceNumber);
                fw.write("Your insurance and registration date is: " + c.get(Calendar.DATE) + "/" + (month + 1) + "/" + c.get(Calendar.YEAR) + "\n");
                fw.write("Your insurance of ₹" + insurancePrice + " has been done.\n");
                fw.write("With the premium of: ₹" + premiumPrice + "\n");
                fw.write("Insurance Number: " + insuranceNumber);
            } else if (ins.equalsIgnoreCase("No")) {
                Calendar c = Calendar.getInstance();
                int month = c.get(Calendar.MONTH);
                int newMonth = month + 1;
                System.out.println("Your registration date is: " + c.get(Calendar.DATE) + "/" + newMonth + "/" + c.get(Calendar.YEAR));
                fw.write("Your registration date is: " + c.get(Calendar.DATE) + "/" + newMonth + "/" + c.get(Calendar.YEAR) + "\n");
                int insuranceMonth = newMonth + 6;
                if (insuranceMonth > 12) {
                    int newInsuranceMonth = insuranceMonth - 12;
                    System.out.println("Get your insurance done within six months to get special offer, i.e. " + c.get(Calendar.DATE) + "/" + newInsuranceMonth + "/" + c.get(Calendar.YEAR));
                    fw.write("Get your insurance done within six months to get special offer, i.e. " + c.get(Calendar.DATE) + "/" + newInsuranceMonth + "/" + c.get(Calendar.YEAR));
                } else {
                    System.out.println("Get your insurance done within six months to get special offer, i.e. " + c.get(Calendar.DATE) + "/" + insuranceMonth + "/" + c.get(Calendar.YEAR));
                    fw.write("Get your insurance done within six months to get special offer, i.e. " + c.get(Calendar.DATE) + "/" + insuranceMonth + "/" + c.get(Calendar.YEAR));
                }
            } else {
                System.out.println("You have given a wrong input.");
            }
            fw.close();
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
    }

    void insurance(String name) {
        try {
            System.out.print("Enter your vehicle number: ");
            String vehicleNumber = sc.nextLine();
            System.out.println("Hello, Mr/s," + name + ", & and vehicle number is: " + vehicleNumber);
            fw.write("Mr/s," + name + ", & and vehicle number is: " + vehicleNumber + "\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter the date of your registration [ in the format of: dd/MM/yyyy ]: ");
            String cInput = sc.nextLine();
            Date regisDate = sdf.parse(cInput);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            Date currentDate = sdf.parse(dateFormat.format(c.getTime()));
            if ((regisDate.before(currentDate)) || (regisDate.equals(currentDate))) {
                System.out.println("Registration date was: " + cInput);
                System.out.print("Enter the price of your vehicle: ₹");
                int price = sc.nextInt();
                int insurancePrice = (price * 90) / 100;
                int premiumPrice = (insurancePrice * 5) / 100;
                System.out.println("Processing.....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Your insurance of ₹" + insurancePrice + " has been done.");
                System.out.println("With the premium of: ₹" + premiumPrice);
                fw.write("Your insurance of ₹" + insurancePrice + " has been done.\n");
                fw.write("With the premium of: ₹" + premiumPrice + "\n");
                int months = c.get(Calendar.MONTH);
                int newMonth = months + 1;
                System.out.println("Your insurance date is: " + c.get(Calendar.DATE) + "/" + newMonth + "/" + c.get(Calendar.YEAR));
                fw.write("Your insurance date is: " + c.get(Calendar.DATE) + "/" + newMonth + "/" + c.get(Calendar.YEAR) + "\n");
            } else if (regisDate.after(currentDate)) {
                System.out.println("You have given a future date.");
            } else {
                System.out.println("You have given a wrong input.");
            }
            int max = 999999;
            int min = 100000;
            int insuranceNumber = min + (int) (Math.random() * ((max - min) + 1));
            System.out.println("Insurance Number: " + insuranceNumber);
            fw.write("Insurance Number: " + insuranceNumber);
            fw.close();
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
    }

    void claim(String name) {
        try {
            System.out.print("Enter your vehicle model name: ");
            String vehicleName = sc.nextLine();
            System.out.print("Enter your vehicle number: ");
            String vehicleNumber = sc.nextLine();
            System.out.print("Enter your engine number: ");
            String engineNum = sc.nextLine();
            System.out.print("Enter your chassis number: ");
            String chassisNum = sc.next();
            sc.nextLine();
            System.out.println("Mr/s. " + name + ", your " + vehicleName + ", of vehicle number: " + vehicleNumber + ", with engine number: " + engineNum + ", and chassis number: " + chassisNum + " has been recognised.");
            fw.write("Mr/s. " + name + ", your " + vehicleName + ", of vehicle number: " + vehicleNumber + ", with engine number: " + engineNum + ", and chassis number: " + chassisNum + " has been recognised.\n");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter the date of your damage [ in the format of: dd/MM/yyyy ]: ");
            String cInput = sc.nextLine();
            Date regisDate = sdf.parse(cInput);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            Date currentDate = sdf.parse(dateFormat.format(c.getTime()));
            if ((regisDate.before(currentDate)) || (regisDate.equals(currentDate))) {
                System.out.println("Please upload the the photo of your vehicle if damaged or the copy the fir if stolen.");
                System.out.println("Verifying.....");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("We will contact you in 2 to 3 working days.");
                System.out.println("Please be, relaxed your insurance be claimed within a week.");
            } else if (regisDate.after(currentDate)) {
                System.out.println("You have given a future date.");
            } else {
                System.out.println("You have given a wrong input.");
            }
            int max = 999999;
            int min = 100000;
            int complaintNumber = min + (int) (Math.random() * ((max - min) + 1));
            System.out.println("Complaint Number: " + complaintNumber);
            fw.write("Complaint Number: " + complaintNumber);
            fw.close();
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
    }

    void service(String name) {
        try {
            System.out.print("Enter your vehicle number: ");
            String vehicleNumber = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Enter the date of to book your slot [ in the format of: dd/MM/yyyy ]: ");
            String cInput = sc.nextLine();
            Date regisDate = sdf.parse(cInput);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            Date currentDate = sdf.parse(dateFormat.format(c.getTime()));
            int max = 100;
            int min = 1;
            int slotNum = min + (int) (Math.random() * ((max - min) + 1));
            if (regisDate.after(currentDate)) {
                System.out.println("Mr/s. " + name + ", slot number " + slotNum + " has been booked on " + cInput + " of your vehicle number" + vehicleNumber);
                fw.write("Mr/s. " + name + ", slot number " + slotNum + " has been booked on " + cInput + " of your vehicle number" + vehicleNumber);
            } else if (regisDate.equals(currentDate)) {
                LocalTime localTime = LocalTime.now();
                LocalTime time1 = LocalTime.of(16, 0, 0);
                if (localTime.isBefore(time1)) {
                    System.out.println("Mr/s. " + name + ", slot number " + slotNum + " has been booked on " + cInput + " of your vehicle number" + vehicleNumber);
                    fw.write("Mr/s. " + name + ", slot number " + slotNum + " has been booked on " + cInput + " of your vehicle number" + vehicleNumber);
                } else if (localTime.isAfter(time1)) {
                    System.out.println("Please, book your slot for tomorrow.");
                } else if (localTime.equals(time1)) {
                    System.out.println("Please, book your slot for tomorrow.");
                } else {
                    System.out.println("Error");
                }
            } else if (regisDate.before(currentDate)) {
                System.out.println("You have given a past date.");
            } else {
                System.out.println("You have given a wrong input.");
            }
            fw.close();
        } catch (InputMismatchException ex) {
            System.out.println("You have given a wrong input.\nError --> " + ex);
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        }
    }
}

public class Vehicle_Management {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            vehicle v = new vehicle();
            System.out.println("********** Registration of your vehicle **********");
            System.out.print("Enter your full name: ");
            String name = sc.nextLine();
            String[] words = name.split("\\s");
            StringBuilder capitalizeStr = new StringBuilder();
            for (String word : words) {
                String firstLetter = word.substring(0, 1);
                String remainingLetters = word.substring(1);
                capitalizeStr.append(firstLetter.toUpperCase()).append(remainingLetters).append(" ");
            }
            String newName = capitalizeStr.toString();
            System.out.print("Enter your mobile number: ");
            long number = sc.nextLong();
            int max = 99;
            int min = 10;
            int otp1 = min + (int) (Math.random() * ((max - min) + 1));
            int otp2 = min + (int) (Math.random() * ((max - min) + 1));
            int otp3 = min + (int) (Math.random() * ((max - min) + 1));
            String otp = String.valueOf(otp1) + otp2 + otp3;
            System.out.println("OTP has been sent on the mobile number: " + number);
            System.out.println("OTP generated: " + otp);
            System.out.print("Enter the OTP: ");
            String OTP = sc.next();
            System.out.println("Verifying the OTP: " + OTP + ".....");
            Calendar c = Calendar.getInstance();
            TimeUnit.SECONDS.sleep(1);
            if (OTP.equals(otp)) {
                System.out.println("Logged in --> " + c.getTime() + " as " + newName);
                System.out.println("Enter: 1, for doing the registration of your vehicle.");
                System.out.println("Enter: 2, for doing the insurance of your vehicle.");
                System.out.println("Enter: 3, for claiming insurance of your vehicle.");
                System.out.println("Enter: 4, for booking a slot for service of your vehicle.");
                System.out.print("Enter you option: ");
                int option = sc.nextInt();
                if (option == 1) {
                    v.registration(newName);
                } else if (option == 2) {
                    v.insurance(newName);
                } else if (option == 3) {
                    v.claim(newName);
                } else if (option == 4) {
                    v.service(newName);
                } else {
                    System.out.println("You have given a wrong input.");
                }
                System.out.println("Details has been sent on your mobile number: " + number);
                System.out.println("Details has been saved in vehicle.txt");
            } else {
                System.out.println("Incorrect OTP");
            }
        } catch (Exception e) {
            System.out.println("Error --> " + e);
        } finally {
            System.out.println("\n********** Thank You **********");
        }
    }
}
