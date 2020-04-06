package com.tgarasanin.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.tgarasanin.coderswag.Model.Category
import com.tgarasanin.coderswag.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter (context: Context, categories: List<Category>): BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var categoryView: View
        categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
        val category = categories[position]
        categoryView.textView.text = category.title
        val resourceId =
            context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryView.imageView.setImageResource(resourceId)
        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

}