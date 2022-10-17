package com.recorder.audiorecorderbe.analysis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;

public class Base64AudioToAudioStatsAdaptor implements IAudioStats {
    
    private boolean audioReveived;
    private String wrappedAudioData;
    private final String audioFileURL = "/app/files/audio";
    private IAudioFileAnalyser audioAnalyser;
    private AudioConverter converter;

    public Base64AudioToAudioStatsAdaptor(String audio){ 
        this.wrappedAudioData = audio;
        this.audioAnalyser = new AudioFileAnalyser();
        this.converter = new AudioConverter();
        try {
            this.decodeAudioToFile();
            this.converter.convertWEbMToMP3(this.audioFileURL);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void decodeAudioToFile() throws IOException{ 
        Decoder decoder = Base64.getDecoder();
        byte[] decodedByte = decoder.decode(this.wrappedAudioData.split(",")[1]);
        FileOutputStream fos = new FileOutputStream(this.audioFileURL);
        fos.write(decodedByte);
        fos.close();
        this.audioReveived = true;
    }

    public boolean isAudioReveived() {
        return this.audioReveived;
    }

    public String getDuration() {
        return this.audioAnalyser.getDuration(this.audioFileURL);
    }

    public String getSampleRate() {
        return this.audioAnalyser.getSampleRate(this.audioFileURL);
    }

}
