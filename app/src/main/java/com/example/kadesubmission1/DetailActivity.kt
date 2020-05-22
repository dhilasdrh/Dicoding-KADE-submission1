package com.example.kadesubmission1

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = intent.getParcelableExtra<Item>("EXTRA_ITEM")
        DetailActivityUI(items).setContentView(this)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = items?.name
    }

    class DetailActivityUI(private val parcel: Item) : AnkoComponent<DetailActivity> {
        @SuppressLint("NewApi")
        override fun createView(ui: AnkoContext<DetailActivity>) = with(ui) {
            scrollView {
                verticalLayout{
                    bottomPadding = dip(10)

                    imageView {
                        backgroundResource = R.color.colorPrimary
                    }.lparams(width = matchParent, height = dip(125))

                    imageView {
                        imageResource = parcel.image!!
                    }.lparams(width= dip(125),height = dip(125)){
                        gravity = Gravity.CENTER
                        topMargin = dip(-70)
                    }

                    textView {
                        textAlignment = View.TEXT_ALIGNMENT_CENTER
                        textColor = Color.BLACK
                        typeface = Typeface.DEFAULT_BOLD
                        text = "${parcel.name}"
                        textSize = 17f
                    }.lparams(width = matchParent, height = wrapContent) {
                        gravity = Gravity.CENTER_VERTICAL
                        topMargin = dip(10)
                        bottomMargin = dip(10)
                    }

                    textView {
                        text = "${parcel.desc}"
                        textColor = Color.DKGRAY
                        leftPadding = dip(8)
                        rightPadding = dip(8)
                    }.lparams(width = matchParent, height = wrapContent) {
                        topMargin = dip(8)
                    }
                }
            }
        }
    }
}
