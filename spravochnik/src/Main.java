import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        while(true) {
            System.out.println("Введите название файла:");
            Scanner in = new Scanner(System.in);
            String file = "C:\\Users\\user\\Desktop\\" + in.nextLine();

            Map<String, Integer> dubli = new HashMap<>();
            Map<String, Integer> houses = new HashMap<>();

            if(file.endsWith("csv")){
                List<String> addressList = new ArrayList<>();
                Map<String, String> addressListWithoutDubli = new HashMap<>();
                long time = System.currentTimeMillis();
                CSV csv = new CSV();
                csv.Form(file, addressList);
                System.out.println("Время обработки файла: " + ((System.currentTimeMillis() - time)/1000.0) + "сек");
                System.out.println("Повторяющиеся строки:");
                csv.Dubli(addressList, dubli);
                addressList = csv.Delete(addressList, addressListWithoutDubli);
                System.out.println("Количевство n-этажных домов в городах:");
                csv.numOfHouses(addressList, houses);
            }
            if(file.endsWith("xml")){
                long time = System.currentTimeMillis();
                XML xml = new XML();
                Root root = xml.Form(file);
                System.out.println("Время обработки файла: " + ((System.currentTimeMillis() - time)/1000.0) + "сек");
                System.out.println("Повторяющиеся строки:");
                xml.Dubli(root, dubli);
                System.out.println("Количевство n-этажных домов в городах:");
                xml.numOfHouses(root, houses);
            }
            if(file.endsWith("exit")){
                System.out.println("Выход из программы...");
                break;
            }
        }
    }
}