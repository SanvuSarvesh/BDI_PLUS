package com.example.Assignment.common;

import com.example.Assignment.models.Books;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto extends Books {

    @NotNull()
    private String bookName;

    @NotNull
    private String authorName;

    @Nullable
    private int price;

    @NotNull
    private int noOfPages;

    @NotNull
    private String language;

}
