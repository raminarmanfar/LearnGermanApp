package com.raminarmanfar.learngermanapp


import android.app.Dialog
import android.content.Context
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
import com.raminarmanfar.learngermanapp.models.HerrProfessorModel


/**
 * A simple [Fragment] subclass.
 */
class HerrProfessorDetailDialog : DialogFragment() {
    private var txtCourseTitle: EditText? = null
    private var txtTranslation: EditText? = null
    private var txtYoutubeLink: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val parent = inflater.inflate(R.layout.fragment_herr_professor_list, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(context!!)
        val inflater = activity!!.layoutInflater
        val view: View = inflater.inflate(R.layout.fragment_herr_professor_detail_dialog, null)

        builder.setView(view)
                .setTitle("Add New Course")
                .setNegativeButton(
                        "Cancel"
                ) { _: DialogInterface?, _: Int -> }
                .setPositiveButton(
                        "Save"
                ) { _: DialogInterface?, _: Int ->
                    if (txtCourseTitle!!.text.toString().trim { it <= ' ' }.isEmpty() ||
                            txtTranslation!!.text.toString().trim { it <= ' ' }.isEmpty() ||
                            txtYoutubeLink!!.text.toString().trim { it <= ' ' }.isEmpty()) {
                        Toast.makeText(view.context, "Please fill in required fields.", Toast.LENGTH_SHORT).show()
                    } else {
                        val courseTitle = txtCourseTitle!!.text.toString()
                        val translation = txtTranslation!!.text.toString()
                        val youtubeLink = txtYoutubeLink!!.text.toString()

                        val hpModel = HerrProfessorModel()
                        hpModel.hpCourseTitle = courseTitle
                        hpModel.hpTranslation = translation
                        hpModel.hpYoutubeLink = youtubeLink

                        // HerrProfessorListFragment.dbHandler.addHp(this, hpModel)
                    }
                }
        txtCourseTitle = view.findViewById(R.id.txtCourseTitle)
        txtTranslation = view.findViewById(R.id.txtTranslation)
        txtYoutubeLink = view.findViewById(R.id.txtYoutubeLink)
        return builder.create()
    }
}
