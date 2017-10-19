package cihangul.com.employechecker.Network;

import cihangul.com.employechecker.S;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tuzlabim on 17.10.2017.
 */

public class Db {

    // end point url
    private static String BASE_URL = "";

    /**
     *
     * @return retrofit instance
     */
    public static Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Connect getConnect(){
        return getRetrofit().create(Connect.class);
    }

}
