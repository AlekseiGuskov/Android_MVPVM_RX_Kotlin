package ru.example.mvpvm_rx_kotlin.info

import ru.example.mvpvm_rx_kotlin.R

class InfoPresenter(private val mView: IInfo.IView, private val mViewModel: InfoViewModel) : IInfo.IPresenter {
    override fun onViewInit() {
        val infoModel = getData()

        mViewModel.image = infoModel.image

        mViewModel.name = infoModel.name

        mViewModel.lastname = infoModel.lastname
    }

    private fun getData(): InfoModel = InfoModel(R.mipmap.putin, "Vladimir", "Putin")
}