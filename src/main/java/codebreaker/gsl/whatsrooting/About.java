package codebreaker.gsl.whatsrooting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar1);
        toolbar.setTitle("About");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        int noOfChild = toolbar.getChildCount();
        View view;

        toolbar.setAlpha(0);
        toolbar.setTranslationY(-300);

        toolbar.animate().setDuration(1000).translationY(0).alpha(1);

/* For loop animates toolbar's child elements to give a nice parallax effect */
        for (int i = 0; i < noOfChild; i++) {
            view = toolbar.getChildAt(i);
            view.setTranslationY(-300);
            view.animate().setStartDelay(900).setDuration(950).translationY(0);
        }


        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

}
