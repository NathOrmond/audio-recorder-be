package com.recorder.audiorecorderbe.analysis;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;

public class AudioFileAnalyser implements IAudioFileAnalyser{

    @Override
    public String getDuration(String url) {
        
        File target = new File(url);
        AudioFile f;
        SimpleDateFormat timeInFormat = new SimpleDateFormat("ss", Locale.UK);
        SimpleDateFormat timeOutFormat = new SimpleDateFormat("mm:ss", Locale.UK);
        SimpleDateFormat timeOutOverAnHourFormat = new SimpleDateFormat("kk:mm:ss", Locale.UK);
        String formattedLength = "";
        long length = 0;

        try {
            f = AudioFileIO.read(target);
            AudioHeader ah = f.getAudioHeader();
            length = (long)ah.getTrackLength();
            Date timeIn;
            synchronized(timeInFormat) {
                timeIn = timeInFormat.parse(String.valueOf(length));
            }
            if(length < 3600L) {
                synchronized(timeOutFormat) {
                    formattedLength =  timeOutFormat.format(timeIn);
                }
            } else {
                synchronized(timeOutOverAnHourFormat) {
                    formattedLength = timeOutOverAnHourFormat.format(timeIn);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            formattedLength = "Error processing audio time: ".concat(e.getMessage());
        }    

        return formattedLength;
    }

    @Override
    public String getSampleRate(String url) {
        String sampleRate = "0";
        try {
            sampleRate = getAudioHeader(url).getBitRate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return sampleRate;
    }

    private AudioHeader getAudioHeader(String url) throws Exception { 
        return AudioFileIO.read(new File(url)).getAudioHeader();
    }
    
}
