package com.example.saimanoj.flames;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e1,e2,e3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.second);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        e3=(EditText)findViewById(R.id.editText6);
        e1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(e1.getText().length()==0){
                    e1.setError("YOUR NAME CANNOT BE LEFT EMPTY");
                }
            }
        });
        e2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(e2.getText().length()==0){
                    e2.setError("YOUR PARTNER'S NAME CANNOT BE LEFT EMPTY");
                }
            }
        });
    }

    public void addition(View view) {

        String a = e1.getText().toString();
        String b = e2.getText().toString();
        if (a.length() <=2||b.length()<=2) {
            if(a.length()<=2)
            Toast.makeText(view.getContext(), "YOUR NAME IS INVALID", Toast.LENGTH_SHORT).show();
            if(b.length()<=2)
                Toast.makeText(view.getContext(), "YOUR PARTNER'S NAME IS INVALID", Toast.LENGTH_SHORT).show();

            return;
        } else {
            char x[] = a.toCharArray();
            char y[] = b.toCharArray();
            int l1 = x.length;
            int l2 = y.length, z = l1 + l2;
            int i, j;
            String P = "FLAMES";
            char f[] = P.toCharArray();
            for (i = 0; i < l1; i++)
                for (j = 0; j < l2; j++) {
                    if (Character.toLowerCase(x[i]) == Character.toLowerCase(y[j])) {
                        x[i] = y[j] = '-';
                        z -= 2;
                        break;
                    }
                }
            for (i = 0; i < l1; i++)
                if (x[i] == ' ')
                    z--;
            for (i = 0; i < l2; i++)
                if (y[i] == ' ')
                    z--;
            int strike = 0, k = f.length, l = 0, count = 0;
            while (strike != 5) {
                count = 0;
                for (i = l; count != z; i++) {
                    if (i == k)
                        i = 0;
                    count++;
                }
                i--;
                for (j = i; j < k - 1; j++) {
                    f[j] = f[j + 1];
                }
                f[k - 1] = '\0';
                k--;
                l = i;
                strike++;
            }
            if (f[0] == 'F')
                e3.setText("FRIENDS");
            else if (f[0] == 'L') e3.setText("LOVER");
            else if (f[0] == 'A') e3.setText("AFFECTION");
            else if (f[0] == 'M') e3.setText("MARRIAGE");
            else if (f[0] == 'E') e3.setText("ENEMY");
            else e3.setText("SIBLING");


        }
    }
}
