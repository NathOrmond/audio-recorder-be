package com.recorder.audiorecorderbe.recording;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.recorder.audiorecorderbe.analysis.IAudioStats;
import com.recorder.audiorecorderbe.analysis.Base64AudioToAudioStatsAdaptor;

@RestController
public class RecordAudioController {

    @GetMapping("/record")
    public String test() {
        return "Record Controller is Working";
    }

    @PostMapping("/record")
    IAudioStats getRecordingResponse(@RequestBody String  base64AudioData) throws IOException {
        return new Base64AudioToAudioStatsAdaptor(base64AudioData);
    }
 
}
