package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import cadastrar.DescricaoDAO;
import conexao.Conexao;
import entity.DadosCliente;

public class UsuarioDAO {
    public int cadastrarUsuario(DadosCliente dadoscliente) {
        int idcliente = -1;
        String sql = "INSERT INTO DADOSCLIENTE (NOME,TELEFONE,EMAIL, CPF, ENDEREÇO) VALUES (?,?,?,?,?)";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dadoscliente.getNome());
            ps.setString(2, dadoscliente.getTelefone());
            ps.setString(3, dadoscliente.getEmail());
            ps.setString(4, dadoscliente.getCpf());
            ps.setString(5, dadoscliente.getEndereco());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idcliente = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro no usuario");
        }

        return idcliente;
    }

    public void cadastrarPedidoClienteProduto(int idProduto, int idCliente) {
        String sql = "INSERT INTO PEDIDO_CLIENTE_PRODUTO (idpedido_produto, idpedido_cliente) VALUES (?,?)";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idProduto);
            ps.setInt(2, idCliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
