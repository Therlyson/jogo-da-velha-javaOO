import java.util.Scanner;
import entities.Jogador;
import entities.Tabuleiro;
import entities.Vencedor;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Vencedor vencedor = new Vencedor();

        int i = 9;
        String corVermelha = "\u001B[31m";
        String reset = "\u001B[0m";
        System.out.println("---------- BEM VINDOS AO JOGO DA VELHA ----------\n");

        System.out.print("Primeiro jogador insira seu nome: ");
        String nome1 = teclado.nextLine();
        System.out.print("Agora escolha uma opção: [X ou O]\n-> ");
        char simbolo1 = teclado.next().charAt(0);
        Jogador jogador1 = new Jogador(nome1, simbolo1);

        teclado.nextLine();

        System.out.print("\nSegundo jogador insira seu nome: ");
        String nome2 = teclado.nextLine();
        System.out.print("Agora escolha uma opção: [X ou O]\n-> ");
        char simbolo2 = teclado.next().charAt(0);
        Jogador jogador2 = new Jogador(nome2, simbolo2);

        tabuleiro.mostrarTabuleiro();
        while(i>0){
            if(i % 2 == 1){
                while(true){
                    System.out.printf("Sua vez %s, digite a linha onde deseja jogar: ", jogador1.getNome());
                    int linha = teclado.nextInt();
                    System.out.print("Agora digite a coluna onde deseja jogar: ");
                    int coluna = teclado.nextInt();

                    boolean validando = tabuleiro.validarJogada(linha, coluna, jogador1.getSimbolo());
                    if(validando){
                        int j = 0;
                        while(j<100){
                            System.out.println(' ');
                            j++;
                        }
                        tabuleiro.mostrarTabuleiro();
                        break;
                    }
                    else{
                        System.out.println(corVermelha + "JOGADA INVÁLIDA, TENTE NOVAMENTE.\n" + reset);
                    }
                }
                i--;
                boolean campeao = vencedor.verificarVencedor(tabuleiro, jogador1.getSimbolo());
                if(campeao){
                    System.out.printf("%s VENCEU!!", jogador1.getNome());
                    break;
                }
            }

            else{
                while(true){
                    System.out.printf("Sua vez %s, digite a linha onde deseja jogar: ", jogador2.getNome());
                    int linha = teclado.nextInt();
                    System.out.print("Agora digite a coluna onde deseja jogar: ");
                    int coluna = teclado.nextInt();

                    boolean validando = tabuleiro.validarJogada(linha, coluna, jogador2.getSimbolo());
                    if(validando){
                        int j = 0;
                        while(j<100){
                            System.out.println(' ');
                            j++;
                        }
                        tabuleiro.mostrarTabuleiro();
                        break;
                    }
                    else{
                        System.out.println(corVermelha + "JOGADA INVÁLIDA, TENTE NOVAMENTE.\n" + reset);
                    }
                }
                i--;
                boolean campeao = vencedor.verificarVencedor(tabuleiro, jogador2.getSimbolo());
                if(campeao){
                    System.out.printf("%s VENCEU!!", jogador2.getNome());
                    break;
                }
            }

            vencedor.verificaEmpate(i);
        }

    }
}



