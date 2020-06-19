package com.example.advancedrecyclerviewtest


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedrecyclerviewtest.bottomsheet.BottomSheetFragment
import com.example.advancedrecyclerviewtest.model.DataSource
import com.example.advancedrecyclerviewtest.recyclerview.CardAdapter
import com.h6ah4i.android.widget.advrecyclerview.draggable.RecyclerViewDragDropManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var cardAdapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()

        call_bottom_sheet.setOnClickListener { callBottomSheet() }
    }

    private fun callBottomSheet() {
        val bottomSheet = BottomSheetFragment()
        bottomSheet.showNow(supportFragmentManager, "BottomSheet")
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        cardAdapter.submitList(data)
    }

    private fun initRecyclerView() {

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        // Setup D&D feature and RecyclerView

        // Setup D&D feature and RecyclerView
        val dragMgr = RecyclerViewDragDropManager()

        dragMgr.setInitiateOnMove(false)
        dragMgr.setInitiateOnLongPress(true)

        recyclerView.layoutManager = GridLayoutManager(this,2)
        cardAdapter = CardAdapter()
        cardAdapter.setStableId()
        recyclerView.adapter = dragMgr.createWrappedAdapter(cardAdapter)

        dragMgr.attachRecyclerView(recyclerView)


        /*recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            cardAdapter = CardAdapter()
            val dragDropManager = RecyclerViewDragDropManager()
            val wrappedAdapter =
                dragDropManager.createWrappedAdapter(adapter!!)
            adapter = wrappedAdapter

            (this.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false

            dragDropManager.attachRecyclerView(this);
        }*/
    }
}