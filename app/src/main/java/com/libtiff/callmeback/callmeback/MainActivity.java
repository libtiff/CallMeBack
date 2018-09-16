package com.libtiff.callmeback.callmeback;

import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
//import com.google.android.gms.ads.AdRequest.Builder;
//import com.google.android.gms.ads.AdView;
import com.libtiff.callmeback.callmeback.AlertDialogRadio;
import com.libtiff.callmeback.callmeback.MainActivity;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity implements AlertDialogRadio.AlertPositiveListener {
    ImageButton Contacts;
    String Hashtag = Uri.encode("#");
    String code;
    int endhash;
    EditText phonenum;
    int position = 0;
    ImageButton send;
    String temp = "";

    class C07071 implements OnClickListener
    {
        C07071() {
        }

        public void onClick(View v) {
            FragmentManager manager = MainActivity.this.getFragmentManager();
            AlertDialogRadio alert = new AlertDialogRadio();
            Bundle b = new Bundle();
            b.putInt("position", MainActivity.this.position);
            alert.setArguments(b);
            alert.show(manager, "alert_dialog_radio");
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        this.Contacts = (ImageButton) findViewById(R.id.btnContacts);
        this.send = (ImageButton) findViewById(R.id.btnSend);
        this.phonenum = (EditText) findViewById(R.id.phoneNumber);
        //((AdView) findViewById(R.id.adView)).loadAd(new Uri.Builder().build());
        ((ImageButton) findViewById(R.id.btn_choose)).setColorFilter(Color.argb(150, 155, 155, 155));
        ((ImageButton) findViewById(R.id.btn_choose)).setOnClickListener(new C07071());
    }
    public void onPositiveClick(int position) {
        this.position = position;
        switch (position) {

//VODAFONE ALBANIA
            case 0:
                this.code = null;
                this.code = this.Hashtag + "123" + this.Hashtag + "2" + this.Hashtag;
                this.endhash = 1;
                break;
//TELSTRA
            case 1:
                this.code = null;
                this.code = this.Hashtag + "125" + this.Hashtag + "5" + this.Hashtag;
                this.endhash = 1;
                break;
//LIFE BELARUS
            case 2:
                this.code = null;
                this.code = "*120*2*";
                this.endhash = 1;
                break;
//PROXIMUS
            case 3:
                this.code = null;
                this.code = this.Hashtag + "111*";
                this.endhash = 1;
                break;
//DIGICELL
            case 4:
                this.code = null;
                this.code = "*126*";
                this.endhash = 1;
                break;
//ORANGE CAMEROON
            case 5:
                this.code = null;
                this.code = this.Hashtag + "146*";
                this.endhash = 1;
                break;
//CALLSAT
            case 6:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//CYTA
            case 7:
                this.code = null;
                this.code = this.Hashtag + "120" + this.Hashtag;
                this.endhash = 0;
                break;
//MTN
            case 8:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//PRIMETEL CYPRUS
            case 9:
                this.code = null;
                this.code = "*130*";
                this.endhash = 1;
                break;
//TATA DOCOMO DOCOMO
            case 10:
                this.code = null;
                this.code = "*678*";
                this.endhash = 1;
                break;
//ETISALAT
            case 11:
                this.code = null;
                this.code = "*266*1*";
                this.endhash = 1;
                break;
//VODAFONE CU
            case 12:
                this.code = null;
                this.code = this.Hashtag;
                this.endhash = 0;
                break;
//KOREKTEL IRAQ
            case 13:
                this.code = null;
                this.code = "*213*";
                this.endhash = 1;
                break;
//AIRTEL INDIA
            case 14:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//FLOW JAMAICA
            case 15:
                this.code = null;
                this.code = "*126*";
                this.endhash = 1;
                break;
//ZAIN JORDAN
            case 16:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//SAFARICOM KENYA
            case 17:
                this.code = null;
                this.code = "*130*";
                this.endhash = 1;
                break;
//YUMobile KENYA
            case 18:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//TMOBILE
            case 19:
                this.code = null;
                this.code = "*345*";
                this.endhash = 1;
                break;
//SKINNY MOBILE NEW ZEALAND
            case 20:
                this.code = null;
                this.code = "*888*8*3*";
                this.endhash = 1;
                break;
//AIRTEL NIGERIA
            case 21:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//ETILASAT NIGERIA
            case 22:
                this.code = null;
                this.code = "*266*1*";
                this.endhash = 1;
                break;
//MTN NIGERIA
            case 23:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//GLO NIGERIA
            case 24:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//FRIENDIMOBILE OMAN
            case 25:
                this.code = null;
                this.code = "*104*";
                this.endhash = 1;
                break;
//RENNA MOBILE OMAN
            case 26:
                this.code = null;
                this.code = "*181*42*";
                this.endhash = 1;
                break;
//MOBILE VIKINGS POLAND
            case 27:
                this.code = null;
                this.code = "*120*";
                this.endhash = 1;
                break;
//OOREDOO QATAR
            case 28:
                this.code = null;
                this.code = "*103*";
                this.endhash = 1;
                break;
//VODAFONE ROMANIA
            case 29:
                this.code = null;
                this.code = "*120*" + this.Hashtag + "2" + this.Hashtag;
                this.endhash = 1;
                break;
//BEELINE
            case 30:
                this.code = null;
                this.code = "*9119*";
                this.endhash = 1;
                break;
//ROSTELECOM
            case 31:
                this.code = null;
                this.code = "*135*";
                this.endhash = 1;
                break;
//MTN SOUTH AFRICA
            case 32:
                this.code = null;
                this.code = "*121*";
                this.endhash = 1;
                break;
//TRUTEQ SOUTH AFRICA
            case 33:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//CELLC SOUTH AFRICA
            case 34:
                this.code = null;
                this.code = "*111*";
                this.endhash = 1;
                break;
//TELEKOM SOUTH AFRICA
            case 35:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//VODACOM SOUTH AFRICA
            case 36:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//VIRGIN MOBILE SOUTH AFRICA
            case 37:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//MOBITEL SRI LANKA
            case 38:
                this.code = null;
                this.code = this.Hashtag + "359*";
                this.endhash = 1;
                break;
//DIALOG SRI LANKA
            case 39:
                this.code = null;
                this.code = this.Hashtag + "356*";
                this.endhash = 1;
                break;
//AIS THAILAND
            case 40:
                this.code = null;
                this.code = "*222*";
                this.endhash = 1;
                break;
//DTAC HAPPY THAILAND
            case 41:
                this.code = null;
                this.code = "*114*";
                this.endhash = 1;
                break;
//TRUECORP THAILAND
            case 42:
                this.code = null;
                this.code = "*922*1*";
                this.endhash = 1;
                break;
//ORANGE UGANDA
            case 43:
                this.code = null;
                this.code = "*100*2*";
                this.endhash = 1;
                break;
//MTS
            case 44:
                this.code = null;
                this.code = "*104*";
                this.endhash = 1;
                break;
//GLOBUL
            case 45:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//VIRGIN MOBILE (USA)
            case 46:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//TELEKOM (USA)
            case 47:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//UCELL UZBEKISTAN
            case 48:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//ECONET ZIMBABWE
            case 49:
                this.code = null;
                this.code = "*555*";
                this.endhash = 1;
                break;
//NETONE ZIMBABWE
            case 50:
                this.code = null;
                this.code = "*134" + this.Hashtag + "7";
                this.endhash = 1;
                break;
//TELECEL ZIMBABWE
            case 51:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
        }
        writeToFile();
    }

    private void writeToFile() {
        try {
            OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("cmbconfig.txt", 0));
            outputWriter.write(this.code);
            outputWriter.close();
            Toast.makeText(getBaseContext(), "Network Carrier selected and saved.", 0).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Contacts(View arg0) {
        Intent pickContactIntent = new Intent("android.intent.action.PICK", Uri.parse("content://contacts"));
        pickContactIntent.setType("vnd.android.cursor.dir/phone_v2");
        startActivityForResult(pickContactIntent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == -1) {
            Cursor cursor = getContentResolver().query(data.getData(), new String[]{"data1"}, null, null, null);
            cursor.moveToFirst();
            this.phonenum.setText(cursor.getString(cursor.getColumnIndex("data1")));
            cursor.close();
        }
    }

    public void send(View v) {
        this.temp = this.phonenum.getText().toString();
        if (this.temp.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR: The recipients mobile number is empty.", 0).show();
            return;
        }
        try {
            InputStreamReader InputRead = new InputStreamReader(openFileInput("cmbconfig.txt"));
            char[] inputBuffer = new char[10];
            String s = "";
            while (true) {
                int charRead = InputRead.read(inputBuffer);
                if (charRead <= 0) {
                    break;
                }
                s = s + String.copyValueOf(inputBuffer, 0, charRead);
            }
            InputRead.close();
            this.code = s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent callIntent = new Intent("android.intent.action.CALL");
        if (this.code.equals("%23120%23") || this.code.equals("%23")) {
            this.endhash = 0;
            callIntent.setData(Uri.parse("tel:" + this.code + this.temp));
            startActivity(callIntent);
        } else {
            this.endhash = 1;
            callIntent.setData(Uri.parse("tel:" + this.code + this.temp + this.Hashtag));
            startActivity(callIntent);
        }
        this.phonenum.setText("");
    }
}
