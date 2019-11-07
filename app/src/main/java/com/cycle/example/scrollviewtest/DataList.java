package com.cycle.example.scrollviewtest;

import android.content.Context;

import java.util.ArrayList;

public class DataList extends ArrayList<ItemInfo> {

    private ItemInfo data_msg = new ItemInfo();
    private ItemInfo data_src = new ItemInfo();
    private ItemInfo data_net = new ItemInfo();
    private ItemInfo data_mda = new ItemInfo();
    private ItemInfo data_opt = new ItemInfo();

    public DataList(Context context) {

        data_msg.setItemName("消息");
        data_msg.setItemIconId(R.mipmap.icon);
        data_msg.setItemBackgroundId(R.drawable.message_background);

        data_src.setItemName("源");
        data_src.setItemIconId(R.mipmap.icon1);
        data_src.setItemBackgroundId(R.drawable.source_background);

        data_net.setItemName("网络");
        data_net.setItemIconId(R.mipmap.icon2);
        data_net.setItemBackgroundId(R.drawable.network_background);

        data_mda.setItemName("媒体");
        data_mda.setItemIconId(R.mipmap.icon3);
        data_mda.setItemBackgroundId(R.drawable.media_background);

        data_opt.setItemName("选项");
        data_opt.setItemIconId(R.mipmap.icon4);
        data_opt.setItemBackgroundId(R.drawable.system_tool_background);

        add(data_msg);
        add(data_src);
        add(data_net);
        add(data_mda);
        add(data_opt);
    }
}
