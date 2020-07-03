package com.icandothisallday2020.ex22spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayAdapter adapter;//adapter 중 글씨를 보여주는 객체
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        //대량의 데이터를 뷰로 만들어주는 adapter 객체 생성
        //자바에 데이터가 있으면 new / xml 에 있으면 create method
        //선택된 데이터 디자인 설정
        adapter=ArrayAdapter.createFromResource(this,R.array.datas,R.layout.spinner_selected);
        //드롭 다운된 TextView 의 디자인 설정
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
        //스피너의 아이템을 선택(클릭X)했을 때 반응 하는 리스너 추가
        //Click: Grid,ListView | Selected: Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
