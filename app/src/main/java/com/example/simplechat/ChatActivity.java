package com.example.simplechat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class ChatActivity extends AppCompatActivity {
    static final String TAG = ChatActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        // User login
        if (ParseUser.getCurrentUser() != null) { // start with existing user
            startWithCurrentUser();
        } else { // If not logged in, login as a new anonymous user
            login();
        }
    }

    // Get the userId from the cached currentUser object
    void startWithCurrentUser() {
        // TODO:
    }

    // Create an anonymous user using ParseAnonymousUtils and set sUserId
    void login() {
        ParseAnonymousUtils.logIn(new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Anonymous login failed: ", e);
                } else {
                    startWithCurrentUser();
                }
            }
        });
    }
}




//public class ChatActivity extends AppCompatActivity implements View.OnClickListener {
//
//    private final String TAG = "ChatActivity";
//    private ImageButton ibSend;
//    private EditText etMessage;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_chat);
//
//        if (ParseUser.getCurrentUser() != null) { // Start with existing user
//            startWithCurrentUser(); //TODO: We will build out this method in the next step
//        } else { // If not logged in, login as a new anonymous user
//            login();
//        }
//
//    }
//
//    // Create an anonymous user using ParseAnonymousUtils and set sUserId
//    void login() {
//        ParseAnonymousUtils.logIn(new LogInCallback() {
//            @Override
//            public void done(ParseUser user, ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Anonymous login failed: ", e);
//                } else {
//                    startWithCurrentUser();
//                }
//            }
//        });
//    }
//
//
//
//    public void setupMessagePosting() {
//        ibSend = (ImageButton) findViewById(R.id.ibSend);
//        etMessage = (EditText) findViewById(R.id.etMessage);
//        ibSend.setOnClickListener(this);
//    }
//
//
//    @Override
//    public void onClick(View v) {
////        Get the message String
//        String message = etMessage.getText().toString();
////        Create a ParseObject for the message and save the USER_ID_KEY and BODY_KEY values in it.
//
//        ParseObject parseMessage = new ParseObject("parseMessage");
////        parseMessage.put("USER_ID_KEY", 1232);
////        parseMessage.put("BODY_KEY", 1232 );
//
////        Call the saveInBackground() method to persist the data to the database and pass it a call to SaveCallback().
////        You can choose to toast a message on save.
//        parseMessage.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Toast.makeText(ChatActivity.this, "Successfully created message on Parse",
//                            Toast.LENGTH_SHORT).show();
//                } else {
//                    Log.e(TAG, "Failed to save message", e);
//                }
//            }
//        });
//
//        Toast.makeText(this, "save text", Toast.LENGTH_SHORT).show();
//
////        Clear the EditText component
//        etMessage.clearComposingText();
//
//    }
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//        super.onPointerCaptureChanged(hasCapture);
//    }
//
//    public void startWithCurrentUser(){
//        setupMessagePosting();
//    }
//}