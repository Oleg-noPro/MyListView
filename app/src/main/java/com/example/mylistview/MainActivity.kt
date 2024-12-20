package com.example.mylistview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val list_users: MutableList<User> = mutableListOf()

    private lateinit var toolbarTB: Toolbar

    private lateinit var name_textET: EditText
    private lateinit var age_textET: EditText

    private lateinit var save_buttonBTN: Button

    private lateinit var list_usersLV: ListView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        toolbarTB = findViewById(R.id.toolbarTB)
        setSupportActionBar(toolbarTB)
        title = "Каталог пользователей"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        name_textET = findViewById(R.id.name_textET)
        age_textET = findViewById(R.id.age_textET)

        save_buttonBTN = findViewById(R.id.save_buttonBTN)


        list_usersLV = findViewById(R.id.list_usersLV)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list_users)
        list_usersLV.adapter = adapter

        save_buttonBTN.setOnClickListener {
            list_users.add(User(name_textET.text.toString(), age_textET.text.toString().toInt()))
            adapter.notifyDataSetChanged()
            name_textET.text.clear()
            age_textET.text.clear()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.exit_menu -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

}