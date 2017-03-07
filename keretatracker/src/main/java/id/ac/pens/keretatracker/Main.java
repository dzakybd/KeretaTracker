package id.ac.pens.keretatracker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Main extends AppCompatActivity {
    private DatePickerDialog datepicker;
    private EditText kedatangan,kereta,tujuan;
    private SimpleDateFormat dateFormatter;
    private Button button;
    private AlertDialog dialog,alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tujuan = (EditText) findViewById(R.id.tracker_tujuan);
        kereta = (EditText) findViewById(R.id.tracker_nama);
        kedatangan = (EditText) findViewById(R.id.tracker_kedatangan);
        button = (Button) findViewById(R.id.tracker_button);
        kedatangan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datepicker.show();
            }
        });

        Calendar newCalendar = Calendar.getInstance();
        datepicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                kedatangan.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                attempttrack();
            }
        });
    }

    private void attempttrack() {
        AlertDialog.Builder result = new AlertDialog.Builder(this);
        View alertview = getLayoutInflater().inflate(R.layout.track_result,null);
        TextView t_kereta = (TextView) alertview.findViewById(R.id.kereta);
        TextView t_tujuan = (TextView) alertview.findViewById(R.id.tujuan);
        TextView t_waktu = (TextView) alertview.findViewById(R.id.waktu);
        TextView t_posisi = (TextView) alertview.findViewById(R.id.posisi);
        TextView t_answer = (TextView) alertview.findViewById(R.id.answer);
        Button ok = (Button) alertview.findViewById(R.id.ok);
        result.setView(alertview);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog=result.create();
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.out) {
            AlertDialog.Builder pilihan = new AlertDialog.Builder(this);
            pilihan.setMessage("Anda ingin keluar?");
            pilihan.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    new Prefs.Builder()
                            .setContext(getApplicationContext())
                            .setMode(ContextWrapper.MODE_PRIVATE)
                            .setPrefsName(getPackageName())
                            .setUseDefaultSharedPreference(true)
                            .build();
                    Prefs.putString("iduser","");
                    startActivity(new Intent(Main.this, Login.class));
                    finish();
                }
            });
            pilihan.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            alert = pilihan.create();
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
