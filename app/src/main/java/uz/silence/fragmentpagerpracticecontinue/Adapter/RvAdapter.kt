package uz.silence.fragmentpagerpracticecontinue.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import uz.silence.fragmentpagerpracticecontinue.R

class RvAdapter(var imageList: ArrayList<Int>):RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun onBind(int: Int){
            itemView.findViewById<ImageView>(R.id.image_rv).setImageResource(int)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}