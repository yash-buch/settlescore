package com.binc.settlescore.presentation.view

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.binc.settlescore.R
import com.binc.settlescore.common.exceptions.ParamIncorrectException
import com.binc.settlescore.dagger.memberquerygraph.MemberQueryScope
import com.binc.settlescore.domain.interactors.OwnerInfo
import javax.inject.Inject

//@MemberQueryScope
class OwnerInfoFragment @Inject constructor(): DialogFragment() {
    private var listener: SaveButtonListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.owner_info_layout, container, false)
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        listener = when (activity is SaveButtonListener) {
            true -> activity
            else -> null
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
        builder?.setView(R.layout.owner_info_layout)
        return builder?.create() ?: this.dialog!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btn: Button? = view.findViewById(R.id.save)
        val etName: EditText? = view.findViewById(R.id.owner_name)
        val etEmail: EditText? = view.findViewById(R.id.owner_email)
        val etPhone: EditText? = view.findViewById(R.id.owner_ph)
        val etUPI: EditText? = view.findViewById(R.id.owner_upi)
        btn?.setOnClickListener {
            val ownerInfo: OwnerInfo
            try {
                ownerInfo = OwnerInfo(etName?.text.toString(),
                    etPhone?.text.toString(),
                    etUPI?.text.toString(),
                    etEmail?.text.toString())
                listener?.handleSaveButton(ownerInfo)
            } catch (e: ParamIncorrectException) {
                listener?.saveError()
            }
        }
    }

    interface SaveButtonListener {
        fun handleSaveButton(ownerInfo: OwnerInfo)
        fun saveError()
    }
}