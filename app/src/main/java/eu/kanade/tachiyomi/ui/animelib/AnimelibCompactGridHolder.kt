package eu.kanade.tachiyomi.ui.animelib

import android.view.View
import androidx.core.view.isVisible
import coil.clear
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.kanade.tachiyomi.databinding.SourceCompactGridItemBinding
import eu.kanade.tachiyomi.util.view.loadAnyAutoPause

/**
 * Class used to hold the displayed data of a anime in the animelib, like the cover or the title.
 * All the elements from the layout file "item_source_grid" are available in this class.
 *
 * @param view the inflated view for this holder.
 * @param adapter the adapter handling this holder.
 * @param listener a listener to react to single tap and long tap events.
 * @constructor creates a new animelib holder.
 */
open class AnimelibCompactGridHolder(
    private val view: View,
    private val adapter: FlexibleAdapter<*>
) : AnimelibHolder<SourceCompactGridItemBinding>(view, adapter) {

    override val binding = SourceCompactGridItemBinding.bind(view)

    /**
     * Method called from [AnimelibCategoryAdapter.onBindViewHolder]. It updates the data for this
     * holder with the given anime.
     *
     * @param item the anime item to bind.
     */
    override fun onSetValues(item: AnimelibItem) {
        // Update the title of the anime.
        binding.title.text = item.anime.title

        // For rounded corners
        binding.badges.clipToOutline = true

        // Update the unread count and its visibility.
        with(binding.unreadText) {
            isVisible = item.unreadCount > 0
            text = item.unreadCount.toString()
        }
        // Update the download count and its visibility.
        with(binding.downloadText) {
            isVisible = item.downloadCount > 0
            text = item.downloadCount.toString()
        }
        // set local visibility if its local anime
        binding.localText.isVisible = item.isLocal

        // For rounded corners
        binding.card.clipToOutline = true

        // Update the cover.
        binding.thumbnail.clear()
        binding.thumbnail.loadAnyAutoPause(item.anime)
    }
}
