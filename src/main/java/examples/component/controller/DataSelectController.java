package examples.component.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

@Controller
public class DataSelectController {
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String CONNECT_URL = "jdbc:mysql://localhost/work_db?serverTimezone=JST";
    private static final String DB_USER_ID = "work_user";
    private static final String DB_USER_PW = "work_password";

    public DataSelectController(){
        super();
    }

    @RequestMapping(value="/data_select.do", method= RequestMethod.GET, produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String handleRequest(){
        try{
            Class.forName(DRIVER_NAME);
            Connection connection = DriverManager.getConnection(CONNECT_URL, DB_USER_ID, DB_USER_PW);

            String sql = "select id, name, price from t_product";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                System.out.println(id + "> " + name + "=" + price);
            }
            connection.close();
            return "success !";
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
