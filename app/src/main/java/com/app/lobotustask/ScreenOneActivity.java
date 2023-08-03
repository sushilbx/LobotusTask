package com.app.lobotustask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.app.lobotustask.Api.RetrofitClient;
import com.app.lobotustask.adapters.AddressAdapter;
import com.app.lobotustask.databinding.ActivityScreenOneBinding;
import com.app.lobotustask.models.AddressModel;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScreenOneActivity extends AppCompatActivity {
    ActivityScreenOneBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityScreenOneBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
        b.svSearch.setQueryHint("Search ...");
        b.fbCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScreenOneActivity.this, ScreenThreeActivity.class));
            }
        });
        getLocation();
    }

    private void getLocation() {
        b.rlLoading.setVisibility(View.VISIBLE);
        Call<AddressModel> call = RetrofitClient.getInstance().getApi().getLocation("MY3YXIp7vDPvIGvzD1MFPHTCxUKhb8j5DPzjPeollNyFO4jo/UIS62RygpHqmCZV98mf1iq4+MLDisqquYFLb373iELvDL6F5QZZE2uy+8DZlNX97IleSCLuQ+lGLG0yhgll4xUQl6HUvs/+q8Szej2rIjp4QB3EA/5lb9ZyLpm2j/UNPrAsQsKP4fxADc2+FByC3/6ipWWAZBHgr9uB0Pi7PE+CpL9kaf7OMfl02U/fotjpnqdGoJAEid/a0r0GHFLq/pWIeF3s6GaH+mGO0YZ4XlOYw0hKAG7F8RzJ1hwAR0jkm4eIZNOfQWIqBJHm");
        call.enqueue(new Callback<AddressModel>() {
            @Override
            public void onResponse(Call<AddressModel> call, Response<AddressModel> response) {
                b.rlLoading.setVisibility(View.GONE);
                Log.e("Get Location Response", new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    AddressAdapter addressAdapter = new AddressAdapter(response.body().result, ScreenOneActivity.this);
                    b.rvAddress.setAdapter(addressAdapter);
                }
            }

            @Override
            public void onFailure(Call<AddressModel> call, Throwable t) {
                b.rlLoading.setVisibility(View.GONE);
                Toast.makeText(ScreenOneActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}