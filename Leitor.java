import static java.lang.StringTemplate.STR;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Leitor {

    private Matriz matriz;

    public Leitor(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Integer> firstLine = Arrays.stream(br.readLine().split(" "))
                                            .map(Integer::parseInt)
                                            .collect(Collectors.toList());

            matriz = new Matriz(firstLine.get(0), firstLine.get(1));

            AtomicInteger lineIndex = new AtomicInteger();
            int[] inicio = {0};

            br.lines().forEach(line -> {
                lineIndex.getAndIncrement();
                String[] valores = line.split("");
                if (valores[0].equals("-")) inicio[0] = lineIndex.get() - 1;
                for (int j = 0; j < matriz.getColunas(); j++) {
                    matriz.setValor(lineIndex.get() - 1, j, j < valores.length ? valores[j] : " ");
                }});
                
            matriz.percorrer(inicio[0]);
            System.out.println(STR."Soma: \{matriz.getSoma()}");
        } catch (IOException _) {}
    }
}