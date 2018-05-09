package com.google.codelabs.mdc.kotlin.shrine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.*
import com.google.codelabs.mdc.kotlin.shrine.network.ProductEntry
import kotlinx.android.synthetic.main.shr_product_grid_fragment.view.*

class ProductGridFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This toggles the menu item's visibilty
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater.inflate(R.layout.shr_product_grid_fragment, container, false)

        // Setting the toolbar
        (activity as AppCompatActivity).setSupportActionBar(v.app_bar)

        // Set-up the recycler view
        v.recycler_view.setHasFixedSize(true)
        v.recycler_view.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        val adapter = ProductCardRecyclerViewAdapter(ProductEntry.initProductEntryList(resources))
        v.recycler_view.adapter = adapter
        val largePadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing)
        val smallPadding = resources.getDimensionPixelSize(R.dimen.shr_product_grid_spacing_small)
        v.recycler_view.addItemDecoration(ProductGridItemDecoration(largePadding, smallPadding))

        return v
    }

    // Inflating the menu options
    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater!!.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
