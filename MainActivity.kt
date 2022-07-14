package com.example.mykathaacounts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        fun Get_Decremented_Number(My_Number: String): String {
            var Decremented_Number = ""
            Decremented_Number = (My_Number.toInt() - 1).toString()
            return Decremented_Number
        }

        fun Get_Incremented_Number(My_Number2: String): String {
            var Incremented_Number = ""
            Incremented_Number = (My_Number2.toInt() + 1).toString()
            return Incremented_Number
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var suhuhCounterT = "0"
        var subuhCounterI = 0
        var thuhurCounter = 0
        var asirCounter = 0
        var magribCounter = 0
        var ishaCounter = 0

        val database =
            Room.databaseBuilder(this, KathaaDatabase::class.java, "kathaa_database2")
                .allowMainThreadQueries()
                .build()
        val katha_Init = database.kathaaDao().getKathaa()
        if (katha_Init.isEmpty()) {
            val kathaastarter = Kathaa(
                0, "0", "0", "0", "0", "0"
            )
            database.kathaaDao().insertKathaa(kathaastarter)
        } else {
            fill_totalK_fields(database)
        }

        buttonSubuh.setOnClickListener {
            if (textViewSubuh.text != "0") {
                textViewSubuh.text = Get_Decremented_Number(textViewSubuh.text.toString())
                textViewSubuhNow.text = Get_Incremented_Number(textViewSubuhNow.text.toString())
            }
        }
        buttonThuhur.setOnClickListener {
            if (textViewThuhur.text != "0") {
                textViewThuhur.text = Get_Decremented_Number(textViewThuhur.text.toString())
                textViewThuhurNow.text = Get_Incremented_Number(textViewThuhurNow.text.toString())
            }
        }
        buttonAsir.setOnClickListener {
            if (textViewAsir.text != "0") {
                textViewAsir.text = Get_Decremented_Number(textViewAsir.text.toString())
                textViewAsirNow.text = Get_Incremented_Number(textViewAsirNow.text.toString())
            }
        }
        buttonMagrib.setOnClickListener {
            if (textViewMagrib.text != "0") {
                textViewMagrib.text = Get_Decremented_Number(textViewMagrib.text.toString())
                textViewMagribNow.text = Get_Incremented_Number(textViewMagribNow.text.toString())
            }
        }
        buttonIsha.setOnClickListener {
            if (textViewIshaa.text != "0") {
                textViewIshaa.text = Get_Decremented_Number(textViewIshaa.text.toString())
                textViewIshaaNow.text = Get_Incremented_Number(textViewIshaaNow.text.toString())
            }
        }
        buttonCancelEntry.setOnClickListener {
            if (textViewSubuhNow.text.toString().toInt() > 0) {
                if (textViewSubuh.text.toString().toInt() > 0 ) {
                    while (textViewSubuhNow.text.toString().toInt() > 0) {
                        textViewSubuh.text = (textViewSubuh.text.toString().toInt() + 1).toString()
                        textViewSubuhNow.text = (textViewSubuhNow.text.toString().toInt() - 1).toString()
                    }
                }
            }
            if (textViewThuhurNow.text.toString().toInt() > 0) {
                if (textViewThuhur.text.toString().toInt() > 0 ) {
                    while (textViewThuhurNow.text.toString().toInt() > 0) {
                        textViewThuhur.text = (textViewThuhur.text.toString().toInt() + 1).toString()
                        textViewThuhurNow.text = (textViewThuhurNow.text.toString().toInt() - 1).toString()
                    }
                }
            }
            if (textViewAsirNow.text.toString().toInt() > 0) {
                if (textViewAsir.text.toString().toInt() > 0 ) {
                    while (textViewAsirNow.text.toString().toInt() > 0) {
                        textViewAsir.text = (textViewAsir.text.toString().toInt() + 1).toString()
                        textViewAsirNow.text = (textViewAsirNow.text.toString().toInt() - 1).toString()
                    }
                }
            }
            if (textViewMagribNow.text.toString().toInt() > 0) {
                if (textViewMagrib.text.toString().toInt() > 0 ) {
                    while (textViewMagribNow.text.toString().toInt() > 0) {
                        textViewMagrib.text = (textViewMagrib.text.toString().toInt() + 1).toString()
                        textViewMagribNow.text = (textViewMagribNow.text.toString().toInt() - 1).toString()
                    }
                }
            }
            if (textViewIshaaNow.text.toString().toInt() > 0) {
                if (textViewIshaa.text.toString().toInt() > 0 ) {
                    while (textViewIshaaNow.text.toString().toInt() > 0) {
                        textViewIshaa.text = (textViewIshaa.text.toString().toInt() + 1).toString()
                        textViewIshaaNow.text = (textViewIshaaNow.text.toString().toInt() - 1).toString()
                    }
                }
            }

        }
        buttonSave.setOnClickListener {
            val Kathaaemp = Kathaa(1, "250", "250", "250", "250", "250")
            Kathaaemp.uid = 1
            Kathaaemp.Subuh = textViewSubuh.text.toString()
            Kathaaemp.Thuhur = textViewThuhur.text.toString()
            Kathaaemp.Asir = textViewAsir.text.toString()
            Kathaaemp.Magrib = textViewMagrib.text.toString()
            Kathaaemp.Ishaa = textViewIshaa.text.toString()
            database.kathaaDao().updateKathaa(Kathaaemp)
            textViewSubuhNow.text = "0"
            textViewThuhurNow.text = "0"
            textViewAsirNow.text = "0"
            textViewMagribNow.text = "0"
            textViewIshaaNow.text = "0"
            showMessage("تم خزن المعلومات...")
        }
        buttonFullDay.setOnClickListener {
            if (textViewSubuh.text == "0" || textViewThuhur.text == "0" ||
                textViewAsir.text == "0" || textViewMagrib.text == "0" ||
                textViewIshaa.text == "0"
            ) {
                showMessage("قضاء اليوم الكامل يجب ان تكون الفروض كلها فيها قضاء...")
            } else {
                textViewSubuh.text = Get_Decremented_Number(textViewSubuh.text.toString())
                textViewThuhur.text = Get_Decremented_Number(textViewThuhur.text.toString())
                textViewAsir.text = Get_Decremented_Number(textViewAsir.text.toString())
                textViewMagrib.text = Get_Decremented_Number(textViewMagrib.text.toString())
                textViewIshaa.text = Get_Decremented_Number(textViewIshaa.text.toString())
                textViewSubuhNow.text = Get_Incremented_Number(textViewSubuhNow.text.toString())
                textViewThuhurNow.text = Get_Incremented_Number(textViewThuhurNow.text.toString())
                textViewAsirNow.text = Get_Incremented_Number(textViewAsirNow.text.toString())
                textViewMagribNow.text = Get_Incremented_Number(textViewMagribNow.text.toString())
                textViewIshaaNow.text = Get_Incremented_Number(textViewIshaaNow.text.toString())
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val database =
            Room.databaseBuilder(this, KathaaDatabase::class.java, "kathaa_database2")
                .allowMainThreadQueries()
                .build()
        fill_totalK_fields(database)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menuEdit -> {
                val intent = Intent(this, Activity2::class.java)
                startActivity(intent)
                return true
            }
            R.id.shareNumbers -> {
                val s = "فجر = " + textViewSubuh.text.toString() + "\n" +
                        "ظهر = " + textViewThuhur.text.toString() + "\n" +
                        "عصر = " + textViewAsir.text.toString() + "\n" +
                        "مغرب = " + textViewMagrib.text.toString() + "\n" +
                        "عشاء = " + textViewIshaa.text.toString()
                //Intent to share the text
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(Intent.createChooser(shareIntent, "Share via"))
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showMessage(msg: String) {
        Snackbar.make(root_layout, msg, Snackbar.LENGTH_SHORT).show()
    }

    fun fill_totalK_fields(db1: KathaaDatabase) {
        val listKathha = db1.kathaaDao().getKathaa()
        listKathha.forEach {
            textViewSubuh.text = it.Subuh
            textViewThuhur.text = it.Thuhur
            textViewAsir.text = it.Asir
            textViewMagrib.text = it.Magrib
            textViewIshaa.text = it.Ishaa
            textViewSubuhNow.text = "0"
            textViewThuhurNow.text = "0"
            textViewAsirNow.text = "0"
            textViewMagribNow.text = "0"
            textViewIshaaNow.text = "0"
        }
    }
}

