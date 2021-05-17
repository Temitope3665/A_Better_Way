package com.abetterway

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abetterway.databinding.ContactListItemBinding

// Extend Recyclerview
class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    // creating list
    private val contactModel = mutableListOf<ContactModel>()

    // method for setting the list in the main activity
    fun setupContacts(contactModel: List<ContactModel>) {
        this.contactModel.addAll(contactModel)
        // this notify the adapter when new item is added
        notifyDataSetChanged()
    }

    // add viewholder here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ContactListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    // Binding items to the on bind viewholder i.e binding the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contactModel[position]
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        return contactModel.size
    }

    // Creating viewholder and binding
    inner class ViewHolder(private val binding: ContactListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindItem(contactModel: ContactModel) {
            binding.name.text = contactModel.name
            binding.phoneNo.text = contactModel.number
        }
    }
}
