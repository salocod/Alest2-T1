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
        System.out.println("Valor X: " + eixoLinhas + " e Y: " + eixoColunas + " = " + matriz[eixoLinhas][eixoColunas] + "");
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

    // percorrer
    public void percorrer() {
        @SuppressWarnings("unused")
        String linha = "";
         for (int i = 0; i < linhas; i++) {
            if (!matriz[i][0].equals("-")) continue;
            int cont = 0;
            String posicao = matriz[i][cont], valor = "";
            direcao = "L";
            while (!posicao.equals("#")) {
                linha += posicao + "";
                switch (posicao) {
                    case "-":
                        switch (direcao) {
                            case "N":
                                i--;
                                posicao = matriz[i][cont];
                                break;
                            case "S":
                                 i++;
                                posicao = matriz[i][cont];
                                break;
                            case "L":
                                cont++;
                                posicao = matriz[i][cont];
                                break;
                            case "O":
                                cont--;
                                posicao = matriz[i][cont];
                                break;
                            default:
                                break;
                        }
                        break;
                    case "/":
                        switch (direcao) {
                            case "N":
                                direcao = "L";
                                cont++;
                                posicao = matriz[i][cont];
                                break;
                            
                            case "S":
                                direcao = "O";
                                cont--;
                                posicao = matriz[i][cont];
                                break;
                            
                            case "L":
                                direcao = "N";
                                 i--;
                                posicao = matriz[i][cont];
                                break;
                            case "O":
                                direcao = "S";
                                i++;
                                posicao = matriz[i][cont];
                                break;
                            default:
                                break;
                        }
                        break;
                    case "\\":
                        switch (direcao) {
                            case "N":
                                direcao = "O";
                                cont--;
                                posicao = matriz[i][cont];
                                break;
                            
                            case "S":
                                direcao = "L";
                                cont++;
                                posicao = matriz[i][cont];
                                break;
                            
                            case "L":
                                direcao = "S";
                                i++;
                                posicao = matriz[i][cont];
                                break;
                            case "O":
                                direcao = "N";
                                i--;
                                posicao = matriz[i][cont];
                                break;
                            default:
                                break;
                        }
                        break;
                    case "|":
                        switch (direcao) {
                            case "N":
                                direcao = "N";
                                i--;
                                posicao = matriz[i][cont];
                                break;
                            case "S":
                                direcao = "S";
                                 i++;
                                posicao = matriz[i][cont];
                                break;
                            case "L":
                                direcao = "L";
                                cont++;
                                posicao = matriz[i][cont];
                                break;
                            case "O":
                                direcao = "O";
                                cont--;
                                posicao = matriz[i][cont];
                                break;
                            default:
                                break;
                        }
                        break;
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
                                i--;
                                posicao = matriz[i][cont];
                                if(numeros.contains(posicao)) {
                                    break;
                                } else {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                break;
                            case "S":
                                 i++;
                                posicao = matriz[i][cont];
                                if(numeros.contains(posicao)) {
                                    break;
                                } else {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                break;
                            case "L":
                                cont++;
                                posicao = matriz[i][cont];
                                if(numeros.contains(posicao)) {
                                    break;
                                } else {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                break;
                            case "O":
                                cont--;
                                posicao = matriz[i][cont];
                                if(numeros.contains(posicao)) {
                                    break;
                                } else {
                                    soma += Integer.parseInt(valor);
                                    valor = "";
                                }
                                break;
                            default:
                                break;
                        }
                }
            }
            break;
        }
    }

    public int getLinhas() {return linhas; }
    public int getColunas() {return colunas;}
    public int getSoma() {return soma;}

}
