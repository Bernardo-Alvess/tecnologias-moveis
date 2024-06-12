package br.com.ulbra.exemplorecycler.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.exemplorecycler.R
import br.com.ulbra.exemplorecycler.configureToolbar
import br.com.ulbra.exemplorecycler.data.Product
import br.com.ulbra.exemplorecycler.presentation.adapters.ProductAdapter
import br.com.ulbra.exemplorecycler.presentation.viewmodels.MainViewModel
import com.bumptech.glide.Glide

class AdicionarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_adicionar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        (requireActivity() as AppCompatActivity).configureToolbar("Adicionar", false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        val name = view.findViewById<EditText>(R.id.productName)
        val price = view.findViewById<EditText>(R.id.productPrice)
        val sendProductButton = view.findViewById<Button>(R.id.sendProductButton)

        var imageUri = ""

        val adapter = ProductAdapter(
            list = mainViewModel.getProducts(),
            goToDetails = {},
            removeItem = { mainViewModel.removeItem(it) },
            addItem = {mainViewModel.addItem(it)}
        )


        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                imageView.setImageURI(uri)
                imageUri = "file://" + uri.toString();
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }

        button.setOnClickListener{
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        sendProductButton.setOnClickListener{
            val product = Product(imageUri, name.text.toString(), price.text.toString())
            adapter.insertItem(product)
            imageView.setImageURI(null)
            name.setText(null)
            price.setText(null)

            Toast.makeText(context, product.toString(), Toast.LENGTH_LONG).show()
        }
    }

}