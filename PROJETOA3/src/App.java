import DAO.UsuarioDAO;
import cadastrar.DescricaoDAO;
import entity.DadosCliente;
import produto.DescricaoProduto;
public class App {
    public static void main(String[] args) throws Exception {
       DadosCliente u = new DadosCliente();
       DescricaoProduto c = new DescricaoProduto();
       c.setModelocamisa();
       c.setTecido();
       c.setTamanho();
       c.setValorunitario();
       c.setQuantidade();
       c.setValortotal();
       
       u.setNome();
       u.setTelefone();
       u.setEmail();
       u.setCpf();
       u.setEndereco();
       
      
       
      
        new DescricaoDAO().cadastrarProduto(c);
         new UsuarioDAO().cadastrarUsuario(u);
        
    }
}
