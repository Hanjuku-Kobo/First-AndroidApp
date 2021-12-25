package com.example.esp32ble.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.esp32ble.usecases.InstructionsSave;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VideoSaveDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("動画を保存しますか？");
        builder.setPositiveButton("はい", this);
        builder.setNegativeButton("いいえ", this);
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE){
            // 現在日時を取得
            Date nowDate = new Date();
            // 表示形式を指定
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            InstructionsSave instructionsSave = new InstructionsSave();
            instructionsSave.moveFiles(
                    "/storage/emulated/0/DCIM/Camera/" + sdf.format(nowDate) + ".mp4");
        }
    }
}