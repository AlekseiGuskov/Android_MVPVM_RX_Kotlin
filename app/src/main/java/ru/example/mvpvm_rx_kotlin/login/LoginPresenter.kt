package ru.example.mvpvm_rx_kotlin.login

import android.view.View

class LoginPresenter(private val mView: ILogin.IView, private val mViewModel: LoginViewModel): ILogin.IPresenter {

    override fun onViewInit() {
        mViewModel.buttonClickListener = View.OnClickListener {
            mViewModel.buttonClicked()
        }

        mViewModel.buttonClickedObservable().subscribe {
            mView.goToInfoScreen()
        }

        mViewModel.emailObservable().subscribe {
            mView.showToast("Email changed")
        }

        mViewModel.passwordObservable().subscribe {
            mView.showToast("Password changed")
        }
    }
}