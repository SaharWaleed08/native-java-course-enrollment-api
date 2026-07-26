package dto.response;

import model.CourseStatus;

import java.math.BigDecimal;
import java.util.UUID;

public class CourseResponse {

    private UUID id;
    private String title;
    private String description;
    private BigDecimal price;
    private int capacity;
    private int availableSeats;
    private CourseStatus status;

}