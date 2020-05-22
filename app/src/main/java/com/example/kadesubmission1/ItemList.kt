package com.example.kadesubmission1

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.*

class ItemList : AnkoComponent<ViewGroup> {

    @SuppressLint("NewApi")
    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        verticalLayout {
            padding = dip(8)
            lparams(width = matchParent, height = wrapContent)
            background = GradientDrawable().apply {
                shape = GradientDrawable.RECTANGLE
                cornerRadius = 8f
                setStroke(1, Color.LTGRAY)
            }

            imageView{
                id = R.id.imgId
                padding = dip(8)
            }.lparams(width = dip(100), height = dip(100)){
                gravity = Gravity.CENTER
            }

            textView {
                id = R.id.nameId
                textColor = Color.DKGRAY
                textAlignment = View.TEXT_ALIGNMENT_CENTER
            }.lparams(width = wrapContent, height = wrapContent){
                gravity = Gravity.CENTER
            }
        }
    }
}