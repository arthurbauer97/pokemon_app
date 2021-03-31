package pokedex.egsys.features.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import pokedex.egsys.R
import pokedex.egsys.databinding.FragmentHomeBinding
import pokedex.egsys.features.home.model.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private val adapter = HomePokemonsAdapter()

    private var searchJob: Job? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(inflater)

        search()
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        binding.rvPokemons.adapter = adapter
        binding.rvPokemons.layoutManager = GridLayoutManager(context, 2)

    }

    private fun search() {
                
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            viewModel.searchRepo().collectLatest {
                adapter.submitData(it)
            }
        }
    }

}