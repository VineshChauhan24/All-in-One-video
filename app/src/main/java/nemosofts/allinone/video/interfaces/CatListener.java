package nemosofts.allinone.video.interfaces;

import java.util.ArrayList;


import nemosofts.allinone.video.item.itemCategory;


public interface CatListener {
    void onStart();
    void onEnd(String success, String verifyStatus, String message, ArrayList<itemCategory> arrayList);
}
