package com.example.johnson.oogdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.johnson.oogdemo.api.GitAPI;
import com.example.johnson.oogdemo.model.GitModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    Button click;
    TextView tv;
    EditText edit_user;
    ProgressBar pbar;
    String API = "https://api.github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        edit_user = (EditText) findViewById(R.id.editText2);
        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setVisibility(View.INVISIBLE);

        click.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user = edit_user.getText().toString();
                pbar.setVisibility(View.VISIBLE);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API)
                        .build();

                GitAPI git = retrofit.create(GitAPI.class);

                git.getFeed(user, new Callback<GitModel>() {
                    @Override
                    public void onResponse(Call<GitModel> call, Response<GitModel> response) {
                        GitModel temp = new GitModel();
                        tv.setText("Github Name: " + temp.getName() +
                                "\nWebsite :" +  temp .getBlog() +
                                "\nCompany Name :"+ temp .getCompany());

                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onFailure(Call<GitModel> call, Throwable t) {

                        pbar.setVisibility(View.VISIBLE);
                    }
                });
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();





    }
}

//interface BlogService {
//    @GET("blog/{id}")
//    Call<ResponseBody> getBlog(@Path("id") int id);
//}
////        注意，这里是interface不是class，所以我们是无法直接调用该方法，我们需要用Retrofit创建一个BlogService的代理对象。
