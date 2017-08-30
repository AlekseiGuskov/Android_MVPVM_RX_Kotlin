package ru.example.mvpvm_rx_kotlin.info

import android.databinding.BaseObservable
import android.databinding.Bindable
import ru.example.mvpvm_rx_kotlin.BR

class InfoViewModel : BaseObservable() {

    @Bindable
    var image: Int? = null
    set(value) {
        field = value
        notifyPropertyChanged(BR.image)
    }
    @Bindable
    var name: String? = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }
    @Bindable
    var lastname: String? = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.lastname)
    }

}