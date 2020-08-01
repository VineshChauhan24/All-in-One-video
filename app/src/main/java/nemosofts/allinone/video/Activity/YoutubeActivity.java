package nemosofts.allinone.video.Activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.StyleRes;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import nemosofts.allinone.video.DBHelper.DBHelper;
import nemosofts.allinone.video.JSONParser.JSONParser;
import nemosofts.allinone.video.Methods.Methods;
import nemosofts.allinone.video.R;
import nemosofts.allinone.video.SharedPref.Setting;

import static nemosofts.allinone.video.Activity.DeveloperKey.DEVELOPER_KEY;

/**
 * Created by thivakaran
 */
public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    private static final String TAG = "Youtube";

    Methods methods;
    int position;

    protected void onCreate(Bundle savedInstanceState) {
        if (Setting.Dark_Mode) {
            setAppTheme(R.style.AppTheme4);
        } else {
            setAppTheme(R.style.AppTheme3);
        }
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        methods = new Methods(this);

        position = getIntent().getIntExtra("pos2", 0);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);
        youTubePlayerView.initialize(DEVELOPER_KEY, this);

        new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String json = JSONParser.okhttpPost(Setting.SERVER_URL, methods.getAPIRequest(Setting.METHOD_VIDEO, 0, "", Setting.arrayList.get(position).getId(), "", "", "", "", "", "","","","","","","","", null));
                return null;
            }
        }.execute();
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Log.d(TAG, "Done");
        youTubePlayer.loadVideo(Setting.arrayList.get(position).getVideo_id());
        youTubePlayer.play();
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Log.d(TAG, "Failed");
    }

    private void setAppTheme(@StyleRes int style) {
        setTheme(style);
    }
}
