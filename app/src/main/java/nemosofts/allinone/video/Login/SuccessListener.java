package nemosofts.allinone.video.Login;

public interface SuccessListener {
    void onStart();
    void onEnd(String success, String registerSuccess, String message);
}