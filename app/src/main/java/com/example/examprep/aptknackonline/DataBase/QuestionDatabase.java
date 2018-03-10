package com.example.examprep.aptknackonline.DataBase;

import android.util.Log;

import com.example.examprep.aptknackonline.POJO.QuestionPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class QuestionDatabase extends ConnectionManager {

    public static LinkedList<QuestionPOJO> getByIdM(int id) throws ClassNotFoundException, SQLException {
        LinkedList<QuestionPOJO> res = new LinkedList<QuestionPOJO>();

        Connection con = getConn();

        try {
            String sql = "SELECT * from quests WHERE id = " + id;
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rset = pst.executeQuery();

            while (rset.next()) {
                QuestionPOJO s = new QuestionPOJO();

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
}
