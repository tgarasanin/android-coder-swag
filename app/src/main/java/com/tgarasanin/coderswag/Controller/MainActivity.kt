package com.tgarasanin.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.tgarasanin.coderswag.Adapters.CategoryAdapter
import com.tgarasanin.coderswag.Adapters.CategoryRecyclerAdapter
import com.tgarasanin.coderswag.R
import com.tgarasanin.coderswag.Services.DataService
import com.tgarasanin.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecyclerAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryRecyclerAdapter(this, DataService.categories) { category ->
            Log.d("TAG", category.title)
            val productIntent = Intent(this, ProductsActivity::class.java).putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }

        layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        categoryRecyclerView.adapter = adapter
        categoryRecyclerView.layoutManager = layoutManager
        categoryRecyclerView.setHasFixedSize(true)
    }




}
