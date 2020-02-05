package com.raminarmanfar.learngermanapp


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 */
class HerrProfessorDetailDialog : DialogFragment() {
    private var txtCategoryName: EditText? = null
    private var txtCategoryType: EditText? = null
    private var hpDialogListener: HPDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_herr_professor_detail_dialog, null)

        builder.setView(view)
                .setTitle("Add New HP")
                .setNegativeButton(
                        "Cancel"
                ) { _: DialogInterface?, _: Int -> }
                .setPositiveButton(
                        "Save"
                ) { _: DialogInterface?, _: Int ->
                    if (txtCategoryName!!.text.toString().trim { it <= ' ' }.isEmpty() || txtCategoryType!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                        Toast.makeText(view.context,"Name or type is not set.", Toast.LENGTH_LONG).show()
                    } else {
                        val categoryName = txtCategoryName!!.text.toString()
                        val categoryType = txtCategoryType!!.text.toString()
                        // txtCategoryName.getText().clear();
                        // txtCategoryType.getText().clear();
                        hpDialogListener!!.applyCategory(categoryName, categoryType)
                    }
                }
        txtCategoryName = view.findViewById(R.id.txtCategoryName)
        txtCategoryType = view.findViewById(R.id.txtCategoryType)
        return builder.create()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_herr_professor_detail_dialog, container, false)
    }

    interface HPDialogListener {
        fun applyCategory(
                categoryName: String?,
                categoryType: String?
        )
    }
}
