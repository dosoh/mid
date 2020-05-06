package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;


public class MemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        final EditText editText_title = (EditText) findViewById(R.id.editText_title);
        final EditText editText_content = (EditText) findViewById(R.id.editText_content);
        Memo memo = (Memo)getIntent().getSerializableExtra("MEMO");
        if (memo != null) {
            editText_title.setText(memo.getTitle());
            editText_content.setText(memo.getBody());
        }

        Button button = (Button) findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_title = (EditText) findViewById(R.id.editText_title);
                String title = editText_title.getText().toString();


                Memo memo = new Memo(title, new Date());
                Intent intent = new Intent();
                intent.putExtra("MEMO", memo);
                setResult(RESULT_OK, intent);
                finish();
            }
        };
        button.setOnClickListener(listener);
    }
    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true; return s.toString().trim().length() == 0;
    }
}