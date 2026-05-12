import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class EcomSalesHashMap {

    public static void main(String[] args) throws Exception {

        HashMap<String, Integer> salesMap = new HashMap<>();

        Scanner sc = new Scanner(new File("ECOM_DATASHEET.txt"));
        sc.nextLine(); // skip header

        while (sc.hasNextLine()) {

            Scanner line = new Scanner(sc.nextLine());

            for (int i = 0; i < 7; i++) line.next();

            String product = line.next() + " " + line.next();
            int amount = line.nextInt();

            salesMap.put(product, salesMap.getOrDefault(product, 0) + amount);

            line.close();
        }

        sc.close();

        System.out.println("===== PRODUCT TOTALS =====");

        for (String product : salesMap.keySet()) {
            System.out.println(product + " = Rs." + salesMap.get(product));
        }
    }
}