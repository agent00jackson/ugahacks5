package com.ugahacks5.wolf.Matched;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.robinhood.spark.SparkView;
import com.ugahacks5.wolf.R;
import com.ugahacks5.wolf.Utils.TopNavigationViewHelper;
import com.ugahacks5.wolf.Utils.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * DatingApp
 * https://github.com/quintuslabs/DatingApp
 * Created on 25-sept-2018.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */

public class Matched_Activity extends AppCompatActivity {

    private static final String TAG = "Matched_Activity";
    private static final int ACTIVITY_NUM = 2;
    List<Users> matchList = new ArrayList<>();
    //List<User> copyList = new ArrayList<>();
    private Context mContext = Matched_Activity.this;
    //private String userId, userSex, lookforSex;
    //private double latitude = 37.349642;
    //private double longtitude = -121.938987;
    //private EditText search;
    private List<Users> usersList = new ArrayList<>();
    private RecyclerView recyclerView, mRecyclerView;
    private ActiveUserAdapter adapter;
    private MatchUserAdapter mAdapter;

    private Random random;
    private TextView scrubInfoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matched);

        setupTopNavigationView();
        //searchFunc();
        random = new Random();
        float[] yData = new float[30];

        for (int i = 0, count = yData.length; i < count; i++) {
            yData[i] = random.nextFloat();
        }

        scrubInfoTextView = findViewById(R.id.scrub_info_textview);

        SparkView sparkView = findViewById(R.id.sparkview);
        adapter = new ActiveUserAdapter(yData);

        sparkView.setAdapter(adapter);

        sparkView.setScrubListener(new SparkView.OnScrubListener() {
            @Override
            public void onScrubbed(Object value) {
                if (value == null) {
                    scrubInfoTextView.setText(R.string.scrub_empty);
                } else {
                    scrubInfoTextView.setText(getString(R.string.scrub_format, value));
                }
            }
        });


        //recyclerView = findViewById(R.id.active_recycler_view);
        mRecyclerView = findViewById(R.id.matche_recycler_view);

        /*adapter = new ActiveUserAdapter(usersList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareActiveData();*/

        mAdapter = new MatchUserAdapter(matchList, getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager1);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        prepareMatchData();


    }

    /*private void prepareActiveData() {
        Users users = new Users("1", "Swati Tripathy", 21, "https://im.idiva.com/author/2018/Jul/shivani_chhabra-_author_s_profile.jpg", "Simple and beautiful Girl", "Acting", 200);
        usersList.add(users);
        users = new Users("2", "Ananaya Pandy", 20, "https://i0.wp.com/profilepicturesdp.com/wp-content/uploads/2018/06/beautiful-indian-girl-image-for-profile-picture-8.jpg", "cool Minded Girl", "Dancing", 800);
        usersList.add(users);
        users = new Users("3", "Anjali Kasyap", 22, "https://pbs.twimg.com/profile_images/967542394898952192/_M_eHegh_400x400.jpg", "Simple and beautiful Girl", "Singing", 400);
        usersList.add(users);
        users = new Users("7", "Sudeshna Roy", 19, "https://talenthouse-res.cloudinary.com/image/upload/c_fill,f_auto,h_640,w_640/v1411380245/user-415406/submissions/hhb27pgtlp9akxjqlr5w.jpg", "Papa's Pari", "Art", 5000);
        usersList.add(users);

        adapter.notifyDataSetChanged();
    }*/

    private void prepareMatchData() {
        Users users = new Users("1", "Google", 21, "https://cdn2.iconfinder.com/data/icons/social-icons-33/128/Google-512.png", "$250", "Tech", 200);
        matchList.add(users);
        users = new Users("2", "Home Depot", 20, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5f/TheHomeDepot.svg/1200px-TheHomeDepot.svg.png", "$160", "Home Improvement", 800);
        matchList.add(users);
        users = new Users("3", "Walmart", 22, "https://umitapak.files.wordpress.com/2016/07/walmart_logo_1.jpg", "$370", "Grocery", 400);
        matchList.add(users);
        users = new Users("4", "Facebook", 19, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/1024px-Facebook_icon.svg.png", "$183", "Social Media", 1308);
        matchList.add(users);
        users = new Users("5", "Apple", 20, "https://image.freepik.com/free-icon/apple-logo_318-40184.jpg", "$299", "Tech", 1200);
        matchList.add(users);
        users = new Users("6", "Starbucks", 21, "https://upload.wikimedia.org/wikipedia/en/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/1200px-Starbucks_Corporation_Logo_2011.svg.png", "$129", "Fast Food", 700);
        matchList.add(users);
        users = new Users("7", "Amazon", 19, "https://redguinness.files.wordpress.com/2015/07/amazon-logo.jpg", "$67", "Retail", 5000);
        matchList.add(users);

        mAdapter.notifyDataSetChanged();
    }

    private void searchFunc() {
       /* search = findViewById(R.id.searchBar);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                searchText();
            }

            @Override
            public void afterTextChanged(Editable s) {
                searchText();
            }
        });*/
    }

    /* private void searchText() {
         String text = search.getText().toString().toLowerCase(Locale.getDefault());
         if (text.length() != 0) {
             if (matchList.size() != 0) {
                 matchList.clear();
                 for (User user : copyList) {
                     if (user.getUsername().toLowerCase(Locale.getDefault()).contains(text)) {
                         matchList.add(user);
                     }
                 }
             }
         } else {
             matchList.clear();
             matchList.addAll(copyList);
         }

         mAdapter.notifyDataSetChanged();
     }

     private boolean checkDup(User user) {
         if (matchList.size() != 0) {
             for (User u : matchList) {
                 if (u.getUsername() == user.getUsername()) {
                     return true;
                 }
             }
         }

         return false;
     }

     private void checkClickedItem(int position) {

         User user = matchList.get(position);
         //calculate distance
         Intent intent = new Intent(this, ProfileCheckinMatched.class);
         intent.putExtra("classUser", user);

         startActivity(intent);
     }
 */
    private void setupTopNavigationView() {
        Log.d(TAG, "setupTopNavigationView: setting up TopNavigationView");
        BottomNavigationViewEx tvEx = findViewById(R.id.topNavViewBar);
        TopNavigationViewHelper.setupTopNavigationView(tvEx);
        TopNavigationViewHelper.enableNavigation(mContext, tvEx);
        Menu menu = tvEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }


}
