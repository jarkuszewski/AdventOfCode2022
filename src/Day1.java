import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("resources/inputDay1"));

        List<Integer> caloriesPerElf = new ArrayList<>();
        var calories = 0;
        var maxCalories = 0;
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.isBlank()) {
                maxCalories = checkIfMaxAndAddPerElf(caloriesPerElf, calories, maxCalories);
                calories = 0;
            } else {
                calories += Integer.parseInt(line);
            }
        }
        caloriesPerElf.sort((a, b) -> b - a);
        System.out.println(caloriesPerElf.get(0) + caloriesPerElf.get(1) + caloriesPerElf.get(2));
    }

    private static int checkIfMaxAndAddPerElf(List<Integer> caloriesPerElf, int calories, int maxCalories) {
        maxCalories = getMaxCalories(calories, maxCalories);
        caloriesPerElf.add(calories);
        return maxCalories;
    }

    private static int getMaxCalories(int caloriesPerElf, int maxCalories) {
        if (caloriesPerElf > maxCalories) {
            maxCalories = caloriesPerElf;
        }
        return maxCalories;
    }
}
