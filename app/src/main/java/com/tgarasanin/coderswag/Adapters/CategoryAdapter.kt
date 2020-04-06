package com.tgarasanin.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.tgarasanin.coderswag.Model.Category
import com.tgarasanin.coderswag.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.category_list_item.view.*

class CategoryAdapter (context: Context, categories: List<Category>): BaseAdapter() {

    val context = context
    val categories = categories

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holderView: ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holderView = ViewHolder()
            holderView.categoryImage = categoryView.imageView
            holderView.categoryName = categoryView.textView

            categoryView.tag = holderView
        } else {
            holderView = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        holderView.categoryName?.text = category.title
        val resourceId =
            context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holderView.categoryImage?.setImageResource(resourceId)
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

    private class ViewHolder {
        var categoryImage: ImageView? = null
        var categoryName: TextView? = null

    }


}