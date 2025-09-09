package DAO;

import model.Produto;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        return List.of();
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
            stmt.setBoolean(3,produto.isStatus());

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

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
