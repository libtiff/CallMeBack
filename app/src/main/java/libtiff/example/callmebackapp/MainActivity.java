package libtiff.example.callmebackapp;

import android.Manifest;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import org.w3c.dom.Text;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity implements AlertDialogRadio.AlertPositiveListener {
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    private TextView txtload,txtcarriercode,txtcarrier;

    ImageButton Contacts;
    String Hashtag = Uri.encode("#");
    String code;
    int endhash;
    EditText phonenum;
    int position = 0;
    ImageButton send;
    String temp = "";

    // Storage Permissions
    private static final int REQUEST_CALL_PHONE = 1;
    private static final int REQUEST_READ_CONTACTS= 1;
    private static final int REQUEST_INTERNET= 1;
    private static final int REQUEST_ACCESS_NETWORK_STATE= 1;

    private static String[] PERMISSIONS_APP= {
            Manifest.permission.CALL_PHONE,Manifest.permission.READ_CONTACTS,Manifest.permission.INTERNET,Manifest.permission.ACCESS_NETWORK_STATE
    };

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
        this.txtload= (TextView) findViewById(R.id.txtload);
        this.txtcarriercode = (TextView) findViewById(R.id.txtcarriercode);
        this.txtcarrier=(TextView) findViewById(R.id.txtcarrier);
        String tempval = loadcarrier();


        txtcarrier.setText(SIMOP());

        if (tempval != null) {
            txtload.setText("✅");
            txtcarriercode.setText(tempval);
        }
        else {
            txtload.setText("❌");
            txtcarriercode.setText("-");
        }
        MobileAds.initialize(this,"ca-app-pub-9082725429338291~9699329161");

        ////////////////////////Banner
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        //InterAds
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-9082725429338291/4148172654");
        interstitialAd.loadAd(new AdRequest.Builder().build());

        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed()
            {
                //startActivity(new Intent(MainActivity.this,MainActivity.class));
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        ///////////////////////////////////////////////////////////////////////////////
        ((ImageButton) findViewById(R.id.btn_choose)).setOnClickListener(new C07071());
        verifyStoragePermissions(MainActivity.this);
    }

    public void intAd(){
        if (interstitialAd.isLoaded())
        {
            interstitialAd.show();
        }
    }

    public static void verifyStoragePermissions(Activity activity)
    {
        // Check if we have write permission
        int callpermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
        int contactspermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_CONTACTS);
        int netstatepermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_NETWORK_STATE);
        int internetpermission = ActivityCompat.checkSelfPermission(activity,Manifest.permission.INTERNET);

        if (callpermission != PackageManager.PERMISSION_GRANTED)
        {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS_APP, REQUEST_CALL_PHONE);
        }
        else if (contactspermission!=PackageManager.PERMISSION_GRANTED)
        {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS_APP, REQUEST_READ_CONTACTS);
        }
        else if (netstatepermission!=PackageManager.PERMISSION_GRANTED)
        {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS_APP, REQUEST_ACCESS_NETWORK_STATE);
        }
        else if (internetpermission!=PackageManager.PERMISSION_GRANTED)
        {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity,PERMISSIONS_APP, REQUEST_INTERNET);
        }
        Toast.makeText(activity, "Done. 0", Toast.LENGTH_SHORT).show();
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
//AIRTEL
            case 2:
                this.code = null;
                this.code = "*121*5";
                this.endhash = 1;
                break;
//BANGLALINK
            case 3:
                this.code = null;
                this.code = "*126*";
                this.endhash = 1;
                break;
//GRAMEENPHONE
            case 4:
                this.code = null;
                this.code = "*123*";
                this.endhash = 1;
                break;
//TELENOR
            case 5:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//LIFE BELARUS
            case 6:
                this.code = null;
                this.code = "*120*2*";
                this.endhash = 1;
                break;
//PROXIMUS
            case 7:
                this.code = null;
                this.code = this.Hashtag + "111*";
                this.endhash = 1;
                break;
//DIGICELL
            case 8:
                this.code = null;
                this.code = "*126*";
                this.endhash = 1;
                break;
//ORANGE CAMEROON
            case 9:
                this.code = null;
                this.code = this.Hashtag + "146*";
                this.endhash = 1;
                break;
//CALLSAT
            case 10:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//CYTA
            case 11:
                this.code = null;
                this.code = this.Hashtag + "120" + this.Hashtag;
                this.endhash = 0;
                break;
//MTN
            case 12:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//PRIMETEL CYPRUS
            case 13:
                this.code = null;
                this.code = "*130*";
                this.endhash = 1;
                break;
//TATA DOCOMO DOCOMO
            case 14:
                this.code = null;
                this.code = "*678*";
                this.endhash = 1;
                break;
//ETISALAT
            case 15:
                this.code = null;
                this.code = "*266*1*";
                this.endhash = 1;
                break;
//VODAFONE CU
            case 16:
                this.code = null;
                this.code = this.Hashtag;
                this.endhash = 0;
                break;
//AIRTEL INDIA
            case 17:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//AIRCEL INDIA
            case 18:
                this.code = null;
                this.code = "*243*10#";
                this.endhash = 0;
                break;
//VODAFONE INDIA
            case 19:
                this.code = null;
                this.code = "*131*";
                this.endhash = 1;
                break;
//KOREKTEL IRAQ
            case 20:
                this.code = null;
                this.code = "*213*";
                this.endhash = 1;
                break;
//FLOW JAMAICA
            case 21:
                this.code = null;
                this.code = "*126*";
                this.endhash = 1;
                break;
//ZAIN JORDAN
            case 22:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//SAFARICOM KENYA
            case 23:
                this.code = null;
                this.code = "*130*";
                this.endhash = 1;
                break;
//YUMobile KENYA
            case 24:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//MALDIVES
            case 25:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//TMOBILE
            case 26:
                this.code = null;
                this.code = "*345*";
                this.endhash = 1;
                break;
//SKINNY MOBILE NEW ZEALAND
            case 27:
                this.code = null;
                this.code = "*888*8*3*";
                this.endhash = 1;
                break;
//AIRTEL NIGERIA
            case 28:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//ETILASAT NIGERIA
            case 29:
                this.code = null;
                this.code = "*266*1*";
                this.endhash = 1;
                break;
//MTN NIGERIA
            case 30:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//GLO NIGERIA
            case 31:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//FRIENDIMOBILE OMAN
            case 32:
                this.code = null;
                this.code = "*104*";
                this.endhash = 1;
                break;
//RENNA MOBILE OMAN
            case 33:
                this.code = null;
                this.code = "*181*42*";
                this.endhash = 1;
                break;
//JAZZ PAKISTAN
            case 34:
                this.code = null;
                this.code = "*131*1"+this.Hashtag;
                this.endhash = 1;
                break;
//TELENOR PAKISTAN
            case 35:
                this.code = null;
                this.code = "*11"+this.Hashtag+"03";
                this.endhash = 1;
                break;
//ZONG PAKISTAN
            case 36:
                this.code = null;
                this.code = "*100*";
                this.endhash = 1;
                break;
//MOBILE VIKINGS POLAND
            case 37:
                this.code = null;
                this.code = "*120*";
                this.endhash = 1;
                break;
//OOREDOO QATAR
            case 38:
                this.code = null;
                this.code = "*103*";
                this.endhash = 1;
                break;
//VODAFONE ROMANIA
            case 39:
                this.code = null;
                this.code = "*120*" + this.Hashtag + "2" + this.Hashtag;
                this.endhash = 1;
                break;
//BEELINE
            case 40:
                this.code = null;
                this.code = "*9119*";
                this.endhash = 1;
                break;
//ROSTELECOM
            case 41:
                this.code = null;
                this.code = "*135*";
                this.endhash = 1;
                break;
//MTN SOUTH AFRICA
            case 42:
                this.code = null;
                this.code = "*121*";
                this.endhash = 1;
                break;
//TRUTEQ SOUTH AFRICA
            case 43:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//CELLC SOUTH AFRICA
            case 44:
                this.code = null;
                this.code = "*111*";
                this.endhash = 1;
                break;
//TELEKOM SOUTH AFRICA
            case 45:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//VODACOM SOUTH AFRICA
            case 46:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//VIRGIN MOBILE SOUTH AFRICA
            case 47:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//MOBITEL SRI LANKA
            case 48:
                this.code = null;
                this.code = this.Hashtag + "359*";
                this.endhash = 1;
                break;
//DIALOG SRI LANKA
            case 49:
                this.code = null;
                this.code = this.Hashtag + "356*";
                this.endhash = 1;
                break;
//AIS THAILAND
            case 50:
                this.code = null;
                this.code = "*222*";
                this.endhash = 1;
                break;
//DTAC HAPPY THAILAND
            case 51:
                this.code = null;
                this.code = "*114*";
                this.endhash = 1;
                break;
//TRUECORP THAILAND
            case 52:
                this.code = null;
                this.code = "*922*1*";
                this.endhash = 1;
                break;
//ORANGE UGANDA
            case 53:
                this.code = null;
                this.code = "*100*2*";
                this.endhash = 1;
                break;
//MTS
            case 54:
                this.code = null;
                this.code = "*104*";
                this.endhash = 1;
                break;
//GLOBUL
            case 55:
                this.code = null;
                this.code = "*133*";
                this.endhash = 1;
                break;
//VIRGIN MOBILE (USA)
            case 56:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//TELEKOM (USA)
            case 57:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
//UCELL UZBEKISTAN
            case 58:
                this.code = null;
                this.code = "*125*";
                this.endhash = 1;
                break;
//ECONET ZIMBABWE
            case 59:
                this.code = null;
                this.code = "*555*";
                this.endhash = 1;
                break;
//NETONE ZIMBABWE
            case 60:
                this.code = null;
                this.code = "*134" + this.Hashtag + "7";
                this.endhash = 1;
                break;
//TELECEL ZIMBABWE
            case 61:
                this.code = null;
                this.code = "*140*";
                this.endhash = 1;
                break;
        }
        writeToFile();
        txtcarriercode.setText(this.code);
    }

    private void writeToFile() {
        try {
            OutputStreamWriter outputWriter = new OutputStreamWriter(openFileOutput("cmbconfig.txt", 0));
            outputWriter.write(this.code);
            outputWriter.close();
            Toast.makeText(getBaseContext(), "Network Carrier selected and saved.", Toast.LENGTH_SHORT).show();
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

    public void send(View v)
    {
        this.temp = this.phonenum.getText().toString();
        if (this.temp.equals("")) {
            Toast.makeText(getBaseContext(), "ERROR: The recipients mobile number is empty.", Toast.LENGTH_SHORT).show();
            intAd();
            return;
        }
       //
        this.code=loadcarrier();
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
        Toast.makeText(getBaseContext(), "Your message has been sent successfully.", Toast.LENGTH_SHORT).show();
        intAd();
        this.phonenum.setText("");
    }

    public String loadcarrier()
    {
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

        return code;
    }

    public String SIMOP()
    {
        TelephonyManager manager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String carrierName = manager.getSimOperatorName();

        if (carrierName == null)
                carrierName="-";

        return carrierName;
    }
}
