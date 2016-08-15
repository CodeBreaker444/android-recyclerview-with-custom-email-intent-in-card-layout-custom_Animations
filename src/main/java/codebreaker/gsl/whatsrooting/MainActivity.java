package codebreaker.gsl.whatsrooting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("WhatsRooting");

        int noOfChild = toolbar.getChildCount();
        View view;

        toolbar.setAlpha(0);
        toolbar.setTranslationY(-300);

        toolbar.animate().setDuration(1100).translationY(0).alpha(1);

/* For loop animates toolbar's child elements to give a nice parallax effect */
        for(int i = 0; i < noOfChild; i++ ){
            view = toolbar.getChildAt(i);
            view.setTranslationY(-300);
            view.animate().setStartDelay(900).setDuration(950).translationY(0);
        }

        setSupportActionBar(toolbar);

        List<ItemObject> rowListItem = getAllItemList();
        LinearLayoutManager lLayout = new LinearLayoutManager(MainActivity.this);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setLayoutManager(lLayout);
        rView.setHasFixedSize(false);
        rView.setNestedScrollingEnabled(false);


        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;
        Intent intent1;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            intent1 = new Intent(MainActivity.this, About.class);
            startActivity(intent1);
        }
        if(id == R.id.action_refresh){
            intent1 = new Intent(MainActivity.this, Question.class);
            startActivity(intent1);
        }

        if(id == R.id.action_new){
            intent = new Intent(MainActivity.this, Developer.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("What's Rooting","Learn Basic Information About Rooting", R.drawable.rooting));
        allItems.add(new ItemObject("How To Root","ROOT Your Android Phone Safely", R.drawable.root));
        allItems.add(new ItemObject("Benefits Of Rooting","Top 10 Reasons To Root Your Android", R.drawable.benefits));
        allItems.add(new ItemObject("Disadvantages Of Rooting","Why You Shouldn't Root", R.drawable.dis));
        allItems.add(new ItemObject("Flashing","More Advance Way To Enhance Your Android", R.drawable.recovery));
        allItems.add(new ItemObject("Custom Roms","Completely Change The Look OF your Android", R.drawable.custom));



        return allItems;
    }


}
