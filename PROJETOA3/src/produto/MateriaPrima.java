package produto;

public class MateriaPrima {

    private int papel; // quantidade em unidades
    private int tinta; // quantidade em ml
    private int vies; // quantidade em unidades
    private int etiquetadeproducao; // quantidade em unidades
    private int embalagem; // quantidade em unidades

    public int getPapel() {
        return papel;
    }

    public void setPapel() {
        papel = 1;
    }

    public int getTinta() {
        return tinta;
    }

    public void setTinta() {
        tinta = 1;
    }

    public int getVies() {
        return vies;
    }

    public void setVies() {
        vies = 1;
    }

    public int getEtiquetadeproducao() {
        return etiquetadeproducao;
    }

    public void setEtiquetadeproducao() {
        etiquetadeproducao = 1;
    }

    public int getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem() {
        embalagem = 1;
    }

    public boolean verificarEstoque(int quantidadeNecessariaPapel, int quantidadeNecessariaTinta, int quantidadeNecessariaVies) {
        if (papel < quantidadeNecessariaPapel) {
            System.out.println("Estoque insuficiente de papel. É necessário comprar mais!");
            return false;
        }
        if (tinta < quantidadeNecessariaTinta) {
            System.out.println("Estoque insuficiente de tinta. É necessário comprar mais!");
            return false;
        }
        if (vies < quantidadeNecessariaVies) {
            System.out.println("Estoque insuficiente de vies. É necessário comprar mais!");
            return false;
        }
        return true;
    }

}