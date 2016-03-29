package com.matictechnology.shrijagdishmandir.Utility;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.matictechnology.shrijagdishmandir.Activity.ActivityTemple;
import com.matictechnology.shrijagdishmandir.R;

import java.util.ArrayList;

/**
 * Created by maticd1 on 19/3/16.
 */
public class UjjainCardFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    ArrayList<String> darshan_templename,darshan_text,darshan_text_full;
    ArrayList<Integer> darshan_imagename,darshan_imagename1;

    ArrayList<String> ghat_name,ghat_text,ghat_text_full;
    ArrayList<Integer> ghat_imagename,ghat_imagename1;

    TextView page_text;
    ListView darshan_list;


    private int position;

    public static UjjainCardFragment newInstance(int position) {
        UjjainCardFragment f = new UjjainCardFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View itemView1=null;
        if(position==0)
        {
            itemView1=inflater1.inflate(R.layout.pager_ujjain1, null);



            GridView gridview = (GridView)itemView1.findViewById(R.id.gridview);
            gridview.setAdapter(new ImageAdapter(getContext()));
        }
        else if(position==1)
        {
            itemView1=inflater1.inflate(R.layout.pager_ujjain2_darshan, null);


            page_text=(TextView)itemView1.findViewById(R.id.page_text);
            darshan_list=(ListView)itemView1.findViewById(R.id.darshan_list);

            ListView darshan_list=(ListView)itemView1.findViewById(R.id.darshan_list);

            darshan_templename=new ArrayList<>();
            darshan_text=new ArrayList<>();
            darshan_text_full=new ArrayList<>();
            darshan_imagename=new ArrayList<>();
            darshan_imagename1=new ArrayList<>();

            darshan_templename.add("Shri Jagdish Mandir");
            darshan_templename.add("Shri Mahakaleshwar Temple");
            darshan_templename.add("Harsiddhi Temple");
            darshan_templename.add("Bade Ganesh Temple");
            darshan_templename.add("Ram-Janardan Temple");
            darshan_templename.add("Nagarkot Ki Rani Temple");
            darshan_templename.add("Chaubis Khamba Mata Temple");
            darshan_templename.add("Navagraha Triveni (Shani Temple)");
            darshan_templename.add("Gadhkalika Temple");
            darshan_templename.add("Shri Gopal Mandir");


            darshan_text.add("");
            darshan_text.add("The presiding deity of time, Shiva, in all his splendour reigns eternal in Ujjain. The temple of Mahakaleshwar, its shikhara soaring into the skies...");
            darshan_text.add("This temple occupies a special place in the galaxy of ancient sacred spots of Ujjain. Seated between the idols of Mahalaxmi and Mahasaraswati....");
            darshan_text.add("This temple situated above the tank near the Mahakaleshwar temple, enshrines a huge artistic sculpture of Ganesh, the son of Shiva....");
            darshan_text.add("Idols of Rama; Lakshmana and Sita in the Rama-temple and that of Janardana-Vishnu in the Janardana-temple belong to the seventeenth century....");
            darshan_text.add("Nagarkot Ki Rani is the guardian deity of the south-west corner of ancient Ujjaiyini. This is a place of some archaeological importance....");
            darshan_text.add("According to old tradition Chaubis Khamba constituted the majestic entrance gate of Mahakala-Vana. Remains of the boundary-wall are also....");
            darshan_text.add("Situated on the Triveni Ghat of the Shipra, the temple is located away from the old site of Ujjaini town. It is dedicated....");
            darshan_text.add("Situated about 2 miles from the city of Ujjain, the deity in this temple is believed to have been worshipped by Kalidasa....");
            darshan_text.add("This huge temple is situated in the middle of the big market square. It was constructed by Bayajibai Shinde, the queen of Maharajah....");


            darshan_text_full.add("");
            darshan_text_full.add("The presiding deity of time, Shiva, in all his splendour reigns eternal in Ujjain. The temple of Mahakaleshwar, its shikhara soaring into the skies, evokes primordial awe and reverence with its majesty. The Mahakal dominates the life of the city and its people, even in the midst of the busy routine of modern preoccupations, and provides an unbreakable link with past traditions "+
                    "The temple is three-storeyed. In the lowest middle and uppermost parts are respectively installed the lingams of Mahakalesvara, Omkareshwar and Nagachandresvara.The pilgrims and the visitors can only have the glimpse of Nagachandresvara on the festive of Naga Panchami. A very large-sized Kunda named Koti Tirtha also exists in the temple-complex. The Kunda is built in the sarvatobhadra style. The Kunda and its water both are treated as very celestial. On the path adjoining the stairs of the Kunda, may be seen many images representing the sculptural grandeur of the temple built during the Paramara period. In the east of the Kunda is a large-sized Veranda in which there is the entrance to the path leading to the garbhagrha. In the northern side of the verandah, in a cell, the images of Sri Rama and goddess Avantika are worshipped. In the southern side of the main shrine, there stand many small Saivite temples built during the shinde regime among these the temple of Vrddha Mahakalesvara, Anadi Kalpesvara and Saptarshi are prominent and are the remarkable pieces of architecture." +
                    "The lingam of Mahakalesvara is colossus. The silver plated Naga Jaladhari and the inscribed and esoteric silver-plate covering the roof of the garbhagrha add extra grandeur to the shrine. Besides Jyotirlinga, attractive and small-sized images of Ganesa, Kartikeya and Paravati can be seen in the garbhagrha. All around the walls classical eulogies in the praise of Lord Siva are exhibited. The Nanda Dipa always remains lit. In the exit-path, there is a wide hall in which a most attractive metal quoted stone Nandi, in the sitting humble pose may be witnessed. The courtyard just opposite to the Omkaresvara temple add much to the magnanimity of the temple-complex. Just adjoining to this temple, there are two pillared projections facing the east and adding a lot to the architecture of the temple. The temple of Mahakalesvara is a planned admixture of the Bhumija, Chalukya and Maratha styles of architecture. The sikhara with the mini-srngas is very peculiar. In previous years its upper part has been covered with gold plate.As seen earlier, the present temple of Mahakala was built during the 4th – 5th decades of Eighteenth c. Simultaneously the religious-minded nobles of Maratha community also built many a temples in the temple-complex. During this period many ancient traditions such as worship abhisheka, arati, sawari (procession) in the Sravana month, Harihara-milana etc, were also revived. These are still continuing with joyful ceremony and devotional enthusiasm." +
                    "The Bhasmarti in early morning, Mahasivaratri, Pancha-Krosi Yatra, Somvati Amavasya etc. are special religious occasions interwoven with the rituals of the temple. Proper repairs and rejuvenation of the temple-complex is done at the time of the Kumbha Parva. In the year 1980, a separate mandapam was constructed to facilitate the visitors. In 1992, Madhya Pradesh Government and Ujjain Development Authority exclusively contributed special repairs and made provisions for the stay of pilgrims. The same process is also being followed at the time of the forthcoming Simhastha.");
            darshan_text_full.add("This temple occupies a special place in the galaxy of ancient sacred spots of Ujjain. Seated between the idols of Mahalaxmi and Mahasaraswati, the idol of Annapurna is painted in dark vermilion colour. The Sri Yantra, the symbol of power or shakti, is also enshrined in the temple." +
                    "According to the Shiva Purana, when Shiva carried away the burning body of Sati from the sacrificial fire, her elbow dropped at this place. There is an interesting legend in the Skanda Purana about the manner in which the Goddess Chandi acquired the epithet of Harsiddhi. Once when Shiva and Parvati were alone on Mount Kailash, two demons Chand and Prachand tried to force their way in." +
                    "Shiva called upon Chandi to destroy them which she did. Pleased, Shiva bestowed upon her the epithet of ‘one who vanquishes all’. The temple was reconstructed during the Maratha period and the two pillars adorned with lamps are special features of Maratha art. These lamps, lit during Navaratri, present a glorious spectacle. There is an ancient well on the premises, and an artistic pillar adorns the top of it.");
            darshan_text_full.add("This temple situated above the tank near the Mahakaleshwar temple, enshrines a huge artistic sculpture of Ganesh, the son of Shiva. An idol of this size and beauty is rarely to be found. The middle of the temple is adorned by an idol of the pancha-mukhi (five faced) Hanuman. There is provision for learning of Sanskrit and Astrology in the temple.");
            darshan_text_full.add("Idols of Rama; Lakshmana and Sita in the Rama-temple and that of Janardana-Vishnu in the Janardana-temple belong to the seventeenth century. Both the temples present an attractive look from the point of view of their structural art. These temples were constructed by Mirza Raja Jaisingh in the Seventeenth Century. The boundary wall and the tank were added later in Maratha Period in the eighteenth Century. Beautiful examples of maratha paintings are seen on the walls of both the temples. Besides the attractive scenes from the lives of Rama and Krishna, the painting of Bedalya Bua Maharaj and Sant Tukoba etc. are quite impressive." +
                    "Certain old images are seen installed in both the temples as well as near the tank opposite Janardan temple which are very important from the point of view of sculpture also. The image of Govardhan dhari Krishna near the tank belongs to eleventh century. The images of Vishnu installed in between the assembly hall and the interior of Rama-temple belongs to the tenth century and the images of Brahma, Vishnu and mahesha belong to the twelth century A.D.");
            darshan_text_full.add("Nagarkot Ki Rani is the guardian deity of the south-west corner of ancient Ujjaiyini. This is a place of some archaeological importance. Many popular tales of Vikramaditya and Bhartrihari are associated with this place. The place is associated with the traditions of Natha Cult also." +
                    "The tank facing the temple is of Paramar-period. Both the sides of the tank have two small temples. The idol of Kartikeya in one of the temples is assigned to Gupta period. The Temple is situated on the ancient mud Rampart and hence is known as the queen of the city wall i.e. Nagarkot Ki Rani.");

            darshan_text_full.add("According to old tradition Chaubis Khamba constituted the majestic entrance gate of Mahakala-Vana. Remains of the boundary-wall are also in existence near this gate. Architectural design, of the twenty four ornate columns, belongs to the ninth or tenth century AD." +
                    "Two images of goddesses are installed one each on the either side of the gate with the names inscribed. On the footstools are Mahamaya and Mahalaya. Looking at the graceful forms of these guardian-deities of the grand entrance structure, one can imagine the dimensions of the boundary-wall of the traditionally known Mahakala-vana, which is not covered under thick inhabitation.");
            darshan_text_full.add("Situated on the Triveni Ghat of the Shipra, the temple is located away from the old site of Ujjaini town. It is dedicated to the nine planets, attracts large crowds on new moon days falling on Saturdays. Its religious importance has increased in recent years though there is no known reference to it in the ancient texts.");
            darshan_text_full.add("Situated about 2 miles from the city of Ujjain, the deity in this temple is believed to have been worshipped by Kalidasa. The legend goes that he was an idiot and it is by his devotion to the goddess Kalika that he acquired great literary skills." +
                    "Emperor Harshavardhan had this temple renovated in the 7th century AD. There is further evidence of renovation during the Paramara period. The temple has been rebuilt in the modern times by the erstwhile Gwalior State.");
            darshan_text_full.add("This huge temple is situated in the middle of the big market square. It was constructed by Bayajibai Shinde, the queen of Maharajah Daulat Rao Shinde in the 19th century. It is a beautiful example of Maratha architecture. The sanctum sanctorum is inlaid with marble and doors are silver plated. The door in the inner sanctum is said to have been carried to Ghazni from the Somnath temple and from thence by Mahmud Shah Abdali to Lahore. Mahadji Scindia recovered it and now it has been installed in this temple.");

            darshan_imagename.add(R.drawable.jagdishmandir);
            darshan_imagename.add(R.drawable.mahankal);
            darshan_imagename.add(R.drawable.harsiddhi);
            darshan_imagename.add(R.drawable.badeganesh);
            darshan_imagename.add(R.drawable.janardan);
            darshan_imagename.add(R.drawable.nagarkot);
            darshan_imagename.add(R.drawable.chaubiskhamba);
            darshan_imagename.add(R.drawable.navagraha);
            darshan_imagename.add(R.drawable.gadhkalika);
            darshan_imagename.add(R.drawable.gopal);


            darshan_imagename1.add(R.drawable.jagdishmandir_thumb);
            darshan_imagename1.add(R.drawable.mahankal_thumb);
            darshan_imagename1.add(R.drawable.harsiddhi_thumb);
            darshan_imagename1.add(R.drawable.badeganesh_thumb);
            darshan_imagename1.add(R.drawable.janardan_thumb);
            darshan_imagename1.add(R.drawable.nagarkot_thumb);
            darshan_imagename1.add(R.drawable.chaubiskhamba_thumb);
            darshan_imagename1.add(R.drawable.navagraha_thumb);
            darshan_imagename1.add(R.drawable.gadhkalika_thumb);
            darshan_imagename1.add(R.drawable.gopal_thumb);

            DarshanListAdapter adapter=new DarshanListAdapter(getContext(),R.layout.item_darshan,darshan_templename,darshan_text,darshan_imagename1);

            darshan_list.setAdapter(adapter);

            darshan_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {
                    Intent in=new Intent(getContext(),ActivityTemple.class);
                    Log.e("sending..", "" + darshan_templename.get(i) + "," + darshan_text_full.get(i) + "," + darshan_imagename.get(i) + "!");
                    in.putExtra("darshan_templename",darshan_templename.get(i));
                    in.putExtra("darshan_text_full",darshan_text_full.get(i));
                    in.putExtra("darshan_imagename",darshan_imagename.get(i));
                    startActivity(in);
                }
            });
        }
        else if(position==2)
        {
            itemView1=inflater1.inflate(R.layout.pager_ujjain2_ghat, null);


            ListView ghat_list=(ListView)itemView1.findViewById(R.id.ghat_list);

            ghat_name=new ArrayList<>();
            ghat_text=new ArrayList<>();
            ghat_text_full=new ArrayList<>();
            ghat_imagename=new ArrayList<>();
            ghat_imagename1=new ArrayList<>();

            ghat_name.add("Narsingh Ghat");
            ghat_name.add("Sunheri Ghat");
            ghat_name.add("Prashanti Dham Ghat");
            ghat_name.add("Chintaman Ghat");
            ghat_name.add("Datt Akhada Ghat");
            ghat_name.add("Bhukimata Ghat");
            ghat_name.add("Rinmukteshwar Ghat");
            ghat_name.add("Kabir Ghat");
            ghat_name.add("Siddhwat Ghat");
            ghat_name.add("Mangalnath Ghat");


            ghat_text.add("This ghat is situated on the banks of River Kshipra, on the left side of which lies the famous Kark Raj Temple opposite Bhukimata Temple....");
            ghat_text.add("This ghat is situated on the right bank of River Kshipra, which lies towards the right side of a small lane on Ujjain Badnagar Road....");
            ghat_text.add("This Ghat is situated in the atrium of Prashanti Dham Temple & towards the right coast of Kshipra river....");
            ghat_text.add("This ghat is situated on the left bank of River Kshipra which flows under the Lalpul Railway Bridge located near a big bridge on the....");
            ghat_text.add("This ghat is situated on the left bank of River Kshipra, connecting Ujjain Barnagar Road. A road extending from the left side of a....");
            ghat_text.add("This ghat is situated on the left side of River Kshipra, near the famous Bhukimata Temple. A road extending from the left side of a big....");
            ghat_text.add("This Ghat is situated near Rinmukteshwar Temple. You will find an ancient statue of Lord Shiva’s main host “Virbhadra” and old tree....");
            ghat_text.add("Kabir ghat is situated on the left bank of River Kshipra, which is located on the right side of the Ujjain Barnagar road....");
            ghat_text.add("Siddhwat Ghat is situated near Siddhawat Temple, on the left bank of River Kshipra. A road, next to the Sidhawat Temple....");
            ghat_text.add("These three ghats are located near the bridge of the auspicious Mangalnath Temple, on the right and left banks of holy River Kshipra....");


            ghat_text_full.add("This ghat is situated on the banks of River Kshipra, on the left side of which lies the famous Kark Raj Temple opposite Bhukimata Temple. The specialty of this temple is that it is located on the Tropic of Cancer passing through Ujjain. This ghat was developed for the purpose of the devotees who come for Simhasth Mahakumbh for taking the Holy Bath. In order to reach this ghat, a 500 metre long road extends from the right side of a big bridge located on the Ujjain-Chintaman Road.");
            ghat_text_full.add("This ghat is situated on the right bank of River Kshipra, which lies towards the right side of a small lane on Ujjain Badnagar Road. This ghat was developed for the purpose of the devotees who come for Simhasth Maha Kumbh for taking Holy Bath. A road extending from the right side of a small lane on Ujjain Badnagar Road will lead to this Ghat.");
            ghat_text_full.add("This Ghat is situated in the atrium of Prashanti Dham Temple & towards the right coast of Kshipra river. The way to reach this Ghat is 1.5 KM Away from Ujjain-Indore Route by the right side of the temple.");
            ghat_text_full.add("This ghat is situated on the left bank of River Kshipra which flows under the Lalpul Railway Bridge located near a big bridge on the Ujjain Chintaman Road. This ghat was developed for the purpose of the devotees who come for Simhasth Maha Kumbh or the Holy Bath. One can reach the ghat from a road made of cement and concrete, which extends on the right side of a big bridge on the Ujjain Chintaman Road. The road is about 50 metres long.");
            ghat_text_full.add("This ghat is situated on the left bank of River Kshipra, connecting Ujjain Barnagar Road. A road extending from the left side of a small lane on the Ujjain Barnagar Road will lead to this Ghat.");
            ghat_text_full.add("This ghat is situated on the left side of River Kshipra, near the famous Bhukimata Temple. A road extending from the left side of a big bridge on the Ujjain Chintaman Road leads to this Ghat. The length of the road is 700 metres. This ghat is situated near the famous Bhkimata Temple on the left bank of River Kshipra. It was created for the bathing purpose of the devotees during the auspicious occasion of Simhasth Maha Kumbh and the Holy Bath.");
            ghat_text_full.add("This Ghat is situated near Rinmukteshwar Temple. You will find an ancient statue of Lord Shiva’s main host “Virbhadra” and old tree under which Rinmukteshwar’s Lord Shiva lingam and ancient Ganesh idol are established. The significance of worshiping the temple is on Saturday. Bhrartruhari cave, Rumi’s tomb and Tilkeshhwar temple are near by places to Rin Muktehswar Temple.");
            ghat_text_full.add("Kabir ghat is situated on the left bank of River Kshipra, which is located on the right side of the Ujjain Barnagar road. One can reach the ghat from a lane, which extends on the left side of roads on the Ujjain Barnagar Road.");
            ghat_text_full.add("Siddhwat Ghat is situated near Siddhawat Temple, on the left bank of River Kshipra. A road, next to the Sidhawat Temple, leads to this Ghat.");
            ghat_text_full.add("These three ghats are located near the bridge of the auspicious Mangalnath Temple, on the right and left banks of holy River Kshipra. These ghats were developed by the Water Resource Department for the purpose of the devotees who come for Simhasth Maha Kumbh or the Holy Bath. These three ghats are located near the Mangalnath Temple.");


            ghat_imagename.add(R.drawable.narsingh);
            ghat_imagename.add(R.drawable.sunheri);
            ghat_imagename.add(R.drawable.prashanti);
            ghat_imagename.add(R.drawable.chintaman);
            ghat_imagename.add(R.drawable.dattakhada);
            ghat_imagename.add(R.drawable.bhukimata);
            ghat_imagename.add(R.drawable.rinmukteshwar);
            ghat_imagename.add(R.drawable.kabir);
            ghat_imagename.add(R.drawable.siddhwat);
            ghat_imagename.add(R.drawable.mangalnath);

            ghat_imagename1.add(R.drawable.narsingh_thumb);
            ghat_imagename1.add(R.drawable.sunheri_thumb);
            ghat_imagename1.add(R.drawable.prashanti_thumb);
            ghat_imagename1.add(R.drawable.chintaman_thumb);
            ghat_imagename1.add(R.drawable.dattakhada_thumb);
            ghat_imagename1.add(R.drawable.bhukimata_thumb);
            ghat_imagename1.add(R.drawable.rinmukteshwar_thumb);
            ghat_imagename1.add(R.drawable.kabir_thumb);
            ghat_imagename1.add(R.drawable.siddhwat_thumb);
            ghat_imagename1.add(R.drawable.mangalnath_thumb);

            //GhatListAdapter adapter=new GhatListAdapter(getContext(),R.layout.item_ghat,ghat_name,ghat_text,ghat_imagename);
            GhatListAdapter adapter=new GhatListAdapter(getContext(),R.layout.item_darshan,ghat_name,ghat_text,ghat_imagename1);

            ghat_list.setAdapter(adapter);


            ghat_list.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {

                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
                {
                    Intent in=new Intent(getContext(),ActivityTemple.class);
                    in.putExtra("darshan_templename",ghat_name.get(i));
                    in.putExtra("darshan_text_full",ghat_text_full.get(i));
                    in.putExtra("darshan_imagename",ghat_imagename.get(i));
                    startActivity(in);
                }
            });
        }
        else if(position==3)
        {


        }

        /*
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        LayoutParams params1 = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        LayoutParams params2 = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);



        FrameLayout fl = new FrameLayout(getActivity());
        fl.setLayoutParams(params);

        final int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources()
                .getDisplayMetrics());

        LinearLayout childLayout = new LinearLayout(getActivity());

        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        childLayout.setLayoutParams(linearParams);

        params.setMargins(margin, margin, margin, margin);
        childLayout.setLayoutParams(params);
        childLayout.setLayoutParams(params);
        childLayout.setBackgroundResource(R.drawable.background_card);
        childLayout.setBackgroundResource(R.color.background);
        childLayout.setOrientation(LinearLayout.VERTICAL);

        TextView pager1_tv1 = new TextView(getActivity());
        TextView pager1_tv2 = new TextView(getActivity());
        TextView pager1_tv3 = new TextView(getActivity());
        ImageView pager1_iv1 =new ImageView(getActivity());
        ImageView pager1_iv2 =new ImageView(getActivity());

        /*pager1_tv1.setLayoutParams(new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT, 1f));
        pager1_tv2.setLayoutParams(new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT, 1f));
        pager1_tv3.setLayoutParams(new TableLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT, 1f));*/

        /*pager1_tv1.setTextSize(35);
        pager1_tv1.setPadding(5, 3, 0, 3);
        pager1_tv1.setLayoutParams(params1);
        pager1_tv1.setLayoutParams(params1);
        pager1_tv1.setTypeface(null, Typeface.BOLD);
        pager1_tv1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        pager1_tv1.setGravity(Gravity.TOP);
        pager1_tv1.setTextColor(Color.BLACK);

        pager1_tv2.setTextSize(18);
        pager1_tv2.setPadding(5, 3, 0, 3);
        pager1_tv2.setLayoutParams(params1);
        pager1_tv2.setLayoutParams(params1);
        pager1_tv2.setTypeface(null, Typeface.BOLD);
        pager1_tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        pager1_tv2.setTextColor(Color.BLUE);

        pager1_tv3.setTextSize(21);
        pager1_tv3.setPadding(5, 3, 0, 3);
        pager1_tv3.setLayoutParams(params1);
        pager1_tv3.setLayoutParams(params1);
        pager1_tv3.setTypeface(null, Typeface.BOLD);
        pager1_tv3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        pager1_tv3.setTextColor(Color.WHITE);

        LinearLayout childchildLayout = new LinearLayout(getActivity());

        LinearLayout.LayoutParams childlinearParams = new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        childchildLayout .setLayoutParams(childlinearParams);

        childchildLayout.setLayoutParams(params1);
        childchildLayout.setLayoutParams(params1);
        childchildLayout.setOrientation(LinearLayout.HORIZONTAL);

        pager1_iv1.setImageResource(R.drawable.babaji_rameswerdas);
        pager1_iv1.setLayoutParams(params2);
        pager1_iv1.setLayoutParams(params2);
        pager1_iv1.setPadding(0,0,60,0);

        pager1_iv2.setImageResource(R.drawable.sahdevmuniji_maharaj);
        pager1_iv2.setLayoutParams(params2);
        pager1_iv2.setLayoutParams(params2);


        pager1_tv1.setText("सिंहस्थ कुम्भ महापर्व 2016");
        pager1_tv2.setText("दि. 22 अप्रैल से 21 मई 2016 तक");
        pager1_tv3.setText("आमंत्रणपत्रं");

        childchildLayout.addView(pager1_iv2, 0);
        childchildLayout.addView(pager1_iv1, 0);
        childLayout.addView(childchildLayout, 0);
        childLayout.addView(pager1_tv3, 0);
        childLayout.addView(pager1_tv2, 0);
        childLayout.addView(pager1_tv1, 0);


        /*
        LinearLayout v=new LinearLayout(getActivity());
        params.setMargins(margin, margin, margin, margin);
        v.setLayoutParams(params);
        v.setLayoutParams(params);
        v.setGravity(Gravity.CENTER);
        v.setBackgroundResource(R.drawable.background_card);
        v.setBackgroundResource(R.color.background);
        v.setOrientation(LinearLayout.VERTICAL);


        TextView v1 = new TextView(getActivity());
        v1.setTextSize(35);
        v1.setTypeface(null, Typeface.BOLD);
        v1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        v1.setTextColor(Color.BLACK);
        v1.setLayoutParams(params);
        v1.setLayoutParams(params);
        v1.setGravity(Gravity.TOP);
        v1.setText("सिंहस्थ कुम्भ महापर्व 2016");
        v.addView(v1,0);

        TextView v2 = new TextView(getActivity());
        v2.setTextSize(28);
        v2.setTypeface(null, Typeface.BOLD);
        v2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        v2.setTextColor(Color.BLUE);
        v2.setLayoutParams(params);
        v2.setLayoutParams(params);
        v2.setText("दि. 22 अप्रैल से 21 मई 2016 तक");
        v.addView(v2,1);
*/
       // fl.addView(childLayout);
        return itemView1;
    }

}