package pokedex.egsys.features.home.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.card.MaterialCardView
import pokedex.egsys.PokemonDetails
import pokedex.egsys.R
import pokedex.egsys.features.home.PokemonClickListener
import pokedex.egsys.model.responses.PokemonDataResponse

class HomePokemonsAdapter(
    var pokemons: List<PokemonDataResponse>,
    var context: Context,
    var listener: PokemonClickListener
) : RecyclerView.Adapter<HomePokemonsAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePokemonsAdapter.PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon_names, parent, false)

        return PokemonViewHolder(view)
    }

    override fun getItemCount() = pokemons.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]

        holder.name.text = pokemon.name.capitalize()
        holder.type.text = pokemon.types.first().type.name.capitalize()
        holder.photo.load(pokemon.sprites.other.photo.front_default)

        //logica do peso
        var peso = pokemon.weight.toString()
        if (pokemon.weight.toString().length > 1) {
            peso = StringBuffer(peso).insert(peso.length - 1, ".").toString()
        } else {
            peso = "0.$peso"
        }
        holder.weight.text = "$peso kg"


        colors(holder, pokemon.types[0].type.name, context)

        holder.cardPokemon.setOnClickListener {
            listener.onPokemonClick(pokemon)
        }

    }


    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val type: TextView
        val weight: TextView
        val photo: ImageView
        val cardPokemon: MaterialCardView

        init {
            name = itemView.findViewById(R.id.tv_name)
            type = itemView.findViewById(R.id.tv_type)
            weight = itemView.findViewById(R.id.tv_weight)
            photo = itemView.findViewById(R.id.iv_photo)
            cardPokemon = itemView.findViewById(R.id.cardPokemon)
        }
    }

    private fun colors(holder: PokemonViewHolder, type: String, context: Context) {
        when (type) {
            "poison" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.poison
                    )
                )
            }

            "electric" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.eletric
                    )
                )
            }

            "ground" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ground
                    )
                )
            }

            "fairy" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.fairy
                    )
                )
            }

            "fire" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.fire
                    )
                )
            }

            "normal" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.normal
                    )
                )
            }

            "grass" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.grass
                    )
                )
            }

            "bug" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.bug
                    )
                )
            }

            "water" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.water
                    )
                )
            }

            "fighting" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.fighting
                    )
                )
            }

            "psychic" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.psychic
                    )
                )
            }

            "rock" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.rock
                    )
                )
            }

            "ghost" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ghost
                    )
                )
            }

            "ice" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ice
                    )
                )
            }

            "dark" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.dark
                    )
                )
            }

            "dragon" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.dragon
                    )
                )
            }

            "steel" -> {
                holder.cardPokemon.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.steel
                    )
                )
            }
        }
    }
}