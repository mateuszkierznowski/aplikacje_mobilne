package pl.lodz.uni.eksoc.project_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    var sqliteHelper: SQLiteHelper = SQLiteHelper(this)
    private lateinit var recyclerView:RecyclerView
    private var adapter: StudentAdapter? = null
    private var std:StudentModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initRecyclerView()
        getStudents()
        btnAdd.setOnClickListener{addStudent()}
        btnView.setOnClickListener { getStudents() }
        btnUpdate.setOnClickListener { updateStudent() }
        adapter?.setOnClickItem{Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
            edName.setText(it.name)
            edEmail.setText(it.name)
            std = it
        }
        adapter?.setOnClickDeleteItem {
            deleteStudent(it.id)
        }

    }
    private fun deleteStudent(id:Int){
        if(id == null) return
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Are you sure you want to delete this user")
        builder.setCancelable(true)
        builder.setPositiveButton("Yes"){dialog, _->
            sqliteHelper.deleteStudentById(id)
            getStudents()
            dialog.dismiss()}
        builder.setNegativeButton("No"){dialog, _-> dialog.dismiss()}
        val alert = builder.create()
        alert.show()
    }

    private fun getStudents(){
        println("in get students fun")
        val stdList = sqliteHelper.getAllStudent()
        adapter?.addItems(stdList)
    }

    private fun addStudent() {
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if (name.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "PLEASE ENTER REQUIRED FILES", Toast.LENGTH_SHORT).show()
            println("puste pola")
        } else {
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

    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        edEmail = findViewById(R.id.edEmail)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
        btnUpdate = findViewById(R.id.btnUpdate)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun updateStudent(){
        val name = edName.text.toString()
        val email = edEmail.text.toString()

        if (name == std?.name && email == std?.email){
            Toast.makeText(this, "Rekord no changed", Toast.LENGTH_SHORT).show()
            return
        }

        if (std == null) return
        val std = StudentModel(id = std!!.id, name = name, email = email)
        val status = sqliteHelper.updateStudent(std)
        if (status > -1){
            clearEditText()
            getStudents()
        } else {
            Toast.makeText(this, "Update failed", Toast.LENGTH_SHORT).show()
        }

    }
}