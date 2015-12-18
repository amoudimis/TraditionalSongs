package com.amou.traditionalsongs.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.amou.traditionalsongs.activities.MainActivity;

/**
 * Created by dimitrios on 10/12/2015.
 */
public class BaseFragment<T extends AppCompatActivity> extends Fragment{


    protected T pActivity;
    protected View progressBar;
    protected ProgressDialog progressDialog;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pActivity = (T) getActivity();
        progressDialog = new ProgressDialog(getActivity());

    }

    public void showProgressDialog(String title)
    {

        progressDialog.setMessage(title);
        progressDialog.setIndeterminate(false);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dismissProgressDialog()
    {
        if(progressBar != null )
            progressDialog.dismiss();
    }



    public boolean onCustomOptionsItemSelected(View option) {
        // TODO Auto-generated method stub
        return true;
    }

    public Context getApplicationContext()
    {
        return pActivity.getApplicationContext();
    }

    public void changeTitleBar(String title) {
        // TODO Auto-generated method stub
        //pActivity.changeTitleBar(title);
    }

    public boolean onBackPressed() { return true;}

//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//    }
//
//    public void startActivity(Intent intent,int animation1,int animation2) {
//        startActivity(intent);
//        getActivity().overridePendingTransition (animation1, animation2);
//    }
//
//    public void startActivityDefault(Intent intent) {
//        startActivity(intent);
//        getActivity().overridePendingTransition (R.anim.slide_right_in, R.anim.slide_right_out);
//    }

//    @Override
//    public void startActivityForResult(Intent intent, int requestCode) {
//        // TODO Auto-generated method stub
//        super.startActivityForResult(intent, requestCode);
//    }
//
//    public void startActivityForResult(Intent intent, int requestCode,int animation1,int animation2) {
//        startActivityForResult(intent,requestCode);
//        getActivity().overridePendingTransition (animation1, animation2);
//    }
//
//    public void startActivityForResultDefault(Intent intent, int requestCode) {
//        startActivityForResult(intent,requestCode);
//        getActivity().overridePendingTransition (R.anim.slide_right_in, R.anim.slide_right_out);
//    }

    protected boolean pageLoaded() {
        return (progressBar.getVisibility() == View.GONE);
    }

    protected void enableProgressBar()
    {
        progressBar.setVisibility(View.VISIBLE);
    }

    protected void disableProgressBar()
    {
        progressBar.setVisibility(View.GONE);
    }

}
