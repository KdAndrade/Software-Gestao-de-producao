package produto;

import java.util.Scanner;

public class DescricaoProduto {
   Scanner leia = new Scanner(System.in);
    private String modelocamisa;
    private String tecido;
    private String tamanho;
      private int valorunitario;
    private int quantidade;
    private float valortotal;
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho() {
        System.out.println("Qual tamanho deseja ?");
        System.out.println("[P] [M] [G] [GG]");
        tamanho = leia.next();
    }
  
    public String getModelocamisa() {
        return modelocamisa;
    }
    public void setModelocamisa() {
        System.out.println("Deseja qual tipo para o seu produto?");
        System.out.println("Tipo da gola: [gola V] ou [gola careca]: ");
        modelocamisa = leia.nextLine();

    }
    public String getTecido() {
        return tecido;
    }
    public void setTecido() {
        System.out.println("Qual tecido ? \n  Dry Fit ou Malha PP :");
     tecido = leia.nextLine();
    }
    public int getValorunitario() {
        return valorunitario;
    }
    public void setValorunitario() {
        System.out.println("Valor unitario:");
        valorunitario=leia.nextInt();
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade() {
        System.out.println("Qual a quantidade :");
        quantidade=leia.nextInt();
    }
    public float getValortotal() {
        return valortotal;
    }
    public void setValortotal() {
        System.out.println("Valor total a pagar :");
        valortotal=leia.nextFloat();
    }
   
    
}
