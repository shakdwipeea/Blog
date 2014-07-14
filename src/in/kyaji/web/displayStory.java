package in.kyaji.web;

import in.kyaji.model.*;

import java.util.ArrayList;

/**
 * Created by Akash on 14-07-2014.
 */
public class displayStory {
    private ArrayList story = null;

    public ArrayList getStory () {
        Post post = new Post();
        try {
            story = post.get();
        }catch (Exception e) {
            System.out.print(e);
        }

        return story;
    }
}
