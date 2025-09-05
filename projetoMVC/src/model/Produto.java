package model;

public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private boolean status;

    public Produto() {
    }

    public Produto(int id, String descricao, double preco, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
