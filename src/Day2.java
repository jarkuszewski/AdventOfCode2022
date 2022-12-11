import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day2 {
    public static void main(String[] args) throws IOException {

        var testInput = """
                A Y
                B X
                C Z
                """;

        BufferedReader reader = new BufferedReader(new FileReader("resources/inputDay2"));

        //A->rock B->paper C->scissors
        //X->rock(1p) Y->paper(2p) Z->scissors(3p)

        //AX -> draw(3p) + rock(1p) = 4p
        //AY -> win(6p) + paper(2p) = 8p
        //AZ -> lose(0p) + scissors(3p) = 3p

        //BX -> lose(0p) + rock(1p) = 1p
        //BY -> draw(3p) + paper(2p) = 5p
        //BZ -> win(6p) + scissors(3p) = 9p

        //CX -> win(6p) + rock(1p) = 7p
        //CY -> lose(0p) + paper(2p) = 2p
        //CZ -> draw(3p) + scissors(3p) = 6p

        Map<String, Integer> shapesWithPoints = new HashMap<>();
        shapesWithPoints.put("A X", 4);
        shapesWithPoints.put("A Y", 8);
        shapesWithPoints.put("A Z", 3);
        shapesWithPoints.put("B X", 1);
        shapesWithPoints.put("B Y", 5);
        shapesWithPoints.put("B Z", 9);
        shapesWithPoints.put("C X", 7);
        shapesWithPoints.put("C Y", 2);
        shapesWithPoints.put("C Z", 6);

        //AX -> rock, and need to lose(0p), means scissors(3p) = 3p
        //AY -> rock, and need to draw(3p), means rock(1p) = 4p
        //AZ -> rock, and need to win(6p), means paper(2p) = 8p

        //BX -> paper and need to lose(0p), means rock(1p) = 1p
        //BY -> paper and need to draw(3p), means  paper(2p) = 5p
        //BZ -> paper and need to win(6p) + scissors(3p) = 9p

        //CX -> scissors and need to lose(0p), means paper(2p) = 2p
        //CY -> scissors and need to draw(3p), means scissors(3p) = 6p
        //CZ -> scissors and need to win(6p),means rock(1p) = 7p

        Map<String, Integer> shapeWithRoundResultAndPoints = new HashMap<>();
        shapeWithRoundResultAndPoints.put("A X", 3);
        shapeWithRoundResultAndPoints.put("A Y", 4);
        shapeWithRoundResultAndPoints.put("A Z", 8);
        shapeWithRoundResultAndPoints.put("B X", 1);
        shapeWithRoundResultAndPoints.put("B Y", 5);
        shapeWithRoundResultAndPoints.put("B Z", 9);
        shapeWithRoundResultAndPoints.put("C X", 2);
        shapeWithRoundResultAndPoints.put("C Y", 6);
        shapeWithRoundResultAndPoints.put("C Z", 7);

        int points = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            points += shapeWithRoundResultAndPoints.get(line);
        }
        System.out.println(points);
    }
}
