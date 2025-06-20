package produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DescricaoProduto {

    Scanner leia = new Scanner(System.in);
    private String modelocamisa;
    private String tecido;
    private String tamanho;
    private int valorunitario;
    private int quantidade;
    private float valortotal;

    private String selecionarOpcao(String titulo, String[] opcoes) {
        while (true) {
            System.out.println(titulo);
            for (int i = 0; i < opcoes.length; i++) {
                System.out.println((i + 1) + " - " + opcoes[i]);
            }
            System.out.print("Digite o número da opção desejada: ");

            try {
                int escolha = leia.nextInt();
                leia.nextLine();

                if (escolha >= 1 && escolha <= opcoes.length) {
                    return opcoes[escolha - 1];
                } else {
                    System.out.println("\nERRO: Opção inválida.");
                    System.out.println("Por favor, digite um número entre 1 e " + opcoes.length + ".\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Entrada inválida.");
                System.out.println("Por favor, digite apenas o número da opção.\n");
                leia.nextLine();
            }
        }
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho() {
        String[] opcoes = {"P", "M", "G", "GG"};
        this.tamanho = selecionarOpcao("Qual tamanho deseja?", opcoes);
    }

    public String getModelocamisa() {
        return modelocamisa;
    }

    public void setModelocamisa() {
        String[] opcoes = {"gola V", "gola careca"};
        this.modelocamisa = selecionarOpcao("Qual o tipo da gola?", opcoes);
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido() {
        String[] opcoes = {"Dry Fit", "Malha PP"};
        this.tecido = selecionarOpcao("Qual o tecido?", opcoes);
    }

    public int getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario() {
        System.out.println("Valor unitario:");
        valorunitario = leia.nextInt();
        leia.nextLine();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade() {
        System.out.println("Qual a quantidade:");
        quantidade = leia.nextInt();
        leia.nextLine();
    }

    public float getValortotal() {
        return valortotal;
    }

    public void setValortotal() {
        System.out.println("Valor total a pagar:");
        valortotal = leia.nextFloat();
        leia.nextLine();
    }
}
