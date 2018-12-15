package tr.org.tobb.navigatordrawerwithoutfragment;

/**
 * Created by fatihkocak on 25.06.2018.
 */


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LeftMenuAdapter extends RecyclerView.Adapter<LeftMenuAdapter.MyViewHolder> {

    private String[] moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.textView2);
        }
    }


    public LeftMenuAdapter(String[] moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(moviesList[position]);
    }

    @Override
    public int getItemCount() {
        return moviesList.length;
    }
}