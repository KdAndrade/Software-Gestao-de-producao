package cadastrar;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import produto.DescricaoProduto;

public class DescricaoDAO {

    public static int idProduto;

    public int cadastrarProduto(DescricaoProduto descricaoProduto) {

        String sql = "INSERT INTO descricaoprodutos ( tecido, tamanho, valorunitario, modelocamisa, valortotal,formadepagamento,formadeentrega,prazodeentrega,status) VALUES (?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement ts = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ts.setString(1, descricaoProduto.getTecido());
            ts.setString(2, descricaoProduto.getTamanho());
            ts.setInt(3, descricaoProduto.getValorunitario());
            ts.setString(4, descricaoProduto.getModelocamisa());
            ts.setFloat(5, descricaoProduto.getValortotal());
            ts.setString(6, descricaoProduto.getFormadepagamento());
            ts.setString(8, descricaoProduto.getPrazodeentrega());
            ts.setString(9, descricaoProduto.getStatus());
            ts.executeUpdate();

            ResultSet ls = ts.getGeneratedKeys();
            if (ls.next()) {
                idProduto = ls.getInt(1);
                System.out.println("A inserção de dados foi concluida com sucesso! \n id Produto =" + idProduto);

                return idProduto;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro no produto");
            ;
        }

        return -1;
    }

    public void cadastrarPedidoClienteProduto(int idProduto, int idCliente) {
        String sql = "INSERT INTO PEDIDO_CLIENTE_PRODUTO (idpedido_produto, idpedido_cliente) VALUES (?,?)";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idProduto);
            ps.setInt(2, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao relacionar produto e cliente");
        }
    }

    public int Levaridproduto(int idprodutO) {
        idprodutO = idProduto;
        return idprodutO;
    }
}
