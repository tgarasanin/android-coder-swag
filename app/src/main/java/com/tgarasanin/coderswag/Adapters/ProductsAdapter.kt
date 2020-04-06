package com.tgarasanin.coderswag.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tgarasanin.coderswag.Model.Product
import com.tgarasanin.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*
import kotlinx.android.synthetic.main.product_list_item.view.*
import java.util.zip.Inflater

class ProductsAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindProduct(context: Context, product: Product) {
            val resourceId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            itemView.logoImageView.setImageResource(resourceId)
            itemView.titleTextView.text = product.title
            itemView.priceTextView.text = product.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        val product = products[position]
        holder.bindProduct(context, product)
    }

}