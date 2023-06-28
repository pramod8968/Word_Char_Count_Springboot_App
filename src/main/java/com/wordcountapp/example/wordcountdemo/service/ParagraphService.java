package com.wordcountapp.example.wordcountdemo.service;

import org.springframework.stereotype.Service;

@Service
public class ParagraphService {
    public Integer countNumberOfCharacters(String paragraph) throws Exception {
        if(paragraph.isEmpty()){
            throw new Exception("Empty paragraph provided.");
        }
        else{
            int count = 0;
            for(int i=0;i<paragraph.length();i++){
                //if the character is not a whitespace, then increment count by 1
                if(!Character.isWhitespace(paragraph.charAt(i))){
                    count=count+1;
                }
            }
            return count;
        }
    }

    public Integer countNumberOfWords(String paragraph) throws Exception {
        if(paragraph.isEmpty()){
            throw new Exception("Empty paragraph provided.");
        }
        else{
            String[] words = paragraph.split("\s+");
            return words.length;
        }
    }
}
