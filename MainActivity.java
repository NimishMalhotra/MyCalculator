package com.example.nimish.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    String display = "";
    String num = "";
    int [] number = new int[50];
    int count1 = 0 ;
    char [] operator = new char[50];
    int count2 = 0;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.TV);
    }
    public void getexp(View view){
        Button button = (Button) view;
        int id = button.getId();
        if(id==R.id.one){
            display+="1";
            textView.setText(display);
            num=num+"1";
        }else if (id==R.id.two){
            num=num+"2";
            display+="2";
            textView.setText(display);
        }else if (id==R.id.three){
            num=num+"3";
            display+="3";
            textView.setText(display);
        }else if (id==R.id.four){
            num=num+"4";
            display+="4";
            textView.setText(display);
        }else if (id==R.id.five){
            num=num+"5";
            display+="5";
            textView.setText(display);
        }else if (id==R.id.six){
            num=num+"6";
            display+="6";
            textView.setText(display);
        }else if (id==R.id.seven){
            num=num+"7";
            display+="7";
            textView.setText(display);
        }else if (id==R.id.eight){
            num=num+"8";
            display+="8";
            textView.setText(display);
        }else if (id==R.id.nine){
            num=num+"9";
            display+="9";
            textView.setText(display);
        }else if (id ==R.id.zero){
            num=num+"0";
            display+="0";
            textView.setText(display);
        }else if (id==R.id.fact){
            display+="!";
            textView.setText(display);
            fact(num);
        }else if(id==R.id.plus){
            num = num +"+";
            display+="+";
            textView.setText(display);
        }else if (id == R.id.minus){
            num = num + "-";
            display+="-";
            textView.setText(display);
        }else if (id == R.id.multiply){
            num = num + "X";
            display+="X";
            textView.setText(display);
        }else if (id == R.id.divide){
            num = num +"/";
            display+="/";
            textView.setText(display);
        }else if (id==R.id.equal){
            display+="=";
            textView.setText(display);
            compute();
        }else if (id==R.id.clear){
            textView.setText("ENTER");
            num="";
            for(int i = 0 ; i< number.length ; i++){
                number[i] = 0 ;
            }
            for(int i = 0 ; i< operator.length ; i++){
                operator[i] = 0 ;
            }
            textView = findViewById(R.id.TV);
            display = "";
            num = "";
            count1 = 0 ;
            count2 = 0;
        }
    }
    public void compute(){
        for(int i=0 ; i<num.length() ; i++){
            String str = "";
            int start;
            for(start = i ; start<num.length() && num.charAt(start) != '+' && num.charAt(start)!= '-' && num.charAt(start) != 'X' && num.charAt(start) != '/' ; start++){
                char ch1 = num.charAt(i);
                str = str + Character.toString(ch1);
            }
            if(start>=num.length()){
                int val = Integer.parseInt(str);
                number[count1]=val;
                count1++;
                break;
            }else{
                int val = Integer.parseInt(str);
                number[count1]=val;
                count1++;
                operator[count2] = num.charAt(start);
                count2++;
                i=start;
            }
        }
        int j = 0;
        char ch = 0;
        int val1 = 0;
        int val2 = 0;
        val1 = number[0];
        for(int i=1;j<count2 && i<count1 ;i++){
            ch = operator[j];
            j++;
            val2 = number[i];
            if(ch =='+') {
                val1 = val1 + val2;
            }else if (ch=='-'){
                val1 = val1 - val2;
            }else if (ch=='X'){
                val1 = val1 * val2;
            }else if (ch=='/'){
                val1 = val1/val2;
            }
        }
        String ans = Integer.toString(val1);
        textView.setText(ans);
        for(int i = 0 ; i< number.length ; i++){
            number[i] = 0 ;
        }
        for(int i = 0 ; i< operator.length ; i++){
            operator[i] = 0 ;
        }
        display = "";
        num = "";
        count1 = 0 ;
        count2 = 0;
    }
    public void fact(String str){
        int elem = Integer.parseInt(str);
        int no=1;
        int i=1;
        while(i<=elem){
            no = no * i;
            i++;
        }
        textView.setText(Integer.toString(no));
        display = "";
        num = "";
        count1 = 0 ;
        count2 = 0;
    }
}
