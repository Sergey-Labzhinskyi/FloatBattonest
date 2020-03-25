package com.example.floatbattonest


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var linearadapter: Adapter
    var list = mutableListOf<UrlModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_main)

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        linearadapter = Adapter(list, this)
        recyclerView.adapter = linearadapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        createList()

    }

    class Adapter(var items: List<UrlModel>, val c: Context) :
        RecyclerView.Adapter<Adapter.MainHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )

        override fun getItemCount() = items.size
        override fun onBindViewHolder(holder: MainHolder, position: Int) {
            holder.bind(items[position])
        }

        inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val title = itemView.findViewById<TextView>(R.id.list_title)
            private val url = itemView.findViewById<TextView>(R.id.list_url)

            fun bind(urlModel: UrlModel) {
                title.text = urlModel.title
                url.text = urlModel.url

                itemView.setOnClickListener {

                   // Log.d("Adapter", "setOnClickListener")
                    val intent = Intent(c, WebViewActivity::class.java)
                    intent.putExtra("URL", urlModel.url)
                    startActivity(c, intent, null)
                }
            }
        }




    }

    private fun createList() {
        list.add(UrlModel("https://www.spotify.com", "Spotify"))
        list.add(UrlModel("https://www.netflix.com", "Netflix"))
        list.add(UrlModel("https://www.instagram.com", "Instagram"))
        list.add(UrlModel("https://www.facebook.com", "Facebook"))
        list.add(UrlModel("https://www.messenger.com", "Facebook Messenger"))
        list.add(UrlModel("https://www.whatsapp.com", "WhatsApp"))
        list.add(UrlModel("https://www.youtube.com", "Youtube"))
        list.add(UrlModel("https://www.google.com", "Google"))
        list.add(UrlModel("https://messages.google.com", "Android Messeges"))
        //list.add(UrlModel("https://messages.google.com/web/authentication", "Android Messeges"))
        list.add(UrlModel("https://translate.google.com", "Google Translate"))
        list.add(UrlModel("https://calendar.google.com", "Google Calendar"))
        list.add(UrlModel("https://www.msn.com", "MSN"))


    }
}
