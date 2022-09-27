package com.example.uana

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uana.adapter.ProdutoAdapter
import com.example.uana.databinding.FragmentProdutoBinding
import com.example.uana.model.Produto


class ProdutoFragment : Fragment() {

    private lateinit var binding: FragmentProdutoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProdutoBinding.inflate(layoutInflater, container, false)

        val listProduto = listOf<Produto>(
            Produto(
                "Sabonete",
                "Cheiro floral",
                12345,
                "R$2.50",
                "imagemlegal.com",
                5,
                "Higiene"

            ),
            Produto(
                "Shampoo em barra",
                "Shampoo de babosa em barra",
                54321,
                "R$10.0",
                "imagemlegal2.com",
                5,
                "Higiene"

            ),
            Produto(
                "Condicionador em barra",
                "Condicionador de babosa em barra",
                43125,
                "R$10.0",
                "imagemlegal3.com",
                5,
                "Higiene"

            )

        )

        val adapter = ProdutoAdapter()
        binding.recyclerProduto.layoutManager = LinearLayoutManager(context)
        binding.recyclerProduto.adapter = adapter
        binding.recyclerProduto.setHasFixedSize(true)

        adapter.setList(listProduto)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_produtoFragment_to_formFragment)
        }

        // Inflate the layout for this fragment
        return binding.root
    }



}