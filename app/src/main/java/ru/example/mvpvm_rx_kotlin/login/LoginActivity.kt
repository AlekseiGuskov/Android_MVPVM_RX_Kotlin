package ru.example.mvpvm_rx_kotlin.login

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import ru.example.mvpvm_rx_kotlin.R
import ru.example.mvpvm_rx_kotlin.databinding.ActivityLoginBinding
import ru.example.mvpvm_rx_kotlin.info.InfoActivity

class LoginActivity : AppCompatActivity(), ILogin.IView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        val viewModel = LoginViewModel()
        val presenter = LoginPresenter(this, viewModel)
        binding.viewModel = viewModel
        binding.executePendingBindings()
        presenter.onViewInit()
    }

    override fun goToInfoScreen() {
        startActivity(Intent(this, InfoActivity::class.java))
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}
