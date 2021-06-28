package pl.lodz.uni.eksoc.project_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var recyclerView: RecyclerView
    private var adapter: StudentAdapter? = null
    var sqliteHelper: SQLiteHelper = SQLiteHelper(this)
    private var std:StudentModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initView()
        initRecyclerView()
        getStudents()
        val actionBar = supportActionBar

        actionBar!!.title = "Players Base"

        actionBar.setDisplayHomeAsUpEnabled(true)
        adapter?.setOnClickDeleteItem {
            deleteStudent(it.id)
        }
        adapter?.setOnClickItem{
            Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show()
            val intent = Intent(this, user_activity::class.java)
//            edName.setText(it.name).toString()
            print("Champions played")
            print(it.champ2)
            print(it.champ3)
            print(it.champ1)

            intent.putExtra("Name", it.name)
            intent.putExtra("wl1", it.wl1)
            intent.putExtra("wl2", it.wl2)
            intent.putExtra("wl3", it.wl3)
            intent.putExtra("champ1", it.champ1)
            intent.putExtra("champ2", it.champ2)
            intent.putExtra("champ3", it.champ3)
            intent.putExtra("kda1", it.kda1)
            intent.putExtra("kda2", it.kda2)
            intent.putExtra("kda3", it.kda3)
            intent.putExtra("id", it.id)
            startActivity(intent)
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
    private fun initRecyclerView(){
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter()
        recyclerView.adapter = adapter
    }

    private fun initView(){
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun getStudents(){
        println("in get students fun")
        val stdList = sqliteHelper.getAllStudent()
        adapter?.addItems(stdList)
    }
}