package joco.com.advancedrecpk1

import android.media.ImageReader
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.h6ah4i.android.widget.advrecyclerview.utils.RecyclerViewAdapterUtils
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils
import kotlinx.android.synthetic.main.item_layout.view.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class ItemBaseAdapter (val itemList : List<Item>, val itemClickListener: OnListItemClickMessageListener) : RecyclerView.Adapter<ItemBaseAdapter.ItemHolder>(), View.OnClickListener , AnkoLogger{

    override fun onClick(view: View) {
        val rcv = RecyclerViewAdapterUtils.getParentRecyclerView(view)
        val vh = rcv!!.findContainingViewHolder(view)

        val rootPosition = vh!!.adapterPosition
        if (rootPosition == RecyclerView.NO_POSITION) {
            return
        }

        val rootAdapter = rcv.adapter
        var localPosition = WrapperAdapterUtils.unwrapPosition(rootAdapter!!,this,rootPosition)

        var message = "Clicked item $localPosition"

        if (itemClickListener != null) {
           itemClickListener.onItemClicked(message)
            info { "$message clicked" }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = itemList[position]
        holder.itemAge.text = item.age.toString()
        holder.itemName.text = item.name
        holder.itemColor.text = item.colour
    }

    override fun getItemCount() = itemList.size


    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemName = itemView.tvName
        val itemAge = itemView.tvAge
        val itemColor = itemView.tvColor

    }
}
