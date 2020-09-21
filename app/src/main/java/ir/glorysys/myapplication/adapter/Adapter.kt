package ir.glorysys.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.glorysys.myapplication.model.DataModel
import ir.glorysys.myapplication.R

class Adapter(var dataModellist: MutableList<DataModel>) :
    RecyclerView.Adapter<Adapter.AdapterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_adapter, parent, false)
        return AdapterViewHolder(view)

    }

    override fun getItemCount(): Int = dataModellist.size

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(dataModellist.get(position))
    }


    class AdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var title:TextView?=null
        init {
            title=itemView.findViewById(R.id.textview_adapter_title)
        }
         fun onBind(dataModel: DataModel) {

             title?.text=dataModel.name
        }

    }


}