package pl.lodz.uni.eksoc.project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    var sqliteHelper: SQLiteHelper = SQLiteHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnAdd.setOnClickListener{addStudent()}
        btnView.setOnClickListener { getStudents() }

    }
    private fun getStudents(){
        println("in get students fun")
        val stdList = sqliteHelper.getAllStudent()
            Log.e("pppp", "${stdList.size}")

    }

    private fun addStudent() {
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if (name.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "PLEASE ENTER REQUIRED FILES", Toast.LENGTH_SHORT).show()
            println("puste pola")
        } else{
            println("dodaj wartosci do bazki")
            val std = StudentModel(name = name, email = email)
            println("dodaj wartosci sqliteHelper")
            val status = sqliteHelper.insertStudent(std)
            if(status > -1){
                Toast.makeText(this, "Student Added...", Toast.LENGTH_SHORT).show()
                clearEditText()
            } else {
                Toast.makeText(this, "RECORD NOT SAVED...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText(){
        edName.setText("")
        edEmail.setText("")
        edName.requestFocus()

    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        edEmail = findViewById(R.id.edEmail)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)

    }


}