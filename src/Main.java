import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Connection connect = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        // This will load the MySQL driver, each DB has its own driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost/Sklep?"
                            + "user=root&password=");

            String sqlSelect = "SELECT * FROM TPRODUCT WHERE id = 1;";

            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement.executeQuery(sqlSelect);

            while (resultSet.next()) {
                Product p = new Product();
                p.id = resultSet.getInt("id");
                p.name = resultSet.getString("name");
                p.price = resultSet.getDouble("price");
                p.amount = resultSet.getInt("amount");

                System.out.println(p.toString());
            }


            String sqlInsert = "INSERT INTO TPRODUCT (id, name, price, amount)" +
                    " VALUES (?, ?, ?, ?);";

            //statement.executeUpdate(sqlInsert);

            preparedStatement = connect.prepareStatement(sqlInsert);

            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2,"Woda");
            preparedStatement.setDouble(3, 4.5);
            preparedStatement.setInt(4,10);


            preparedStatement.executeUpdate();
            preparedStatement.clearParameters();




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
