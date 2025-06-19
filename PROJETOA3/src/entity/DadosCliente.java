package entity;

import java.util.Scanner;

public class DadosCliente {
    Scanner leia = new Scanner(System.in);
    
    private String nome ;
    private String telefone;;
    private String email;
     private String cpf;
    private String Endereco;
    public String getEmail() {
        return email;
    }
    public void setEmail() {
        System.out.println("Digite o seu email:");
        email=leia.nextLine();
    }
   
    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco() {
        System.out.println("Informe o endereço: ");
        Endereco = leia.nextLine();
    }
   
    public String getNome() {
        return nome;
    }
    public void setNome() {
        System.out.println("Digite o nome a ser cadastrado: ");
        nome = leia.nextLine();
    }
    public String getTelefone() {
        
        return telefone;
    }
    public void setTelefone() {
        System.out.println("Digite o telefone a ser cadastrado: ");
        telefone = leia.nextLine();
       
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf() {
        System.out.println("Digite o CPF: ");
        cpf = leia.nextLine();
    }
    
}
