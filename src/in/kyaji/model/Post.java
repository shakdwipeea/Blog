package in.kyaji.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSInputFile;
import sun.misc.IOUtils;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


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
            System.out.println("The error is " + e.getMessage());
            return false;
        }
    }


    public String add(String title,String body) {
        try{
            boolean goAhead = init();

            if (goAhead) {
                basicDBObject.put("title",title);
                basicDBObject.put("body",body);
                basicDBObject.put("createdDate",new Date());
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
        ArrayList answer = new ArrayList();
        ArrayList ids = null;
        String result = null;
       String [] title = null;
        String [] story = null;
        try {
            // for blog stories
            if (flag == 0) {
                boolean headsUp = init();
                if (headsUp) {
                    BasicDBObject searchQuery = new BasicDBObject();
                    searchQuery.put("title","second");
                    DBCursor dbCursor = dbCollection.find();
                    //System.out.println("from dbcursor" + dbCursor.toString());
                    while (dbCursor.hasNext()) {
                        //result = dbCursor.next().toString();
                        DBObject dbObject = dbCursor.next();
                       System.out.println("Title:" + dbObject.get("title"));
                        try {
                            answer.add(dbObject.get("title").toString());
                            answer.add(dbObject.get("body").toString());
                            Date date = (Date) dbObject.get("createdDate");
                            answer.add(date);
                        }catch (NullPointerException e) {
                            System.out.println("Phir wahi error");

                        }
                        System.out.println("Here" + dbObject);
                        //JsonParser jsonParser = new JsonParser();
                       // JsonObject jsonObject = (JsonObject) jsonParser.parse(result);
                       // answer.add(jsonObject.get("title"));
                       // answer.add(jsonObject.get("body"));
                    }


                } else {
                    System.out.println("Could not connect to databse");
                }
            }

        } catch (Exception e) {
             e.printStackTrace();
        }
        System.out.println(answer);
        return answer;
    }



    public String addImage(String title,InputStream image) {
        try {
            String fileName = title;

            boolean headsUp = init();
            if (headsUp) {
                GridFS gridFS = new GridFS(db);
                GridFSInputFile gridFSInputFile = gridFS.createFile(image);

                gridFSInputFile.setFilename(title);

                gridFSInputFile.save();
            }


        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "hello";
    }



}
