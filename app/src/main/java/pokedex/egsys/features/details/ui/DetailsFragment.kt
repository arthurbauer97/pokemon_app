package pokedex.egsys.features.details.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import coil.load
import pokedex.egsys.PokemonDetails
import pokedex.egsys.R
import pokedex.egsys.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

        private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inflater.inflate(R.layout.fragment_details, container, false)
        binding = FragmentDetailsBinding.inflate(inflater)


        binding.ivPokemon.load(PokemonDetails.image)
        binding.tvPokemonName.text = PokemonDetails.name.capitalize()

        //logica altura
        var altura = PokemonDetails.height.toString()
        if (PokemonDetails.height.toString().length > 1){
            altura = StringBuffer(altura).insert(altura.length - 1, ".").toString()
        }else{
            altura = "0.$altura"
        }
        binding.tvPokemonHeight.text = "$altura m"

        //logica do peso
        var peso = PokemonDetails.weight.toString()
        if (PokemonDetails.weight.toString().length > 1){
            peso = StringBuffer(peso).insert(peso.length - 1, ".").toString()
        }else{
            peso = "0.$peso"
        }
        binding.tvPokemonWeight.text = "$peso kg"


        binding.tvPokemonType.text = PokemonDetails.type.capitalize()

        context?.let { colors(PokemonDetails.type, it) }

        return binding.root
    }

    private fun colors(type : String, context: Context){
        when (type) {
            "poison" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.poison))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.poison))
            }

            "electric" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.eletric))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.eletric))
            }

            "ground" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.ground))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.ground))
            }

            "fairy" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.fairy))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.fairy))
            }

            "fire" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.fire))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.fire))
            }

            "normal" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.normal))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.normal))
            }

            "grass" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.grass))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.grass))
            }

            "bug" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.bug))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.bug))
            }

            "water" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.water))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.water))
            }

            "fighting" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.fighting))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.fighting))
            }

            "psychic" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.psychic))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.psychic))
            }

            "rock" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.rock))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.rock))
            }

            "ghost" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.ghost))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.ghost))
            }

            "ice" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.ice))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.ice))
            }

            "dark" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.dark))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.dark))
            }

            "dragon" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.dragon))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.dragon))
            }

            "steel" -> {
                binding.fragmentDetails.setBackgroundColor(ContextCompat.getColor(context,R.color.steel))
                binding.tvPokemonTypeCard.setCardBackgroundColor(ContextCompat.getColor(context,R.color.steel))
            }
        }
    }

}