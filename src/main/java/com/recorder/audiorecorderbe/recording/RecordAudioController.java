package com.recorder.audiorecorderbe.recording;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordAudioController {

    @GetMapping("/record")
    public String test() {
        return "Record Controller is Working";
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/record")
    String getRecordingResponse(@RequestBody MultiValueMap<String, String> formData) {
        System.out.println("POST POST POST");
        System.out.println(formData);
        return "{ \"data\": \"not yet implemented\" }";
    }

    
}
