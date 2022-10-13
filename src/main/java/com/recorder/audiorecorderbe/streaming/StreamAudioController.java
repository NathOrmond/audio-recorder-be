package com.recorder.audiorecorderbe.streaming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamAudioController {

    @GetMapping("/stream")
    public String mainResponse() {
        return "Hello from the Stream Controller";
    }
    
}
