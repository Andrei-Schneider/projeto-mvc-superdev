import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Connection;

public class ConnectionTeste {
    public static void main(String[] args)

    Connection connection = ConnectionFactory.getConnection();

    if(connection != null) {
        System.out.println("A conxão foi estabelecida");
    } else {
        System.out.println("Algum problema");
    }
connection.close();

}
