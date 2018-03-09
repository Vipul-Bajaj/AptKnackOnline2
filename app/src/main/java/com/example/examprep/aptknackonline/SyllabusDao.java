package com.example.examprep.aptknackonline;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class SyllabusDao extends BaseDao {
    public static final String storedMarkPrefix = "MRK_";
    public static final String storedProgPrefix = "PROG_";

    public static LinkedList<Syllabus> getAllM() throws ClassNotFoundException, SQLException {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();

        Connection con = null;
        con = getConn();
        Log.d("Vipul", "getAllM: " + con);
        String sql = "SELECT * from syllabus";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Syllabus s = new Syllabus();

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

    public static LinkedList<Syllabus> getAll(Context ctx) {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();
        Log.d("Vipul", ctx.getApplicationInfo().dataDir);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from syllabus";
        Cursor c = db.rawQuery(sql, null);
        Log.d("Vipul", "getAll: " + c.getCount());
        while (c.moveToNext()) {
            Syllabus s = new Syllabus();
            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setTotalQuestions(c.getInt(c.getColumnIndex("tot_ques")));
            s.setTotalMarks(c.getInt(c.getColumnIndex("tot_mrk")));
            s.setQuestionTopic(c.getString(c.getColumnIndex("exm_name")));
            s.setQuestionNo(c.getString(c.getColumnIndex("quests")));
            res.add(s);
        }

        db.close();
        return res;
    }

    public static LinkedList<Syllabus> getBySubM(String subject) throws ClassNotFoundException, SQLException {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();

        Connection con = getConn();
        String sql = "SELECT * from syllabus WHERE sub_type = '" + subject + "'";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Syllabus s = new Syllabus();
                s.setId(rset.getInt("id"));
                s.setTotalQuestions(rset.getInt("tot_ques"));
                s.setTotalMarks(rset.getInt("tot_mrk"));
                s.setQuestionTopic(rset.getString("exm_name"));
                s.setQuestionNo(rset.getString("questions"));
                res.add(s);
            }

        } catch (SQLException e) {
            Log.d("NET", e.getMessage());
        }


        closeConn(con);

        return res;
    }


    public static LinkedList<Syllabus> getBySub(Context ctx, String subject) {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from syllabus WHERE sub_type = '" + subject + "'";
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            Syllabus s = new Syllabus();
            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setTotalQuestions(c.getInt(c.getColumnIndex("tot_ques")));
            s.setTotalMarks(c.getInt(c.getColumnIndex("tot_mrk")));
            s.setQuestionTopic(c.getString(c.getColumnIndex("exm_name")));
            s.setQuestionNo(c.getString(c.getColumnIndex("questions")));
            res.add(s);
        }
//		Toast.makeText(ctx, "Total cols:"+c.getCount(), Toast.LENGTH_LONG).show();
        db.close();
        return res;
    }

    public static LinkedList<Syllabus> getByIdM(int id) throws ClassNotFoundException, SQLException {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();

        Connection con = null;
        con = getConn();
        String sql = "SELECT * from syllabus WHERE id = " + id;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Syllabus s = new Syllabus();
                s.setId(rset.getInt("id"));
                s.setQuestionTopic(rset.getString("exm_name"));
                s.setQuestionNo(rset.getString("questions"));
                s.setTotalQuestions(rset.getInt("tot_ques"));
                s.setTotalMarks(rset.getInt("tot_mrk"));
                res.add(s);
            }
        } catch (SQLException e) {
            Log.d("NET", e.getMessage());
        }

        closeConn(con);
        return res;
    }

    public static LinkedList<Syllabus> getById(Context ctx, int id) {
        LinkedList<Syllabus> res = new LinkedList<Syllabus>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from syllabus WHERE id = " + id;
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            Syllabus s = new Syllabus();
            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setQuestionTopic(c.getString(c.getColumnIndex("exm_name")));
            s.setQuestionNo(c.getString(c.getColumnIndex("quests")));
            s.setTotalQuestions(c.getInt(c.getColumnIndex("tot_ques")));
            s.setTotalMarks(c.getInt(c.getColumnIndex("tot_mrk")));
            res.add(s);
        }
        db.close();
//		Toast.makeText(ctx, "Total cols:"+c.getCount(), Toast.LENGTH_LONG).show();
        return res;
    }

}
