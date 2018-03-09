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

public class QuestsDao extends BaseDao {

    public static LinkedList<Quest> getAllM() throws ClassNotFoundException, SQLException {
        LinkedList<Quest> res = new LinkedList<Quest>();
        Connection con = getConn();

        try {
            String sql = "SELECT * from quests";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();
            while (rset.next()) {
                Quest s = new Quest();
                s.setId(rset.getInt("id"));
                s.setAns(rset.getString("ans"));
                s.setQuestion(rset.getString("question"));
                s.setQuestionType(rset.getString("q_type"));
                s.setMarks(rset.getInt("mark"));
                s.setNegMarks(rset.getInt("neg_mark"));
                res.add(s);
            }
        } catch (Exception e) {
            Log.d("NET", e.getMessage());
        }

        closeConn(con);

        return res;
    }

    public static LinkedList<Quest> getAll(Context ctx) {
        LinkedList<Quest> res = new LinkedList<Quest>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from quests";
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            Quest s = new Quest();

            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setAns(c.getString(c.getColumnIndex("ans")));
            s.setQuestion(c.getString(c.getColumnIndex("question")));
            s.setQuestionType(c.getString(c.getColumnIndex("q_type")));
            s.setMarks(c.getInt(c.getColumnIndex("mark")));
            s.setNegMarks(c.getInt(c.getColumnIndex("neg_mark")));
            res.add(s);
        }
//		Toast.makeText(ctx, "Total cols:"+c.getCount(), Toast.LENGTH_LONG).show();
        db.close();
        return res;
    }

    public static LinkedList<Quest> getByIdM(int id) throws ClassNotFoundException, SQLException {
        LinkedList<Quest> res = new LinkedList<Quest>();

        Connection con = getConn();

        try {
            String sql = "SELECT * from quests WHERE id = " + id;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();

            while (rset.next()) {
                Quest s = new Quest();

                s.setId(rset.getInt("id"));
                s.setAns(rset.getString("ans"));
                s.setQuestion(rset.getString("question"));
                s.setQuestionType(rset.getString("q_type"));
                s.setMarks(rset.getInt("mark"));
                s.setNegMarks(rset.getInt("neg_mark"));

                res.add(s);
            }

        } catch (Exception e) {
            Log.d("NET", e.getMessage());
        }

        closeConn(con);

        return res;
    }

    public static LinkedList<Quest> getById(Context ctx, int id) {
        LinkedList<Quest> res = new LinkedList<Quest>();
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(ctx.getApplicationInfo().dataDir + "/examprep.sqlite", null);
        String sql = "SELECT * from quests WHERE id = " + id;
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()) {
            Quest s = new Quest();

            s.setId(c.getInt(c.getColumnIndex("id")));
            s.setAns(c.getString(c.getColumnIndex("ans")));
            s.setQuestion(c.getString(c.getColumnIndex("question")));
            s.setQuestionType(c.getString(c.getColumnIndex("q_type")));
            s.setMarks(c.getInt(c.getColumnIndex("mark")));
            s.setNegMarks(c.getInt(c.getColumnIndex("neg_mark")));

            res.add(s);
        }
        db.close();
        return res;
    }

}
