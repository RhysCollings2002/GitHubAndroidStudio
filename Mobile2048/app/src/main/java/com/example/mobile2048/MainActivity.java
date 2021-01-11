package com.example.mobile2048;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allZero(nums);
        randomTwoCheck();
        updateText(nums);
    }

    int[][] nums = new int[4][4];
    public void allZero(int[][] nums){
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<nums[i].length; j++){
                nums[i][j]=0;
            }
        }
    }

    public void updateText(int[][]nums){
        ((TextView)findViewById(R.id.textView1)).setText(nums[0][0]+"");
        ((TextView)findViewById(R.id.textView2)).setText(nums[0][1]+"");
        ((TextView)findViewById(R.id.textView3)).setText(nums[0][2]+"");
        ((TextView)findViewById(R.id.textView4)).setText(nums[0][3]+"");
        ((TextView)findViewById(R.id.textView5)).setText(nums[1][0]+"");
        ((TextView)findViewById(R.id.textView6)).setText(nums[1][1]+"");
        ((TextView)findViewById(R.id.textView7)).setText(nums[1][2]+"");
        ((TextView)findViewById(R.id.textView8)).setText(nums[1][3]+"");
        ((TextView)findViewById(R.id.textView9)).setText(nums[2][0]+"");
        ((TextView)findViewById(R.id.textView10)).setText(nums[2][1]+"");
        ((TextView)findViewById(R.id.textView11)).setText(nums[2][2]+"");
        ((TextView)findViewById(R.id.textView12)).setText(nums[2][3]+"");
        ((TextView)findViewById(R.id.textView13)).setText(nums[3][0]+"");
        ((TextView)findViewById(R.id.textView14)).setText(nums[3][1]+"");
        ((TextView)findViewById(R.id.textView15)).setText(nums[3][2]+"");
        ((TextView)findViewById(R.id.textView16)).setText(nums[3][3]+"");
    }

    public void randomTwoCheck(){
        if(openSpace()) {
            randomTwo();
        }
    }

    public boolean openSpace(){
        boolean contains_zero = false;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                if(nums[i][j] == 0){
                    contains_zero = true;
                }
            }
        }
        return contains_zero;
    }

    public void randomTwo(){
        int i = (int) Math.round(Math.random() * 3);
        int j = (int) Math.round(Math.random() * 3);
        if(nums[i][j]==0){
            nums[i][j]=2;
        }else{
            randomTwo();
        }
    }

    public void left (View view){
        moveLeft();
        combineLeft();
        moveLeft();
        randomTwoCheck();
        updateText(nums);

    }
    public void right(View view){
        moveRight();
        combineRight();
        moveRight();
        randomTwoCheck();
        updateText(nums);
    }
    public void up(View view){
        moveUp();
        combineUp();
        moveUp();
        randomTwoCheck();
        updateText(nums);

    }
    public void down(View view){
        moveDown();
        combineDown();
        moveDown();
        randomTwoCheck();
        updateText(nums);
    }

    public void reset(View view){
        allZero(nums);
        randomTwo();
        updateText(nums);
    }

    public void moveLeft(){
        for(int count = 0; count < 3; count++){
            for(int i = 0; i < nums.length; i++){
                for(int j = 0; j < nums.length-1; j++){
                    if(nums[i][j] == 0){
                        nums[i][j] = nums[i][j+1];
                        nums[i][j+1]=0;
                    }
                }
            }
        }

    }

    public void moveRight(){
        for(int count = 0; count<3; count++){
            for(int i = 0; i < nums.length; i++){
                for(int j = nums.length-1; j > 0; j--){
                    if(nums[i][j] == 0){
                        nums[i][j] = nums[i][j-1];
                        nums[i][j-1]=0;
                    }
                }
            }
        }

    }

    public void moveUp(){
        for(int count = 0; count < 3; count++){
            for(int i = 0; i < nums.length-1; i++){
                for(int j = 0; j < nums[i].length; j++){
                    if(nums[i][j]==0){
                        nums[i][j]= nums[i+1][j];
                        nums[i+1][j]=0;
                    }
                }
            }
        }
    }

    public void moveDown(){
        for(int count = 0; count < 3; count++){
            for(int i = nums.length-1; i>0; i--){
                for(int j = 0; j<nums[i].length;j++){
                    if(nums[i][j] == 0){
                        nums[i][j]= nums[i-1][j];
                        nums[i-1][j]=0;
                    }
                }
            }
        }

    }

    public void combineLeft(){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length-1; j++){
                if(nums[i][j]==nums[i][j+1]){
                    nums[i][j]*=2;
                    nums[i][j+1]=0;
                }
            }
        }
    }

    public void combineRight(){
        for(int i = 0; i < nums.length; i++){
            for(int j = nums.length-1; j>0; j--){
                if(nums[i][j]==nums[i][j-1]){
                    nums[i][j]*=2;
                    nums[i][j-1]=0;
                }
            }
        }
    }

    public void combineUp(){
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 0; j<nums[i].length; j++){
                if(nums[i][j]==nums[i+1][j]){
                    nums[i][j]*=2;
                    nums[i+1][j]=0;
                }
            }
        }
    }

    public void combineDown(){
        for(int i = nums.length-1; i > 0; i--){
            for(int j = 0; j<nums[i].length; j++){
                if(nums[i][j]==nums[i-1][j]){
                    nums[i][j]*=2;
                    nums[i-1][j]=0;
                }
            }
        }
    }





}