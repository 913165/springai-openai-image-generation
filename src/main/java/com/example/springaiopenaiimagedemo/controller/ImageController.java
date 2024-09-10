package com.example.springaiopenaiimagedemo.controller;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    OpenAiImageModel openaiImageModel;

    public ImageController(OpenAiImageModel openaiImageModel) {
        this.openaiImageModel = openaiImageModel;
    }

    @GetMapping("/image")
    public String image() {
        ImageResponse response = openaiImageModel.call(
                new ImagePrompt("A airplane flying in the sky",
                        OpenAiImageOptions.builder()
                                .withQuality("hd")
                                .withN(1)
                                .withHeight(1024)
                                .withWidth(1024).build())

        );
        return response.getResult().getOutput().getUrl();

    }

}
