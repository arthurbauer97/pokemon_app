package pokedex.egsys.features.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import pokedex.egsys.R
import pokedex.egsys.model.responses.PokemonDataResponse

class HomePokemonsAdapter :
    PagingDataAdapter<PokemonDataResponse, HomePokemonsAdapter.PokemonViewHolder>(REPO_COMPARATOR) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomePokemonsAdapter.PokemonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon_names, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val repoItem = getItem(position)
        if (repoItem != null) {
            holder.bind(repoItem)
        }
    }


    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView
        val type: TextView
        val weight: TextView
        val photo: ImageView

        init {
            name = itemView.findViewById(R.id.tv_name)
            type = itemView.findViewById(R.id.tv_type)
            weight = itemView.findViewById(R.id.tv_weight)
            photo = itemView.findViewById(R.id.iv_photo)
        }

        fun bind(pokemon: PokemonDataResponse) {
            name.text = pokemon.name
            type.text = pokemon.types.first().type.name
            photo.load(pokemon.sprites.other.photo.front_default)
            val peso = pokemon.weight.toString()
            weight.text = "$peso Kg"
        }

    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<PokemonDataResponse>() {
            override fun areItemsTheSame(
                oldItem: PokemonDataResponse,
                newItem: PokemonDataResponse
            ): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: PokemonDataResponse,
                newItem: PokemonDataResponse
            ): Boolean =
                oldItem == newItem
        }
    }
}