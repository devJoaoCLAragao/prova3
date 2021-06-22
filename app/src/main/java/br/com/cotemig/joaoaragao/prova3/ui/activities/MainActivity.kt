package br.com.cotemig.joaoaragao.prova3.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.cotemig.joaoaragao.prova3.R
import br.com.cotemig.joaoaragao.prova3.ui.fragment.LibraryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(LibraryFragment.newInstance())
    }

    fun setFragment(fragment: Fragment) {
        var ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.content, fragment)
        ft.commit()
    }
}