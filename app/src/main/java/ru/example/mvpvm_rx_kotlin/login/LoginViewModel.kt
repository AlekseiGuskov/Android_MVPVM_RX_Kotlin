package ru.example.mvpvm_rx_kotlin.login

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.BehaviorSubject
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
    var buttonIsEnable: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.buttonIsEnable)
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

    private val emailIsMatchSubject = BehaviorSubject.createDefault(false)
    private val passwordIsMatchSubject = BehaviorSubject.createDefault(false)
    private val emailSubject = PublishSubject.create<String>()
    private val passwordSubject = PublishSubject.create<String>()
    private val buttonClickedSubject = PublishSubject.create<Empty>()

    fun emailObservable(): Observable<String> = emailSubject
    fun passwordObservable(): Observable<String> = passwordSubject
    fun buttonClickedObservable(): Observable<Empty> = buttonClickedSubject
    fun buttonIsEnableObservable(): Observable<Boolean> =
            Observable.combineLatest(emailIsMatchSubject, passwordIsMatchSubject,
                    BiFunction<Boolean, Boolean, Boolean> { t1, t2 ->
        return@BiFunction t1 && t2
    })

    fun buttonClicked() {
        buttonClickedSubject.onNext(Empty.instance)
    }

    fun emailIsMatched(isMath: Boolean) {
        emailIsMatchSubject.onNext(isMath)
    }

    fun passwordIsMatched(isMath: Boolean) {
        passwordIsMatchSubject.onNext(isMath)
    }
}