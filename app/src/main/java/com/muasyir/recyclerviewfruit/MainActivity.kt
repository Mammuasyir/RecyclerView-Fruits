package com.muasyir.recyclerviewfruit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaBuah =
            arrayOf("Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry")

        val gambarBuah = arrayOf(
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
        )
        val suaraBuah = arrayOf(
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambu_air,
            R.raw.manggis,
            R.raw.rodhi
        )
        val buahAdapter = BuahAdapter(namaBuah, gambarBuah, suaraBuah)
        rv_buah.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
//yang ini biar layouot ny kebagi 2
//            layoutManager = GridLayoutManager(this@MainActivity, 2)
            setHasFixedSize(true)
            adapter = buahAdapter
        }
    }

    //    call Layout Menu Buat opsi grid atau list
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_grid) {
            rv_buah.layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        if (item.itemId == R.id.menu_list) {
            rv_buah.layoutManager = LinearLayoutManager(this@MainActivity)
        }
        return super.onOptionsItemSelected(item)
    }


}