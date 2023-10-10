package com.keremkulac.contactsapp.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.entity.Person
import com.keremkulac.contactsapp.databinding.ContactsItemBinding
import com.keremkulac.contactsapp.util.switch

class ContactsAdapter(var context: Context, var personList: List<Person>, var viewModel : HomeViewModel) : RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){

    inner class ViewHolder(var binding : ContactsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : ContactsItemBinding= DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.contacts_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = personList[position]
        holder.binding.person = person
        holder.binding.cardViewRow.setOnClickListener {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToContactsDetailFragment(person)
            Navigation.switch(it,direction)
        }
        holder.binding.deleteContact.setOnClickListener {
            Snackbar.make(it,"${person.personName} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.deleteContacts(person.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}