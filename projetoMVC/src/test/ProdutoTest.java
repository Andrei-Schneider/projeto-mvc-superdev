package test;

import controller.ProdutoController;
import model.Produto;
import javax.swing.*;
import java.util.List;

    public class ProdutoTest {

        public static void main(String[] args) throws  Exception {

            ProdutoController controller = new ProdutoController();

       /* Produto novoProduto= new Produto();
        novoProduto.setDescricao("Garrafinha de inox 500ml");
        novoProduto.setPreco(59.99);
        novoProduto.setStatus(true);

        String mensagemInsert = controller.insert(novoProduto);
        JOptionPane.showMessageDialog(null,mensagemInsert);*/



            //Processo de apresentar a lista dos produtos

            //Obter a lista do tipo produto
            List<Produto> produtoList = controller.getAll();

            //Crio uma variavel para construir a mensagem de saida de dados
            StringBuilder listaImprimir = new StringBuilder();

            for (Produto produto : produtoList) {
                listaImprimir.append(produto.getDescricao());
                listaImprimir.append("  -  ");
                listaImprimir.append(produto.getPreco());
                listaImprimir.append("\n");

        }

            JOptionPane.showMessageDialog(
                    null,
                    listaImprimir.toString());

    }


}
