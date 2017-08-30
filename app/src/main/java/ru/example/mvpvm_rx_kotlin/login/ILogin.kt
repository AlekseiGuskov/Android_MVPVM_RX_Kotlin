package ru.example.mvpvm_rx_kotlin.login

interface ILogin {
    interface IView {
        fun showToast(text: String)
        fun goToInfoScreen()
    }

    interface IPresenter {
        fun onViewInit()
    }
}