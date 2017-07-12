package com.threeti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ztcao on 2017/7/12.
 */

public abstract class BaseListAdapter<T, VH extends BaseListAdapter.ViewHolder> extends BaseAdapter {

    protected Context context;
    protected List<T> list;

    public BaseListAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public BaseListAdapter(Context context, List<T> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        VH holder;
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(getLayoutResId(),parent,false);
            //RelayoutUtil.relayoutViewHierarchy(convertView);
            holder = onCreateViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (VH) convertView.getTag();
        }
        T t = list.get(position);
        bindViewHolder(holder,t);
        return convertView;
    }

    public void add(T t){
        list.add(t);
        notifyDataSetChanged();
    }

    public void addAll(Collection<? extends T> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }

    public void remove(T t){
        list.remove(t);
        notifyDataSetChanged();
    }

    public void removeAll(Collection<? extends T> collection){
        list.remove(collection);
        notifyDataSetChanged();
    }

    public abstract int getLayoutResId();

    protected abstract VH onCreateViewHolder(View convertView);

    public abstract void bindViewHolder(VH holder, T t);

    public static class ViewHolder{

        public ViewHolder(View view) {

        }
    }
}
