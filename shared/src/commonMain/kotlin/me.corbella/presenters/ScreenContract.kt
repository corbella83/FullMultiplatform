package me.corbella.presenters

import me.corbella.presenters.base.Contract

interface ScreenContract {

    interface View : Contract.View {
        fun drawValue(name: String)
    }

    interface Presenter : Contract.Presenter {
        fun onParamClick(param: String)
    }

    interface Router : Contract.Router

}
