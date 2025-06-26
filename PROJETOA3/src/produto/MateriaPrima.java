package produto;

import java.util.Scanner;

public class MateriaPrima {
    Scanner leia = new Scanner(System.in);

    private int papel; // quantidade em unidades
    private int tinta; // quantidade em ml
    private int vies; // quantidade em unidades
    private int etiquetadeproducao; // quantidade em unidades
    private int embalagem; // quantidade em unidades

    public int getPapel() {
        return papel;
    }
    public void setPapel() {
        System.out.println("Quantidade de papel?");
        papel = leia.nextInt();
        leia.nextLine(); // Limpa o buffer
    }

    public int getTinta() {
        return tinta;
    }
    public void setTinta() {
        System.out.println("Quantidade de tinta?");
        tinta = leia.nextInt();
        leia.nextLine();
    }

    public int getVies() {
        return vies;
    }
    public void setVies() {
        System.out.println("Quantidade de vies?");
        vies = leia.nextInt();
        leia.nextLine();
    }

    public int getEtiquetadeproducao() {
        return etiquetadeproducao;
    }
    public void setEtiquetadeproducao() {
        System.out.println("Quantidade de etiqueta?");
        etiquetadeproducao = leia.nextInt();
        leia.nextLine();
    }

    public int getEmbalagem() {
        return embalagem;
    }
    public void setEmbalagem() {
        System.out.println("Quantidade de embalagem?");
        embalagem = leia.nextInt();
        leia.nextLine();
    }
}
