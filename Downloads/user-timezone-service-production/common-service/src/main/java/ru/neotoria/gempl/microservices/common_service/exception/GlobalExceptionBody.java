package ru.neotoria.gempl.microservices.common_service.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import ru.neotoria.gempl.microservices.common_service.util.DatePatterns;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GlobalExceptionBody {

    private HttpStatus status;

    private String description;

    @DateTimeFormat(pattern = DatePatterns.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatePatterns.DATE_TIME)
    private LocalDateTime time;

    private Map<String, Object> stacktrace = new LinkedHashMap<>();

    protected void clone(GlobalExceptionBody globalExceptionBody) {
        this.setStatus(globalExceptionBody.getStatus());
        this.setDescription(globalExceptionBody.getDescription());
        this.setTime(globalExceptionBody.getTime());
        this.setStacktrace(globalExceptionBody.getStacktrace());
    }
}
