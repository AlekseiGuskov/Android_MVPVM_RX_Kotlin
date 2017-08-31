package ru.example.mvpvm_rx_kotlin.login

import android.view.View
import java.util.regex.Pattern

class LoginPresenter(private val mView: ILogin.IView, private val mViewModel: LoginViewModel) : ILogin.IPresenter {

    override fun onViewInit() {
        mViewModel.buttonClickListener = View.OnClickListener {
            mViewModel.buttonClicked()
        }

        mViewModel.buttonClickedObservable().subscribe {
            mView.goToInfoScreen()
        }

        mViewModel.buttonIsEnableObservable().subscribe { enable ->
            mViewModel.buttonIsEnable = enable
        }

        mViewModel.emailObservable().filter { email ->
            mViewModel.emailIsMatched(false)
            return@filter emailIsMatched(email)
        }.subscribe {
            mViewModel.emailIsMatched(true)
        }

        mViewModel.passwordObservable().filter { password ->
            mViewModel.passwordIsMatched(false)
            return@filter passwordIsMatched(password)
        }.subscribe {
            mViewModel.passwordIsMatched(true)
        }
    }

    private fun emailIsMatched(text: String) =
            Pattern.compile("^.+@.+\\..+$").matcher(text).matches()

    private fun passwordIsMatched(text: String) = text != ""
}