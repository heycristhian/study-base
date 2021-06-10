package br.com.heycristhian.studybase.error;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
@Getter
public class RequestError {
    private final int status;
    private final String title;
    private final String message;
    private final String classPath;
    private final LocalDateTime localDateTime;
}
