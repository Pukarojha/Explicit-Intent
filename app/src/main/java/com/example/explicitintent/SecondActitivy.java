package com.example.explicitintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.explicitintent.databinding.ActivitySecondActitivyBinding;

public class SecondActitivy extends AppCompatActivity {

    private ActivitySecondActitivyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivitySecondActitivyBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        ViewCompat.setOnApplyWindowInsetsListener(view, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extra = getIntent().getExtras();
        if(extra == null){
            return;
        }
        String qString = extra.getString("qString");
        binding.textView2.setText(qString);

    }

    public void returnText(View view) {
        finish();
    }
    @Override
    public void finish(){
        Intent data = new Intent();
        String returnString = binding.editText2.getText().toString();
        data.putExtra("returnData", returnString);
        setResult(RESULT_OK, data);
        super.finish();
    }
}