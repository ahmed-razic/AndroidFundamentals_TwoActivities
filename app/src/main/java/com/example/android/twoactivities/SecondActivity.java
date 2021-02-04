package com.example.android.twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    private static final String TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.EXTRA_REPLY";
    private EditText mReplyEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get data from Intent from Main activity
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);

        //Get reference to reply editText
        mReplyEditText = findViewById(R.id.editText_second);

        //Display Toast message and Log entry into logcat
        Toast toast = Toast.makeText(this, "Welcome to " + TAG, Toast.LENGTH_LONG);
        toast.show();
        Log.d(TAG, "In " + TAG);
    }

    //Reply to Main activity
    public void returnReply(View view) {

        String replyMessage = mReplyEditText.getText().toString();
        Intent intentReply = new Intent(this, MainActivity.class);

        intentReply.putExtra(EXTRA_REPLY, replyMessage);
        setResult(RESULT_OK, intentReply);
        finish();
    }
}