package src;
public class Matriz {
    
    private int linhas, colunas;
    private String N, S, L, O;
    private String[][] matriz;

    public Matriz(int linhas, int colunas) {
        matriz = new String[linhas][colunas];
        this.linhas = linhas;
        this.colunas = colunas;
    }

    public void setValor(int x, int y, String valor) {
        matriz[x][y] = valor;
    }

    public void printarMatriz() {
        for (int i = 0; i < linhas; i++) {//y
            for (int j = 0; j < colunas; j++) {//x
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    //percorrer
    public void percorrer() {
        for (int i = 0; i < linhas; i++) {
        if(!matriz[i][0].equals("-")) continue;
            System.out.println("inicio: " + i);
        }
    }

    public int getLinhas() {return linhas;}
    public int getColunas() {return colunas;}

}
