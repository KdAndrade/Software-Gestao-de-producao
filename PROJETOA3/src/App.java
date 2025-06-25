import java.util.ArrayList;
import java.util.Scanner;

import DAO.UsuarioDAO;
import cadastrar.DescricaoDAO;
import entity.DadosCliente;
import produto.DescricaoProduto;

public class App {
    public static void main(String[] args) throws Exception {
        DadosCliente u = new DadosCliente();
        Scanner leia = new Scanner(System.in);
        System.out.print("Quantos produtos deseja cadastrar? ");
        int quantidadeProdutos = leia.nextInt();
        leia.nextLine(); // Limpa o buffer
        ArrayList<Integer> idsProdutos = new ArrayList<>();
        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("\nCadastro do produto " + (i + 1) + ":");
            DescricaoProduto produto = new DescricaoProduto();
            produto.setQuantidade();
            produto.setTecido();
            produto.setTamanho();
            produto.setValorunitario();
            produto.setModelocamisa();
            produto.setValortotal();
            produto.setFormadepagamento();
            produto.setFormadeentrega();
            produto.setPrazodeentrega();
            produto.setStatus();
            int idProduto = new DescricaoDAO().cadastrarProduto(produto);
            idsProdutos.add(idProduto);
        }

        System.out.println("Todos os produtos foram cadastrados!");

        u.setNome();
        u.setTelefone();
        u.setEmail();
        u.setCpf();
        u.setEndereco();
        leia.close();

        int idCliente = new UsuarioDAO().cadastrarUsuario(u);

        for (int idProduto : idsProdutos) {
            new UsuarioDAO().cadastrarPedidoClienteProduto(idProduto, idCliente);
        }
    }
}
