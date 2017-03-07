package id.ac.pens.keretatracker;

import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

public class Login extends AppCompatActivity {
    private EditText username,password;
    private TextView daftar;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        if(!Prefs.getString("iduser","").contentEquals("")){
            moveberanda();
        }


        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        daftar = (TextView) findViewById(R.id.login_daftar);
        button = (Button) findViewById(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                attemptlogin();
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);
            }
        });

    }

    private void attemptlogin() {
        username.setError(null);
        password.setError(null);
        boolean cancel = false;
        View focusView = null;
        String a = username.getText().toString();
        String b = password.getText().toString();
        if(a.isEmpty()){
            username.setError("Isi dengan username / email");
            focusView = username;
            cancel = true;
        }
        else if(b.isEmpty()){
                password.setError("Isi dengan password");
                focusView = password;
                cancel = true;
        }else if(isValidEmail(a)){
            if(!a.contentEquals("a@b.c")){
                username.setError("email tidak ada");
                focusView = username;
                cancel = true;
            }else if(a.contentEquals("a@b.c")&&b.contentEquals("123")){
                savesession();
                moveberanda();
            } else{
                password.setError("password salah");
                focusView = password;
                cancel = true;
            }
        }else{
            if(!a.contentEquals("dzakyzf")){
                username.setError("username tidak ada");
                focusView = username;
                cancel = true;
            }else if(a.contentEquals("dzakyzf")&&b.contentEquals("123")){
                savesession();
                moveberanda();
            } else{
                password.setError("password salah");
                focusView = password;
                cancel = true;
            }
        }

        if (cancel) focusView.requestFocus();
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    private void moveberanda() {
        Intent i = new Intent(Login.this, Main.class);
        startActivity(i);
        finish();
    }

    private void savesession() {
        Prefs.putString("iduser","user1");
    }
}
