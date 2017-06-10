package com.itydl.myapplication.view;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

import com.itydl.myapplication.bean.TextObj;

/**
 * @author yangdaolong
 * @des 插入话题效果
 */

public class SelfEditText extends EditText {

    private String huatiColor = "#0000ff";

    public SelfEditText(Context context) {
        super(context);
    }

    public SelfEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SelfEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHuaTiColor(String huatiColor){
        this.huatiColor = huatiColor;
    }

    /**
     * 插入/设置话题
     */
    public void setObject(TextObj object) {

        if (object == null)
            return;

        String objectRule = object.getObjectRule();
        String objectText = object.getObjectText();

        int textlen = objectText.length();

        if (TextUtils.isEmpty(objectText) || TextUtils.isEmpty(objectRule))
            return;

        objectText = objectRule + objectText + objectRule;

        object.setObjectText(objectText);


        /**======    将话题内容添加到EditText中展示    ======**/
        Editable editable = getText();
        int len = editable.toString().length();

        if (len >= 0) {
            // 在原来文本位置基础上插入内容
            editable.insert(len, objectText);
        }


        /******************************选中话题的方式*********************************/
        // 选中话题
        this.setSelection(this.getText().length() - textlen - 1, this.getText().length() - 1);
        // 设置插入话题的颜色
        editable.setSpan(new ForegroundColorSpan(Color.parseColor(huatiColor)), this.getText().length() - textlen - 2, this.getText().length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    /**---------  简单解决嵌套冲突  ---------**/
    @Override
    public boolean onTouchEvent (MotionEvent event){
        boolean result = super.onTouchEvent(event);
        if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return result;
    }
}