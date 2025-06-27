package testemateriaprima;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contador {

    // Consulta o estoque atual da matéria-prima pelo nome do campo e compara com a quantidade solicitada
    public static boolean verificarEstoque(String nomeCampo, int quantidadeSolicitada) {
        int estoqueAtual = 0;
        String sql = "SELECT " + nomeCampo + " FROM estoquemateriaprima LIMIT 1";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estoqueAtual = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (estoqueAtual < quantidadeSolicitada) {
            System.out.println("Estoque insuficiente de " + nomeCampo + ". É necessário comprar mais!");
            return false;
        } else {
            System.out.println("Estoque suficiente de " + nomeCampo + ".");
            return true;
        }
    }

    public static int atualizarEstoque(String nomeCampo, int quantidadeUsada) {
        String sql = "UPDATE estoquemateriaprima SET " + nomeCampo + " = " + nomeCampo + " - ? LIMIT 1";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, quantidadeUsada);
            ps.executeUpdate();
            System.out.println("Estoque de " + nomeCampo + " atualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar o estoque de " + nomeCampo);
        }
        return quantidadeUsada;
    }
}