package edu.pxxy.jyq.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.pxxy.jyq.R;
import edu.pxxy.jyq.bean.Food;

public class FoodAdapter extends BaseAdapter {
    //数据源与数据适配器进行关联
    private List<Food> mList;
    private LayoutInflater mInflater;

    //创建构造方法
    public FoodAdapter(Context context, List<Food> list){
        mList=list;
        mInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view==null){

            viewHolder=new ViewHolder();

            view=mInflater.inflate(R.layout.food_item,null);

            viewHolder.foodName= view.findViewById(R.id.food_name);
            viewHolder.foodPrice= view.findViewById(R.id.food_price);

            viewHolder.count=  view.findViewById(R.id.food_count);


            view.setTag(viewHolder);
        }else{

            viewHolder= (ViewHolder) view.getTag();
        }

        Food food=mList.get(i);



        viewHolder.foodName.setText(food.getFoodName());
        viewHolder.foodPrice.setText((int) food.getFoodPrice()+" ");

        viewHolder.count.setText(String.valueOf(food.getCount()));

        return view;
    }


    class ViewHolder{
        private TextView foodName;
        private TextView foodPrice;
        private TextView  count;
    }
}
