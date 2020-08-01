package nemosofts.allinone.video.interfaces;


import nemosofts.allinone.video.item.ItemHomeBanner;
import nemosofts.allinone.video.item.itemVideo;
import nemosofts.allinone.video.item.itemCategory;


import java.util.ArrayList;

public interface HomeListener {
    void onStart();
    void onEnd(String success, ArrayList<ItemHomeBanner> arrayListBanner, ArrayList<itemVideo> arrayList_home1, ArrayList<itemVideo> arrayList_home2, ArrayList<itemVideo> arrayList_home3, ArrayList<itemCategory> arrayList_cat);
}
