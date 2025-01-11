package com.aman.customlayoutsapplication

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.aman.customlayoutsapplication.databinding.AppToolbarBinding

class AppToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyle, defStyleRes) {

    private var binding: AppToolbarBinding =
        AppToolbarBinding.inflate(LayoutInflater.from(context), this)
    private var showRightIcon: Boolean = false
    private var showLeftIcon: Boolean = true
    private var textCaps: Boolean = true
    private var rightIcon : Drawable? = null

    init {

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.AppToolbar)
            val title = typedArray.getString(R.styleable.AppToolbar_title)
            showRightIcon = typedArray.getBoolean(R.styleable.AppToolbar_showRightIcon, false)
            showLeftIcon = typedArray.getBoolean(R.styleable.AppToolbar_showLeftIcon, true)
            rightIcon = typedArray.getDrawable(R.styleable.AppToolbar_rightIcon)

            binding.tvTitle.text = title
            binding.tvTitle.isAllCaps = textCaps
            showHideRightIcon(showRightIcon)

            if(showLeftIcon){
                binding.ivBack.visibility = View.VISIBLE
            } else {
                binding.ivBack.visibility = View.GONE
            }

            if (rightIcon != null) {
                val bitmap = (rightIcon as BitmapDrawable).bitmap
                val d: Drawable = BitmapDrawable(
                    resources,
                    Bitmap.createScaledBitmap(bitmap, 24, 24, true)
                )
                binding.ivMenu.setImageDrawable(d)
            }

            typedArray.recycle()
        }
    }

    fun setTitle(title: String) {
        binding.tvTitle.text = title
    }

    fun onBackClicked(onClick: (View) -> Unit) {
        binding.ivBack.setOnClickListener { onClick(it) }
    }

    fun updateRightIcon(value: Drawable){
        val bitmap = (value as BitmapDrawable).bitmap
        val d: Drawable = BitmapDrawable(
            resources,
            Bitmap.createScaledBitmap(bitmap, 24, 24, true)
        )
        binding.ivMenu.setImageDrawable(d)
    }

    fun onRightIconClicked(onClick: (View) -> Unit){
        binding.ivMenu.setOnClickListener {
            onClick(it)
        }
    }

    private fun showHideRightIcon(isShow : Boolean) {
        if(isShow){
            binding.ivMenu.visibility = View.VISIBLE
        } else {
            binding.ivMenu.visibility = View.GONE
        }
    }
}