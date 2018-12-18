package joco.com.advancedrecpk1

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import joco.com.advancedrecpk1.R.id.message
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var listItems = arrayListOf<Item>()
        listItems.add(Item("1",1,"Brown"))
        listItems.add(Item("2",5,"Yellow"))
        listItems.add(Item("3",20,"Purple"))
        listItems.add(Item("4",15,"Black"))


        val itemClickListener = object : OnListItemClickMessageListener {
            override fun onItemClicked(message: String) {
                toast(message)
            }
        }

        rcvAdvRc1.adapter = ItemBaseAdapter(listItems,itemClickListener )
        rcvAdvRc1.layoutManager = LinearLayoutManager(this)




    }







}
