package ru.example.mvpvm_rx_kotlin.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import ru.example.mvpvm_rx_kotlin.BR
import ru.example.mvpvm_rx_kotlin.Empty

class LoginViewModel : BaseObservable() {
    @Bindable
    var buttonClickListener: View.OnClickListener? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.buttonClickListener)
        }
    @Bindable
    var email = ""
        set(value) {
            field = value
            emailSubject.onNext(value)
        }
    @Bindable
    var password = ""
        set(value) {
            field = value
            passwordSubject.onNext(value)
        }

    private val emailSubject = PublishSubject.create<String>()
    private val passwordSubject = PublishSubject.create<String>()
    private val buttonSubject = PublishSubject.create<Empty>()

    fun emailObservable(): Observable<String> = emailSubject
    fun passwordObservable(): Observable<String> = passwordSubject
    fun buttonClickedObservable(): Observable<Empty> = buttonSubject

    fun buttonClicked()  {
        buttonSubject.onNext(Empty.instance)
    }
}