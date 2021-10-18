package com.example.ratesgif.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GifDto {
    String id;
    String type;
    @JsonProperty("image_url")
    String imageUrl;
}
