package login;

import java.sql.connection;
import java.util.concurrent.ExecutionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User{
    public Connection conectarBD(){
        Connection conn = null; //1
        try{//2
            Class.forname("com.mysql.Driver.Manager").newInstance();//3
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        }catch(Exception e) { }//4
        return conn;}//5
    public String nome ="";//6
    public boolean result = false;//7
    public boolean verificarUsuario(String login, String senha){//8
        String sql = "";//9
        Connection conn = conectarBD();//10
        //INTRUÇÃO SQL
        sql += "select nome from usuarios ";//11
        sql += "where login = " + "'" + login + "'";//12
        sql += " and senha = " + "'" + senha + "';";//13
        try{//14
            Statement st = conn.createStatement();//15
            ResultSet rs = st.executeQuery(sql);//16
            if(rs.next()){//17
                result = true;//18
                nome = rs.getString("nome");}  //19
        }catch (Exception e) {  }//20
        return result;//21
    }//22 fim da class
}