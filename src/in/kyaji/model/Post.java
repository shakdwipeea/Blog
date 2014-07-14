package in.kyaji.model;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Akash on 14-07-2014.
 */
public class Post {

    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public String add(String title,String body) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?" + "user=root&password=");
            statement = connection.createStatement();

            DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");
            Date d = new Date();
            String d1 = dateFormat.format(d);

            preparedStatement = connection.prepareStatement("insert into stories (Title,Story,date) values (?,?,?)");
            preparedStatement.setString(1,title);
            preparedStatement.setString(2,body);
            preparedStatement.setString(3,d1);

            preparedStatement.executeUpdate();

            return "Sucess";
        }catch (Exception e) {
                return  e.getMessage().toString();
        }

    }

    public ArrayList get() throws  Exception {
        ArrayList answer = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/blog?" + "user=root&password=");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from stories");
            answer = writeResultSet(resultSet);
        } catch (Exception e) {
             System.out.print(e);
        }
        return answer;
    }

    private ArrayList writeResultSet(ResultSet resultSet) throws SQLException {
        String result =null;
        ArrayList stories;
        stories = new ArrayList();
        while (resultSet.next()) {
            int sno = resultSet.getInt("Sno");
            String title = resultSet.getString("Title");
            String story = resultSet.getString("Story");
            String date = resultSet.getString("Date");
           stories.add(sno);
            stories.add(title);
            stories.add(story);
            stories.add(date);

        }
        return stories;
    }
}
