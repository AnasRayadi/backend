package com.rayadi.backend.dto;

import com.rayadi.backend.annotation.ValidEditionDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

import static com.rayadi.backend.constants.ErrorMessagesConstant.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    @NotNull(message = TITLE_REQUIRED)
    private String title;
    @NotNull(message = AUTHOR_REQUIRED)
    private String author;
    @NotNull(message = DESCRIPTION_REQUIRED)
    @Size(min = 10, message = DESCRIPTION_MIN_LENGTH)
    private String description;
    @NotNull(message = IMAGE_REQUIRED)
    @Pattern(regexp = "(https?://.*\\.(?:png|jpg))", message = IMAGE_VALID_URL)
    private String image;
    @NotNull(message = EDITION_REQUIRED)
    @ValidEditionDate
    private LocalDate edition;
    @NotNull(message = CATEGORY_ID_REQUIRED)
    private Integer categoryId;
    @NotNull(message = PRICE_REQUIRED)
    private double price;
}
