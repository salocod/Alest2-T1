package src;

public class Matriz {

    private int linhas, colunas, soma;
    private String direcao;
    private String[][] matriz;

    public Matriz(int linhas, int colunas) {
        matriz = new String[linhas][colunas];
        this.linhas = linhas;
        this.colunas = colunas;
        soma = 0;
    }

    public void getValor(int eixoLinhas, int eixoColunas) {
        System.out.println(
                "Valor X: " + eixoLinhas + " e Y: " + eixoColunas + " = " + matriz[eixoLinhas][eixoColunas] + "");
    }

    public void setValor(int x, int y, String valor) {
        matriz[x][y] = valor;
    }

    public void printarMatriz() {
        for (int i = 0; i < linhas; i++) {// y
            for (int j = 0; j < colunas; j++) {// x
                System.out.print(matriz[i][j] + "");
            }
            System.out.println();
        }
    }

    public void percorrer(int inicio) {
            int cordX = 0, cordY = inicio;
            String posicao = matriz[cordY][cordX], valor = "";
            direcao = "L";
            while (!posicao.equals("#")) {
                switch (posicao) {
                    case "-":
                        switch (direcao) {
                            case "N":
                                cordY--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "S":
                                cordY++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "L":
                                cordX++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "O":
                                cordX--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            default:
                            break;
                        }
                    case "/":
                        switch (direcao) {
                            case "N":
                                direcao = "L";
                                cordX++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            
                            case "S":
                                direcao = "O";
                                cordX--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            
                            case "L":
                                direcao = "N";
                                 cordY--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "O":
                                direcao = "S";
                               cordY++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            default:
                            break;
                        }
                    case "\\":
                        switch (direcao) {
                            case "N":
                                direcao = "O";
                                cordX--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            
                            case "S":
                                direcao = "L";
                                cordX++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            
                            case "L":
                                direcao = "S";
                               cordY++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "O":
                                direcao = "N";
                                cordY--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            default:
                                break;
                        }
                    case "|":
                        switch (direcao) {
                            case "N":
                                cordY--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "S":
                                cordY++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "L":
                                cordX++;
                                posicao = matriz[cordY][cordX];
                                continue;
                            case "O":
                                cordX--;
                                posicao = matriz[cordY][cordX];
                                continue;
                            default:
                                break;
                        }
                    case "0":
                    case "1":
                    case "2":
                    case "3":
                    case "4":
                    case "5":
                    case "6":
                    case "7":
                    case "8":
                    case "9":
                    String numeros = "0123456789";
                    valor += posicao;
                        switch(direcao) {
                            case "N":
                                cordY--;
                                posicao = matriz[cordY][cordX];
                                if(!numeros.contains(posicao)) {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                continue;
                            case "S":
                                cordY++;
                                posicao = matriz[cordY][cordX];
                                if(!numeros.contains(posicao)) {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                continue;
                            case "L":
                                cordX++;
                                posicao = matriz[cordY][cordX];
                                if(!numeros.contains(posicao)) {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                continue;
                            case "O":
                                cordX--;
                                posicao = matriz[cordY][cordX];
                                if(!numeros.contains(posicao)) {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                continue;
                            default:
                                continue;
                            }
            }
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public int getSoma() {
        return soma;
    }

}
