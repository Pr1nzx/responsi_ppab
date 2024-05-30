package dapri.anime.ui.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dapri.anime.R

class DashboardAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val sagaNames = context.resources.getStringArray(R.array.saga_names)
    private val sagaDescription = context.resources.getStringArray(R.array.saga_descriptions)
    private val sagaArcs = context.resources.getStringArray(R.array.arc_names)
    private val arcImages = context.resources.obtainTypedArray(R.array.arc_images)


    private var isGridMode = false

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val sagaNameTextView: TextView = itemView.findViewById(R.id.list_saga_name)
        val sagaDescriptionTextView: TextView = itemView.findViewById(R.id.list_saga_description)
        val sagaArcsTextView: TextView = itemView.findViewById(R.id.list_saga_arc)
        val sagaImageView: ImageView = itemView.findViewById(R.id.list_image_saga)
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val sagaNameTextView: TextView = itemView.findViewById(R.id.grid_saga_name)
        val sagaDescriptionTextView: TextView = itemView.findViewById(R.id.grid_saga_description)
        val sagaArcsTextView: TextView = itemView.findViewById(R.id.grid_saga_arc)
        val sagaImageView: ImageView = itemView.findViewById(R.id.grid_image_saga)
    }


    override fun getItemViewType(position: Int): Int {
        return if (isGridMode) GRID_VIEW_TYPE else LIST_VIEW_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutId = if (viewType == GRID_VIEW_TYPE) R.layout.saga_grid else R.layout.saga_list
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return if (viewType == GRID_VIEW_TYPE) GridViewHolder(view) else ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {


        if (holder.itemViewType == GRID_VIEW_TYPE) {
            val gridHolder = holder as GridViewHolder
            gridHolder.sagaNameTextView.text = sagaNames[position]
            gridHolder.sagaDescriptionTextView.text = sagaDescription[position]
            gridHolder.sagaArcsTextView.text = sagaArcs[position]
            gridHolder.sagaImageView.setImageResource(arcImages.getResourceId(position, -1))
            gridHolder.itemView.setOnClickListener {

                val intent = DashboardDetailActivity.newIntent(context, sagaNames[position], sagaDescription[position], arcImages.getResourceId(position, -1), sagaArcs[position])
                context.startActivity(intent)
            }
        } else {
            val listHolder = holder as ListViewHolder
            listHolder.sagaNameTextView.text = sagaNames[position]
            listHolder.sagaDescriptionTextView.text = sagaDescription[position]
            listHolder.sagaArcsTextView.text = sagaArcs[position]
            listHolder.sagaImageView.setImageResource(arcImages.getResourceId(position, -1))
            listHolder.itemView.setOnClickListener {

                val intent = DashboardDetailActivity.newIntent(context, sagaNames[position], sagaDescription[position], arcImages.getResourceId(position, -1), sagaArcs[position])
                context.startActivity(intent)
            }
        }
    }



    override fun getItemCount(): Int {
        return sagaNames.size
    }

    fun setGridMode(isGrid: Boolean) {
        isGridMode = isGrid
        notifyDataSetChanged()
    }

    companion object {
        private const val LIST_VIEW_TYPE = 0
        private const val GRID_VIEW_TYPE = 1
    }
}
