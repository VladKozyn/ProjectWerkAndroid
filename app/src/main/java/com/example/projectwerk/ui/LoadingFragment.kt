package com.example.projectwerk.ui

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.projectwerk.R
import java.lang.IllegalStateException
import java.util.zip.Inflater

class LoadingFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        isCancelable =false

        return inflater.inflate(R.layout.fragment_loading,container,false)
    }

    override fun show(manager: FragmentManager, tag: String?){
        try{
            val ft = manager.beginTransaction()
            ft.add(this,tag)
            ft.commitAllowingStateLoss()
        }catch (ignored: IllegalStateException){

        }
    }
}