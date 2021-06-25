package pl.lodz.uni.eksoc.project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class user_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_activity)
        val actionBar = supportActionBar
        val textView_name: TextView = findViewById(R.id.name)
        val textView_email: TextView = findViewById(R.id.email)

        actionBar!!.title = "Profile Manager"

        val get_name = intent.getStringExtra("Name").toString()
        val get_email = intent.getStringExtra("Email").toString()


        textView_name.text = get_name
        textView_email.text = get_email

    }

}