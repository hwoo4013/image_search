package com.example.image_search_0201.feature.storage

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.image_search_0201.MainActivity
import com.example.image_search_0201.databinding.FragmentStorageBinding
import com.example.image_search_0201.model.SearchItemModel

class StorageFragment : Fragment() {

    private lateinit var mContext: Context

    private var binding: FragmentStorageBinding? = null
    private lateinit var adapter: StorageAdapter

    private var likedItems: List<SearchItemModel> = listOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainActivity = activity as MainActivity
        likedItems = mainActivity.likedItems

        Log.d("BookmarkFragment", "#jblee likedItems size = ${likedItems.size}")

        // 어댑터 설정
        adapter = StorageAdapter(mContext).apply {
            items = likedItems.toMutableList()
        }

        // 바인딩 및 RecyclerView 설정
        binding = FragmentStorageBinding.inflate(inflater, container, false).apply {
            rvBookmark.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            rvBookmark.adapter = adapter
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}