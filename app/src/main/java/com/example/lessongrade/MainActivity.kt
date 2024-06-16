package com.example.lessongrade

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var inputGradeET: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        init()
    }

    private fun init() {
        setContentView(R.layout.activity_main)
        inputGradeET = findViewById(R.id.inputGradeET)
        registerForContextMenu(inputGradeET)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu_main, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_change_color -> {
                when(inputGradeET.text.toString()){
                    "1" -> inputGradeET.setTextColor(Color.rgb(255,87,34))
                    "2" -> inputGradeET.setTextColor(Color.rgb(255,235,59))
                    "3" -> inputGradeET.setTextColor(Color.rgb(12,202,20))
                    "4" -> inputGradeET.setTextColor(Color.rgb(14,44,209))
                    "5" -> inputGradeET.setTextColor(Color.rgb(225,10,10))
                }
            }
            R.id.menu_exit -> {
                finish()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}