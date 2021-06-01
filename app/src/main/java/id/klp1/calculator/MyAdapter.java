package id.klp1.calculator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String data1[];

    Context context;

    public MyAdapter(Context ct, String s1[]){
        context = ct;
        data1 = s1;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position==0){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity0.class);
                    v.getContext().startActivity(intent);

                }else if (position==1){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==2){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==3){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==4){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==5){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==6){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==7){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==8){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }else if (position==9){
                    Intent intent = new Intent(v.getContext(), CurrencyActivity1.class);
                    v.getContext().startActivity(intent);

                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mytext1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.myText1);
        }
    }
}