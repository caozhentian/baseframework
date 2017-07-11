package com.threeti.net;

import com.threeti.commlibrary.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitFactory {

	public static Retrofit getBaseRetrofit(String baseUrl) {

		OkHttpClient.Builder builder = new OkHttpClient().newBuilder() ;
		if(BuildConfig.DEBUG) {
			HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
			logging.setLevel(HttpLoggingInterceptor.Level.BODY);
			builder.addInterceptor(logging);
		}
		OkHttpClient client = builder.build() ;
		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
				.addConverterFactory(GsonConverterFactory.create()).client(client).build();
		return retrofit;

	}

//	public static Retrofit getDownRetrofit(String baseUrl) {
//		OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new LoggingInterceptor())
//				.addInterceptor(new DownInterceptor()).build();
//		Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
//				.addConverterFactory(GsonConverterFactory.create()).client(client).build();
//		return retrofit;
//	}
}
