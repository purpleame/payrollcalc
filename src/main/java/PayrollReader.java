import java.io.*;
import java.util.Scanner;

public class PayrollReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter fileWriter = new FileWriter("filehere");
            FileReader fileReader = new FileReader("filehere");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String print;
            bufferedWriter.write("id|name|gross pay");
            bufferedWriter.newLine();
            String header = bufferedReader.readLine();

            while ((print = bufferedReader.readLine()) != null) {
                String[] lines = print.split("\\|");

                int id = Integer.parseInt(lines[0]);
                String name = lines[1];
                double hours = Double.parseDouble(lines[2]);
                double rate = Double.parseDouble(lines[3]);

                Employee employee = new Employee(id, name, hours, rate);

                System.out.println("ID: " + employee.getEmployeeId() + " | Name: " + employee.getName()
                        + " | Gross Pay: $" + employee.getGrossPay());
                bufferedWriter.write("ID: " + employee.getEmployeeId() + " | Name: " + employee.getName()
                        + " | Gross Pay: $" + employee.getGrossPay());
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // for (int i = 0; i < lines.length; i++) {
            // System.out.println(lines[i]);
        // }
    }
}
