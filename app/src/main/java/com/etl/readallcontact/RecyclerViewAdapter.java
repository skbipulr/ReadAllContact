package com.etl.readallcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tomash.androidcontacts.contactgetter.entity.ContactData;
import com.tomash.androidcontacts.contactgetter.main.contactsGetter.ContactsGetterBuilder;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolderContact> {
    private Context context;
    private List<ContactData> contactDatas; /* = new ContactsGetterBuilder(context)
            .onlyWithPhones().buildList();*/

    public RecyclerViewAdapter(Context context, List<ContactData> contactDatas) {
        this.context = context;
        this.contactDatas = contactDatas;
    }

    @NonNull
    @Override
    public ViewHolderContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_display_layout,
                        parent,false);
        return new ViewHolderContact(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContact holder, int position) {
        final ContactData contacts = contactDatas.get(position);

        String phone = contacts.getPhoneList().get(0).getMainData();
        String name = contacts.getCompositeName().toString();

        holder.nameTv.setText(name);
        holder.phoneNumberTv.setText(phone);
    }

    @Override
    public int getItemCount() {
        return contactDatas.size();
    }

    public class ViewHolderContact extends RecyclerView.ViewHolder {

        TextView nameTv, phoneNumberTv;
        public ViewHolderContact(@NonNull View itemView) {
            super(itemView);

            nameTv = itemView.findViewById(R.id.nameTV);
            phoneNumberTv = itemView.findViewById(R.id.phoneNumberTV);
        }
    }
}
