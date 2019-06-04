package hr.factory.app_send_postcard.view

import hr.factory.app_send_postcard.model.MailDataWrapper
import hr.factory.base_module.view.BaseView

interface SendPostcardView:BaseView {
    fun setEnabledSubmitButton(isEnabled: Boolean)

    fun makePostcard(mailDataWrapper: MailDataWrapper)
    //fun bindRxToInputFields()
}