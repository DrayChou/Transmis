package com.dss886.transmis.utils;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.dss886.transmis.R;
import com.dss886.transmis.base.BaseActivity;

import androidx.appcompat.app.AlertDialog;

/**
 * Created by dss886 on 2017/7/1.
 */

public class DialogBuilder {

    @SuppressLint("InflateParams")
    public static void showEditTextDialog(BaseActivity activity, String title, String content,
                                                 int inputType, EditTextDialogCallback callback) {
        View layout = LayoutInflater.from(activity).inflate(R.layout.view_dialog_edit_text, null);
        EditText input = layout.findViewById(R.id.edit_text);
        input.setText(content);
        input.setInputType(inputType);
        input.setSelection(input.getText().length());

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        builder.setView(layout);
        builder.setPositiveButton("确定", (dialog, which) -> {
            if (callback != null) {
                callback.onSuccess(input.getText().toString());
            }
        });
        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());
        builder.show();
    }

    @SuppressWarnings("UnusedReturnValue")
    public static AlertDialog showAlertDialog(BaseActivity activity, String content, AlertDialogCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(content);
        builder.setPositiveButton("确定", (dialog, which) -> {
            if (callback != null) {
                callback.onSuccess();
            }
        });
        builder.setNegativeButton("取消", (dialog, which) -> dialog.dismiss());

        return builder.show();
    }

    public interface EditTextDialogCallback {
        void onSuccess(String content);
    }

    public interface AlertDialogCallback {
        void onSuccess();
    }
}
