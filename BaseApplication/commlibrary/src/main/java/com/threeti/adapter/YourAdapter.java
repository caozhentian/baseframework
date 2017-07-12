package com.threeti.adapter;

import android.content.Context;
import android.view.View;

/**实例代码
 * Created by Administrator on 2017/7/12.
 */

public class YourAdapter extends BaseListAdapter<Object , YourAdapter.ViewHolder> {

    public YourAdapter(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        //return R.layout.adapter_yours;
        return 0 ;
    }

    @Override
    protected ViewHolder onCreateViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void bindViewHolder(ViewHolder holder, Object yourEntity) {
//        holder.avatarImage.setImageUri(yourEntity.getImageUri());
//        holder.nickText.setText(yourEntity.getNick());
    }

    static class ViewHolder extends BaseListAdapter.ViewHolder {
//        @Bind(R.id.avatar_image)
//        SimpleDraweeView avatarImage;
//        @Bind(R.id.nick_text)
//        TextView nickText;

        ViewHolder(View view) {
            super(view);
//            ButterKnife.bind(this, view);
        }
    }
}
