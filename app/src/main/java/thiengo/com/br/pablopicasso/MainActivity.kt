package thiengo.com.br.pablopicasso

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_paintings.*
import thiengo.com.br.pablopicasso.domain.Painting
import android.view.ViewGroup
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.AppBarLayout
import android.util.Log
import thiengo.com.br.pablopicasso.data.Database


open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setAppBarHeight() {
        val size = dpToPx(56)
        app_bar.setLayoutParams(
            CoordinatorLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
        getStatusBarHeight() + dpToPx(56) // Toolbar é sempre 56dp, no Android.
            )
        )
    }

    private fun getStatusBarHeight(): Int {
        var result = 0
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId)
        }
        return result
    }

    private fun dpToPx(dp: Int): Int {
        val density = resources
                .displayMetrics
                .density
        return Math.round(dp.toFloat() * density)
    }
}
