package com.recorder.audiorecorderbe.analysis;

import java.io.IOException;

public class AudioConverter {
    
    public void convertWEbMToMP3(String url){ 
        try {
            String command = String.format("ffmpeg -i %s -vn -ab 128k -ar 44100 -y %s.mp3", url, url);
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
