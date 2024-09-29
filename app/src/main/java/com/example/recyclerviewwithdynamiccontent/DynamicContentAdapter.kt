package com.example.recyclerviewwithdynamiccontent

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithdynamiccontent.databinding.ViewHolderEditTextBinding

class DynamicContentAdapter(
    private val context: Context
) : RecyclerView.Adapter<DynamicContentAdapter.EditTextViewHolder>() {


    private var dynamicDataSet = emptyList<RandomInput>()

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditTextViewHolder {
        val binding = ViewHolderEditTextBinding.inflate(LayoutInflater.from(context), parent, false)
        return EditTextViewHolder(binding)
    }

    override fun getItemCount() = dynamicDataSet.size

    override fun onBindViewHolder(holder: EditTextViewHolder, position: Int) {
        dynamicDataSet.getOrNull(position)?.let {
            holder.bind(it)
        }
    }


    /**
     * This approach will fix the problem but it will defeat the purpose
     * of the recycler view as it will not allow recycling because every
     * time view type is unique and it will increase the memory overhead.
     */
    /*

     override fun getItemViewType(position: Int) = position

     override fun getItemId(position: Int) = position.toLong()

     */


    inner class EditTextViewHolder(
        private val binding: ViewHolderEditTextBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val textWatcher: TextWatcher? = null

        fun bind(randomInput: RandomInput) {
           binding.apply {
               labelTv.text = randomInput.label
               etRandom.setText(randomInput.enteredInput)


               /**
                * We need to remove any existing text watcher if we have
                * to make previous object available for garbage collector
                */
               etRandom.removeTextChangedListener(textWatcher)

               /**
                * We will use text watcher to get the data which user entered
                * and save all the data in the particular object so when view is
                * recycled, all the data will update. We can do the same thing for
                * other input field like check boxes, radio buttons.
                */
               etRandom.addTextChangedListener(object :TextWatcher {
                   override fun beforeTextChanged(
                       s: CharSequence?,
                       start: Int,
                       count: Int,
                       after: Int
                   ) {

                   }

                   override fun onTextChanged(
                       s: CharSequence?,
                       start: Int,
                       before: Int,
                       count: Int
                   ) {

                   }

                   override fun afterTextChanged(s: Editable?) {
                       dynamicDataSet[adapterPosition].enteredInput = s.toString()
                   }

               })
           }
        }
    }

    fun setData(data: List<RandomInput>) {
        this.dynamicDataSet = data
        notifyDataSetChanged()
    }

    override fun getItemId(position: Int): Long {
        return dynamicDataSet[position].uniqueId
    }

}