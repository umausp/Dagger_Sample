package com.tb.balheroquiz.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tb.dagger.BeerDataAdapter
import com.tb.dagger.TestViewModel
import com.tb.dagger.databinding.FragmentMainBinding
import com.tb.dagger.model.BeerDataModelItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaceholderFragment : Fragment() {

    private val viewModel: TestViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val root = binding.root
        setUpUI()
        setUpObservers()

        return root
    }

    private fun setUpUI() {
        binding.beerRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = BeerDataAdapter(arguments?.getInt(ARG_SECTION_NUMBER) ?: 0)
            addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }
    }

    private fun setUpObservers() {
        viewModel.beerLiveData.observe(viewLifecycleOwner, { countryList ->
            countryList?.let {
                binding.beerRecyclerview.apply {
                    with(adapter as BeerDataAdapter) {
                        data = it as ArrayList<BeerDataModelItem>
                        data[2] = BeerDataModelItem("https://static.wixstatic.com/media/863502_6c4f8b4d799b4f3baf57b956bf1dc8d1~mv2.png/v1/fit/w_2500,h_1330,al_c/863502_6c4f8b4d799b4f3baf57b956bf1dc8d1~mv2.png", data[2].name)
                        notifyDataSetChanged()
                    }
                }
            }
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}