package item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicapp_phamtuandat.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private Context mContext;
    private List<Item> mItems;

    public ItemAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<Item> list){
        this.mItems = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recent,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = mItems.get(position);
        if(item == null){
            return;
        }
        holder.imgItem.setImageResource(item.getResourceId());
        holder.tvTieuDe.setText(item.getTieuDe());
        holder.tvMoTa.setText(item.getMoTa());
    }

    @Override
    public int getItemCount() {
        if( mItems != null){
            return mItems.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgItem;
        private TextView tvTieuDe;
        private TextView tvMoTa;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.img_item);
            tvTieuDe = itemView.findViewById(R.id.tv_tieuDe);
            tvMoTa = itemView.findViewById(R.id.tv_moTa);
        }
    }
}
