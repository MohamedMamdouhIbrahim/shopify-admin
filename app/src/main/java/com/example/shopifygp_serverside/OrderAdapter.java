package com.example.shopifygp_serverside;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class OrderAdapter extends FirebaseRecyclerAdapter<Order, OrderViewHolder> {
    private DatabaseReference ordersRef;
    FirebaseDatabase database;
    public OrderAdapter(@NonNull FirebaseRecyclerOptions<Order> options) {
        super(options);
        database = FirebaseDatabase.getInstance("https://shopifygp-70897-default-rtdb.firebaseio.com/");
        ordersRef = database.getReference("Orders");
    }

    @Override
    protected void onBindViewHolder(@NonNull OrderViewHolder holder, int position, @NonNull Order order) {
        holder.orderIdTextView.setText("Order ID:\n#" + order.getOrderID().toUpperCase(Locale.ROOT));
        holder.deliveryTimeTextView.setText("Delivery Time:\n" + order.getDeliveryTime());
        holder.deliveryGateTextView.setText("Delivery Area:\n" + order.getDeliveryGate());
        holder.paymentMethodTextView.setText("Payment Method:\n" + order.getPaymentMethod());
        holder.userFullNameTextView.setText("User Full Name:\n" + order.getUserFullName());
        holder.userPhoneNumberTextView.setText("User Phone Number:\n" + order.getUserPhoneNumber());
        holder.orderPriceTextView.setText(order.getPrice() + " $");
        List<String> orderSummary = new ArrayList<>();
        for (OrderItemModel orderItem : order.getOrderItems()) {
            orderSummary.add("x" + orderItem.getOrderItemCount() + " " + orderItem.getOrderItemName() + "\n" + orderItem.getOrderItemTotalPrice() + "$");
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(holder.itemView.getContext(), android.R.layout.simple_list_item_1, orderSummary);
        holder.orderItemsListView.setAdapter(adapter);

        ArrayAdapter<String> orderStatusAdapter = new ArrayAdapter<>(holder.itemView.getContext(),
                android.R.layout.simple_spinner_item, new String[]{"Order Requested", "Order Confirmed", "Order Delivered", "Order Cancelled"});
        orderStatusAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.orderStatusSpinner.setAdapter(orderStatusAdapter);

        holder.orderStatusSpinner.setSelection(orderStatusAdapter.getPosition(order.getOrderStatus()));
        holder.orderStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedStatus = (String) parent.getItemAtPosition(position);
                ordersRef.child(order.getOrderID()).child("orderStatus").setValue(selectedStatus);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });


    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }
}
