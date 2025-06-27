
import DAO.UsuarioDAO;
import cadastrar.DescricaoDAO;
import entity.DadosCliente;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import produto.DescricaoProduto;
import produto.MateriaPrima;
import produto.PedidoMateria;
import testemateriaprima.Contador;

public class App {

    public static void main(String[] args) throws Exception {
        DadosCliente u = new DadosCliente();
        UsuarioDAO cadastrarmateriaprima = new UsuarioDAO();
        Scanner leia = new Scanner(System.in);

        int quantidadeProdutos = 0; // Declaração da variável
        int valortotal = 0; // Inicialização do valor total
        ArrayList<Integer> idsProdutos = new ArrayList<>();
        ArrayList<Integer> idsCliente = new ArrayList<>();

        // Validação da entrada
        while (true) {
            try {
                System.out.print("Quantos produtos deseja cadastrar? ");
                quantidadeProdutos = leia.nextInt();
                leia.nextLine(); // Limpa o buffer do scanner

                if (quantidadeProdutos > 0) {
                    System.out.println("Você escolheu cadastrar " + quantidadeProdutos + " produtos.");
                    break; // Sai do loop após entrada válida
                } else {
                    System.out.println("Quantidade inválida. Por favor, insira um número maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                leia.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }

        // Cadastro dos produtos
        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println("\nCadastro do produto " + (i + 1) + ":");
            DescricaoProduto produto = new DescricaoProduto();
            MateriaPrima materiaPrima = new MateriaPrima();

            // Configuração do produto
            produto.setTecido();
            produto.setTamanho();
            produto.setValorunitario();
            produto.setModelocamisa();
            produto.setFormadepagamento();
            produto.setPrazodeentrega();
            produto.setStatus();

            // Acumula o valor total
            valortotal += produto.getValorunitario();

            // Configuração da matéria-prima
            materiaPrima.setPapel();
            materiaPrima.setTinta();
            materiaPrima.setVies();
            materiaPrima.setEtiquetadeproducao();
            materiaPrima.setEmbalagem();

            // Verifica o estoque antes de cadastrar
            if (Contador.verificarEstoque("quantidadepapel", materiaPrima.getPapel())
                    && Contador.verificarEstoque("quantidadetinta", materiaPrima.getTinta())
                    && Contador.verificarEstoque("quantidadevies", materiaPrima.getVies())
                    && Contador.verificarEstoque("quantidadeetiqueta", materiaPrima.getEtiquetadeproducao())
                    && Contador.verificarEstoque("quantidadeembalagem", materiaPrima.getEmbalagem())) {

                // Atualiza o estoque
                Contador.atualizarEstoque("quantidadepapel", materiaPrima.getPapel());
                Contador.atualizarEstoque("quantidadetinta", materiaPrima.getTinta());
                Contador.atualizarEstoque("quantidadevies", materiaPrima.getVies());
                Contador.atualizarEstoque("quantidadeetiqueta", materiaPrima.getEtiquetadeproducao());
                Contador.atualizarEstoque("quantidadeembalagem", materiaPrima.getEmbalagem());

                // Cadastro do produto
                int idProduto = new DescricaoDAO().cadastrarProduto(produto);
                idsProdutos.add(idProduto);

                // Cadastro do cliente
                u.setNome();
                u.setTelefone();
                u.setEmail();
                u.setCpf();
                u.setEndereco();
                int idCliente = new UsuarioDAO().cadastrarUsuario(u);
                idsCliente.add(idCliente);

                // Cadastro da matéria-prima
                int idMateriaPrima = PedidoMateria.Cadastrarmateriaprima(materiaPrima,
                        materiaPrima.getPapel(),
                        materiaPrima.getTinta(),
                        materiaPrima.getVies());

                // Relacionamento entre produto, cliente e matéria-prima
                cadastrarmateriaprima.cadastrarPedidoClienteProduto(idProduto, idCliente, idMateriaPrima);

            } else {
                System.out.println("Não foi possível cadastrar o pedido por falta de matéria-prima.");
                continue;
            }

            System.out.println("Produto " + (i + 1) + " cadastrado com sucesso!");
        }

        System.out.println("Todos os produtos foram cadastrados!");
        System.out.println("Valor Total: " + valortotal);
        leia.close();
    }
}
