//public class task2_2 {
//}
import java.io.*;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class task2_2 {
    public static void main(String[] args) {

        SimplCalc simplCalc = new SimplCalc();
        simplCalc.simplCalc();
    }
}
class MyLogger {
    private static final Logger log = Logger.getLogger("MyLogger");

    static {
        FileHandler fh;
        try {
            fh = new FileHandler("task2_2.txt", true);
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }catch (IOException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }
    public static void writeLog (String messeg){
        log.log(Level.INFO, "msgSupplier");
    }
    public static void writeLog (String messeg, Exception e){
        log.log(Level.WARNING, "msgSupplier", e);
    }
}

class SimplCalc {
    void simplCalc() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double x = sc.nextDouble();
        System.out.print("Enter the operator: -, +, *, /");
        char oper = sc.next().charAt(0);
        System.out.print("Enter the second number: ");
        double y = sc.nextDouble();
        sc.close();
        String result = "";
        switch (oper) {
            case '+':
                result = String.format("%.2f + %.2f = %.2f", x, y, x + y);
                break;
            case '-':
                result = String.format("%.2f - %.2f = %.2f", x, y, x - y);
                break;
            case '*':
                result = String.format("%.2f * %.2f = %.2f", x, y, x * y);
                break;
            case '/':
                result = String.format("%.2f / %.2f = %.2f", x, y, x / y);
                break;
        }
        MyLogger.writeLog(result);
        System.out.println(result);
    }
}