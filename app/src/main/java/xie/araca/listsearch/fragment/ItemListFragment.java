package xie.araca.listsearch.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import xie.araca.listsearch.R;
import xie.araca.listsearch.model.Item;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends ListFragment {

    List<Item> mItems;
    ArrayAdapter<Item> adapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mItems = loadItems();
        clearSearch();

        adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItems);
        setListAdapter(adapter);
    }

    private List<Item> loadItems(){
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Vicio Louco"));
        items.add(new Item("Banda Torpedo"));
        items.add(new Item("MC Loma"));
        items.add(new Item("Banda Musa"));

        return items;
    }
    public void clearSearch(){
        adapter = new ArrayAdapter<Item>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                mItems);
        setListAdapter(adapter);
    }

    public void search(String s){
        if (s == null || s.trim().equals("")){
            clearSearch();
            return;
        }
        List<Item> itemFound = new ArrayList<Item>(mItems);

        for (int i = itemFound.size()-1; i >= 0; i--){
            Item item = itemFound.get(i);
            if (!item.name.toUpperCase().contains(s.toUpperCase())){
                itemFound.remove(item);
            }
        }
        adapter = new ArrayAdapter<Item>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                itemFound);
        setListAdapter(adapter);
    }

}
