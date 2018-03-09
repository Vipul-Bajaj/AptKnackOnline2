package com.example.examprep.aptknackonline;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class ExmAdapter extends BaseAdapter {

    public LinkedList<ExmAdaData> data;
    Context ctx;
    LayoutInflater infl;

    public ExmAdapter(Context ctx) {
        this.ctx = ctx;
        infl = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        data = new LinkedList<ExmAdaData>();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ExmAdaData getItem(int arg0) {
        return data.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(final int arg0, View arg1, ViewGroup arg2) {

        View v = infl.inflate(R.layout.exm_adapter, null);
        final Paint p = new Paint();
        p.setColor(Color.parseColor("#AAFC9A"));
        v.setBackground(new Drawable() {

            @Override
            public void setColorFilter(ColorFilter arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void setAlpha(int arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public int getOpacity() {
                // TODO Auto-generated method stub
                return 0;
            }

            @Override
            public void draw(Canvas can) {

                final float per = 0.01f * can.getWidth() * data.get(arg0).getCompleted();
                can.drawRect(0, 0, per, can.getHeight(), p);

            }
        });

        TextView courceName = v.findViewById(R.id.txtCName);
        courceName.setText(data.get(arg0).getSyllabus().getQuestionTopic());
        TextView txtProg = v.findViewById(R.id.txtProgress);
        txtProg.setText(data.get(arg0).getCompleted() + "% Completed");
        TextView txtmrk = v.findViewById(R.id.txtTtlMrk);
        txtmrk.setText("Total mark " + data.get(arg0).getSyllabus().getTotalMarks());
        return v;
    }

    public void add(ExmAdaData item) {
        data.add(item);
    }

    public void add(Syllabus item) {
        ExmAdaData s = new ExmAdaData();
        s.setSyllabus(item);
        s.setMrkObt(0);
        s.setCompleted(0);
        data.add(s);
    }

    public void add(Syllabus item, int mrk, int prog) {
        ExmAdaData s = new ExmAdaData();
        s.setSyllabus(item);
        s.setMrkObt(mrk);
        s.setCompleted(prog);
        data.add(s);
    }
}
