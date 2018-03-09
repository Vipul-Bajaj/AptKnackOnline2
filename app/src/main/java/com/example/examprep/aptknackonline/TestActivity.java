package com.example.examprep.aptknackonline;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class TestActivity extends AppCompatActivity {
    public static int exmId;
    TextView questionTypeTextView, marksTextView, questionNoTextView, timerTextView;
    LinkedList<Integer> questions;
    WebView questionWebView;
    int currQuest;
    Button previousButton, nextButton;
    RadioButton optionA, optionB, optionD, optionC;
    RadioGroup radioGroup;
    int totalMrk;
    int remainingMins;
    SharedPreferences sp;
    String[] yourAns;
    String[] rightAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        questions = new LinkedList<Integer>();
        LinkedList<Syllabus> res = SyllabusDao.getById(this, exmId);
        sp = getPreferences(MODE_PRIVATE);
        if (res.size() <= 0) {
            Toast.makeText(this, "No exam found matching id " + exmId, Toast.LENGTH_SHORT).show();
            finish();
        }
        marksTextView = findViewById(R.id.maxmarksTtextView);
        questionNoTextView = findViewById(R.id.questionTextView);
        timerTextView = findViewById(R.id.timerTextView);
        questionTypeTextView = findViewById(R.id.questionTypeTextView);
        questionWebView = findViewById(R.id.questionWebView);
        previousButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        optionA = findViewById(R.id.optionARadioButton);
        optionB = findViewById(R.id.optionBRadioButton);
        optionC = findViewById(R.id.optionCradioButton);
        optionD = findViewById(R.id.optionDRadioButton);
        radioGroup = findViewById(R.id.optionRadioGroup);
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currQuest < questions.size() - 1) {
                    String ans = "";
                    if (optionA.isChecked() == true) {
                        ans = "A";
                    } else if (optionB.isChecked() == true) {
                        ans = "B";
                    } else if (optionC.isChecked() == true) {
                        ans = "C";
                    } else if (optionD.isChecked() == true) {
                        ans = "D";
                    }
                    if (ans.equals("")) {
                        Toast.makeText(TestActivity.this, "Please select an option", Toast.LENGTH_LONG).show();
                        return;
                    }
                    yourAns[currQuest] = ans;
                    currQuest++;
                    drawQuest(questions.get(currQuest));
                    regProgress();
                    clearOpts();
                } else if (currQuest == questions.size() - 1) {

                    String ans = "";
                    if (optionA.isChecked() == true) {
                        ans = "A";
                    } else if (optionB.isChecked() == true) {
                        ans = "B";
                    } else if (optionC.isChecked() == true) {
                        ans = "C";
                    } else if (optionD.isChecked() == true) {
                        ans = "D";
                    }
                    if (ans.equals("")) {
                        Toast.makeText(TestActivity.this, "Please select an option", Toast.LENGTH_LONG).show();
                        return;
                    }
                    yourAns[questions.size() - 1] = ans;
                    finishExm();
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currQuest > 0) {
                    String ans = "";
                    if (optionA.isChecked() == true) {
                        ans = "A";
                    } else if (optionB.isChecked() == true) {
                        ans = "B";
                    } else if (optionC.isChecked() == true) {
                        ans = "C";
                    } else if (optionD.isChecked() == true) {
                        ans = "D";
                    }
                    if (ans.equals("")) {
                        Toast.makeText(TestActivity.this, "Please select an option", Toast.LENGTH_LONG).show();
                        return;
                    }
                    yourAns[currQuest] = ans;
                    currQuest--;
                    drawQuest(questions.get(currQuest));
                    clearOpts();
                }
            }
        });
        currQuest = 0;
        Syllabus s = res.get(0);
        marksTextView.setText("Max. Mrks: " + s.getTotalMarks());
        questionTypeTextView.setText(s.getQuestionTopic());
        String[] questsStr = s.getQuestionNo().split(",");
        for (String q : questsStr) {
            try {
                Integer i = Integer.parseInt(q);
                questions.add(i);
            } catch (Exception e) {
            }
        }

        if (questions.size() <= 0) {
            Toast.makeText(this, "This exams contains no questions:Exiting", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            /**
             * Exam initialization
             */
            yourAns = new String[questions.size()];
            rightAns = new String[questions.size()];
            drawQuest(questions.get(currQuest));
            /**
             * set the timer
             */
            startTimer();
        }
    }

    private void drawQuest(final int q) {

        AsyncTask<Void, Void, Message> aTask = new AsyncTask<Void, Void, Message>() {
            AlertDialog dlg;

            @Override
            protected void onPreExecute() {
                final AsyncTask self = this;
                AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
                builder.setCancelable(false);
                builder.setTitle("Loading Question...");
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        self.cancel(true);
                    }
                });
                dlg = builder.create();

                dlg.show();
                super.onPreExecute();
            }

            @Override
            protected Message doInBackground(Void... arg0) {
                Message msg = new Message();
                msg.code = 0;
                msg.msg = "";

                LinkedList<Quest> res = new LinkedList<Quest>();

                try {
                    res = QuestsDao.getById(getApplicationContext(), q);
                    msg.data = res;
                } catch (Exception e) {
                    msg.code = 1;
                    msg.msg = e.getMessage();
                }
                return msg;
            }

            @Override
            protected void onPostExecute(Message msg) {

                if (msg.code != 0) {
                    Toast.makeText(TestActivity.this, msg.msg, Toast.LENGTH_LONG).show();
                    dlg.dismiss();
                    TestActivity.this.finish();
                    return;
                }

                LinkedList<Quest> res = (LinkedList<Quest>) msg.data;

                rightAns[currQuest] = res.get(0).getAns();

                if (res.size() <= 0) {
                    return;
                }
                questionWebView.loadData(res.get(0).getQuestion(), "text/html", "utf-8");
                questionNoTextView.setText("Q:" + (currQuest + 1) + " of " + questions.size());
                dlg.dismiss();

                super.onPostExecute(msg);
            }
        };

        aTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    private void clearOpts() {
        radioGroup.clearCheck();
    }

    private void regProgress() {
        double per = ((currQuest + 1.0) / questions.size()) * 100.0;
        SharedPref.saveIt(this, SyllabusDao.storedProgPrefix + exmId, (int) per);
    }

    private void startTimer() {
        Log.d("Vipul", "startTimer: " + questions.size());
        remainingMins = questions.size() * 1;
        timerTextView.setText("Time remaining : " + (remainingMins) + " Min");
        Thread t = new Thread(new Runnable() {
            int sec;

            @Override
            public void run() {
                while (remainingMins > 0) {
                    remainingMins--;
                    sec = 59;
                    while (sec > -1) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        sec--;
                        runOnUiThread(new Runnable() {
                            public void run() {
                                TestActivity.this.timerTextView.setText("Time remaining : " + (remainingMins) + ":" + sec);
                            }
                        });
                    }
                }
                Log.d("finisher", "Exam Should finish now");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finishExm();
                    }
                });

            }

        });

        t.start();

    }

    private void finishExm() {
        int c = 0;
        totalMrk = 0;
        for (String s : yourAns) {
            if (yourAns[c] != null) {
                if (yourAns[c].compareToIgnoreCase(rightAns[c]) == 0) {
                    totalMrk += 2;
                }

                c++;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setMessage("You got " + totalMrk + " Marks in test");
        builder.setTitle("Exam completed!!");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        builder.show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(TestActivity.this);
        builder.setMessage("Are you sure ??");
        builder.setTitle("Leaving exam !!");
        builder.setPositiveButton("I am damn sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finishExm();
            }
        });

        builder.setNegativeButton("No i will complete my exam", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });
        builder.show();
    }
}
