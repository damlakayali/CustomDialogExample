package net.damlakayali.customdialogexample;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button btnWin,btnLose,btnWinDialog,btnLoseDialog;
    ImageView winExit,loseExit;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWin = (Button) findViewById(R.id.btn_win);
        btnLose = (Button) findViewById(R.id.btn_lose);

        btnWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("Damla","OK");
                dialog = new Dialog(MainActivity.this);

                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.win_dialog);
                dialog.setTitle("Kazandın.");




                winExit = (ImageView) dialog.findViewById(R.id.win_exit);

                winExit.setSaveEnabled(true);
                //loseExit.setEnabled(true);

                btnWinDialog = (Button) dialog.findViewById(R.id.btn_win_dialog);
                btnWinDialog.setEnabled(true);

                winExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

                try{
                    dialog.show();
                }catch (Exception e){
                    Log.d("HATA",e.toString());
                }

            }
        });

        btnLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

                dialog.setContentView(R.layout.lose_dialog);
                dialog.setTitle("Kaybettin.");

                loseExit = (ImageView)dialog.findViewById(R.id.lose_exit);
                loseExit.setEnabled(true);

                btnLoseDialog = (Button)dialog.findViewById(R.id.btn_lose_dialog);
                btnLoseDialog.setEnabled(true);

                loseExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

                try{
                    dialog.show();
                }catch (Exception e){
                    Log.d("HATA",e.toString());
                }
            }
        });


    }
}
