package in.co.poonam.hnwebtest.util;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import in.co.poonam.hnwebtest.Model.EventData;
import in.co.poonam.hnwebtest.Model.EventModel;
import in.co.poonam.hnwebtest.Model.EventViewModel;
import in.co.poonam.hnwebtest.R;
import in.co.poonam.hnwebtest.adapter.EventAdapter;

import static in.co.poonam.hnwebtest.util.Constant.eventModelData;


public class EventListActivity extends AppCompatActivity implements EventAdapter.onClickInterface {

    private EventAdapter adapter;
    private ArrayList<EventData> list;
    private RecyclerView recyclerListview;
    private EventViewModel eventViewModel;
    private LinearLayout emptyLayout;
    private TextView txtEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Event List");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        init();
    }

    private void init() {
        recyclerListview = findViewById(R.id.recyclerListView);
        emptyLayout = findViewById(R.id.emptyLayout);
        txtEmpty = findViewById(R.id.txtEmpty);
        list = new ArrayList<>();
        adapter = new EventAdapter(this, list);
        adapter.setOnClickInterfaceObj(this);
        recyclerListview.setHasFixedSize(true);
        recyclerListview.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerListview.setAdapter(adapter);
        final ProgressDialog pd = new ProgressDialog(this);
        eventViewModel = new ViewModelProvider(this).get(EventViewModel.class);

        emptyLayout.setVisibility(View.GONE);
        eventViewModel.getEventList().observe(this, new Observer<ArrayList<EventModel>>() {
            @Override
            public void onChanged(ArrayList<EventModel> eventModel) {
                emptyLayout.setVisibility(View.GONE);
                list.addAll(eventModel.get(0).data);
                Log.d("TAG", "list:" + list.size());
                if (list.size() > 0)
                    adapter.notifyDataSetChanged();
                else {
                    emptyLayout.setVisibility(View.VISIBLE);
                    txtEmpty.setText("Data not available.");
                }
            }
        });
        eventViewModel.showDialog().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    pd.setMessage("Loading.....");
                    pd.show();
                } else {
                    pd.dismiss();
                }

            }
        });
    }

    @Override
    public void itemOnClick(EventData eventData) {
        if (new CommonMethods().isInternetConnection(EventListActivity.this)) {
            Intent i = new Intent(this, DetailViewActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable(eventModelData, eventData);
            i.putExtras(bundle);
            startActivity(i);
        }else{
            Toast.makeText(EventListActivity.this, "Please check internet connection.", Toast.LENGTH_SHORT).show();

        }

    }
}
