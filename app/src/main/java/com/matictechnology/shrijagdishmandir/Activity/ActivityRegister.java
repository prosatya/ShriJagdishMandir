package com.matictechnology.shrijagdishmandir.Activity;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.matictechnology.shrijagdishmandir.R;
import com.matictechnology.shrijagdishmandir.Utility.DbHelper;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityRegister extends AppCompatActivity implements View.OnClickListener
{
    EditText reg_name,reg_email,reg_pass,reg_cpass,reg_village,reg_tehsil,reg_dist,reg_mob;
    Button reg;
    Spinner reg_blood,reg_gotra;
    CoordinatorLayout l;
    ArrayList<String> gotra_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        l=(CoordinatorLayout)findViewById(R.id.l);
        reg_name=(EditText)findViewById(R.id.reg_name);
        reg_email=(EditText)findViewById(R.id.reg_email);
        reg_pass=(EditText)findViewById(R.id.reg_pass);
        reg_cpass=(EditText)findViewById(R.id.reg_cpass);
        reg_blood=(Spinner)findViewById(R.id.reg_blood);
        reg_village=(EditText)findViewById(R.id.reg_village);
        reg_tehsil=(EditText)findViewById(R.id.reg_tehsil);
        reg_dist=(EditText)findViewById(R.id.reg_dist);
        reg_gotra=(Spinner)findViewById(R.id.reg_gotra);
        reg_mob=(EditText)findViewById(R.id.reg_mob);
        reg=(Button)findViewById(R.id.reg);

        reg.setOnClickListener(this);

        ArrayList<String> blood_list=new ArrayList<String>();
        blood_list.add("Select Blood Group");
        blood_list.add("A +ve");
        blood_list.add("A -ve");
        blood_list.add("B +ve");
        blood_list.add("B -ve");

        blood_list.add("AB +ve");
        blood_list.add("AB -ve");
        blood_list.add("O +ve");
        blood_list.add("O -ve");

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ActivityRegister.this,R.layout.support_simple_spinner_dropdown_item,blood_list);
        reg_blood.setAdapter(adapter);


        gotra_list=new ArrayList<String>();
        setGotra();

        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(ActivityRegister.this,R.layout.support_simple_spinner_dropdown_item,gotra_list);
        reg_gotra.setAdapter(adapter1);


    }

    @Override
    protected void onStart()
    {
        super.onStart();
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.reg)
        {
            Pattern p = Pattern.compile("[^A-Za-z' ']");
            Pattern p1 = Pattern.compile("[^0-9]");

            Matcher m_mob = p1.matcher(reg_mob.getText().toString());
            boolean b_mob = m_mob.find();

            Matcher m_name = p.matcher(reg_name.getText().toString());
            boolean b_name = m_name.find();

            Matcher m_vill = p.matcher(reg_village.getText().toString());
            boolean b_vill = m_vill.find();

            Matcher m_tehsil = p.matcher(reg_tehsil.getText().toString());
            boolean b_tehsil = m_tehsil.find();

            Matcher m_dist = p.matcher(reg_dist.getText().toString());
            boolean b_dist = m_dist.find();

            Matcher m_gotra = p.matcher(reg_gotra.getSelectedItem().toString());
            boolean b_gotra = m_gotra.find();

            DbHelper dbhelper = new DbHelper(ActivityRegister.this);
            SQLiteDatabase db = dbhelper.getWritableDatabase();

            if (reg_name.getText().toString().equals("") || reg_name == null)
            {
                reg_name.requestFocus();
                Toast.makeText(ActivityRegister.this, "Name is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_name.getText().toString().contains("0") || reg_name.getText().toString().contains("1") || reg_name.getText().toString().contains("2") || reg_name.getText().toString().contains("3") || reg_name.getText().toString().contains("4") || reg_name.getText().toString().contains("5") || reg_name.getText().toString().contains("6") || reg_name.getText().toString().contains("7") || reg_name.getText().toString().contains("8") || reg_name.getText().toString().contains("9"))
            {
                reg_name.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Name!", Toast.LENGTH_LONG).show();
            }
            else if (b_name)
            {
                reg_name.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Name!", Toast.LENGTH_LONG).show();
            }
            else if (!reg_email.getText().toString().contains("@") || !reg_email.getText().toString().contains("."))
            {
                reg_email.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Email Id!", Toast.LENGTH_LONG).show();
            }
            else if (reg_pass.getText().toString().equals("") || reg_pass == null)
            {
                reg_pass.requestFocus();
                Toast.makeText(ActivityRegister.this, "Password is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_cpass.getText().toString().equals("") || reg_cpass == null)
            {
                reg_cpass.requestFocus();
                Toast.makeText(ActivityRegister.this, "Confirming password is Required!", Toast.LENGTH_LONG).show();
            }
            else if (!reg_cpass.getText().toString().equals(reg_pass.getText().toString()))
            {
                reg_pass.requestFocus();
                Toast.makeText(ActivityRegister.this, "both passwords should match!", Toast.LENGTH_LONG).show();
            }
            else if (reg_village.getText().toString().equals("") || reg_village == null)
            {
                reg_village.requestFocus();
                Toast.makeText(ActivityRegister.this, "village name is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_village.getText().toString().contains("0") || reg_village.getText().toString().contains("1") || reg_village.getText().toString().contains("2") || reg_village.getText().toString().contains("3") || reg_village.getText().toString().contains("4") || reg_village.getText().toString().contains("5") || reg_village.getText().toString().contains("6") || reg_village.getText().toString().contains("7") || reg_village.getText().toString().contains("8") || reg_village.getText().toString().contains("9"))
            {
                reg_village.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Village name!", Toast.LENGTH_LONG).show();
            }
            else if (b_vill)
            {
                reg_village.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Village name!", Toast.LENGTH_LONG).show();
            }
            else if (reg_tehsil.getText().toString().equals("") || reg_tehsil == null)
            {
                reg_tehsil.requestFocus();
                Toast.makeText(ActivityRegister.this, "Tehsil Name is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_tehsil.getText().toString().contains("0") || reg_tehsil.getText().toString().contains("1") || reg_tehsil.getText().toString().contains("2") || reg_tehsil.getText().toString().contains("3") || reg_tehsil.getText().toString().contains("4") || reg_tehsil.getText().toString().contains("5") || reg_tehsil.getText().toString().contains("6") || reg_tehsil.getText().toString().contains("7") || reg_tehsil.getText().toString().contains("8") || reg_tehsil.getText().toString().contains("9"))
            {
                reg_tehsil.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Tehsil name!", Toast.LENGTH_LONG).show();
            }
            else if (b_tehsil)
            {
                reg_tehsil.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Tehsil name!", Toast.LENGTH_LONG).show();
            }
            else if (reg_dist.getText().toString().equals("") || reg_dist == null)
            {
                reg_dist.requestFocus();
                Toast.makeText(ActivityRegister.this, "District Name is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_dist.getText().toString().contains("0") || reg_dist.getText().toString().contains("1") || reg_dist.getText().toString().contains("2") || reg_dist.getText().toString().contains("3") || reg_dist.getText().toString().contains("4") || reg_dist.getText().toString().contains("5") || reg_dist.getText().toString().contains("6") || reg_dist.getText().toString().contains("7") || reg_dist.getText().toString().contains("8") || reg_dist.getText().toString().contains("9"))
            {
                reg_dist.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid District name!", Toast.LENGTH_LONG).show();
            }
            else if (b_dist)
            {
                reg_dist.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid District name!", Toast.LENGTH_LONG).show();
            }
            else if (reg_gotra.getSelectedItem().toString().equals("Select Gotra") || reg_gotra == null)
            {
                reg_gotra.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid Gotra name!", Toast.LENGTH_LONG).show();
            }
            else if (reg_mob.getText().toString().equals("") || reg_mob == null)
            {
                reg_mob.requestFocus();
                Toast.makeText(ActivityRegister.this, "Mobile number is a Required field!", Toast.LENGTH_LONG).show();
            }
            else if (reg_mob.getText().toString().length() != 10)
            {
                reg_mob.requestFocus();
                Toast.makeText(ActivityRegister.this, "enter a valid Mobile number!", Toast.LENGTH_LONG).show();
            }
            else if (b_mob)
            {
                reg_mob.requestFocus();
                Toast.makeText(ActivityRegister.this, "Enter a Valid mobile number!", Toast.LENGTH_LONG).show();
            }
            else if (reg_blood.getSelectedItem().toString().equals("Select Blood Group"))
            {
                reg_blood.requestFocus();
                Toast.makeText(ActivityRegister.this, "Please select a valid Blood Group!", Toast.LENGTH_LONG).show();
            }
            else
            {
                if (dbhelper.checkLogin(db, reg_email.getText().toString())) {/*
                    LayoutInflater inflater = (LayoutInflater) ActivityRegister.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    View itemView_select = inflater.inflate(R.layout.dialog_msg_confiramtion, null);

                    final EditText otp = (EditText) itemView_select.findViewById(R.id.otp);

                    mMaterialDialog = new MaterialDialog(HomeActivity.this)
                            .setTitle("Logout")
                            .setMessage("Are You Sure You Want to Logout??")
                            .setPositiveButton("OK", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(ActivityRegister.this, "" + otp.getText().toString(), Toast.LENGTH_LONG).show();
                                    mMaterialDialog.show();
                                }
                            })
                            .setNegativeButton("CANCEL", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    mMaterialDialog.show();
                                }
                            });

                    mMaterialDialog.show();*/

                    dbhelper.insertUser(db, reg_name.getText().toString(), reg_email.getText().toString(),
                            reg_pass.getText().toString(),
                            reg_blood.getSelectedItem().toString(), reg_village.getText().toString(),
                            reg_tehsil.getText().toString(), reg_dist.getText().toString(),
                            reg_gotra.getSelectedItem().toString(),
                            reg_mob.getText().toString());

                    Task t=new Task();
                    t.execute(reg_name.getText().toString(),
                            reg_email.getText().toString(),
                            reg_pass.getText().toString(),
                            reg_mob.getText().toString(),
                            reg_blood.getSelectedItem().toString(),
                            reg_village.getText().toString(),
                            reg_tehsil.getText().toString(),
                            reg_dist.getText().toString(),
                            reg_gotra.getSelectedItem().toString());

                    Snackbar snackbar = Snackbar.make(l, "Registered Successfully", Snackbar.LENGTH_LONG);

                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();
                    finish();
                }
                else
                {
                    Task t=new Task();
                    t.execute(reg_name.getText().toString(),reg_email.getText().toString(),reg_pass.getText().toString(),reg_mob.getText().toString(),reg_blood.getSelectedItem().toString(),reg_village.getText().toString(),reg_tehsil.getText().toString(),reg_dist.getText().toString(),reg_gotra.getSelectedItem().toString());

                    Snackbar snackbar = Snackbar
                            .make(l, "User Already Registered!!! Try to Login!", Snackbar.LENGTH_LONG);

                    View sbView = snackbar.getView();
                    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.YELLOW);
                    snackbar.show();
                }

            }
        }
    }

    public class Task extends AsyncTask<String,String,String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            String result="";
            try
            {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://jagdishmandirujjain.in/androidcode/register.php?name=Satya&email=prosatya@gmail.com&password=123456");

                Log.e("register in=>", "do in");
                // Add your data
                //user_email, class, year, percent, board
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);


                nameValuePairs.add(new BasicNameValuePair("name", strings[0]));
                nameValuePairs.add(new BasicNameValuePair("email", strings[1]));
                nameValuePairs.add(new BasicNameValuePair("password", strings[2]));
                nameValuePairs.add(new BasicNameValuePair("mobile", strings[3]));
                nameValuePairs.add(new BasicNameValuePair("blood", strings[4]));
                nameValuePairs.add(new BasicNameValuePair("village", strings[5]));
                nameValuePairs.add(new BasicNameValuePair("tehsil", strings[6]));
                nameValuePairs.add(new BasicNameValuePair("district", strings[7]));
                nameValuePairs.add(new BasicNameValuePair("gotra", strings[8]));

                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                HttpResponse response = httpclient.execute(httppost);

                InputStream is = response.getEntity().getContent();
                InputStreamReader reader = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(reader);
                while (true)
                {
                    String str = br.readLine();
                    if (str == null)
                        break;
                    result = result + str;
                }
                br.close();
                Log.e("resume do in=>", "" + result);
                Log.e("resume do in=>", "" + result);
                Log.e("resume do in=>", "" + result);
                Log.e("resume do in=>", "" + result);
                Log.e("resume do in=>", "" + result);
            }
            catch(Exception e)
            {
                e.printStackTrace();

            }
            return result;
        }
    }

    public void setGotra()
    {
        gotra_list.add("Select Gotra");
        gotra_list.add("भंवरसिया(Bhanvrasiya)");
        gotra_list.add("बोर्दिया(Dordiya)");
        gotra_list.add("गुन्घोडिया(Gunghodiya)");
        gotra_list.add("ननधारिया(Kanodhariya)");
        gotra_list.add("कण्ठगरिया(Kanthgariya)");
        gotra_list.add("धनबरदाय(Dhanbardaya)");
        gotra_list.add("अज्वास्य(Ajvasya)");
        gotra_list.add("ननदिया(Nanodiya)");
        gotra_list.add("बाघोदारया(Baghodaraya)");
        gotra_list.add("ांसवारिया (Aansavariya)");
        gotra_list.add("वजन्य देवाय (Vajenya-Devaya)");
        gotra_list.add("चिक्लोद मान्य (Chiklod-Manya)");
        gotra_list.add("मंगरोलिया(Mangroliya)");
        gotra_list.add("किरतपुरिया(Kiratpuriya)");
        gotra_list.add("सलोनाराय(Salonaraya)");
        gotra_list.add("विरोट्या(Virotya)");
        gotra_list.add("छिबड़िया(Chhibadiya)");
        gotra_list.add("कुरंदनस्य (Kurandansya)");
        gotra_list.add("संभत हेडिया (Sumbhat-Hediya)");
        gotra_list.add("दलोंड्रिया(Dalodriya)");
        gotra_list.add("इन्द्रिय(Indriya)");
        gotra_list.add("विरोठिया(Virothiya)");
        gotra_list.add("वरसखीरिया(Varaskhiriya)");
        gotra_list.add("इच्छावरिया(Icchhavariya)");
        gotra_list.add("आकासोदिया(Aakasodiya)");
        gotra_list.add("ताजपुरिया(Tajpuriya)");
        gotra_list.add("संदोरन्य(Sandoranya)");
        gotra_list.add("उछोड़िया(Uchodiya)");
        gotra_list.add("अलवण्या(Alvanya)");
        gotra_list.add("देवतारया(Devtaraya)");
        gotra_list.add("भैसोदिया(Bhaisodiya)");
        gotra_list.add("मण्डलवड़िया(Mandalavdiya)");
        gotra_list.add("गोळ्या(Golya)");
        gotra_list.add("जगोठिया(Jagothiya)");
        gotra_list.add("केलोडिया(Kelodiya)");
        gotra_list.add("रुदड़िया(Rudadiya)");
        gotra_list.add("पार्सवडिया(Parsavdiya)");
        gotra_list.add("देवदालिया(Devdaliya)");
        gotra_list.add("भादरिया(Bhaderiya)");
        gotra_list.add("कनसिया(Kanasiya)");
        gotra_list.add("बींजलिया(Binjaliya)");
        gotra_list.add("सोठड़िया(Sothadiya)");
        gotra_list.add("सवासिया(Savasiya)");
        gotra_list.add("सोनानिया(Sonaniya)");
        gotra_list.add("सूतिया(Soothiya)");
        gotra_list.add("सिसोदिया(Sisodiya)");
        gotra_list.add("शिवदासिया(Shivdasiya)");
        gotra_list.add("सरोजिया(Sarojiya)");
        gotra_list.add("सग्वलिया(Sagwaliya)");
        gotra_list.add("रिनोदिया(Rinodiya)");
        gotra_list.add("रणवासिया(Ranvasiya)");
        gotra_list.add("भड़लावड़िया(Bhadlavdiya)");
        gotra_list.add("भठुरिया(Bhathuriya)");
        gotra_list.add("भैसरोदिया(Bhaisrodiya)");
        gotra_list.add("भैसानिया(Bhaisaniya)");
        gotra_list.add("भदोड़िया(Bhdodiya)");
        gotra_list.add("भमोरिया(Bhamoriya)");
        gotra_list.add("बिनरोटिया(Binrotiya)");
        gotra_list.add("बीजलपुरिया(Bijalpuriya)");
        gotra_list.add("बिलावलिया(Bilavliya)");
        gotra_list.add("बडबडोदिया(Badbadodiya)");
        gotra_list.add("सिरसोडिया(Sirsodiya)");
        gotra_list.add("बबुलडिया(Babuldiya)");
        gotra_list.add("बरनवाया(Baranvaya)");
        gotra_list.add("बरनासिया(Barnasiya)");
        gotra_list.add("पंचोरिया(Panchoriya)");
        gotra_list.add("धनोरिया(Dhnoriya)");
        gotra_list.add("देवथलिया(Devthliya)");
        gotra_list.add("देथलिया(Dethliya)");
        gotra_list.add("ठेंगलिया(Thengliya)");
        gotra_list.add("तुमड़िया ,तोमर (Tumdiya,tomar)");
        gotra_list.add("तंडिया(Tamdiya)");
        gotra_list.add("तिलवडिया(Tilavdiya)");
        gotra_list.add("ठीकरोडिया(Thikrodiya)");
        gotra_list.add("डिंगरोडिया(Dingrodiya)");
        gotra_list.add("झलवाया(Jhalvaya)");
        gotra_list.add("जवारिया(Javariya)");
        gotra_list.add("जमलिया ,जमले (Jamliya/Jamle)");
        gotra_list.add("कामोठिया(Kaamothiya)");
        gotra_list.add("जमगोड़िया(Jamgodiya)");
        gotra_list.add("जलोदिया(Jalodiya)");
        gotra_list.add("चौरसिया(Chourasiya)");
        gotra_list.add("चंदवासिया(Chandvasiya)");
        gotra_list.add("ग्वालिया(Gavaliya)");
        gotra_list.add("गुरवादिया(Guravadiya)");
        gotra_list.add("गिड़गिड़ाया(Gidgidaya)");
        gotra_list.add("गिरितिया(Kiritiya)");
        gotra_list.add("खिरबाड़ोदिया(Khirbadodiya)");
        gotra_list.add("खचरोडिया(Khachrodiya)");
        gotra_list.add("खरलीय(Kharaliya)");
        gotra_list.add("खेवसिया(Khevasiya)");
        gotra_list.add("खजुरिया(Khajuriya)");
        gotra_list.add("केलिए(Keliya)");
        gotra_list.add("कुलखंडिया(Kulkhandiya)");
        gotra_list.add("कसया(Kasanya)");
        gotra_list.add("करंजिया(Karanjiya)");
        gotra_list.add("कसुन्दरिया(Kasundariya)");
        gotra_list.add("कल्मोदिया(Kalmodiya)");
        gotra_list.add("करनावडिया(Karnavdiya)");
        gotra_list.add("उपलवड़िया(Uplavdiya)");
        gotra_list.add("ितवदिया(Itavdiya)");
        gotra_list.add("अकोलिया(Akoliya)");
        gotra_list.add("अम्लवड़िया(Amlavdiya)");
        gotra_list.add("अलेरिया (Aleriya)");
        gotra_list.add("अजनावडिया(Ajnavdiya)");
    }




}
