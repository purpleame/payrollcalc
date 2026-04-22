import java.io.*;
import java.util.Scanner;

public class PayrollReader {
    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("input absolute path here");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String print;
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
            }

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
