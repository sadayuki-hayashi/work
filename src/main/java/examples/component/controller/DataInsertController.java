package examples.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class DataInsertController {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String CONNECT_URL = "jdbc:mysql://localhost/work_db?serverTimezone=JST";
    private static final String DB_USER_ID = "work_user";
    private static final String DB_USER_PW = "work_password";

    public DataInsertController() { super(); }

    @RequestMapping(value="/data_insert.do", method= RequestMethod.GET, produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String handleRequest(){
        try{
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(CONNECT_URL, DB_USER_ID, DB_USER_PW);

            connection.setAutoCommit(false);

            String sql = "insert into t_product(id, name, price) values(?, ?, ?)";
            try{
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, "eraser");
                preparedStatement.setString(2, "消しゴム");
                preparedStatement.setInt(3, 100);
                int n = preparedStatement.executeUpdate();
                connection.commit();

                System.out.println("n=" + String.valueOf(n));
                return "success !";
            }
            catch(SQLException e){
                connection.rollback();
                throw e;
            }
            finally{
                connection.close();
            }
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            return "failure !";
        }
        catch(SQLException e){
            e.printStackTrace();
            return "failure !";
        }
    }
}
