package entities;

import java.util.Scanner;

public class Jogador {
    private String nome;
    private char simbolo;

    public Jogador(String nome, char simbolo){
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome(){
        return nome;
    }

    public char getSimbolo(){
        return simbolo;
    }

    public void jogar(Tabuleiro tabuleiro, Jogador jogador, char caracter){
        Scanner teclado = new Scanner(System.in);
        int key = 0;
        String corVermelha = "\u001B[31m";
        String reset = "\u001B[0m";

        while(key==0){
            System.out.printf("Sua vez %s, digite a linha onde deseja jogar: ", jogador.getNome());
            int linha = teclado.nextInt();

            System.out.print("Agora digite a coluna onde deseja jogar: ");
            int coluna = teclado.nextInt();


            boolean validando = tabuleiro.validarJogada(linha, coluna, caracter);
            if(validando){
                tabuleiro.realizarJogada(linha, coluna, caracter);
                tabuleiro.mostrarTabuleiro();
                key = 1;
            }
            else{
                System.out.println(corVermelha + "JOGADA INVÁLIDA, TENTE NOVAMENTE.\n" + reset);
            }
        }

    }

}
