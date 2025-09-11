package DAO;

import model.Produto;
import util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements GenericDAO {

    private Connection conn;

    public ProdutoDAO () throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public List<Object> getAll() {

        List<Object> produtoList = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM produto ORDER BY id";

        try {
            stmt = this.conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next());
            //Declaro um objeto da classe Produto pra ser populado com as informaçôes do banco
            Produto produto = new Produto();

            //Fazemos um match entre o nome da coluna no banco de dados com o nome do
            //atributo correspondente do objeto
            produto.setId(rs.getInt("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setPreco(rs.getDouble("preco"));
            produto.setStatus(rs.getBoolean("status"));

            //Inserir objeto na lista
            produtoList.add(produto);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception e){ e.printStackTrace();
        }
    }
    return produtoList;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Boolean add(Object object) {

        //Convertendo o objeto generico
        Produto produto = (Produto) object;

        //Instanciando um objeto da classe que formata o comando sql
        PreparedStatement stmt = null;

        //Escrevendo sql para inserir um novo registro na tabela 'produto'
        String sql = "INSERT INTO produto (descricao, preco, status) VALUES (?, ?, ?)";

        try {
            //Transforma a String sql em um cmando válido para ser executado no banco
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setBoolean(3, produto.isStatus());

        } catch (SQLException e) {
            System.out.println("Problemas ao inserir produto. Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception ex) {

            }

        }
        return null;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean insert(Object object) {
        return false;
    }
}
