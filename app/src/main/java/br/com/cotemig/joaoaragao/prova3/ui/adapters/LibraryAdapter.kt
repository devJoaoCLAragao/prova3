package br.com.cotemig.joaoaragao.prova3.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.joaoaragao.prova3.R
import br.com.cotemig.joaoaragao.prova3.model.ListPlaylist

class LibraryAdapter(var context: Context, var list: List<ListPlaylist>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.item_library, parent, false)
        return LibraryHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LibraryHolder).bind(context, list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LibraryHolder(var view: View) : RecyclerView.ViewHolder(view) {
        fun bind(context: Context, listPlaylist: ListPlaylist) {

            var name = view.findViewById<TextView>(R.id.name)
            name.text = listPlaylist.name

            var recyclerViewItemLibrary =
                view.findViewById<RecyclerView>(R.id.recyclerViewItemLibrary)
            recyclerViewItemLibrary.adapter = MusicAdapter(context, listPlaylist.playlist)
            recyclerViewItemLibrary.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewItemLibrary.onFlingListener = null
            //var snapHelper = PagerSnapHelper()
            //snapHelper.attachToRecyclerView(recyclerViewItemLibrary)


        }
    }
}