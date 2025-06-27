package produto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DescricaoProduto {

    Scanner leia = new Scanner(System.in);

    private String tecido;
    private String tamanho;
    private int valorunitario;
    private int quantidade;
    private float valortotal;
    private String formadepagamento;
    private String Status;
    private String prazodeentrega;
    private int contadordoarray;

    public int getContadordoarray() {
        return contadordoarray;
    }

    public void setContadordoarray() {
        contadordoarray = quantidade; // Garante que contadordoarray seja atualizado
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        setContadordoarray(); // Atualiza contadordoarray automaticamente
    }

    private String modelocamisa;

    public String getStatus() {
        return Status;
    }

    public String setStatus() {//Ajustado
        String[] opcoes = {"Em Andamento", "Produção", "OS Finalizada", "Expedição", "Concluído"};
        this.Status = selecionarOpcao("Selecione o status do produto:", opcoes);
        return Status;
    }

    public String getPrazodeentrega() {
        return prazodeentrega;
    }

    public void setPrazodeentrega() {//Alterado
        System.out.println("30 dias uteis");
    }

    public String getFormadepagamento() {
        return formadepagamento;
    }

    public String setFormadepagamento() { //Alterado
        String[] opcoes = {"Pix", "Dinheiro", "Cartão"};
        this.formadepagamento = selecionarOpcao("Qual a forma de pagamento?", opcoes);

        return formadepagamento;
    }

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

    public void setTamanho() throws InterruptedException {
        String[] opcoes = {"P", "M", "G", "GG"};
        this.tamanho = selecionarOpcao("Qual tamanho deseja?", opcoes);
        int i;
        for (i = 0; i < 15; i++) {
            System.out.println("");
            Thread.sleep(150);
        }
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

        valorunitario = 35;

        System.out.println("Valor unitario é 35");
    }

    public float getValortotal() {
        return valortotal;

    }

    public void setValortotal() {
        if (valorunitario > 0 && contadordoarray > 0) {
            valortotal = valorunitario * contadordoarray;
            System.out.println("Valor total a pagar: " + valortotal);
        } else {
            System.out.println("Erro: valorunitario ou contadordoarray não foram inicializados corretamente.");
        }
    }
}
