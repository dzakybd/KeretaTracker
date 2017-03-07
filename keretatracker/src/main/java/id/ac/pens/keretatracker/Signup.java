package id.ac.pens.keretatracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Signup extends AppCompatActivity {
    private EditText nama,email,username,password,password2;
    private Button button;
    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nama = (EditText) findViewById(R.id.daftar_nama);
        email = (EditText) findViewById(R.id.daftar_email);
        username = (EditText) findViewById(R.id.daftar_username);
        password = (EditText) findViewById(R.id.daftar_password);
        password2 = (EditText) findViewById(R.id.daftar_password2);
        button = (Button) findViewById(R.id.daftar_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                attemptsignup();
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }





    private void attemptsignup() {
        username.setError(null);
        password.setError(null);
        nama.setError(null);
        email.setError(null);
        password2.setError(null);
        boolean cancel = false;
        View focusView = null;

        String a = username.getText().toString();
        String b = password.getText().toString();
        String c = password2.getText().toString();
        String d = email.getText().toString();
        String e = nama.getText().toString();

        if(e.isEmpty()){
            nama.setError("Isi dengan nama");
            focusView = nama;
            cancel = true;
        } else if(d.isEmpty()){
            email.setError("Isi dengan email");
            focusView = email;
            cancel = true;
        } else if(a.isEmpty()){
            username.setError("Isi dengan username");
            focusView = username;
            cancel = true;
        } else if(b.isEmpty()){
            password.setError("Isi dengan password");
            focusView = password;
            cancel = true;
        } else if(c.isEmpty()){
            password2.setError("Isi dengan password");
            focusView = password2;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            progress = new ProgressDialog(this);
            progress.setMessage("Mendaftarkan.. ");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    progress.dismiss();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            finish();
                        }
                    }, 2000);
                }
            }, 3000);

        }
    }
}
