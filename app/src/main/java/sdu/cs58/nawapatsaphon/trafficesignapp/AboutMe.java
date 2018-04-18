package sdu.cs58.nawapatsaphon.trafficesignapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AboutMe extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
    }//end on click

    public void clickBack(View view) {
        finish();
    }//end clickBack

    public void PlaySound(View view) {
        if (mediaPlayer != null) {//ตรวจว่ามี oj
            mediaPlayer.stop();//ถ้ามีให้หยุดเล่น
            mediaPlayer.release();//คืน resource ที่ mediaplayer เติมให้กับระบบ
        }
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cat);
        mediaPlayer.start();
    }//end playsound

    public void clickFacebook(View view) {
        Intent fbIntent = new Intent(Intent.ACTION_VIEW);
        fbIntent.setData(Uri.parse("https://www.facebook.com/krittabun.attakasem"));
        startActivity(fbIntent);
    }

    public void clickMobile(View view) {
        Intent mobileIntent = new Intent(Intent.ACTION_DIAL);
        mobileIntent.setData(Uri.parse("tel:0983321308"));
        startActivity(mobileIntent);
    }

    public void clickMap(View view) {
        String lat = "13.776264";
        String lng = "100.510564";
        String label = "มหาลัยสวนดุสิต";
        Uri location = Uri.parse("https://maps.google.com/maps?z=10&q=loc:"+lat+","+lng+"("+label+")");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW,location);
        //mapIntent.setPackage("com.google.android.apps.maps"); //เทสบนgenyไม่ได้
        startActivity(mapIntent);
    }
}//ens class
