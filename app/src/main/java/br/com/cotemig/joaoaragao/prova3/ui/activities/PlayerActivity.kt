package br.com.cotemig.joaoaragao.prova3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cotemig.joaoaragao.prova3.R
import br.com.cotemig.joaoaragao.prova3.model.Playlist
import coil.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        var playlist = intent.getSerializableExtra("item") as Playlist

        showPlayer(playlist)
    }

    fun showPlayer(details : Playlist){

        thumb.load(details.thumb){
            transformations(RoundedCornersTransformation(20f))
        }
        artist.text = details.artist
        music.text = details.title
    }
}