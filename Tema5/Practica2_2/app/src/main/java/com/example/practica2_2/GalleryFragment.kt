package com.example.practica2_2

import android.os.Bundle
import android.view.ActionMode
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica2_2.databinding.FragmentGalleryBinding
import com.example.practica2_2.databinding.GalleryImageBinding

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding

    private var mActionMode : ActionMode? = null;

    private var mActionModeCallback = object : ActionMode.Callback{
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.context_menu, menu)
            mode?.title = "Opciones"
            return true
        }
        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            return false
        }
        override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
            return false
        }
        override fun onDestroyActionMode(mode: ActionMode?) {
            mActionMode = null
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )

        registerForContextMenu(binding.recycler)

        val nameList = this.resources.getStringArray(R.array.title_array).asList()

        val adapter = GalleryImageRecyclerAdapter(imageList, nameList)
        binding.recycler.adapter = adapter

        binding.recycler.layoutManager =
            GridLayoutManager(this.requireActivity(), 2, GridLayoutManager.VERTICAL, false)
    }

    inner class GalleryImageRecyclerAdapter(val imageList : List<Int>, val nameList : List<String>) :
        RecyclerView.Adapter<GalleryImageRecyclerAdapter.GalleryImageViewHolder>() {
        inner class GalleryImageViewHolder(val binding : GalleryImageBinding) : RecyclerView.ViewHolder(binding.root),
            View.OnCreateContextMenuListener{
            init {
                binding.root.setOnCreateContextMenuListener(this)
            }
            override fun onCreateContextMenu(menu: ContextMenu?, v: View?,
                                             menuInfo: ContextMenu.ContextMenuInfo?) {
                this@GalleryFragment.requireActivity().menuInflater.inflate(R.menu.context_menu, menu)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageViewHolder {
            return GalleryImageViewHolder(GalleryImageBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        override fun onBindViewHolder(holder: GalleryImageViewHolder, position: Int) {
            holder.binding.cardImage.setImageResource(imageList[position])
            holder.binding.cardTitle.text = nameList[position]
            holder.binding.root.setOnLongClickListener{
                if(mActionMode != null){
                    return@setOnLongClickListener false
                }
                mActionMode = this@GalleryFragment.requireActivity().startActionMode(mActionModeCallback)
                return@setOnLongClickListener true
            }
        }

    }
}