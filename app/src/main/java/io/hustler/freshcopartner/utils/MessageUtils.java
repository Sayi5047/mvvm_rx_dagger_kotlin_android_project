package io.hustler.freshcopartner.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import io.hustler.freshcopartner.R;

import java.util.Objects;

import in.aabhasjindal.otptextview.OtpTextView;

public class MessageUtils {

    public static void showShortToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showShortToastContext(Context activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLongToast(Activity activity, String message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
    }

    public static void showDismissableSnackBar(View view, String message) {
        Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT);
        snackbar.setAction(view.getContext().getString(R.string.ok), v -> snackbar.dismiss());
        snackbar.setActionTextColor(ContextCompat.getColor(Objects.requireNonNull(view.getContext()), R.color.colorAccent));
        snackbar.show();
    }

    public interface BinaryClickListener {

        void onPositiveClick(String message);

        void onNegativeClick();
    }

    public class OtpTextWathcer implements TextWatcher {
        private EditText etNext, etPrev, etCurrent;

        public OtpTextWathcer(EditText etNext, EditText etPrev, EditText current) {
            this.etNext = etNext;
            this.etPrev = etPrev;
            this.etCurrent = current;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s.toString().length() == 1) {
                /*New Val*/
                etNext.requestFocus();
            }

            if (s.toString().length() > 1) {
//                /*Edit Val*/
//
                etCurrent.requestFocus();
                etCurrent.setText(String.valueOf(s.toString().charAt(0)));
            } else {
                /*Remove Val*/
                etPrev.requestFocus();

            }

        }
    }

    public static void showSoftKeyBoard(Context context, View view) {
        new Handler().postDelayed(() -> {
            ((OtpTextView) view).requestFocusOTP();
            InputMethodManager inputMethodManager = ((InputMethodManager) (context.getSystemService(Context.INPUT_METHOD_SERVICE)));
            assert inputMethodManager != null;
            inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        }, 300);
    }

    public static void hideSodtKeyBoard(Context context, View view) {
        new Handler().postDelayed(() -> {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        }, 300);

    }
}


