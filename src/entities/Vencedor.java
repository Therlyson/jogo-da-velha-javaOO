package entities;

public class Vencedor {
    public boolean verificarVencedor(Tabuleiro tabuleiro, char simbolo){
        int contLinha = 0, contColu = 0, contDiag1 = 0, contDiag2 = 0;

        for(int i=0; i < 3; i++){
            for(int j=0; j<3; j++){
                if(tabuleiro.getMatriz()[i][j] == simbolo){ //verificando as linhas
                    contLinha++;
                }
                if(tabuleiro.getMatriz()[j][i] == simbolo){ //verificando as colunas
                    contColu++;
                }
            }
            if(tabuleiro.getMatriz()[i][i] == simbolo){ //verificando a diagonal principal
                    contDiag1++;
            }
            if (tabuleiro.getMatriz()[i][2 - i] == simbolo) {  //verificando a diagonal secundária
                contDiag2++;
            }

            if(contLinha == 3 || contColu==3 || contDiag1==3 || contDiag2==3){ //verificando se o jogador venceu
                return true;
            }

            contLinha = 0;
            contColu = 0;
        }
        return false;
    }

    public void verificaEmpate(int i){
        if(i==0){
            System.out.println("O JOGO DEU VELHA!");
        }
    }

}
