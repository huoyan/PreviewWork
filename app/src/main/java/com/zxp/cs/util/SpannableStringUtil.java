package com.zxp.cs.util;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.zxp.cs.R;
import com.zxp.cs.constant.Constant;
import com.zxp.cs.view.ViewSpan;

public class SpannableStringUtil {

    public static SpannableString getSpan(final TextView textView, String usrStr){
        final String qStr = usrStr.split(":")[0];
        final String phone = usrStr.split(":")[1];
        String str;
//        User user = findUser(phone);
//        if(user == null){
            str = "@" + phone;
//        }else {
//            str = "@" + user.name;
//        }
        SpannableString spanText = new SpannableString(usrStr);
        TextView spanTv = (TextView) LayoutInflater.from(textView.getContext()).inflate(R.layout.item_at, (ViewGroup) textView.getParent(), false);
        spanTv.setText(str);
        //第二个参数其实应该是用textView的最大宽度，这里的300是随便写的
        ViewSpan span = new ViewSpan(spanTv,300);
        spanText.setSpan(span, qStr.length(), spanText.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        //添加点击事件
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(textView.getContext(), phone, Toast.LENGTH_SHORT).show();
            }
        };
        spanText.setSpan(clickableSpan,0, spanText.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        return spanText;
    }

    public static void setText(TextView textView, String str){
        if(str.matches(Constant.regEx)){
            textView.setText("");
            String[] splitStrs = str.split(Constant.splitRegex);
            int num = splitStrs.length;
            int temp = 0;
            for(int i =0; i < num; i++){
                textView.append(splitStrs[i]);
                if((i+1) != num){
                    int n = splitStrs[i].length();
                    n += temp;
                    int m = str.indexOf(splitStrs[i+1], n);
                    String usr = str.substring(n, m);
                    temp = n + usr.length();
                    textView.append(getSpan(textView,usr));
                    Log.d("@Span",usr);
                }
            }
        }else{
            textView.setText(str);
        }
    }

}
