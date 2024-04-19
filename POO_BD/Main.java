import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/seu_banco_de_dados";
        String user = "seu_usuario";
        String password = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM sua_tabela";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nome = resultSet.getString("nome");
                        double preco = resultSet.getDouble("preco");
                        System.out.println("ID: " + id + ", Nome: " + nome + ", Preço: " + preco);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
