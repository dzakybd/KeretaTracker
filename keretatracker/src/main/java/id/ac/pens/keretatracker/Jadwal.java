package id.ac.pens.keretatracker;

/**
 * Created by Dini on 27/04/2017.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jadwal extends AppCompatActivity {
    private TextView Stasiunya, datangnya, berangkatnya;
    private TextView Surabaya1, Surabayadt1, Surabayabr1;
    private TextView Surabaya2, Surabayadt2, Surabayabr2;
    private TextView Surabaya3, Surabayadt3, Surabayabr3;
    private TextView Sidoarjo1, Sidoarjodt1, Sidoarjobr1;
    private TextView Sidoarjo2, Sidoarjodt2, Sidoarjobr2;
    private TextView Sidoarjo3, Sidoarjodt3, Sidoarjobr3;
    private TextView Mojokerto, Mojokertodt, Mojokertobr;
    private TextView Jombang1, Jombangdt1, Jombangbr1;
    private TextView Jombang2, Jombangdt2, Jombangbr2;
    private TextView Jombang3, Jombangdt3, Jombangbr3;
    private TextView Jombang4, Jombangdt4, Jombangbr4;
    private TextView Sembung, Sembungdt, Sembungbr;
    private TextView Kertosono, Kertosonodt, Kertosonobr;
    private TextView Kediri1, Kediridt1, Kediribr1;
    private TextView Kediri2, Kediridt2, Kediribr2;
    private TextView Kediri3, Kediridt3, Kediribr3;
    private TextView Kediri4, Kediridt4, Kediribr4;
    private TextView Tulungagung1, Tulungagungdt1, Tulungagungbr1;
    private TextView Tulungagung2, Tulungagungdt2, Tulungagungbr2;
    private TextView Tulungagung3, Tulungagungdt3, Tulungagungbr3;
    private TextView Tulungagung4, Tulungagungdt4, Tulungagungbr4;
    private TextView Blitar, Blitardt, Blitarbr;

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jadwal_kereta);
        Stasiunya = (TextView) findViewById(R.id.stasiun);
        datangnya = (TextView) findViewById(R.id.datang);
        berangkatnya = (TextView) findViewById(R.id.berangkat);
        Surabaya1 = (TextView) findViewById(R.id.sbykt);
        Surabayadt1 = (TextView) findViewById(R.id.sbyktdt);
        Surabayabr1 = (TextView) findViewById(R.id.sbyktbr);
        Surabaya2 = (TextView) findViewById(R.id.sbygb);
        Surabayadt2 = (TextView)findViewById(R.id.sbygbdt);
        Surabayabr2 = (TextView)findViewById(R.id.sbygbbr);
        Surabaya3 = (TextView)findViewById(R.id.sbywn);
        Surabayadt3 = (TextView)findViewById(R.id.sbywndt);
        Surabayabr3 = (TextView)findViewById(R.id.sbywnbr);
        Sidoarjo1 = (TextView)findViewById(R.id.sdrspj);
        Sidoarjodt1 = (TextView)findViewById(R.id.sdrspjdt);
        Sidoarjobr1 = (TextView)findViewById(R.id.sdrspjbr);
        Sidoarjo2 = (TextView)findViewById(R.id.sdrkr);
        Sidoarjodt2 = (TextView)findViewById(R.id.sdrkrdt);
        Sidoarjobr2 = (TextView)findViewById(R.id.sdrkrbr);
        Sidoarjo3 = (TextView)findViewById(R.id.sdrtr);
        Sidoarjodt3 = (TextView)findViewById(R.id.sdrtrdt);
        Sidoarjobr3 = (TextView)findViewById(R.id.sdrtrbr);
        Mojokerto = (TextView)findViewById(R.id.mjkt);
        Mojokertodt = (TextView)findViewById(R.id.mjktdt);
        Mojokertobr = (TextView)findViewById(R.id.mjktbr);
        Jombang1 = (TextView)findViewById(R.id.jbgcr);
        Jombangdt1 = (TextView)findViewById(R.id.jbgcrdt);
        Jombangbr1 = (TextView)findViewById(R.id.jbgcrbr);
        Jombang2 = (TextView)findViewById(R.id.jbgsm);
        Jombangdt2 = (TextView)findViewById(R.id.jbgsmdt);
        Jombangbr2 = (TextView)findViewById(R.id.jbgsmbr);
        Jombang3 = (TextView)findViewById(R.id.jbgpt);
        Jombangdt3 = (TextView)findViewById(R.id.jbgptdt);
        Jombangbr3 = (TextView)findViewById(R.id.jbgptbr);
        Jombang4 = (TextView)findViewById(R.id.jbg);
        Jombangdt4 = (TextView)findViewById(R.id.jbgdt);
        Jombangbr4 = (TextView)findViewById(R.id.jbgbr);
        Sembung = (TextView)findViewById(R.id.sbg);
        Sembungdt = (TextView)findViewById(R.id.sbgdt);
        Sembungbr = (TextView)findViewById(R.id.sbgbr);
        Kertosono = (TextView)findViewById(R.id.krtsn);
        Kertosonodt = (TextView)findViewById(R.id.krtsndt);
        Kertosonobr = (TextView)findViewById(R.id.krtsnbr);
        Kediri1 = (TextView)findViewById(R.id.kdrppr);
        Kediridt1 = (TextView)findViewById(R.id.kdrpprdt);
        Kediribr1 = (TextView)findViewById(R.id.kdrpprbr);
        Kediri2 = (TextView)findViewById(R.id.kdr);
        Kediridt2 = (TextView)findViewById(R.id.kdrdt);
        Kediribr2 = (TextView)findViewById(R.id.kdrbr);
        Kediri3 = (TextView)findViewById(R.id.kdrngadi);
        Kediridt3 = (TextView)findViewById(R.id.kdrngadidt);
        Kediribr3 = (TextView)findViewById(R.id.kdrngadibr);
        Kediri4 = (TextView)findViewById(R.id.kdrkras);
        Kediridt4 = (TextView)findViewById(R.id.kdrkrasdt);
        Kediribr4 = (TextView)findViewById(R.id.kdrkrasbr);
        Tulungagung1 = (TextView)findViewById(R.id.tlg);
        Tulungagungdt1 = (TextView)findViewById(R.id.tlgdt);
        Tulungagungbr1 = (TextView)findViewById(R.id.tlgbr);
        Tulungagung2 = (TextView)findViewById(R.id.tlgsb);
        Tulungagungdt2 = (TextView)findViewById(R.id.tlgsbdt);
        Tulungagungbr2 = (TextView)findViewById(R.id.tlgsbbr);
        Tulungagung3 = (TextView)findViewById(R.id.tlgng);
        Tulungagungdt3 = (TextView)findViewById(R.id.tlgngdt);
        Tulungagungbr3 = (TextView)findViewById(R.id.tlgngbr);
        Tulungagung4 = (TextView)findViewById(R.id.tlgrejo);
        Tulungagungdt4 = (TextView)findViewById(R.id.tlgrejodt);
        Tulungagungbr4 = (TextView)findViewById(R.id.tlgrejobr);
        Blitar = (TextView)findViewById(R.id.bltr);
        Blitardt = (TextView)findViewById(R.id.bltrdt);
        Blitarbr = (TextView)findViewById(R.id.bltrbr);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}
