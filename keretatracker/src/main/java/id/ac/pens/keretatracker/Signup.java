package id.ac.pens.keretatracker;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Signup extends Activity {
    private static final String TAG = Signup.class.getSimpleName();
    private Button button;
    private EditText inputnama;
    private EditText inputemail;
    private EditText inputusername;
    private EditText inputpassword;
    private EditText inputpassword2;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        inputnama = (EditText) findViewById(R.id.daftar_nama);
        inputemail = (EditText) findViewById(R.id.daftar_email);
        inputusername = (EditText) findViewById(R.id.daftar_username);
        inputpassword = (EditText) findViewById(R.id.daftar_password);
        inputpassword2 = (EditText) findViewById(R.id.daftar_password2);
        button = (Button) findViewById(R.id.daftar_button);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Signup.this,
                    Main.class);
            startActivity(intent);
            finish();
        }
// Register Button Click event
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = inputnama.getText().toString().trim();
                String email = inputemail.getText().toString().trim();
                String username = inputusername.getText().toString().trim();
                String password = inputpassword.getText().toString().trim();
                String password2 = inputpassword2.getText().toString().trim();

                if (!name.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty() && !password2.isEmpty()) {
                    registerUser(name, email, username, password, password2);
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your details!", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    private void registerUser(final String name, final String email, final String username,
                              final String password, final String password2) {
        // Tag used to cancel the request
        String tag_string_req = "req_register";

        pDialog.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    Log.i("tagconvertstring", "["+ response +"]");
                    JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL

                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                Signup.this,
                                Login.class);
                        startActivity(intent);
                        finish();
                    } else {

                        // Error occurred in registration. Get the error
                        // message
                        String errorMsg = jObj.getString("error_msg");
                        Toast.makeText(getApplicationContext(),
                                errorMsg, Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", name);
                params.put("email", email);
                params.put("username", username);
                params.put("password", password);
                params.put("password2", password2);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
/*// Progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent(Signup.this,
                    Login.class);
            startActivity(intent);
            finish();
        }

// Register Button Click event

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            String daftar_nama = nama.getText().toString().trim();
            String daftar_email = email.getText().toString().trim();
            String daftar_username = username.getText().toString().trim();
            String daftar_password = password.getText().toString().trim();
            String daftar_password2 = password2.getText().toString().trim();

            if (!daftar_nama.isEmpty() && !daftar_email.isEmpty() && !daftar_username.isEmpty() && !daftar_password.isEmpty() && !daftar_password2.isEmpty()) {
                    registerUser(daftar_nama, daftar_email, daftar_username, daftar_password, daftar_password2);
            } else {
            Toast.makeText(getApplicationContext(),
                  "Please enter your details!", Toast.LENGTH_LONG)
                   .show();
                }
            }
        });
    }
    private void registerUser(final String daftar_nama, final String daftar_email, final String daftar_username,
                              final String daftar_password, final String daftar_password2) {
        //Tag used to cancel the request
        String tag_string_req = "req_register";

        progress.setMessage("Registering ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST,
                AppConfig.URL_REGISTER, new Response.Listener<String>() {
            @Override
           public void onResponse(String response) {
                Log.d(TAG, "Register Response: " + response.toString());
                hideDialog();

                try {
                    Log.i("tagconvertstr", "["+response+"]");
                 JSONObject jObj = new JSONObject(response);
                    boolean error = jObj.getBoolean("error");
                    if (!error) {
                        // User successfully stored in MySQL
                        // Now store the user in sqlite
                        //String uid = jObj.getString("uid");

                        JSONObject login = jObj.getJSONObject("login");
                        String login_username = login.getString("login_username");
                        String login_password = login.getString("login_password");

// Inserting row in users table


                        Toast.makeText(getApplicationContext(), "User successfully registered. Try login now!", Toast.LENGTH_LONG).show();

                        // Launch login activity
                        Intent intent = new Intent(
                                Signup.this,
                                Login.class);
                        startActivity(intent);
                        finish();
                    }else {

                        // Error occurred in registration. Get the error
                        // message
                     String errorMsg = jObj.getString("error_msg");
                      Toast.makeText(getApplicationContext(),
                               errorMsg, Toast.LENGTH_LONG).show();
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Registration Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();
                hideDialog();
            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting params to register url
                Map<String, String> params = new HashMap<String, String>();
                params.put("daftar_nama", daftar_nama);
                params.put("daftar_email", daftar_email);
                params.put("daftar_username", daftar_username);
                params.put("daftar_password", daftar_password);
                params.put("daftar_password2", daftar_password2);

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
    }

    private void showDialog() {
        if (!progress.isShowing())
            progress.show();
    }

    private void hideDialog() {
        if (progress.isShowing())
            progress.dismiss();
    }
            }


    }

    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     * */



