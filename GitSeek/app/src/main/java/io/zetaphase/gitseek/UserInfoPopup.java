package io.zetaphase.gitseek;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xeliot on 3/31/17.
 */

public class UserInfoPopup extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_info_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        double widthProportion = 0.8;
        double heightProportion = 0.8;

        getWindow().setLayout((int) (width*widthProportion), (int) (height*heightProportion));

        Intent intent = getIntent();
        String json = intent.getStringExtra("JSON");

        TextView name = (TextView) findViewById(R.id.user_info_name);
        TextView location = (TextView) findViewById(R.id.user_info_location);
        TextView numRepos = (TextView) findViewById(R.id.user_info_numrepos);
        TextView numFollowers = (TextView) findViewById(R.id.user_info_num_followers_following);
        TextView biography = (TextView) findViewById(R.id.user_info_bio);
        Button viewRepos = (Button) findViewById(R.id.user_info_view_repos_button);
        Button goToGithub = (Button) findViewById(R.id.user_info_to_github_button);
    }
}
