package com.example.foody.ui.fragments.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import coil.load
import com.example.foody.R
import com.example.foody.bindingadapters.RecipesRowBinding
import com.example.foody.databinding.FragmentOverviewBinding
import com.example.foody.models.Result
import kotlinx.android.synthetic.main.fragment_overview.view.*
import org.jsoup.Jsoup

class OverviewFragment : Fragment() {

    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       _binding =  FragmentOverviewBinding.inflate(inflater, container, false)

        val args =  arguments
        val myBundle : Result = args!!.getParcelable<Result>("recipeBundle") as Result

        binding.mainImageView.load(myBundle?.image)
        binding.titleTextView.text = myBundle?.title
        binding.likesTextView.text = myBundle?.aggregateLikes.toString()
        binding.timeTextView.text = myBundle?.readyInMinutes.toString()
        RecipesRowBinding.parseHtml(binding.summaryTextView,  myBundle.summary)

        // myBundle?.summary.let{
        //      val summary = Jsoup.parse(it).text()
        //      view.summary_text = summary
        // } last version method for data binding

        updateColors(myBundle.vegetarian,binding.vegetarianTextView,binding.vegetarianImageView)
        updateColors(myBundle.vegan,binding.veganTextView,binding.vegetarianImageView)
        updateColors(myBundle.glutenFree,binding.glutenFreeTextView,binding.glutenFreeImageView)
        updateColors(myBundle.dairyFree,binding.dairyFreeTextView,binding.dairyFreeImageView)
        updateColors(myBundle.veryHealthy,binding.healthTextView,binding.healthImageView)
        updateColors(myBundle.cheap,binding.cheapTextView,binding.cheapImageView)

        return binding.root
    }

    private fun updateColors(stateIsOn: Boolean, textView: TextView, imageView:ImageView){
        if(stateIsOn){
            textView.setTextColor(ContextCompat.getColor(requireContext(),R.color.green))
            imageView.setColorFilter(ContextCompat.getColor(requireContext(),R.color.green))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}