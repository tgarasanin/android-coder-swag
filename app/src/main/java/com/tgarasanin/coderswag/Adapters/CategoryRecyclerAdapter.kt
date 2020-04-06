package com.tgarasanin.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tgarasanin.coderswag.Model.Category
import com.tgarasanin.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryRecyclerAdapter(val context: Context, val categories: List<Category>) : RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryHolder>() {

    inner class CategoryHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            itemView.imageView.setImageResource(resourceId)
            itemView.textView.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return CategoryHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category = categories[position]
        holder?.bindCategory(category, context)
    }


}