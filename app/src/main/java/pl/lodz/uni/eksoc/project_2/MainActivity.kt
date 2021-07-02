package pl.lodz.uni.eksoc.project_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    private lateinit var spinnerwl1: Spinner
    private lateinit var spinnerwl2: Spinner
    private lateinit var spinnerwl3: Spinner
    private lateinit var spinner_champion1: Spinner
    private lateinit var spinner_champion2: Spinner
    private lateinit var spinner_champion3: Spinner
    private lateinit var spinner_kda1: Spinner
    private lateinit var spinner_kda2: Spinner
    private lateinit var spinner_kda3: Spinner

    var sqliteHelper: SQLiteHelper = SQLiteHelper(this)
    private var std:StudentModel? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        btnAdd.setOnClickListener{addStudent()}
        btnView.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val win_lose = arrayOf("Win",  "Lose")
        val champions = arrayOf("Draven", "Ezreal", "Jhin", "Jinx", "Kai'Sa", "Kalista",
        "Kog'Maw", "Lucian", "Miss Fortune", "Quinn")
        val kils  = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
            "15")
        val win_lose_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, win_lose)
        val champion_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, champions)
        val kils_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kils)
        spinnerwl1.adapter = win_lose_adapter
        spinnerwl1.onItemSelectedListener = object :
            AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinnerwl1.adapter = win_lose_adapter
        spinnerwl1.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinnerwl2.adapter = win_lose_adapter
        spinnerwl2.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinnerwl3.adapter = win_lose_adapter
        spinnerwl3.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_champion1.adapter = champion_adapter
        spinner_champion1.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_champion2.adapter = champion_adapter
        spinner_champion2.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_champion3.adapter = champion_adapter
        spinner_champion3.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_kda1.adapter = kils_adapter
        spinner_kda1.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_kda2.adapter = kils_adapter
        spinner_kda2.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }
        spinner_kda3.adapter = kils_adapter
        spinner_kda3.onItemSelectedListener = object :
                AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                print("hello")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                print("hello")
            }

            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }


        }

    }




    private fun addStudent() {
        val name = edName.text.toString()
        val wlg1 = spinnerwl1.getSelectedItem().toString()
        val wlg2 = spinnerwl2.getSelectedItem().toString()
        val wlg3 = spinnerwl3.getSelectedItem().toString()
        val champ1 = spinner_champion1.getSelectedItem().toString()
        val champ2 = spinner_champion2.getSelectedItem().toString()
        val champ3 = spinner_champion3.getSelectedItem().toString()
        val kda1 = spinner_kda1.getSelectedItem().toString()
        val kda2 = spinner_kda2.getSelectedItem().toString()
        val kda3 = spinner_kda3.getSelectedItem().toString()


        if (name.isEmpty()){
            Toast.makeText(this, "PLEASE ENTER REQUIRED FILES", Toast.LENGTH_SHORT).show()
        } else {
            val std = StudentModel(name = name, wl1 = wlg1, wl2 = wlg2, wl3 = wlg3, champ1 = champ1, champ2 = champ2, champ3 = champ3, kda1 = kda1, kda2 = kda2, kda3 = kda3)
            val status = sqliteHelper.insertStudent(std)
            if(status > -1){
                Toast.makeText(this, "Player Added...", Toast.LENGTH_SHORT).show()
                clearEditText()
            } else {
                Toast.makeText(this, "RECORD NOT SAVED...", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun clearEditText(){
        edName.setText("")
        edName.requestFocus()

    }

    private fun initView(){
        edName = findViewById(R.id.edName)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)
        spinnerwl1 = findViewById(R.id.spinnerwl1)
        spinnerwl2 = findViewById(R.id.spinnerwl2)
        spinnerwl3 = findViewById(R.id.spinnerwl3)
        spinner_champion1 = findViewById(R.id.spinner_champion1)
        spinner_champion2 = findViewById(R.id.spinner_champion2)
        spinner_champion3 = findViewById(R.id.spinner_champion3)
        spinner_kda1 = findViewById(R.id.spinner_kda1)
        spinner_kda2 = findViewById(R.id.spinner_kda2)
        spinner_kda3 = findViewById(R.id.spinner_kda3)


    }


}