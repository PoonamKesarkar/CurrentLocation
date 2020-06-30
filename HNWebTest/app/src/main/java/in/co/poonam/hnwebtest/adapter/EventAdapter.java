package in.co.poonam.hnwebtest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import in.co.poonam.hnwebtest.Model.EventData;
import in.co.poonam.hnwebtest.R;
import in.co.poonam.hnwebtest.util.CommonMethods;

import static in.co.poonam.hnwebtest.util.Constant.imageUrl;
import static in.co.poonam.hnwebtest.util.Constant.imageUrls;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<EventData> listdata;
    private Context context;
    private onClickInterface onClickInterface;

    public EventAdapter(Context context, ArrayList<EventData> listdata) {
        this.listdata = listdata;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtEventTitle.setText(listdata.get(position).getEvent_name());

        if (new CommonMethods().isInternetConnection(context)) {
            //Used glide for loading image

            String str = listdata.get(position).getEvent_flyer().replace(imageUrls, "");
            String imagePath = imageUrl + str;
            Log.d("TAG", "imagePath:" + imagePath);
            Glide.with(context)
                    .load(imagePath)
                    .placeholder(R.drawable.logo)
                    .into(holder.imgEvent);

        } else {
            holder.imgEvent.setBackgroundResource(R.drawable.logo);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickInterface.itemOnClick(listdata.get(position));

            }
        });
    }

    public void setOnClickInterfaceObj(onClickInterface onClickInterface) {
        this.onClickInterface = onClickInterface;
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public interface onClickInterface {
        void itemOnClick(EventData eventData);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtEventTitle;
        private ImageView imgEvent;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgEvent = itemView.findViewById(R.id.imgEvent);
            txtEventTitle = itemView.findViewById(R.id.txtEventTitle);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
