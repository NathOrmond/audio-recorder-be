package com.recorder.audiorecorderbe.analysis;

public interface IAudioFileAnalyser {
    String getDuration(String url);
    String getSampleRate(String url);
}
