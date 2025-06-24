import DAO.UsuarioDAO;
import cadastrar.DescricaoDAO;
import entity.DadosCliente;
import produto.DescricaoProduto;
public class App {
    public static void main(String[] args) throws Exception {
       DadosCliente u = new DadosCliente();
       DescricaoProduto c = new DescricaoProduto(); //TEM QUE COLOCAR UMA CONDIÇÃO PARA CASO QUEIRA FAZER MAIS DE UM PEDIDO EM UM SÓ "RUN"
       int i=0;
       c.setQuantidade();
       
       while(i <c.getQuantidade() ){
         c.setModelocamisa();
       c.setTecido();
       c.setTamanho();
       c.setValorunitario();
       
       c.setValortotal();
       c.setFormadepagamento();
       c.setFormadeentrega();
       c.setPrazodeentrega();
       c.setStatus();


       
       u.setNome();
       u.setTelefone();
       u.setEmail();
       u.setCpf();
       u.setEndereco();
       i++;
       }
      
       
      
       
      
        new DescricaoDAO().cadastrarProduto(c);
         new UsuarioDAO().cadastrarUsuario(u);
        
    }
}
