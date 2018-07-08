package thiengo.com.br.pablopicasso

import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_top_bar.*

/*
 * A MainActivity contém métodos comuns em mais de uma atividade do
 * projeto, ou seja, ela será a atividade pai dessas outras atividades,
 * por isso a definição open e também a não necessidade de defini-la
 * no AndroidManifest.xml do projeto.
 * */
open class MainActivity : AppCompatActivity() {

    fun setAppBarHeight() {
        // Toolbar é sempre 56dp de altura, no Android.
        val heightToolbar = dpToPixel(56)

        val heightTopBar = getStatusBarHeight() + heightToolbar
        val layoutParams = CoordinatorLayout
            .LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                heightTopBar
            )

        app_bar.setLayoutParams( layoutParams )
    }

    /*
     * O algoritmo abaixo é necessário, pois o tamanho do statusBar em
     * aparelhos Android pode variar.
     * */
    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources
            .getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )

        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    /*
     * Método responsável por converter um número inteiro bruto
     * (representando os DPs) para o equivalente em pixels.
     * */
    private fun dpToPixel(dp: Int): Int {
        val density = resources.displayMetrics.density
        return Math.round( dp.toFloat() * density )
    }
}
