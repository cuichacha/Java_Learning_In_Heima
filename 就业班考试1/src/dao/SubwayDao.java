package dao;

import domain.Subway;

import java.io.*;
import java.util.ArrayList;

public class SubwayDao {
    private static ArrayList<Subway> subwayArrayList = new ArrayList<>();

    private ArrayList<Subway> readSubwayInfo(ArrayList<Subway> subwayArrayList) {
        BufferedReader bufferedReader = null;
        String str;

        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/willdufresne/Documents/黑马Java/就业班考试1/src/subways.txt"));
            while ((str = bufferedReader.readLine()) != null) {
                String[] subwayInfo = str.split(",");
                if (subwayInfo.length == 3) {
                    Subway subway = new Subway(subwayInfo[0], subwayInfo[1], subwayInfo[2]);
                    subwayArrayList.add(subway);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return subwayArrayList;
    }

    private ArrayList<Subway> getSubways() {
        return readSubwayInfo(subwayArrayList);
    }

    public ArrayList<Subway> invokeGetSubways() {
        return getSubways();
    }

    public void invokeAddSubway(Subway subway) {
        addSubway(subway);
    }

    private void addSubway(Subway subway) {
        subwayArrayList.add(subway);
        writeSubway(subway);
    }

    private void writeSubway(Subway subway) {
        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("/Users/willdufresne/Documents/黑马Java/就业班考试1/src/subways.txt", true));
            bufferedWriter.newLine();
            bufferedWriter.write(subway.getNumber() + "," + subway.getName() + "," + subway.getLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
