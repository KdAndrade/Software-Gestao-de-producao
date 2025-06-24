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
        
        int idproduto = DescricaoDAO.idProduto;
        int idcliente=-1;
        String sql = "INSERT INTO DADOSCLIENTE (NOME,TELEFONE,EMAIL, CPF, ENDEREÇO) VALUES (?,?,?,?,?)";
        String sql2 = "INSERT INTO PEDIDO_CLIENTE_PRODUTO (idpedido_produto,idpedido_cliente) VALUES (?,?)";
       
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, dadoscliente.getNome());
            ps.setString(2, dadoscliente.getTelefone());
            ps.setString(3, dadoscliente.getEmail());
            ps.setString(4, dadoscliente.getCpf());
            ps.setString(5, dadoscliente.getEndereco());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idCliente = rs.getInt(1);
                System.out.println("A inserção de dados foi concluida com sucesso! \n id =" + idCliente);
                idcliente = idCliente;
                try (PreparedStatement es = Conexao.getConexao().prepareStatement(sql2)) {
                es.setInt(1, idproduto);
                es.setInt(2, idcliente);
                es.executeUpdate();
            }
            return idcliente;
                

            }/*es = Conexao.getConexao().prepareStatement(sql2);
            idproduto = DescricaoDAO.idProduto;
            es.setInt(1, idproduto);
            es.setInt(2, idcliente);
            es.executeUpdate();
            es.close(); */

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro no usuario");
        }
       

        return -1;

    }

}
