package br.com.cotemig.joaoaragao.prova3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.cotemig.joaoaragao.prova3.R
import br.com.cotemig.joaoaragao.prova3.model.ListPlaylist
import br.com.cotemig.joaoaragao.prova3.service.RetrofitInitializer
import br.com.cotemig.joaoaragao.prova3.ui.adapters.LibraryAdapter
import kotlinx.android.synthetic.main.fragment_library.*
import retrofit2.Call
import retrofit2.Response

class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_library, container, false)

        getPlaylist(view)

        return view
    }

    companion object {
        fun newInstance(): LibraryFragment {
            return LibraryFragment()
        }
    }

    fun getPlaylist(view: View) {
        var service = RetrofitInitializer().servicePlaylist()
        var call = service.getPlaylist()

        call.enqueue(object : retrofit2.Callback<List<ListPlaylist>> {
            override fun onResponse(
                call: Call<List<ListPlaylist>>,
                response: Response<List<ListPlaylist>>
            ) {
                if (response.code() == 200) {
                    response.body()?.let {
                        showLibrary(view, it)
                    }
                }
            }

            override fun onFailure(call: Call<List<ListPlaylist>>, t: Throwable) {
                Toast.makeText(context, "Deu Ruim, corre Dirceu!!!", Toast.LENGTH_LONG).show()
            }
        })
    }

    fun showLibrary(view: View, list: List<ListPlaylist>) {
        recyclerViewLibrary.adapter = LibraryAdapter(context!!, list)
        recyclerViewLibrary.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
    }

}