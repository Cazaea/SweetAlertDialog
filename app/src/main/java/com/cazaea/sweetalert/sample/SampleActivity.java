package com.cazaea.sweetalert.sample;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.cazaea.sweetalert.SweetAlertDialog;

public class SampleActivity extends Activity implements View.OnClickListener {

    private int i = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);
        findViewById(R.id.basic_test).setOnClickListener(this);
        findViewById(R.id.under_text_test).setOnClickListener(this);
        findViewById(R.id.error_text_test).setOnClickListener(this);
        findViewById(R.id.success_text_test).setOnClickListener(this);
        findViewById(R.id.warning_confirm_test).setOnClickListener(this);
        findViewById(R.id.warning_cancel_test).setOnClickListener(this);
        findViewById(R.id.custom_img_test).setOnClickListener(this);
        findViewById(R.id.progress_dialog).setOnClickListener(this);
        findViewById(R.id.three_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.three_button:
                SweetAlertDialog sd1 = new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setCustomImage(R.drawable.pill_icon)
                        .setTitleText("3:00PM")
                        .setContentText("Asprin 50 mg. Take 2 pills")
                        .setNeutralText("Later")
                        .setCancelText("Skip it")

                        .setConfirmText("Take it!")
                        .setNeutralClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Toast.makeText(SampleActivity.this, "Take it later!", Toast.LENGTH_SHORT).show();
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Toast.makeText(SampleActivity.this, "Skip it!", Toast.LENGTH_SHORT).show();
                                sweetAlertDialog.dismiss();
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                Toast.makeText(SampleActivity.this, "Take it now!", Toast.LENGTH_SHORT).show();
                                sweetAlertDialog.dismiss();
                            }
                        });

                sd1.setCancelable(true);
                sd1.setCanceledOnTouchOutside(true);
                sd1.show();
                sd1.setDialogLayout(320, 200);
                break;
            case R.id.basic_test:
                // default title "Here's a message!"
                SweetAlertDialog sd = new SweetAlertDialog(this);
                sd.setCancelable(true);
                sd.setCanceledOnTouchOutside(true);
                sd.setConfirmText("OK");
                sd.show();
                break;
            case R.id.under_text_test:
                new SweetAlertDialog(this)
                        .setContentText("It's pretty, isn't it?")
                        .setConfirmText("OK")
                        .show();
                break;
            case R.id.error_text_test:
                new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                        .setTitleText("Oops...")
                        .setContentText("Something went wrong!")
                        .setConfirmText("OK")
                        .show();
                break;
            case R.id.success_text_test:
                final SweetAlertDialog successDialog = new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Good job!")
                        .setContentText("You clicked the button!");
                successDialog.show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (successDialog.isShowing()) {
                            successDialog.dismiss();
                        }
                    }
                }, 1500);
                break;
            case R.id.warning_confirm_test:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setConfirmText("Yes,delete it!")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                // reuse previous dialog instance
                                sDialog.setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        })
                        .show();
                break;
            case R.id.warning_cancel_test:
                SweetAlertDialog sdd = new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Are you sure?")
                        .setContentText("Won't be able to recover this file!")
                        .setCancelText("No,cancel plx!")
                        .setConfirmText("Yes,delete it!")
                        .showCancelButton(true)
                        .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                // reuse previous dialog instance, keep widget user state, reset them if you need
                                sDialog.setTitleText("Cancelled!")
                                        .setContentText("Your imaginary file is safe :)")
                                        .setConfirmText("OK")
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.ERROR_TYPE);

                                // or you can new a SweetAlertDialog to show
                               /* sDialog.dismiss();
                                new SweetAlertDialog(SampleActivity.this, SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Cancelled!")
                                        .setContentText("Your imaginary file is safe :)")
                                        .setConfirmText("OK")
                                        .show();*/
                            }
                        })
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.setTitleText("Deleted!")
                                        .setContentText("Your imaginary file has been deleted!")
                                        .setConfirmText("OK")
                                        .showCancelButton(false)
                                        .setCancelClickListener(null)
                                        .setConfirmClickListener(null)
                                        .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                            }
                        });


                sdd.show();
                sdd.setDialogWidth(300);
                break;
            case R.id.custom_img_test:
                new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("Sweet!")
                        .setContentText("Here's a custom image.")
                        .setCustomImage(R.drawable.custom_img)
                        .setConfirmText("OK")
                        .show();
                break;
            case R.id.progress_dialog:
                final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE)
                        .setTitleText("Loading");
                pDialog.show();
                pDialog.setCancelable(false);
                new CountDownTimer(800 * 3, 800) {
                    public void onTick(long millisUntilFinished) {
                        // you can change the progress bar color by ProgressHelper every 800 millis
                        i++;
                        switch (i) {
                            case 0:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.blue_btn_bg_color));
                                break;
                            case 1:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_50));
                                break;
                            case 2:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                            case 3:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_deep_teal_20));
                                break;
                            case 4:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.material_blue_grey_80));
                                break;
                            case 5:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.warning_stroke_color));
                                break;
                            case 6:
                                pDialog.getProgressHelper().setBarColor(getResources().getColor(R.color.success_stroke_color));
                                break;
                        }
                    }

                    public void onFinish() {
                        i = -1;
                        pDialog.setTitleText("Success!")
                                .setConfirmText("OK")
                                .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                    }
                }.start();
                break;
        }
    }
}
