package in.kyaji.model;


import com.mongodb.*;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by Akash on 14-07-2014.
 */
public class Post {

    public MongoClient mongoClient;
    public DB db;
    public DBCollection dbCollection;
    public BasicDBObject basicDBObject;


    public boolean init() {
        try {
            mongoClient = new MongoClient("localhost", 27017);

            db = mongoClient.getDB("blog");

            dbCollection = db.getCollection("stories");

            basicDBObject = new BasicDBObject();

            return true;
        }catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    public String add(String title,String body) {
        try{
            boolean goAhead = init();

            if (goAhead) {
                basicDBObject.put("title",title);
                basicDBObject.put("body",body);
                basicDBObject.put("createdDate",date);
                dbCollection.insert(basicDBObject);
                return "New Story added";
            } else {
                return "Some error occured";
            }

        }catch (Exception e) {
                return  e.getMessage().toString();
        }

    }

    public ArrayList get(int flag) throws  Exception {
        ArrayList answer = null;
        try {
            // for blog stories
            if (flag == 0) {
                if (init()) {
                    DBCursor dbCursor = dbCollection.find();

                    while (dbCursor.hasNext()) {
                        answer.add(dbCursor.next());
                    }

                } else {
                    System.out.println("Could not connect to databse");
                }
            }

        } catch (Exception e) {
             System.out.print(e);
        }

        return answer;
    }

    private ArrayList writeResultSet(ResultSet resultSet,int flag) throws SQLException {

        return stories;
    }

    public String addImage(String title,InputStream image) {
        try {



        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }



}
