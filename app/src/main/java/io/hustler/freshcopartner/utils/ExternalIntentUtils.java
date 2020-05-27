package io.hustler.freshcopartner.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import io.hustler.freshcopartner.R;

//import ph.bilidito..driver.R;

public class ExternalIntentUtils {

    public static void launchDialer(String number, Context context) {
        Uri u = Uri.parse("tel:" + number);
        Intent i = new Intent(Intent.ACTION_DIAL, u);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    public static void launchBrowser(String url, Context context) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(browserIntent);
    }

    public static void sendMail(Context context) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "sayimanoj@gmail.com", null));
        emailIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.fromCustomer));
        emailIntent.putExtra(Intent.EXTRA_TEXT, context.getString(R.string.fromCustomer));
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}
