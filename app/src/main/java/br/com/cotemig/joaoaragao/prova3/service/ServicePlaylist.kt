package br.com.cotemig.joaoaragao.prova3.service

import br.com.cotemig.joaoaragao.prova3.model.ListPlaylist
import retrofit2.Call
import retrofit2.http.GET

interface ServicePlaylist {

    @GET("playlist/top10")
    fun getPlaylist(): Call<List<ListPlaylist>>
}