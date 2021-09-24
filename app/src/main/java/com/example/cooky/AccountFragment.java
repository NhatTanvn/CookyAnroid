package com.example.cooky;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    ArrayList<AccountFragment.AccountFile> ac_items = new ArrayList<>();
    RecyclerView rcv_account;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_account, container, false);
       rcv_account = view.findViewById(R.id.rcv_account);

       int icon = R.drawable.banner1;
       String title = "Food";
       int next = R.drawable.next;

        for (int i =0 ; i<5 ; i++){
            AccountFile a = new AccountFile(icon,title,next);
            ac_items.add(a);
        }
        linearLayoutManager= new LinearLayoutManager(view.getContext());
        accountAdapter adapter = new accountAdapter(ac_items, view.getContext());
        rcv_account.setLayoutManager(linearLayoutManager);
        rcv_account.setAdapter(adapter);

        return view;
    }
    class accountHolderView extends RecyclerView.ViewHolder {

        private ImageView img_icon;
        private ImageView img_next;
        private TextView tv_title;
        public accountHolderView(@NonNull View itemView) {
            super(itemView);
            img_icon = itemView.findViewById(R.id.img_icon_account);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_next = itemView.findViewById(R.id.img_icon_next);

        }
    }
    class accountAdapter extends RecyclerView.Adapter<accountHolderView>{

        private ArrayList<AccountFragment.AccountFile> ac_items;
        private Context context;

        public accountAdapter(ArrayList<AccountFile> ac_items, Context context) {
            this.ac_items = ac_items;
            this.context = context;

        }

        @NonNull
            @Override
            public accountHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater =LayoutInflater.from(context);
                View view = layoutInflater.inflate(R.layout.account_item_layout,parent,false);
                accountHolderView holderView = new accountHolderView(view);

                return holderView;
            }

            @Override
            public void onBindViewHolder(@NonNull accountHolderView holder, int position) {

            holder.img_icon.setImageResource(ac_items.get(position).getImage_icon());
            holder.tv_title.setText(ac_items.get(position).getNameAccount());
            holder.img_next.setImageResource(ac_items.get(position).getImage_next());
            }

            @Override
            public int getItemCount() {
                return ac_items.size();
            }
        }

    class AccountFile{
       private  int image_icon;
       private String nameAccount;
       private int image_next;

        public AccountFile(int image_icon, String nameAccount, int image_next) {
            this.image_icon = image_icon;
            this.nameAccount = nameAccount;
            this.image_next = image_next;
        }

        public int getImage_icon() {
            return image_icon;
        }

        public void setImage_icon(int image_icon) {
            this.image_icon = image_icon;
        }

        public String getNameAccount() {
            return nameAccount;
        }

        public void setNameAccount(String nameAccount) {
            this.nameAccount = nameAccount;
        }

        public int getImage_next() {
            return image_next;
        }

        public void setImage_next(int image_next) {
            this.image_next = image_next;
        }
    }
}
