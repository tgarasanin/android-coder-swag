package com.tgarasanin.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.tgarasanin.coderswag.Adapters.CategoryAdapter
import com.tgarasanin.coderswag.R
import com.tgarasanin.coderswag.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = CategoryAdapter(this, DataService.categories)
        categoryListView.adapter = adapter
    }
}
