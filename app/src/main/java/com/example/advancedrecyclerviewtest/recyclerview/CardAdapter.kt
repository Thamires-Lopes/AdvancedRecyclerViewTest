package com.example.advancedrecyclerviewtest.recyclerview

import android.R.attr
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrecyclerviewtest.R
import com.example.advancedrecyclerviewtest.model.Card
import com.h6ah4i.android.widget.advrecyclerview.draggable.DraggableItemAdapter
import com.h6ah4i.android.widget.advrecyclerview.draggable.ItemDraggableRange
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractDraggableItemViewHolder
import kotlinx.android.synthetic.main.card_item.view.*


class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>(),
    DraggableItemAdapter<CardAdapter.CardViewHolder> {

    //private var cards: List<Card> = ArrayList()
    var cards: MutableList<Card> = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
       return cards.size
    }

    override fun onBindViewHolder(holder: CardAdapter.CardViewHolder, position: Int) {
        when(holder) {
            is CardViewHolder -> {
                holder.bind(cards[position])
            }
        }
    }

    fun submitList(cardList: MutableList<Card>) {
        cards = cardList
    }

    class CardViewHolder
    constructor(
        cardView: View
    ): AbstractDraggableItemViewHolder(cardView) {
        val cardTitle = cardView.card_title
        val cardContent = cardView.card_content
        var dragHandle = cardView.findViewById<View>(R.id.drag_handle)

        fun bind(card: Card) {
            cardTitle.text = card.title
            cardContent.text = card.content
        }

    }

    //Advanced Recyclerview

    fun setStableId() {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        // requires static value, it means need to keep the same value
        // even if the item position has been changed.
        return cards[position].id.toLong()
    }

    override fun onGetItemDraggableRange(
        holder: CardViewHolder,
        position: Int
    ): ItemDraggableRange? {
        return null
    }

    override fun onCheckCanStartDrag(
        holder: CardViewHolder,
        position: Int,
        x: Int,
        y: Int
    ): Boolean {
        /*val itemView = holder.itemView
        val dragHandle: View = holder.dragHandle

        val handleWidth = dragHandle.width
        val handleHeight = dragHandle.height
        val handleLeft = dragHandle.left
        val handleTop: Int = dragHandle.top

        return attr.x >= handleLeft && attr.x < handleLeft + handleWidth &&
                attr.y >= handleTop && attr.y < handleTop + handleHeight*/

        return true
    }

    override fun onItemDragStarted(position: Int) {

    }

    override fun onMoveItem(fromPosition: Int, toPosition: Int) {
        val removed: Card = cards.removeAt(fromPosition)
        cards.add(toPosition, removed)
    }

    override fun onCheckCanDrop(draggingPosition: Int, dropPosition: Int): Boolean {
        return true
    }

    override fun onItemDragFinished(fromPosition: Int, toPosition: Int, result: Boolean) {

    }
}