package br.com.cotemig.joaoaragao.prova3.model

import java.io.Serializable

class Playlist (
    var artist : String = "",
    var year : String = "",
    var thumb : String = "",
    var album : String = "",
    var length : Int = 0,
    var id : String = "",
    var title : String = ""

) : Serializable