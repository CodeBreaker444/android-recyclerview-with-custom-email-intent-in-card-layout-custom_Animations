package codebreaker.gsl.whatsrooting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



import static com.google.android.gms.internal.zzir.runOnUiThread;


public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {
     public TextView Name;
    private ProgressDialog dialog;
    public TextView Desc;

    public ImageView Photo;

    private  Context context;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        context = itemView.getContext();
        itemView.setOnClickListener(this);

        Photo = (ImageView) itemView.findViewById(R.id.main_image);
        Name = (TextView) itemView.findViewById(R.id.main_name);
        Desc = (TextView) itemView.findViewById(R.id.main_description);

    }


    @Override
    public void onClick(View v) {


        dialog = ProgressDialog.show(new ContextThemeWrapper(context, R.style.Theme_MyDialog), "Hacking.....", "JustKidding");
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.isIndeterminate();
        dialog.show();

         new Thread(new Runnable() {
            @Override
            public void run() {
                final Intent intent;
                {
                    if (getPosition() == 0) {

                        intent = new Intent(context, whatsrooting.class);

                    } else if (getPosition() == 1) {
                        intent = new Intent(context, howtoroot.class);
                    } else if (getPosition() == 2) {
                        intent = new Intent(context, Benefits.class);
                    } else if (getPosition() == 3) {
                        intent = new Intent(context, Disadvantages.class);
                    } else if (getPosition() == 4) {
                        intent = new Intent(context, Flashing.class);
                    } else if (getPosition() == 5) {
                        intent = new Intent(context, Custom.class);
                    } else {
                        intent = new Intent(context, MainActivity.class);
                    }
                    context.startActivity(intent);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run()
                    {
                        dialog.dismiss();

                    }
                });

            }
         }).start();


    }}