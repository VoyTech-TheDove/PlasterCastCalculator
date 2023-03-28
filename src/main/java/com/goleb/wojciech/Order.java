package com.goleb.wojciech;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record Order(String customerName, List<Figure> list, BigDecimal price, LocalDateTime time) {
}
