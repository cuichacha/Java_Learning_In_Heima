package Util;

import javazoom.jl.player.Player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;

public class MusicUtil {
    /**
     * 可以播放mp3文件，只会播放一次
     * @param fileName
     */
    public static void playMp3(String fileName){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedInputStream in = new BufferedInputStream(MusicUtil.class.getResourceAsStream("/"+fileName));
                    Player player = new Player(in);
                    player.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 可以播放wmv文件，只会播放一次
     * @param fileName
     */
    public static void playMusic(String fileName){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream in =
                    AudioSystem.getAudioInputStream(MusicUtil.class.getResourceAsStream("/" + fileName));
            clip.open(in);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 循环播放音乐，播放不了Mp3
     * @param fileName
     */
    public static void loopPlayMusic(String fileName){
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream in =
                    AudioSystem.getAudioInputStream(MusicUtil.class.getResourceAsStream("/" + fileName));
            clip.open(in);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
