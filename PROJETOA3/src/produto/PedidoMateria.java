package produto;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PedidoMateria {

    public static int Cadastrarmateriaprima(MateriaPrima materia, int quantidadeNecessariaPapel, int quantidadeNecessariaTinta, int quantidadeNecessariaVies) {
        if (!materia.verificarEstoque(quantidadeNecessariaPapel, quantidadeNecessariaTinta, quantidadeNecessariaVies)) {
            System.out.println("Não foi possível cadastrar o pedido por falta de matéria-prima.");
            return -1; // Retorna um valor indicando falha no cadastro
        }

        String sql = "INSERT INTO materiaprima (papel,tinta,vies,etiquetaproduto,embalagem) VALUES (?,?,?,?,?)";
        int idmateriaprima = -1;
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, materia.getPapel());
            ps.setInt(2, materia.getTinta());
            ps.setInt(3, materia.getVies());
            ps.setInt(4, materia.getEtiquetadeproducao());
            ps.setInt(5, materia.getEmbalagem());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                idmateriaprima = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro no cadastro de matéria-prima.");
        }

        return idmateriaprima;
    }
}
