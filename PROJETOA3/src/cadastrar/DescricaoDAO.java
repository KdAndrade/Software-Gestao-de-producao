package cadastrar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import produto.DescricaoProduto;


import conexao.Conexao;
public class DescricaoDAO {
    public int cadastrarProduto(DescricaoProduto descricaoProduto){
String sql = "INSERT INTO descriçãoprodutos (modelocamisa, tecido, tamanho, valorunitario, quantidade, valortotal) VALUES (?,?,?,?,?,?)";
  
   try (PreparedStatement ts = Conexao.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
   
    ts.setString(1, descricaoProduto.getModelocamisa());
    ts.setString(2, descricaoProduto.getTecido());
    ts.setString(3, descricaoProduto.getTamanho());
    ts.setInt(4, descricaoProduto.getValorunitario());
    ts.setInt(5, descricaoProduto.getQuantidade());
    ts.setFloat(6, descricaoProduto.getValortotal());
    
    ts.executeUpdate();

    ResultSet ls = ts.getGeneratedKeys();
    if(ls.next()){
        int idProduto = ls.getInt(1);
       System.out.println("A inserção de dados foi concluida com sucesso! \n id Produto ="+idProduto);  
       return idProduto;
        
    }
    
} catch (SQLException e) {
    e.printStackTrace();
    System.out.println("Erro no produto");;
}

return -1;
    }
}