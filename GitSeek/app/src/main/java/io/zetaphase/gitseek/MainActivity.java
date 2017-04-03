package io.zetaphase.gitseek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    Button github_search_button;
    EditText github_username_edittext;
    private String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        github_search_button = (Button) findViewById(R.id.github_search_button);
        github_username_edittext = (EditText) findViewById(R.id.searchGithubUsername);
        json = "";
        github_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("CLICK", "button is clicked");
                final String username = github_username_edittext.getText().toString();
                setJson("NOTHING");
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api.github.com/users/" + username;
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                setJson(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("ERROR", "that was unsuccessful");
                    }
                });
                queue.add(stringRequest);
                while(true){
                    if(getJson()=="NOTHING"){
                        continue;
                    }else{
                        break;
                    }
                }
                Log.d("JSON", getJson());
                Intent intent = new Intent(MainActivity.this, UserInfoPopup.class);
                intent.putExtra("JSON", getJson());
                startActivity(intent);
            }
        });
    }

    public void setJson(String json){ this.json = json; }
    public String getJson(){ return this.json; }
}
