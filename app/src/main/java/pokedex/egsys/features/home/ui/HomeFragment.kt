package pokedex.egsys.features.home.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import org.koin.androidx.viewmodel.ext.android.viewModel
import pokedex.egsys.R
import pokedex.egsys.databinding.FragmentHomeBinding
import pokedex.egsys.features.home.listener.PokemonClickListener
import pokedex.egsys.features.home.viewModel.HomeViewModel
import pokedex.egsys.model.PokemonDataResponse
import pokedex.egsys.model.PokemonDetails
import pokedex.egsys.model.ResultName

class HomeFragment : Fragment(), PokemonClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()

    var listAllPokemons = mutableListOf<ResultName>()
    var listPokemons: List<PokemonDataResponse> = emptyList()

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

        if (listPokemons.isEmpty()) {
            getPokemons()
        } else {
            setAdapter(listPokemons)
        }

        binding.tietFilter.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length != 0) {
                    val filtered =
                        listPokemons.filter { it.name.contains(s.toString().toLowerCase()) }
                    filtered
                    setAdapter(filtered)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    private fun setAdapter(pokemons: List<PokemonDataResponse>) {
        var adapter =
            context?.let { context -> HomePokemonsAdapter(pokemons, context, this@HomeFragment) }
        binding.rvPokemons.adapter = adapter
        binding.rvPokemons.layoutManager = GridLayoutManager(context, 2)
    }

    private fun getPokemons() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvLoading.visibility = View.VISIBLE

        viewModel.getAllPokemons()

        viewModel.resultAllPokemons.observe(
            viewLifecycleOwner, Observer {
                it.results.map{ pokemon ->
                    listAllPokemons.add(pokemon)
                }

                if (it.next == null) {
                    for (i in listAllPokemons) {
                        var pokemonId = i.url
                            .replace("https://pokeapi.co/api/v2/pokemon/", "")
                            .replace("/", "").toInt()

                        viewModel.getPokemonsData(pokemonId)
                    }
                } else {
                    morePokemons(it.next)
                }
            }
        )

        viewModel.resultDataPokemons.observe(
            viewLifecycleOwner, Observer {

                listPokemons = it

                if (listPokemons.size == listAllPokemons.size){
                    binding.progressBar.visibility = View.GONE
                    binding.tvLoading.visibility = View.GONE

                    setAdapter(listPokemons)
                }
            }
        )
    }

    private fun morePokemons(next: String?) {
        next?.let {

            var formatUrl = next
                .replace("https://pokeapi.co/api/v2/pokemon?offset=", "")
                .split("=")

            var offset = formatUrl[0]
                .replace("&limit","")

            var limit = formatUrl[1]

            viewModel.getAllPokemons(offset.toInt(),limit.toInt())
        }
    }

    override fun onPokemonClick(pokemon: PokemonDataResponse) {
        PokemonDetails.setDetailsPokemon(pokemon)

        findNavController().navigate(R.id.FragmentDetails)
    }
}