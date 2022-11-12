package com.abrahamgudratli.androidfundamentals5

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myList = listOf<String>("First", "Second", "Third", "Forth")
        val adapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myList)
        svMonths.adapter = adapter

        svMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                if (p0 != null) {
                    Toast.makeText(this@MainActivity, "We selected ${p0.getItemAtPosition(p2).toString()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        val alert = AlertDialog.Builder(this)
            .setTitle("Remove Contact")
            .setMessage("Do you want to remove Ibrahim Strange from your friends list?")
            .setIcon(R.drawable.ic_remove_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "Ibrahim Strange was removed", Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(this, "Ibrahim Strange was not removed", Toast.LENGTH_LONG).show()
            }
            .setNeutralButton("Cancel") { _, _ ->
                Toast.makeText(this, "Operation was canceled", Toast.LENGTH_LONG).show()
            }
            .create()


        buttonTestAlert.setOnClickListener {
            alert.show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sample_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.ivAddContact -> Toast.makeText(this, "Add Contact is selected", Toast.LENGTH_LONG).show()
            R.id.ivFavorites -> Toast.makeText(this, "Favorite is selected", Toast.LENGTH_LONG).show()
            R.id.ivFeedBack -> Toast.makeText(this, "Feedback is selected", Toast.LENGTH_LONG).show()
            R.id.ivSettings -> Toast.makeText(this, "Settings is selected", Toast.LENGTH_LONG).show()
        }
        return true
    }


}