package com.app.bsoft_salary_slip.AppUtils;

import static android.app.Notification.WearableExtender.SIZE_DEFAULT;
import static android.app.PendingIntent.FLAG_MUTABLE;
import static android.content.Context.ALARM_SERVICE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaMetadataRetriever;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.opengl.GLES10;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import android.util.Base64OutputStream;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

;
import com.app.bsoft_salary_slip.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public class Utils {

    private static final int SIZE_LIMIT = 200;
    public static String Authorization = "AuthKey";
    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static String Token = "";

    public static int sInputImageWidth = 0;
    public static int sInputImageHeight = 0;

    public static String OtpValidate = "OtpValid";

    public static void showAlert(Context mContext, String mTitle, String mMessage) {
        try {
            final Dialog alertDialog = new Dialog(mContext);
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialog.setContentView(R.layout.dialog_alert_message);

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            lp.copyFrom(alertDialog.getWindow().getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            alertDialog.show();
            alertDialog.getWindow().setAttributes(lp);

            TextView aTitle = alertDialog.findViewById(R.id.textViewATitle);
            aTitle.setText(mTitle);

            TextView aMessage = alertDialog.findViewById(R.id.textViewAMessage);
            aMessage.setText(mMessage);

            Button aOK = alertDialog.findViewById(R.id.buttonAOK);
            aOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View arg0) {
                    alertDialog.dismiss();
                }
            });
            alertDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.gc();
        }
    }

    public static boolean isValid(String s) {

        if (s != null && !s.isEmpty() && !s.equalsIgnoreCase("null")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = Objects.requireNonNull(cm).getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }


    public static int getMaxSize() {
        int maxSize = SIZE_DEFAULT;
        int[] arr = new int[1];
        GLES10.glGetIntegerv(GLES10.GL_MAX_TEXTURE_SIZE, arr, 0);
        if (arr[0] > 0) {
            maxSize = Math.min(arr[0], SIZE_LIMIT);
        }
        return maxSize;
    }


    public static Bitmap decodeSampledBitmapFromUri(Context context, Uri sourceUri, int requestSize) {
        InputStream is = null;
        try {
            is = context.getContentResolver().openInputStream(sourceUri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = Utils.calculateInSampleSize(context, sourceUri, requestSize);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(is, null, options);
    }

    public static int calculateInSampleSize(Context context, Uri sourceUri, int requestSize) {
        InputStream is = null;
        // check image size
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            is = context.getContentResolver().openInputStream(sourceUri);
            BitmapFactory.decodeStream(is, null, options);
        } catch (FileNotFoundException ignored) {
        } finally {
//            closeQuietly(is);
        }
        int inSampleSize = 1;
        sInputImageWidth = options.outWidth;
        sInputImageHeight = options.outHeight;
        while (options.outWidth / inSampleSize > requestSize
                || options.outHeight / inSampleSize > requestSize) {
            inSampleSize *= 2;
        }
        return inSampleSize;
    }

    @SuppressLint("ResourceAsColor")
    public static Dialog progressDialog(Context mContext) {
        final Dialog dialog = new Dialog(mContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.rotating_progress_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));

        ImageView imgRotationClock = dialog.findViewById(R.id.img_rotation_clock);
        dialog.setCancelable(false);

        Animation rotationClock = AnimationUtils.loadAnimation(mContext, R.anim.rotator);
        rotationClock.setRepeatCount(Animation.INFINITE);
        imgRotationClock.startAnimation(rotationClock);

        return dialog;
    }

    public static void clickAniamtion(View view) {
        AlphaAnimation imageAnimation = new AlphaAnimation(0.3f, 1.0f);
        imageAnimation.setDuration(200);
        view.startAnimation(imageAnimation);

    }



}
