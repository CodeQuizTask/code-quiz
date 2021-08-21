package com.codequiz;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionsBank {

    public static String getData(String filename) {
        Context context = MainActivity.getAppContext();
        String jsonString = "";
        try {
            InputStream is = context.getAssets().open(filename);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
            return jsonString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private static List<QuestionsList> mapData(String filename) {
        String jsonString = getData(filename);

        Gson gson = new Gson();
        Type listUserType = new TypeToken<List<Question>>() {
        }.getType();

        ArrayList<Question> questions = gson.fromJson(jsonString, listUserType);
        ArrayList<QuestionsList> questionsLists = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            final QuestionsList question = new QuestionsList(questions.get(i).question, questions.get(i).options, questions.get(i).answer);
            questionsLists.add(question);
        }
        Collections.shuffle(questionsLists);
        return questionsLists;
    }

    private static List<QuestionsList> javaQuestions() {
        return mapData("c_data.json");
    }

    private static List<QuestionsList> phpQuestions() {
        return mapData("c_data.json");
    }

    private static List<QuestionsList> pyQuestions() {
        return mapData("c_data.json");
    }

    private static List<QuestionsList> jsQuestions() {
        return mapData("c_data.json");
    }

    public static List<QuestionsList> getQuestions(String selectedTopicName, String origin) {
        switch (selectedTopicName) {
            case "java":
                if (origin.equals("selectedTopic")) return javaQuestions().subList(0, 5);
                return javaQuestions();
            case "php":
                if (origin.equals("selectedTopic")) return phpQuestions().subList(0, 5);
                return phpQuestions();
            case "js":
                if (origin.equals("selectedTopic")) return jsQuestions().subList(0, 5);
                return jsQuestions();
            default:
                if (origin.equals("selectedTopic")) return pyQuestions().subList(0, 5);
                return pyQuestions();
        }
    }
}
