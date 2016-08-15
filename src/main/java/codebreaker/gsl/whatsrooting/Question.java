package codebreaker.gsl.whatsrooting;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Question extends AppCompatActivity {

    public static final String IMAGE_RESOURCE_ID = "iconResourceID";
    public static final String ITEM_NAME = "itemName";

    EditText textTo;

    Button send;

    @Override


public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.register_layout);
    final Toolbar toolbar = (Toolbar) findViewById(R.id.MyToolbar);
    toolbar.setTitleTextColor(0xFFFFFFFF);
        toolbar.setTitle("Support");

    int noOfChild = toolbar.getChildCount();
    View view;

    toolbar.setAlpha(0);
    toolbar.setTranslationY(-300);

    toolbar.animate().setDuration(1000).translationY(0).alpha(1);

/* For loop animates toolbar's child elements to give a nice parallax effect */
    for(int i = 0; i < noOfChild; i++ ){
        view = toolbar.getChildAt(i);
        view.setTranslationY(-300);
        view.animate().setStartDelay(900).setDuration(950).translationY(0);
    }


    setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        textTo=(EditText)findViewById(R.id.email);

    send=(Button)findViewById(R.id.btnLogin);

        send.setOnClickListener(new OnClickListener() {


            @Override
            public void onClick(View arg0) {

                String message = textTo.getText().toString();


                Intent email = new Intent(Intent.ACTION_SEND);

                email.putExtra(Intent.EXTRA_TEXT, message);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"zeroerror.444@gmail.com"});
                email.putExtra(Intent.EXTRA_SUBJECT, "Got A Question For You!!!!");

                //need this to prompts email client only
                email.setType("message/rfc822");

                try {
                    startActivity(Intent.createChooser(email, "Choose an Email client :"));
                } catch (ActivityNotFoundException exception) {
                    Toast.makeText(Question.this, "No email clients installed on device!", Toast.LENGTH_LONG).show();
            }

        }

    });



    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

}
