import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Leitor {

    private Matriz matriz;

    Leitor(String path) {
                try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            var firstLine = Arrays.stream(br.readLine().split(" "))
                                  .map(Integer::parseInt)
                                  .toList();

            matriz = new Matriz(firstLine.get(0), firstLine.get(1));

            var lineIndex = new AtomicInteger();
            var inicio = new int[]{0};

            br.lines().forEach(line -> {
                int i = lineIndex.getAndIncrement();
                var valores = line.split("");
                if (valores[0].equals("-")) inicio[0] = i;
                for (int j = 0; j < matriz.getColunas(); j++) {
                    matriz.setValor(i, j, j < valores.length ? valores[j] : " ");
                }
            });

            matriz.percorrer(inicio[0]);
            System.out.println(StringTemplate.STR."Soma: \{matriz.getSoma()}".toString());
        } catch (IOException _) {}
    }
}