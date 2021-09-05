package com.example.pitagoras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.pitagoras.databinding.ActivityMainBinding
import com.example.pitagoras.mvvm.views.GeometricFiguresFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        replaceFragment(GeometricFiguresFragment.newInstance(), "", false)
    }

    fun replaceFragment(fragment: Fragment, tag: String?, addToBack: Boolean) {
        getFragmentTransaction(fragment, tag, addToBack, null).commit()
    }

    fun nextFragment(fragment: Fragment, tag: String?) {
        getFragmentTransaction(fragment, tag, true, FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit()
    }

    private fun getFragmentTransaction(fragment: Fragment, tag: String?, addToBack: Boolean, transition: Int?) : FragmentTransaction {
        var fragmentTransaction = supportFragmentManager.beginTransaction().replace(R.id.root_layout, fragment, tag)
        if (addToBack)
            fragmentTransaction = fragmentTransaction.addToBackStack(tag)
        if (transition != null)
            fragmentTransaction.setTransition(transition)
        return fragmentTransaction
    }
}