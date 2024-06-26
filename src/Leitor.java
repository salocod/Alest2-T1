package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Leitor {

    private BufferedReader br;
    private Scanner sc;
    private Matriz matriz;

    public Leitor() {
        ler();
    }

    public void ler() {
        try {
            br = new BufferedReader(new FileReader("./src/tests/casoC2000.txt"));
            sc = new Scanner(br.readLine());
            matriz = new Matriz(sc.nextInt(), sc.nextInt());
            System.out.println("Linhas: " + matriz.getLinhas());
            System.out.println("Colunas: " + matriz.getColunas());

            int inicio = 0;
            for (int i = 0; i < matriz.getLinhas(); i++) {
                String linha = br.readLine();
                String[] valores = linha.split("");
                if(valores[0].equals("-")) {
                    inicio = i;
                }
                if (valores.length >= matriz.getColunas()) {
                    for (int j = 0; j < matriz.getColunas(); j++) {
                        matriz.setValor(i, j, valores[j]);
                    }
                } else {
                    int contador = 0;
                    for (String string : valores) {
                        matriz.setValor(i, contador, string);
                        contador++;
                    }
                    for (int k = contador; k < matriz.getColunas(); k++) {
                        matriz.setValor(i, k, " ");
                    }
                }
            }
            matriz.percorrer(inicio);
            System.out.println("Soma: " + matriz.getSoma());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}