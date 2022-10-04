package com.example.uana


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.uana.databinding.FragmentFormBinding
import com.example.uana.model.Categoria
import com.example.uana.model.Produto


class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {


        binding = FragmentFormBinding.inflate(layoutInflater, container, false)

        mainViewModel.myCategoriaResponse.observe(viewLifecycleOwner) { response ->
            Log.d("Requisicao", response.body().toString())
            spinnerCategoria(response.body())
        }

        binding.buttonSalvar.setOnClickListener {
            inserirNaLista()
        }

        binding.buttonCancelar.setOnClickListener {
            findNavController().navigate(R.id.action_formFragment_to_produtoFragment)
        }


        return binding.root
    }


    private fun validarCampos(
        nome: String,
        descricao: String,
        preco: String,
        imagemProduto: String,
        estoque: Int

    ): Boolean {

        return !((nome == "" || nome.length < 3 || nome.length > 20) ||
                (descricao == "" || descricao.length < 5 || descricao.length > 300) ||
                (preco == "" || preco <= 0.toString() || preco.length > 5) ||
                (imagemProduto == "" || imagemProduto.length < 10) ||
                (estoque < 0))

    }

    private fun inserirNaLista() {

        val nome = binding.nome.text.toString()
        val desc = binding.descricao.text.toString()
        val price = binding.preco.text.toString()
        val imagem = binding.imagemProduto.text.toString()
        val estoq = binding.estoque.text.toString().toInt()


        if (validarCampos(nome, desc, price, imagem, estoq)) {

            Toast.makeText(context, "Produto criado", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_formFragment_to_produtoFragment)

        } else {

            Toast.makeText(context, "Verifique os campos", Toast.LENGTH_SHORT).show()

        }
    }

    private fun spinnerCategoria(listCategoria: List<Categoria>?) {

        if(listCategoria != null){
            binding.spinnerCategoria.adapter =
                ArrayAdapter(
                    requireContext(),
                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                    listCategoria
                )
        }

    }


}
