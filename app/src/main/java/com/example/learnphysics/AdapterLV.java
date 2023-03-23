package com.example.learnphysics;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AdapterLV extends ArrayAdapter<Row> {
    Context context;
    Row[] item;
    public AdapterLV (Context context, Row[] item){
        super(context,R.layout.item,item);
          this.context = context;
          this.item = item;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE );
        View view = inflater.inflate(R.layout.item,parent,false);
        Button b = (Button) view.findViewById(R.id.butt);
        TextView t = (TextView) view.findViewById(R.id.text);
        b.setText(this.item[position].getName());
        if(this.item[position].getPassed() == false){
            t.setText("не пройдено");
        }else{
            t.setText("пройдено");
        }
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i;
                if ( item[position].getNum() == 0 || item[position].getNum() == 1 || item[position].getNum() == 2 ){
                    i = new Intent(context.getApplicationContext(),Activity1a1.class);
                }else{
                    i = new Intent(context.getApplicationContext(),Activity1a2.class);
                }
                i.putExtra("position",item[position].getNum());
                context.startActivity(i);
            }
        });

        return view;
    }
}
