package com.example.examprep.aptknackonline.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.examprep.aptknackonline.POJO.SyllabusPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class SyllabusDatabase extends ConnectionManager {
    public static final String storedMarkPrefix = "MRK_";
    public static final String storedProgPrefix = "PROG_";

    public static LinkedList<SyllabusPOJO> getAllM() throws ClassNotFoundException, SQLException {
        LinkedList<SyllabusPOJO> res = new LinkedList<SyllabusPOJO>();

        Connection con = null;
        con = getConn();
        String sql = "SELECT * from syllabus";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                SyllabusPOJO s = new SyllabusPOJO();

                s.setId(rset.getInt("id"));
                s.setTotalQuestions(rset.getInt("tot_ques"));
                s.setTotalMarks(rset.getInt("tot_mrk"));
                s.setQuestionTopic(rset.getString("exm_name"));
                s.setQuestionNo(rset.getString("quests"));

                res.add(s);
            }
        } catch (SQLException e) {
            Log.d("NET", e.getMessage());
        }

        closeConn(con);
        return res;
    }

    public static LinkedList<SyllabusPOJO> getById(Context ctx, int id) {
        LinkedList<SyllabusPOJO> res = new LinkedList<SyllabusPOJO>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from syllabus WHERE id = " + id;
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            SyllabusPOJO s = new SyllabusPOJO();
            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setQuestionTopic(c.getString(c.getColumnIndex("exm_name")));
            s.setQuestionNo(c.getString(c.getColumnIndex("quests")));
            s.setTotalQuestions(c.getInt(c.getColumnIndex("tot_ques")));
            s.setTotalMarks(c.getInt(c.getColumnIndex("tot_mrk")));
            res.add(s);
        }
        db.close();
        return res;
    }

    public static LinkedList<SyllabusPOJO> getBySubM(String subject) throws ClassNotFoundException, SQLException {
        LinkedList<SyllabusPOJO> res = new LinkedList<SyllabusPOJO>();

        Connection con = getConn();
        String sql = "SELECT * from syllabus WHERE sub_type = '" + subject + "'";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                SyllabusPOJO s = new SyllabusPOJO();
                s.setId(rset.getInt("id"));
                s.setTotalQuestions(rset.getInt("tot_ques"));
                s.setTotalMarks(rset.getInt("tot_mrk"));
                s.setQuestionTopic(rset.getString("exm_name"));
                s.setQuestionNo(rset.getString("quests"));
                res.add(s);
            }

        } catch (SQLException e) {
            Log.d("NET", e.getMessage());
        }
        closeConn(con);
        return res;
    }
}
