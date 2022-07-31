package com.example.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.foody.R

class RecipesRowBinding {

    companion object{

        @BindingAdapter("loadingImageFromUrl")
        @JvmStatic
        fun loadingImageFromUrl(imageView: ImageView, imageUrl: String){
            imageView.load(imageUrl){
                crossfade(600)
                error(R.drawable.ic_error_placeholder)
            }
        }

        @BindingAdapter("setNumberOfLike")
        @JvmStatic
        fun setNumberOfLike(textView: TextView, likes: Int){
            textView.text = likes.toString()
        }

        @BindingAdapter("setNumberOfMinute")
        @JvmStatic
        fun setNumberOfMinute(textView: TextView, minutes: Int){
            textView.text = minutes.toString()
        }

        @BindingAdapter("applyingVeganColor")
        @JvmStatic
        fun applyingVeganColor(view: View, vegan : Boolean){
            if(vegan){
                when(view){
                    is TextView ->{
                        view.setTextColor(
                            ContextCompat.getColor(
                                view.context,
                                R.color.green
                            )
                        )
                    }
                    is ImageView ->{
                    view.setColorFilter(
                        ContextCompat.getColor(
                            view.context,
                            R.color.green
                            )
                        )
                    }
                }
            }
        }
    }
}