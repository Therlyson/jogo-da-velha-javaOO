import java.util.Scanner;
import entities.Jogador;
import entities.Tabuleiro;
import entities.Vencedor;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();
        Vencedor vencedor = new Vencedor();

        String nome1, nome2;
        int i = 9;

        System.out.println("---------- BEM VINDOS AO JOGO DA VELHA ----------\n");

        System.out.print("Primeiro jogador insira seu nome: ");
        nome1 = teclado.nextLine();
        System.out.print("Agora escolha uma opção: [X ou O]\n-> ");
        char simbolo1 = teclado.next().charAt(0);

        Jogador jogador1 = new Jogador(nome1, simbolo1);
        teclado.nextLine();

        System.out.print("\nSegundo jogador insira seu nome: ");
        nome2 = teclado.nextLine();
        System.out.print("Agora escolha uma opção: [X ou O]\n-> ");
        char simbolo2 = teclado.next().charAt(0);

        Jogador jogador2 = new Jogador(nome2, simbolo2);

        tabuleiro.mostrarTabuleiro();
        while(i>0){
            if(i % 2 == 1){
                jogador1.jogar(tabuleiro, jogador1, jogador1.getSimbolo());
                i--;
                boolean campeao = vencedor.verificarVencedor(tabuleiro, jogador1.getSimbolo());
                if(campeao){
                    System.out.printf("%s VENCEU!!", jogador1.getNome());
                    break;
                }
            }

            else{
                jogador2.jogar(tabuleiro, jogador2, jogador2.getSimbolo());
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



