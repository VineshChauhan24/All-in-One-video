package nemosofts.allinone.video.interfaces;

import java.util.ArrayList;

import nemosofts.allinone.video.item.itemComment;

/**
 * Created by thivakaran
 */

public interface CommentListener {
    void onStart();
    void onEnd(String success, ArrayList<itemComment> arrayListCat);
}
