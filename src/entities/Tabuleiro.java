package entities;

public class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro(){
        matriz = new char[3][3];
        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                matriz[i][j] = ' ';
            }
        }
    }

    public char[][] getMatriz(){
        return matriz;
    }

    public void mostrarTabuleiro(){
        String corAzul = "\u001B[34m";
        String corLaranja = "\u001B[33m";
        String reset = "\u001B[0m";

        System.out.println();
        System.out.println("   0   1   2");
        for(int i=0; i < 3; i++){
            System.out.print(i + " ");
            for(int j=0; j<3; j++){
                if(matriz[i][j] == 'X'){
                    System.out.printf(corAzul + " %c" + reset,matriz[i][j]);  //coloca cores diferentes em X e O.
                }
                else{
                    System.out.printf(corLaranja + " %c" + reset,matriz[i][j]);
                }
                if(j<2){
                    System.out.print(" |");
                }
            }
            System.out.println("\n ------------");
        }

    }

    public boolean validarJogada(int linha, int coluna, char simbolo){
        if(linha >= 0 && linha <= 2 && coluna >= 0 && coluna <= 2 && matriz[linha][coluna] == ' '){
            realizarJogada(linha, coluna, simbolo);
            return true;
        }
        return false;
    }

    public void realizarJogada(int linha, int coluna, char simbolo){
        matriz[linha][coluna] = simbolo;
    }

}
