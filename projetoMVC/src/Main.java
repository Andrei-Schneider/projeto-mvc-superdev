
import controller.ProdutoController;
import model.Produto;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {


        ProdutoController controller = new ProdutoController();

        StringBuilder menu = new StringBuilder();
        menu.append("*** Menu do Sistema ***");
        menu.append("\n [1] Cadastrar");
        menu.append("\n [2] Listar");
        menu.append("\n [0] Sair");
        menu.append("\n\nSelecione uma opção");

        int opcao = -1;

        while (opcao != 0) {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    //cadastrar
                    String descricao = JOptionPane.showInputDialog("Descriçãon do Produto");
                    Double preco = Double.parseDouble((JOptionPane.showInputDialog("Preço do produto")));

                    Produto novoProduto = new Produto();
                    novoProduto.setDescricao(descricao);
                    novoProduto.setPreco(preco);
                    novoProduto.setStatus(true);

                    String mensagemInsert = controller.insert(novoProduto);
                    JOptionPane.showMessageDialog(null, mensagemInsert);
                    break;
                case 2:
                    //Listar
                    List<Produto> produtoList = controller.getAll();

                    StringBuilder listImprimir = new StringBuilder();

                    for (Produto produto : produtoList) {
                        listImprimir.append(produto.getId());
                        listImprimir.append("  -  ");
                        listImprimir.append(produto.getDescricao());
                        listImprimir.append("  -  ");
                        listImprimir.append(produto.getPreco());
                        listImprimir.append("\n");
                    }
                    break;
                case 3:

            }
        }

    }
}
