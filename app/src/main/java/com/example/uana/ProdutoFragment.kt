package com.example.uana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uana.adapter.ProdutoAdapter
import com.example.uana.databinding.FragmentProdutoBinding
import com.example.uana.model.Produto


class ProdutoFragment : Fragment() {

    private lateinit var binding: FragmentProdutoBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProdutoBinding.inflate(layoutInflater, container, false)


        val adapter = ProdutoAdapter()
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_produtoFragment_to_formFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}