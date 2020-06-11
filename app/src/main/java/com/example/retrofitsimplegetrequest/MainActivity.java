package com.example.retrofitsimplegetrequest;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.retrofitsimplegetrequest.apiInterface.ApiInterface;
import com.example.retrofitsimplegetrequest.model.UserPost;
import com.example.retrofitsimplegetrequest.retrofitClient.RetrofitClient;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvData;
    UserPost userPost;
    ApiInterface apiInterface;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = findViewById(R.id.tv_data);

        retrofit = RetrofitClient.getInstance(this, "api");
        apiInterface = retrofit.create(ApiInterface.class);

        Call<List<UserPost>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<UserPost>>() {
            @Override
            public void onResponse(Call<List<UserPost>> call, Response<List<UserPost>> response) {
                if (response.isSuccessful()) {
                    List<UserPost> userPost = response.body();
                    String post = "";
                    for (UserPost postValue : userPost) {
                        post += "ID: " + postValue.getId() + "\n";
                        post += "User ID: " + postValue.getUserId() + "\n";
                        post += "Title: " + postValue.getTitle() + "\n";
                        post += "Body: " + postValue.getBody() + "\n\n";
                    }
                    tvData.append(post);
                } else {
                    tvData.setText("code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<UserPost>> call, Throwable t) {
                tvData.setText("message: " + t.getMessage());
            }
        });
    }
}
