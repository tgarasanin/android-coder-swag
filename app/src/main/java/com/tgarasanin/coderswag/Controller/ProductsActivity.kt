package com.tgarasanin.coderswag.Controller

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tgarasanin.coderswag.Adapters.ProductsAdapter
import com.tgarasanin.coderswag.R
import com.tgarasanin.coderswag.Services.DataService
import com.tgarasanin.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var productAdapter: ProductsAdapter
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val category = intent.getStringExtra(EXTRA_CATEGORY)

        productAdapter = ProductsAdapter(this, DataService.getProducts(category))
        productsRecyclerView.adapter = productAdapter

        val orientation = resources.configuration.orientation
        var spanCount = 2
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3
        }

        layoutManager = GridLayoutManager(this, spanCount)
        productsRecyclerView.layoutManager = layoutManager
    }
}
