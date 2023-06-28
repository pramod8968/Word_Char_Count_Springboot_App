package com.wordcountapp.example.wordcountdemo.controller;

import com.wordcountapp.example.wordcountdemo.service.ParagraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/Counter")
public class ParagraphController {

    @Autowired
    private ParagraphService paragraphService;

    @PostMapping("/getCharactersCount")
    public ResponseEntity<?> getCharactersCount(@RequestBody(required = false) String paragraph){
        try {
            Integer noOfCharacters = paragraphService.countNumberOfCharacters(paragraph);
            return new ResponseEntity<>(noOfCharacters, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/getWordsCount")
    public ResponseEntity<?> getWordsCount(@RequestBody(required = false) String paragraph){
        try{
            Integer noOfWords = paragraphService.countNumberOfWords(paragraph);
            return new ResponseEntity<>(noOfWords, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
