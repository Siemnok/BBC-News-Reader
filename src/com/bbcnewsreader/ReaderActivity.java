package com.bbcnewsreader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ScrollView;

import com.bbcnewsreader.data.DatabaseHandler;

public class ReaderActivity extends Activity {
	/** variables */
	ScrollView scroller;
	private DatabaseHandler dh;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.dh = new DatabaseHandler(this);
        dh.dropTables();
        dh.insertItem("Title1", "description1", "link1", "pubdate1", "World");
        dh.insertItem("Title2", "description2", "link2", "pubdate2", "World");
        dh.insertCategory("World",true,"http://feeds.bbci.co.uk/world/rss.xml");
        dh.insertCategory("Technology",false,"http://feeds.bbci.co.uk/news/rss.xml");
        dh.insertCategory("Science",true,"http://feeds.bbci.co.uk/science/rss.xml");
        String[] categories = dh.getEnabledCategories();
        Log.v("TEST",categories[0]+categories[1]);
    }
}
