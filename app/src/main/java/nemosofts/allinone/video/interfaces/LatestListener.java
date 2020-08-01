package nemosofts.allinone.video.interfaces;

import java.util.ArrayList;

import nemosofts.allinone.video.item.itemVideo;


/**
 * Created by thivakaran
 */

public interface LatestListener {
    void onStart();
    void onEnd(String success, String verifyStatus, String message, ArrayList<itemVideo> arrayListVideo);
}
