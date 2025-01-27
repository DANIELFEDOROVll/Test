package com.example.testtaskintern.presentation.history

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskintern.databinding.ItemHistoryBinding
import com.example.testtaskintern.presentation.model.InformationItem

class HistoryAdapter(
    private val context: Context
): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private  var itemsInformation: List<InformationItem> = emptyList()

    class HistoryViewHolder(itemHistory: ItemHistoryBinding) : RecyclerView.ViewHolder(itemHistory.root){
        private val binding = itemHistory

        fun bind(informationItem: InformationItem){
            binding.textElemBin.text = informationItem.bin
            binding.textElem1.text = informationItem.country
            binding.textElem2.text = informationItem.latitude.toString()
            binding.textElem3.text = informationItem.longitude.toString()
            binding.textElem4.text = informationItem.cardType
            binding.textElem5.text = informationItem.bankName
            binding.textElem6.text = informationItem.bankUrl
            binding.textElem7.text = informationItem.bankPhone
            binding.textElem8.text = informationItem.bankCity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return itemsInformation.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = itemsInformation[position]
        holder.bind(item)
    }

    fun updateList(newList: List<InformationItem>){
        itemsInformation = newList
        notifyDataSetChanged()
    }
}