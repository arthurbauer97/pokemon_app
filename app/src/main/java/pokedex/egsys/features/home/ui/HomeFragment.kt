package pokedex.egsys.features.home.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.Job
import org.koin.androidx.viewmodel.ext.android.viewModel
import pokedex.egsys.PokemonDetails
import pokedex.egsys.R
import pokedex.egsys.databinding.FragmentHomeBinding
import pokedex.egsys.features.home.PokemonClickListener
import pokedex.egsys.features.home.model.HomeViewModel
import pokedex.egsys.model.responses.PokemonDataResponse

class HomeFragment : Fragment(), PokemonClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()

    var listPokemons : List<PokemonDataResponse> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater)

        initListener()

        return binding.root
    }

    private fun initListener() {

        if (listPokemons.isEmpty()){
            getPokemons()
        }else{
            setAdapter(listPokemons)
        }

        binding.tietFilter.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length != 0){
                  val filtered = listPokemons.filter { it.name.contains(s.toString().toLowerCase())}
                    setAdapter(filtered)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun setAdapter(pokemons : List<PokemonDataResponse>){
        var adapter = context?.let { context -> HomePokemonsAdapter(pokemons, context,this@HomeFragment) }
        binding.rvPokemons.adapter = adapter
        binding.rvPokemons.layoutManager = GridLayoutManager(context, 2)
    }

    private fun getPokemons() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvLoading.visibility = View.VISIBLE

        for (i in 1..898) {
            viewModel.getPokemonsData(i)
        }

        viewModel.resultDataPokemons.observe(
            viewLifecycleOwner, Observer {
                if (it.size == 898) {
                    binding.progressBar.visibility = View.GONE
                    binding.tvLoading.visibility = View.GONE

                    listPokemons = it
                    setAdapter(listPokemons)
                }
            }
        )
    }

    override fun onPokemonClick(pokemon: PokemonDataResponse) {
        PokemonDetails.setDetailsPokemon(pokemon)

        findNavController().navigate(R.id.FragmentDetails)
    }
}