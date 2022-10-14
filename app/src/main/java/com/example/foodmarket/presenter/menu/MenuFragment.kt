package com.example.foodmarket.presenter.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.foodmarket.R

import com.example.foodmarket.databinding.FragmentMenuBinding
import com.example.foodmarket.entity.MarketingItem
import com.example.foodmarket.entity.TypeFoodItem
import com.example.foodmarket.presenter.menu.rcFood.AdapterFood
import com.example.foodmarket.presenter.menu.rcMarketing.AdapterMarketing
import com.example.foodmarket.presenter.menu.rcTypeFood.AdapterTypeFood
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null

    @Inject
    lateinit var menuFactory: MenuViewModelFactory
    private val menuViewModel: MenuViewModel by viewModels { menuFactory }
    private val binding get() = _binding!!
    private val adapterMarketing = AdapterMarketing()
    private val adapterFood = AdapterFood()
    private val adapterTypeFood = AdapterTypeFood()
    private val listMarketing = listOf<MarketingItem>(
        MarketingItem(1, R.drawable.market2),
        MarketingItem(2, R.drawable.market2),
        MarketingItem(3, R.drawable.market_3)
    )
    private val listTypeFood = listOf<TypeFoodItem>(
        TypeFoodItem(1, "Пицца"),
        TypeFoodItem(2, " Напитики"),
        TypeFoodItem(3, "Десерты"),
        TypeFoodItem(4, "Комбо"),
        TypeFoodItem(5, "Сувениры")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val root: View = binding.root
        menuViewModel.getPizza()


        binding.rcMarketing.adapter = adapterMarketing
        binding.rcTypeFood.adapter = adapterTypeFood
        binding.rcFood.adapter = adapterFood
        adapterMarketing.submitList(listMarketing)
        adapterTypeFood.submitList(listTypeFood)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            menuViewModel.state.collect {
                when (it) {
                    is State.Error -> {

                    }
                    State.Loading -> {}
                    is State.Success -> {
                        adapterFood.submitList(it.listPizza)
                    }
                }
            }

        }




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}