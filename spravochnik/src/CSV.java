import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSV {
    public void printDubli(Map<String, Integer> dubli){
        for (Map.Entry<String, Integer> entry : dubli.entrySet()) {
            if (entry.getValue() !=1){
                System.out.println("Строка: " + "\"" + entry.getKey() + ", Количество повторов: " + entry.getValue());
            }
        }
    }
    public void printHouses(Map<String, Integer> houses){
        for (Map.Entry<String, Integer> entry : houses.entrySet()) {
            System.out.println("В городе \"" + entry.getKey() + " в количестве " + entry.getValue());
        }
    }
    public void numOfHouses(List<String> addressList, Map<String, Integer> houses){
        for (String line : addressList) {
            String[] splitedLine = line.split(";");
            String cur = (splitedLine[0] + " " + splitedLine[3] + "-этажных домов");
            Integer count = houses.get(cur);
            houses.put(cur, (count == null) ? 1 : count + 1);
        }
        printHouses(houses);
    }
    public void Dubli(List<String> addressList, Map<String, Integer> dubli){
        for (String line : addressList) {
            Integer count = dubli.get(line);
            dubli.put(line, (count == null) ? 1 : count + 1);
        }
        printDubli(dubli);
    }

    public List<String> Delete(List<String> addressList, Map<String, String> proba){
        List<String> temp = new ArrayList<>();
        for (String line : addressList) {
            proba.put(line, line);
        }
        for (Map.Entry<String, String> entry : proba.entrySet()) {
            temp.add(entry.getValue());
        }
        return temp;
    }
    public void Form(String file, List<String> addresrList) throws IOException {

        try {
            InputStreamReader fileReader = new InputStreamReader(new FileInputStream(file));

            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();
            List<String[]> allData = csvReader.readAll();

            for (String[] row : allData) {
                for (String cell : row) {
                    addresrList.add(cell);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не найден...");
        }
        catch(Exception e){
            System.out.println("ooopp");
        }
    }
}
