import lab8task2.Product;
import lab8task4.ReportList;

import java.util.List;

class Main{
    public static void main() {
        //Task 2
        Product<Double> p1 = new Product<>("Laptop", 1200.00);
        Product<Double> p2 = new Product<>("Tablet", 850.00);

        System.out.println(p1.comparePrice(p2));
        System.out.println(p2.comparePrice(p1));

        //Task 2



        //Task 4

        ReportList reportService = new ReportList();

        List<String> customerNames = List.of("Alice", "Bob", "Charlie");
        List<Double> dailyRevenue = List.of(1250.75, 980.25, 1430.60);
        List<Integer> productRatings = List.of(4, 5, 3, 5);

        System.out.println("--- Customer Names ---");
        reportService.exportList(customerNames);

        System.out.println("\n--- Daily Revenue ---");
        reportService.exportList(dailyRevenue);

        System.out.println("\n--- Product Ratings ---");
        reportService.exportList(productRatings);

        //Task 4
    }
}