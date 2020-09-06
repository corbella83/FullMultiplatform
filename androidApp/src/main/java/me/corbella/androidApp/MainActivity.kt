package me.corbella.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cc.popkorn.inject
import kotlinx.android.synthetic.main.activity_main.*
import me.corbella.presenters.ScreenContract
import me.corbella.presenters.ScreenPresenter
import me.corbella.presenters.base.Arguments

class MainActivity : AppCompatActivity(), ScreenContract.View, ScreenContract.Router {
    private val presenter by lazy { inject<ScreenPresenter>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.initialize(Arguments())
        presenter.attachView(this)

        button1.setOnClickListener { presenter.onParamClick("ip") }
        button2.setOnClickListener { presenter.onParamClick("country") }
        button3.setOnClickListener { presenter.onParamClick("location") }
        button4.setOnClickListener { presenter.onParamClick("platform") }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        presenter.destroy()
    }

    override fun drawValue(name: String) {
        text1.text = name
    }

}
