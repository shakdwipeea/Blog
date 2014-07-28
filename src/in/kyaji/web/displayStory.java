package in.kyaji.web;

import in.kyaji.model.*;

import java.util.ArrayList;

/**
 * Created by Akash on 14-07-2014.
 */
public class displayStory {
    private ArrayList story = null;

    public ArrayList getStory(int i) {
        System.out.println("Funciton called");
        Post post = new Post();
        try {
            story = post.get(i);
        }catch (Exception e) {
            System.out.print("The error is in getstoiry" +e.getMessage());
        }
        System.out.println("in getStory");
        return story;
    }
}
