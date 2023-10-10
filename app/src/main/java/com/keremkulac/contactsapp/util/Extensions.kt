package com.keremkulac.contactsapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.switch(view : View, id : Int){
        Navigation.findNavController(view).navigate(id)
}

fun Navigation.switch(view : View, id : NavDirections){
    Navigation.findNavController(view).navigate(id)
}