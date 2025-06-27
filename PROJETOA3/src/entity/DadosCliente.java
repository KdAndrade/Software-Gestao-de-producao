package entity;

import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.text.MaskFormatter;

public class DadosCliente {

    Scanner leia = new Scanner(System.in);

    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String Endereco;

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private String formatarString(String valor, String mascara) {
        try {
            MaskFormatter mf = new MaskFormatter(mascara);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(valor);
        } catch (ParseException ex) {
            return valor;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail() {
        while (true) {
            System.out.println("Digite o seu email:");
            String emailInput = leia.nextLine();
            if (EMAIL_PATTERN.matcher(emailInput).matches()) {
                this.email = emailInput;
                break;
            } else {
                System.out.println("\n--- ERRO ---");
                System.out.println("Formato de e-mail inválido.");
                System.out.println("O formato correto é: nome@dominio.com");
                System.out.println("Por favor, digite novamente.\n");
            }
        }
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
        while (true) {
            System.out.println("Digite o telefone (apenas números):");
            String telefoneInput = leia.nextLine();
            String telefoneNumerico = telefoneInput.replaceAll("[^0-9]", "");

            /*
            OLHAR ISSO DO TELEFONE
             */ if (telefoneNumerico.length() == 11) {
                this.telefone = formatarString(telefoneNumerico, "(##) #####-####");
                break;
            } else {
                System.out.println("\n--- ERRO ---");
                System.out.println("Formato de telefone inválido.");
                System.out.println("O formato correto deve conter 11 números: (##) #####-####");
                System.out.println("Por favor, digite novamente.\n");
            }
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf() {
        while (true) {
            System.out.println("Digite o CPF (apenas números):");
            String cpfInput = leia.nextLine();
            String cpfNumerico = cpfInput.replaceAll("[^0-9]", "");

            if (cpfNumerico.length() == 11) {
                this.cpf = formatarString(cpfNumerico, "###.###.###-##");
                break;
            } else {
                System.out.println("\n--- ERRO ---");
                System.out.println("Formato de CPF inválido.");
                System.out.println("O formato correto deve conter 11 números: ###.###.###-##");
                System.out.println("Por favor, digite novamente.\n");
            }
        }
    }
}
