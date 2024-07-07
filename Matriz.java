public class Matriz {

    private int linhas, colunas, soma, x, y;
    private String direcao;
    private String[][] matriz;

    public Matriz(int linhas, int colunas) {
        matriz = new String[linhas][colunas];
        this.linhas = linhas;
        this.colunas = colunas;
        soma = 0;
        x = 0;
        y = 0;
    }

    public void setValor(int x, int y, String valor) {if (isInBounds(x, y)) matriz[x][y] = valor;}

    public void percorrer(int inicio) {
        x = 0;
        y = inicio;
        String valor = "";
        direcao = "L";

        while (isInBounds(y, x) && !matriz[y][x].equals("#")) {
            String posicao = matriz[y][x];
            switch (posicao) {
                case "-":
                case "|":
                    mover();
                    break;
                case "/":
                case "\\":
                    virarDiagonal(posicao);
                    mover();
                    break;
                default:
                    if (Character.isDigit(posicao.charAt(0))) {
                        valor += posicao;
                        mover();
                        if (!isNumero(matriz[y][x])) {
                            soma += Integer.parseInt(valor);
                            valor = "";
                        }
                    } else mover();
                    break;
            }
        }
    }

    private void mover() {
        switch (direcao) {
            case "N" -> y--;
            case "S" -> y++;
            case "L" -> x++;
            case "O" -> x--;
        }
    }

    private void virarDiagonal(String posicao) {
        switch (direcao) {
            case "N" -> direcao = posicao.equals("/") ? "L" : "O";
            case "S" -> direcao = posicao.equals("/") ? "O" : "L";
            case "L" -> direcao = posicao.equals("/") ? "N" : "S";
            case "O" -> direcao = posicao.equals("/") ? "S" : "N";
        }
    }

    private boolean isInBounds(int y, int x) {return y >= 0 && y < linhas && x >= 0 && x < colunas;}
    private boolean isNumero(String posicao) {return posicao.matches("\\d");}

    public int getLinhas() {return linhas;}
    public int getColunas() {return colunas;}
    public int getSoma() {return soma;}
}