package com.example.examprep.aptknackonline.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.examprep.aptknackonline.DataBase.SyllabusDatabase;
import com.example.examprep.aptknackonline.Misc.ExamData;
import com.example.examprep.aptknackonline.Misc.ExamAdapter;
import com.example.examprep.aptknackonline.Misc.Message;
import com.example.examprep.aptknackonline.POJO.SyllabusPOJO;
import com.example.examprep.aptknackonline.R;
import com.example.examprep.aptknackonline.Misc.SharedPref;

import java.util.LinkedList;

public class MockTest extends AppCompatActivity {

    ListView lstMockTst;
    ExamAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mock_test);

        final String subject = getIntent().getStringExtra("testType");

        lstMockTst = findViewById(R.id.lstMockTest);
        adapter = new ExamAdapter(MockTest.this);

        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void, Void, Message> a = new AsyncTask<Void, Void, Message>() {
            AlertDialog.Builder b;
            AlertDialog dlg;

            protected void onPreExecute() {
                final AsyncTask self = this;
                b = new AlertDialog.Builder(MockTest.this);
                b.setCancelable(false);
                b.setTitle("Loading syllabus");
                b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        self.cancel(true);
//                        LayoutSwitcher.this.changeView(R.layout.help);
                    }
                });
                dlg = b.create();
                dlg.show();

            }

            @Override
            protected Message doInBackground(Void... arg0) {
                Message msg = new Message();
                msg.code = 0;
                msg.msg = "";

                LinkedList<SyllabusPOJO> res = new LinkedList<SyllabusPOJO>();
                try {

                    if (subject.equalsIgnoreCase("self")) {
                        res = SyllabusDatabase.getAllM();
                    } else {
                        res = SyllabusDatabase.getBySubM(subject);
                    }

                    msg.data = res;

                } catch (Exception e) {
                    msg.code = 1;
                    msg.msg = e.getMessage();
                    msg.data = null;
                }

                return msg;
            }

            protected void onPostExecute(Message msg) {
                SharedPreferences sp = MockTest.this.getPreferences(Context.MODE_PRIVATE);

                LinkedList<SyllabusPOJO> res = (LinkedList<SyllabusPOJO>) msg.data;

                if (msg.code != 0) {
                    dlg.dismiss();
                    AlertDialog.Builder build = new AlertDialog.Builder(MockTest.this);
                    build.setTitle("Error!!");
                    build.setMessage(msg.msg);

                    build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                            finish();
                        }
                    });
                    build.show();
                    return;
                }

                for (SyllabusPOJO s : res) {
                    int mrk = SharedPref.getIt(MockTest.this, SyllabusDatabase.storedMarkPrefix + s.getId());
                    int prog = SharedPref.getIt(MockTest.this, SyllabusDatabase.storedProgPrefix + s.getId());
                    adapter.add(s, mrk, prog);
                }

                lstMockTst.setAdapter(adapter);
                lstMockTst.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                        ExamData dat = adapter.data.get(arg2);
                        TestActivity.exmId = dat.getSyllabus().getId();
                        MockTest.this.startActivity(new Intent(MockTest.this, TestActivity.class));
                    }
                });
                dlg.dismiss();
            }
        };
        a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
