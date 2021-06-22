package br.com.cotemig.joaoaragao.prova3.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.cotemig.joaoaragao.prova3.R
import br.com.cotemig.joaoaragao.prova3.model.ListPlaylist
import br.com.cotemig.joaoaragao.prova3.service.RetrofitInitializer
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
                        Toast.makeText(context, "Deu bom porra!!", Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<List<ListPlaylist>>, t: Throwable) {
                Toast.makeText(context, "Deu Ruim, corre", Toast.LENGTH_LONG).show()
            }
        })
    }

}