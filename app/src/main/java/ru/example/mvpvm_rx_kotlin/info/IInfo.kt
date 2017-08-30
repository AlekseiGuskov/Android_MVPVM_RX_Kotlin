package ru.example.mvpvm_rx_kotlin.info

interface IInfo {
    interface IView {
        fun showToast(text: String)
    }

    interface IPresenter {
        fun onViewInit()
    }
}