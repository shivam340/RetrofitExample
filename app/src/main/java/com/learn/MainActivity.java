package com.learn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.widget.Toast;

import com.learn.model.LoggedInUser;
import com.learn.model.LoginRequest;
import com.learn.model.RegionList;
import com.learn.util.RetrofitHelper;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LoginRequest loginRequest = new LoginRequest("namrata", "123456");

        // Create a call instance to log in user.
        RetrofitHelper.getApiClient().login(loginRequest, new Callback<LoggedInUser>() {
            @Override
            public void success(LoggedInUser loggedInUser, Response response) {

                // Fetch and print a data.
                try {
                    Log.d("Cust id is ", ""+loggedInUser.getCustId());
                    Toast.makeText(getApplicationContext(), "login done! , cust id is  "
                            + loggedInUser.getCustId(), Toast.LENGTH_SHORT).show();
                    Log.d("Cust id is ", ""+loggedInUser.getCustId());

                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.d("login failed ", "" + ex.getMessage());
                    Toast.makeText(getApplicationContext(), "login failed "
                            + ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "login failed "
                        +error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        getRegionList();

    }


    private void getRegionList(){



        RetrofitHelper.getApiClient().getRegionList(new Callback< ArrayList< RegionList>>(){

            @Override
            public void success(ArrayList<RegionList> regionLists, Response response) {


                Log.d("region list is ", ""+regionLists.toString());

                Toast.makeText(MainActivity.this, "region list size is "+regionLists.size(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });


    }


}
