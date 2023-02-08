package com.seleco.camera_recognition_firebase.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.ktx.messaging
import com.seleco.camera_recognition_firebase.R

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null){
            startActivity(Intent(this,LoginActivity::class.java))
        }

        Firebase.messaging.subscribeToTopic("test_topic").addOnCompleteListener {
            task->
            var msg = "Subscribed"
            if (!task.isSuccessful) {
                msg = "Subscribe failed"
            }
            Log.d("MainActivity", msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        }

        //1. Recycler view recent events
        //2. unsubscribe with logout
        //3. in recycler after click put extra to intent and open event window
    }
//    val intent = Intent(this, WebViewActivity::class.java)
//    intent.putExtra("url", "https://www.example.com")
//    startActivity(intent)
}
//private List<Object> firebaseData;
//
//new LoadDataFromFirebase().execute();

//private class LoadDataFromFirebase extends AsyncTask<Void, Void, List<Object>> {
//
//    @Override
//    protected List<Object> doInBackground(Void... voids) {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("node_name");
//
//        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                firebaseData = new ArrayList<>();
//                for (DataSnapshot child : dataSnapshot.getChildren()) {
//                Object object = child.getValue(Object.class);
//                firebaseData.add(object);
//            }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });
//        return firebaseData;
//    }
//}
//
//private void logIn() {
//    // ... log in logic ...
//
//    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
//    mainIntent.putExtra("firebase_data", (Serializable) firebaseData);
//    startActivity(mainIntent);
//    finish();
//}
//}

//@Override
//protected void onPostExecute(String value) {
//    textView.setText(value);
//}





