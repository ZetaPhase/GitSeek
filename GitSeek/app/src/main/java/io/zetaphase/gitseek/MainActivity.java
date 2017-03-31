package io.zetaphase.gitseek;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button github_search_button;
    EditText github_username_edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        github_search_button = (Button) findViewById(R.id.github_search_button);
        github_username_edittext = (EditText) findViewById(R.id.searchGithubUsername);
        final String username = github_username_edittext.getText().toString();
        github_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.github.com/users/" + username;
            }
        });
    }
}
