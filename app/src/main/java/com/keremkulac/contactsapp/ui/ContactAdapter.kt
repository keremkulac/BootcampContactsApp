package com.keremkulac.contactsapp.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.keremkulac.contactsapp.R
import com.keremkulac.contactsapp.data.Person
import com.keremkulac.contactsapp.databinding.ContactItemBinding

class ContactAdapter(var context: Context,var personList: List<Person>) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    inner class ViewHolder(var binding : ContactItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : ContactItemBinding= DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.contact_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = personList[position]
        holder.binding.person = person
        holder.binding.cardViewRow.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToContactDetailFragment(person)
            Navigation.findNavController(it).navigate(direction)
        }
        holder.binding.deleteContact.setOnClickListener {
            Snackbar.make(it,"${person.personName} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    delete(person.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun delete(id : Int){
        Log.d("TAG","$id silindi")
    }


}