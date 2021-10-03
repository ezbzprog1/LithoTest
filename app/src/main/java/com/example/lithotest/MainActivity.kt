package com.example.lithotest

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.soloader.SoLoader
import com.facebook.yoga.YogaDirection
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SoLoader.init(this, false)
        supportFragmentManager.beginTransaction().add(R.id.rootView, TestFragment(), "tag").commit()
    }
}


class TestFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val componentContext = ComponentContext(inflater.context)
        return LithoView.create(
            componentContext,
            BaseViewPager.create(componentContext)
                .layoutDirection(YogaDirection.RTL)
                .build()
        )
    }
}