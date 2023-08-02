package com.app.lobotustask.Api;

import com.app.lobotustask.models.AddressModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface Api {
    @GET("api/Client/Get?UserId=USR045&CurrentPage =1&PageSize=100&EnabledStatus=2")
    Call<AddressModel> getLocation(
            @Header("Travelize_Authentication") String auth
    );
}


