import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Input filename to write to when compiling");
            return;
        }

        String filePath = args[0];
        List<Product> products = new ArrayList<>();

        LocalDate ldCreated = LocalDate.of(2024, 10, 21);
        Date createDt = Date.from(ldCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());

        products.add(new Product(1L, "Mouse", "For click UI on screen", "Computer", 59.0f, createDt));
        products.add(
                new Product(2L, "Keyboard", "Device that allows alphanumeric inputs", "Computer", 235.5f, createDt));
        products.add(new Product(3L, "15.6 inch Monitor", "Extended display panel", "Computer", 157.5f, createDt));
        products.add(new Product(4L, "Huawei Pura 70 Ultra", "Huawei phone", "Mobile", 900.0f, createDt));
        products.add(new Product(5L, "Huawei Mate 50 Pr", "Huawei phone", "Mobile", 1200.0f, createDt));
        products.add(new Product(6L, "iPhone 15 Pro", "iPhone", "Mobile", 2000.0f, createDt));
        products.add(new Product(7L, "iPhone 14 Pro", "iPhone", "Mobile", 1800.0f, createDt));

        List<Product> filterProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() <= 1500.0f) {
                filterProducts.add(product);
            }
        }

        System.out.println("Products below $1500:");
        for (Product product : filterProducts) {
            System.out.println(product.getProdName() + ", $" + product.getPrice());
        }

        writeToFile(filePath, filterProducts);

        System.out.println("Ascending Order: \n");
        sortAsc(filterProducts);
        writeToFile(filePath + "_ascending.txt", filterProducts);

        System.out.println("Descending Order: \n");
        sortDesc(filterProducts);
        writeToFile(filePath + "_descending.txt", filterProducts);
    }



    private static void writeToFile(String filePath, List<Product> filterProducts) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)));
            for (Product product : filterProducts) {
                bw.write(product.getProdName() + " - $" + product.getPrice());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sortAsc(List<Product> filterProducts) {
        filterProducts.sort(Comparator.comparing(Product::getProdCategory));
        for (Product product : filterProducts) {
            System.out.println(product.getProdCategory() + " " +  product.getProdName());
        }
    }

    private static void sortDesc(List<Product> filterProducts) {
    filterProducts.sort(Comparator.comparing(Product::getProdCategory).reversed());
    for (Product product : filterProducts) {
        System.out.println(product.getProdCategory() + " " +  product.getProdName());
    }
}
}
