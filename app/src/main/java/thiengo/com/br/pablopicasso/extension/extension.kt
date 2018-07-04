package thiengo.com.br.pablopicasso.extension

import android.widget.ImageView
import thiengo.com.br.pablopicasso.R

/*
 * Extensão realizada, pois o mesmo algoritmo, vinculado
 * somente aos ImageViews do projeto, terá de ser utilizado
 * em contextos diferentes, assim evitamos a repetição de
 * código.
 * */
fun ImageView.setStar(rating: Double, position: Int){
    val ceil = Math.ceil(rating)
    val floor = Math.floor(rating)

    val starId = when{
        position <= floor -> R.drawable.ic_star_white_24dp
        position <= ceil -> R.drawable.ic_star_half_white_24dp
        else -> R.drawable.ic_star_outline_white_24dp
    }
    this.setImageResource( starId )
}