package com.businessmanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

import static android.view.KeyEvent.ACTION_UP;

public class LoginActivity extends BaseActivity implements View.OnKeyListener, View.OnFocusChangeListener {

    private EditText et1, et2, et3, et4;
    private String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        et4 = findViewById(R.id.editText4);

        et1.setOnKeyListener(this);
        et2.setOnKeyListener(this);
        et3.setOnKeyListener(this);
        et4.setOnKeyListener(this);


        et2.setOnFocusChangeListener(this);
        et3.setOnFocusChangeListener(this);
        et4.setOnFocusChangeListener(this);

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    et1.clearFocus();
                     et2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    et2.clearFocus();
                     et3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    et3.clearFocus();
                     et4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) {
                    hideKeyboard();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        findViewById(R.id.btn_go).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.btn_go:
                if (!et1.getText().toString().trim().isEmpty()
                        && !et2.getText().toString().trim().isEmpty()
                        && !et3.getText().toString().trim().isEmpty()
                        && !et4.getText().toString().trim().isEmpty()) {
                    pin = et1.getText().toString().trim()
                            + et2.getText().toString().trim()
                            + et3.getText().toString().trim()
                            + et4.getText().toString().trim();

                    preferences.setLoginTime(new Date().getTime());

                    startActivity(new Intent(LoginActivity.this, MainActivity.class)
                    .putExtra("NAME","Hitesh Jhajhria")
                    .putExtra("MOBILE","+91-9636255382"));
                    finish();
                }

                break;

        }
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == ACTION_UP && keyEvent.getKeyCode() == KeyEvent.KEYCODE_DEL) {
            switch (view.getId()) {
                case R.id.editText2:
                    if (et2.getText().toString().trim().isEmpty()) {
                        et1.requestFocus();
                    }
                    break;
                case R.id.editText3:
                    if (et3.getText().toString().trim().isEmpty()) {
                        et2.requestFocus();
                    }
                    break;
                case R.id.editText4:
                    if (et4.getText().toString().trim().isEmpty()) {
                        et3.requestFocus();
                    }
                    break;
            }
        }
        return false;
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.editText2:
                if (et1.getText().toString().trim().isEmpty()) {
                    et1.requestFocus();
                }
                break;
            case R.id.editText3:
                if (et1.getText().toString().trim().isEmpty()) {
                    et1.requestFocus();
                } else if (et2.getText().toString().trim().isEmpty()) {
                    et2.requestFocus();
                }
                break;
            case R.id.editText4:
                if (et1.getText().toString().trim().isEmpty()) {
                    et1.requestFocus();
                } else if (et2.getText().toString().trim().isEmpty()) {
                    et2.requestFocus();
                } else if (et3.getText().toString().trim().isEmpty()) {
                    et3.requestFocus();
                }
                break;
        }
    }
}
