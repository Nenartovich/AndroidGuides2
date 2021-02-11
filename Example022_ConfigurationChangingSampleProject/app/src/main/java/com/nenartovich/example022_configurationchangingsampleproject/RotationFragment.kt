package com.nenartovich.example022_configurationchangingsampleproject

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import java.net.URI

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val PICK_REQUEST = 1337

/**
 * A simple [Fragment] subclass.
 * Use the [RotationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RotationFragment : Fragment(), View.OnClickListener{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var contact: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        retainInstance = true
        val result = inflater.inflate(R.layout.activity_main, container, false)
        result.findViewById<Button>(R.id.pick).setOnClickListener(this)
        val v = result.findViewById<Button>(R.id.view)
        v.setOnClickListener(this)
        v.isEnabled = contact != null
        return result
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PICK_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                contact = data!!.data
                view!!.findViewById<Button>(R.id.view).isEnabled = true
            }
        }
    }

    override fun onClick(v: View?) {
        if (v!!.id  == R.id.pick) {
            pickContact(v)
        } else {
            viewContact(v)
        }
    }

    private fun pickContact(v: View) {
        val i = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        startActivityForResult(i, PICK_REQUEST)
    }

    private fun viewContact(v: View) {
        startActivity(Intent(Intent.ACTION_VIEW, contact))
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RotationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RotationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}