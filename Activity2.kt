package com.example.mykathaacounts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.initial_screen.*

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val database =
            Room.databaseBuilder(this, KathaaDatabase::class.java, "kathaa_database2")
                .allowMainThreadQueries()
                .build()
        val listKathha = database.kathaaDao().getKathaa()
        if (listKathha.size == 1) {
            listKathha.forEach {
                editTextS.setText(it.Subuh)
                editTextT.setText(it.Thuhur)
                editTextA.setText(it.Asir)
                editTextM.setText(it.Magrib)
                editTextI.setText(it.Ishaa)
            }
        } else if (listKathha.isEmpty()) {
            editTextS.setText("0")
            editTextT.setText("0")
            editTextA.setText("0")
            editTextM.setText("0")
            editTextI.setText("0")
        }

        buttonSaveTotal.setOnClickListener {
            val empkathaainit = Kathaa(
                0, editTextS.text.toString(), editTextT.text.toString(),
                editTextA.text.toString(), editTextM.text.toString(), editTextI.text.toString()
            )
            if (listKathha.isEmpty()) {
                database.kathaaDao().insertKathaa(empkathaainit)
            } else if (listKathha.size.toInt() == 1) {
                empkathaainit.uid = 1
                database.kathaaDao().updateKathaa(empkathaainit)
                showMessage1("تم خزن المعلومات...")
            }

        }
        buttonReturn.setOnClickListener {
            finish()
        }

    }
    private fun showMessage1(msg:String) {
        Snackbar.make(kchange_layout, msg, Snackbar.LENGTH_SHORT).show()
    }
}
